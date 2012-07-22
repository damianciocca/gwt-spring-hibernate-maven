package au.com.uptick.gwt.maven.sample.server.auth.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import au.com.uptick.gwt.maven.sample.client.auth.exceptions.SecurityException;
import au.com.uptick.gwt.maven.sample.client.auth.services.SecurityService;
import au.com.uptick.gwt.maven.sample.server.auth.CustomUserAuthentication;
import au.com.uptick.gwt.maven.sample.server.auth.dao.RoleDao;
import au.com.uptick.gwt.maven.sample.shared.auth.dto.RoleDto;
import au.com.uptick.gwt.maven.sample.shared.auth.model.Role;
import au.com.uptick.gwt.maven.sample.shared.auth.rpc.response.RoleListData;
import au.com.uptick.gwt.maven.sample.shared.auth.rpc.response.RoleListPageData;

@Service("securityService")
public class SecurityServiceImpl implements SecurityService{
	
	@Autowired
	RoleDao roleDao;	

	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=SecurityException.class)
	public RoleDto saveRole(RoleDto role) throws SecurityException{
		
		System.out.println("SecurityServiceImpl => saveRole [INICIO]");
		Role rolePersisted = roleDao.persist(bindFrom(role));
		RoleDto result = bindFrom(rolePersisted);
		System.out.println("SecurityServiceImpl => saveRole [FIN]");
		return result;
	}

	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=SecurityException.class)
	public RoleDto upateRole(RoleDto role) throws SecurityException {

		System.out.println("SecurityServiceImpl => upateRole [INICIO]");
		Role roleUpdated = roleDao.merge(bindFrom(role));
		RoleDto result = bindFrom(roleUpdated);
		System.out.println("SecurityServiceImpl => upateRole [FIN]");
		return result;
	}			
	
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=SecurityException.class)
	public Set<RoleDto> deleteRoles(Set<RoleDto> roles) throws SecurityException {
		
		System.out.println("SecurityServiceImpl => deleteRoles [INICIO]");
		Set<RoleDto> result = new HashSet<RoleDto>();
		for (RoleDto dto : roles) {
			Role roleLoaded = roleDao.findById(dto.getId());
			if (roleLoaded == null){
				throw new SecurityException("No se puede continuar con el proceso de eliminacion de roles ya que no se obtuvo el rol para el ID " + dto.getId());
			}
			roleDao.remove(roleLoaded);
			result.add(dto);			
		}
		System.out.println("SecurityServiceImpl => deleteRoles [FIN]");
		return result;
	}
	
	public RoleDto retriveRoleById(Long id) throws SecurityException {
		
		System.out.println("SecurityServiceImpl => retriveRoleById [INICIO]");
		Role role = roleDao.findById(id);
		RoleDto result = bindFrom(role);
		System.out.println("SecurityServiceImpl => retriveRoleById [FIN]");
		return result;
	}

	
	public RoleListPageData retriveRoleListPage(RoleDto filter) throws SecurityException {
		
		RoleListPageData result = new RoleListPageData();
		
		List<RoleDto> rolesForFilter = retriveRoles(null);
		result.setListRoles(rolesForFilter);

		return result;
	}
	
	public RoleListData retriveRoleList(RoleDto filter) throws SecurityException {
		
		RoleListData result = new RoleListData();
		
		List<RoleDto> rolesForGrid = retriveRoles(filter);
		Long roleCount = roleDao.retriveRolesCount(filter);
		result.setListRoles(rolesForGrid);
		result.setListRolesSize(roleCount.intValue());

		return result;
	}	
	
	public String getUserLogged() {
		
		/**
		 * By default the SecurityContextHolder uses a ThreadLocal to store these details, 
		 * which means that the security context is always available to methods in the same thread of execution.
		 */
		CustomUserAuthentication user = (CustomUserAuthentication) SecurityContextHolder.getContext().getAuthentication();
		return user.getName() + " " + user.getSurname();
	}
	
	private List<RoleDto> retriveRoles(RoleDto filter) throws SecurityException{
		
		System.out.println("SecurityServiceImpl => retriveRoles [INICIO]");
		List<Role> roles = roleDao.retriveRoles(filter);
		List<RoleDto> result = new ArrayList<RoleDto>();
		for (Role r : roles) {
			result.add(bindFrom(r));
		}
		System.out.println("SecurityServiceImpl => retriveRoles [FIN]");
		return result;
	}
	
	private Role bindFrom(RoleDto dto){
		
		Role role = new Role();		
		role.setRoleId(dto.getId());
		role.setRoleName(dto.getName());
		role.setRoleDescription(dto.getDescription());
		return role;
	}
	
	private RoleDto bindFrom(Role role){
		
		RoleDto dto = new RoleDto();
		dto.setId(role.getRoleId());
		dto.setName(role.getRoleName());
		dto.setDescription(role.getRoleDescription());
		return dto;
	}
	
}

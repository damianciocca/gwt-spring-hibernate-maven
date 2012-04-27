package au.com.uptick.gwt.maven.sample.server.auth.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import au.com.uptick.gwt.maven.sample.client.auth.services.SecurityService;
import au.com.uptick.gwt.maven.sample.server.dao.auth.RoleDao;
import au.com.uptick.gwt.maven.sample.shared.auth.model.Role;
import au.com.uptick.gwt.maven.sample.shared.auth.model.dto.RoleDto;

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
	
	public List<RoleDto> retriveRoles(RoleDto role) {
		
		// TODO el parametro lo utilizaremos como filtro
		System.out.println("SecurityServiceImpl => retriveRoles [INICIO]");
		List<Role> roles = roleDao.findAll();
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

package au.com.uptick.gwt.maven.sample.server.auth.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import au.com.uptick.gwt.maven.sample.client.auth.services.SecurityService;
import au.com.uptick.gwt.maven.sample.server.dao.CustomerDao;
import au.com.uptick.gwt.maven.sample.server.dao.auth.RoleDao;
import au.com.uptick.gwt.maven.sample.shared.auth.model.Role;
import au.com.uptick.gwt.maven.sample.shared.auth.model.dto.RoleDto;

@Service("securityService")
public class SecurityServiceImpl implements SecurityService{
	
	@Autowired
	RoleDao roleDao;	

	public RoleDto saveRole(RoleDto role) {
		
		System.out.println("SecurityServiceImpl => saveRole [INICIO]");
		Role rolePersisted = roleDao.persist(bindFrom(role));
		RoleDto result = bindFrom(rolePersisted);
		System.out.println("SecurityServiceImpl => saveRole [FIN]");
		return result;
	}

	public RoleDto upateRole(RoleDto role) {

		System.out.println("SecurityServiceImpl => upateRole [INICIO]");
		System.out.println("SecurityServiceImpl => upateRole [FIN]");
		return null;
	}
	
	private Role bindFrom(RoleDto dto){
		
		Role role = new Role();
		role.setRoleName(dto.getName());
		role.setRoleDescription(dto.getDescription());
		return role;
	}
	
	private RoleDto bindFrom(Role role){
		
		RoleDto dto = new RoleDto();
		dto.setName(role.getRoleName());
		dto.setDescription(role.getRoleDescription());
		return dto;
	}
}

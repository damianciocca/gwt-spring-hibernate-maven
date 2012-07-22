package au.com.uptick.gwt.maven.sample.shared.auth.rpc.response;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import au.com.uptick.gwt.maven.sample.shared.auth.dto.RoleDto;

/**
 * Container de datos de respuesta para popular la grilla de roles 
 * 
 * @author dciocca
 */
public class RoleListData implements Serializable {
	
	List<RoleDto> listRoles = new ArrayList<RoleDto>();
	int listRolesSize = 0;
	
	public RoleListData() {

	}

	public RoleListData(List<RoleDto> listRoles) {
		super();
		this.listRoles = listRoles;
	}

	public List<RoleDto> getListRoles() {
		return listRoles;
	}

	public void setListRoles(List<RoleDto> listRoles) {
		this.listRoles = listRoles;
	}

	public int getListRolesSize() {
		return listRolesSize;
	}

	public void setListRolesSize(int listRolesSize) {
		this.listRolesSize = listRolesSize;
	}

}

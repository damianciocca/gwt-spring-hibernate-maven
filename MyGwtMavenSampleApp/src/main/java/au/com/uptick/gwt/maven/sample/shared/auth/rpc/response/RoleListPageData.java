package au.com.uptick.gwt.maven.sample.shared.auth.rpc.response;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import au.com.uptick.gwt.maven.sample.shared.auth.dto.RoleDto;

/**
 * Container que encapsula todos los datos de la pantalla de listado de roles.
 * 
 * @author Damian Ciocca
 */
public class RoleListPageData implements Serializable{
	
	List<RoleDto> listRoles = new ArrayList<RoleDto>();
	
	public RoleListPageData() {

	}

	public RoleListPageData(List<RoleDto> listRoles) {
		super();
		this.listRoles = listRoles;
	}

	public List<RoleDto> getListRoles() {
		return listRoles;
	}

	public void setListRoles(List<RoleDto> listRoles) {
		this.listRoles = listRoles;
	}

}

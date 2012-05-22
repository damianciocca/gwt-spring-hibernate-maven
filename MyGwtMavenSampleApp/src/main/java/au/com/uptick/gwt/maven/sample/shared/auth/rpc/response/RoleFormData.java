package au.com.uptick.gwt.maven.sample.shared.auth.rpc.response;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import au.com.uptick.gwt.maven.sample.shared.auth.dto.RoleDto;

/**
 * Container de datos de respuesta para popular la pantalla de 
 * listado de roles.
 * Esto permite obtener todos los datos mediante una sola pegada al server.
 * 
 * @author dciocca
 *
 */
public class RoleFormData implements Serializable {
	
	List<RoleDto> filterRoles = new ArrayList<RoleDto>();
	List<RoleDto> listRoles = new ArrayList<RoleDto>();
	
	public RoleFormData() {

	}

	public RoleFormData(List<RoleDto> filterRoles, List<RoleDto> listRoles) {
		super();
		this.filterRoles = filterRoles;
		this.listRoles = listRoles;
	}

	public List<RoleDto> getFilterRoles() {
		return filterRoles;
	}

	public void setFilterRoles(List<RoleDto> filterRoles) {
		this.filterRoles = filterRoles;
	}

	public List<RoleDto> getListRoles() {
		return listRoles;
	}

	public void setListRoles(List<RoleDto> listRoles) {
		this.listRoles = listRoles;
	}
}

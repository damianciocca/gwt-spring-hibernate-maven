package au.com.uptick.gwt.maven.sample.shared.auth.model.dto;

import java.io.Serializable;

public class RoleDto implements Serializable{
	
	private long id;
	private String name;
	private String description;
		
	public RoleDto() {
		super();
	}

	public RoleDto(long id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "RoleDto [id=" + id + ", name=" + name + ", description="
				+ description + "]";
	}
	
	
}

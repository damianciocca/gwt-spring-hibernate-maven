package au.com.uptick.gwt.maven.sample.shared.auth.dto;

import java.io.Serializable;

public class RoleDto implements Serializable{
	
	private Long id;
	private String name;
	private String description;
		
	public RoleDto() {
		super();
	}

	public RoleDto(Long id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

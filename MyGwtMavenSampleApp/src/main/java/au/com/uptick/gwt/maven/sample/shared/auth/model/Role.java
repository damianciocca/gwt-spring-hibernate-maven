package au.com.uptick.gwt.maven.sample.shared.auth.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "AUTH_ROLE")
public class Role implements java.io.Serializable{
	
	@SequenceGenerator(name="ROLE_SEQUENCE_GENERATOR",sequenceName="ROLE_SEQ")
	@Id @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ROLE_SEQUENCE_GENERATOR")
	@Column(name="id")
    private Long roleId;
   
    @Column(name="name", nullable = false, length=50)
    private String roleName;
    
    @Column(name="description", nullable = false, length=250)
    private String roleDescription;
        
	public Role() {
		super();
	}

	public Role(Long roleId, String roleName, String roleDescription) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.roleDescription = roleDescription;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDescription() {
		return roleDescription;
	}

	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}
	
}

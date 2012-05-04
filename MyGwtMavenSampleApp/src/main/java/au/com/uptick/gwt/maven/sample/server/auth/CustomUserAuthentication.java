package au.com.uptick.gwt.maven.sample.server.auth;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

public class CustomUserAuthentication implements Authentication {
	
	private static final long serialVersionUID = -3091441742758356129L;
	
	private boolean authenticated;
	private List<GrantedAuthority> grantedAuthorities;
	private Authentication authentication;
	private String name;
	private String surname;
	private String email;
	
	/**
	 * In the constructor, we pass the user's permissions and the original Authentication object. 
	 * In the implemented methods, the most important one is the getAuthorities, which returns the authorities (permissions) that the principal 
	 * has been granted. That information is provided inside a collection of GrantedAuthority objects.
	 * @param role
	 * @param authentication
	 * @param name 
	 * @param surname
	 * @param email 
	 */
	public CustomUserAuthentication(List<GrantedAuthority> permissions, Authentication authentication, String name, String surname, String email) {
		this.grantedAuthorities = permissions;
		this.authentication = authentication;
		this.name = name;
		this.surname = surname;
		this.email = email;
	}

	/**
	 * Permisos
	 */
	public Collection<GrantedAuthority> getAuthorities() {
		System.out.println("CustomUserAuthentication => getAuthorities() ");
		return grantedAuthorities;
	}
	
	/**
	 * Password (UsernamePasswordAuthenticationToken)
	 */
	public Object getCredentials() {
		System.out.println("CustomUserAuthentication => getCredentials() ");
		return authentication.getCredentials();
	}

	/**
	 * Username (UsernamePasswordAuthenticationToken)
	 */
	public Object getPrincipal() {
		System.out.println("CustomUserAuthentication => getPrincipal() ");
		return authentication.getPrincipal();
	}
	
	public Object getDetails() {
		System.out.println("CustomUserAuthentication => getDetails() ");
		return authentication.getDetails();
	}

	public boolean isAuthenticated() {
		System.out.println("CustomUserAuthentication => isAuthenticated() ");
		return authenticated;
	}

	public void setAuthenticated(boolean authenticated) throws IllegalArgumentException {
		System.out.println("CustomUserAuthentication => setAuthenticated() ");
		this.authenticated = authenticated;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public String getEmail() {
		return email;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}

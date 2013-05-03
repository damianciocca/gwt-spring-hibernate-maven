package com.springbatch.ejemplo9;

public class Contact {
	
	private String firstname;
	
	private String lastname;
	
	private Contact() {
		super();
	}

	private Contact(String firstname, String lastname) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Override
	public String toString() {
		
		return firstname + " - " + lastname;
		
	}
	
	

}

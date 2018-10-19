package edu.acc.java1.savenload;

import java.security.*;

public class Employee {
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	
	public Employee() {}

	public Employee(String fn, String ln, String un, String pass, boolean hashIt)
			throws NoSuchAlgorithmException {
		setFirstName(fn);
		setLastName(ln);
		setUsername(un);
		if (hashIt) hashPassword(pass);
		else setPasswordHash(pass);
	}
	
	public void setFirstName(String fn) {
		firstName = fn;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setLastName(String ln) {
		lastName = ln;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setUsername(String un) {
		if (un.indexOf('@') < 1)
			throw new IllegalArgumentException("Usernames are email addresses.");
		username = un;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setPasswordHash(String hash) {
		this.password = hash;
	}
	
	public void hashPassword(String password) throws NoSuchAlgorithmException {
		if (password.length() < 5)
			throw new IllegalArgumentException("Passwords must be 5 or more characters.");
		MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] hash = md.digest(password.getBytes());
		StringBuilder sb = new StringBuilder(32);
		for (byte b : hash)
			sb.append(String.format("%02x", b));
		setPasswordHash(sb.toString());
	}
	
	public String getPassword() {
		return password;
	}
	
	@Override
	public String toString() {
		return String.format("Employee[%s, %s, %s, %s]",
			lastName, firstName, username, getPassword());
	}
}












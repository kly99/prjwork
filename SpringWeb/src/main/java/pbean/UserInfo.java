package pbean;

import vbean.VUserInfo;

public class UserInfo {
	private String userid;
	private String password;
	private String name;
	private String email;
	private String role;
	
	public UserInfo() {}
	
	public UserInfo(VUserInfo userInfo){
		this.userid = userInfo.getUserid();
		this.password = userInfo.getPassword();
		this.name = userInfo.getName();
		this.email = userInfo.getEmail();
		this.role = userInfo.getRole();
		
	}
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
}

package vbean;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class VUserInfo {
	@NotEmpty(message="아이디는 필수 입력입니다.")
	private String userid;
	@NotEmpty(message="패스워드는 필수 입력입니다.")
	private String password;
	@NotEmpty(message="이름은 필수 입력입니다.")
	private String name;
	@NotEmpty(message="이메일은 필수 입력입니다.")
	@Email(message="이메일 형식을 지켜주세요.")
	private String email;
	
	private String role;
	
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

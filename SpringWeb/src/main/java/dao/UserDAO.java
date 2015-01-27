package dao;

import java.util.List;

import pbean.BoardFile;
import pbean.UserInfo;

public interface UserDAO {
	//로그인
	public UserInfo login(UserInfo userInfo);
	//이름으로 사용자 검색
	public List<UserInfo> searchByName(String name);
	//사용자 추가
	public void addUser(UserInfo userinfo);
	//아이디 중복 체크
	public List<UserInfo>searchByIdAjax(String userId);
	
	//role값 가져오기
	public List<UserInfo>searchByRole(String role);
}

//UserDaoImpl
//UserMapper.xml
//select * from userinfo
//where userid=? and pawssword=?

//UserLogic
//UserLogicImpl
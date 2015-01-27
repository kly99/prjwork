package logic;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.UserDAO;
import pbean.UserInfo;
import vbean.VUserInfo;

@Service
public class UserLogicImpl implements UserLogic{
	@Autowired
	private UserDAO userDAO;
	
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public UserInfo login(VUserInfo userInfo) {
		UserInfo Info = new UserInfo(userInfo);
		return this.userDAO.login(Info);		
	}

	@Transactional
	public List<UserInfo> searchByName(String name) {
		if(name == null || name.equals("")){
			return Collections.emptyList();
		}else{
			return this.userDAO.searchByName(name);			
		}
	}

	@Override
	public void addUser(VUserInfo userInfo) {
		UserInfo info = new UserInfo(userInfo);
		this.userDAO.addUser(info);
	}

	@Override
	public List<UserInfo> searchByIdAjax(String userId) {
		return this.userDAO.searchByIdAjax(userId);
	}

	@Override
	public List<UserInfo> searchByRole(String role) {
		return this.userDAO.searchByRole(role);
	}
}

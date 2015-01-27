package dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import pbean.BoardFile;
import pbean.UserInfo;
import utills.MyBatisManager;
import dao.UserDAO;

@Repository
public class UserDAOImpl extends SqlSessionDaoSupport implements UserDAO {

	@Override
	public UserInfo login(UserInfo userInfo) {
		return getSqlSession().selectOne("login",userInfo);
		
		}

	@Override
	public List<UserInfo> searchByName(String name) {
		return getSqlSession().selectList("searchByName",name);
	}

	@Override
	public void addUser(UserInfo userinfo) {
		getSqlSession().insert("addUserInfo",userinfo);
	}

	@Override
	public List<UserInfo> searchByIdAjax(String userId) {
		return getSqlSession().selectList("searchById",userId);
	}

	@Override
	public List<UserInfo> searchByRole(String role) {
		return getSqlSession().selectList("searchByRole",role);
	}
	}

package dao.mybatis;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import pbean.Board;
import pbean.BoardFile;
import utills.MyBatisManager;
import dao.BoardDAO;

//실제 코드를 구현하는 곳
public class BoardDAOImpl implements BoardDAO {

	@Override
	public List<Board> getBoardList() {
		List<Board> list = null;
		SqlSession sqlSession = MyBatisManager.getSqlSession().openSession();
		
		try{ //sql을 닫아주기 위함.
			return sqlSession.selectList("getBoardList");
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			sqlSession.close();
		}
		return list;
	}

	@Override
	public List<Board> getBoardList(Map<String, Object> map) {
		List<Board> list = null;
		SqlSession sqlSession = MyBatisManager.getSqlSession().openSession();
		try{
		list =	sqlSession.selectList("getBoardListPaging", map);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			sqlSession.commit();
			sqlSession.close();
		}
		return list;
	}
	
	@Override
	public Board getBoard(int num) {
		Board board = null;
		SqlSession sqlSession = MyBatisManager.getSqlSession().openSession();
			
		try{
			board = sqlSession.selectOne("getBoard" , num);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			sqlSession.close();
		}
		return board;
	}
	@Override
	public void addArticle(Board board) {
		
		SqlSession sqlSession = MyBatisManager.getSqlSession().openSession();
		try{
		sqlSession.insert("insertBoard",board);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
		sqlSession.commit();
		sqlSession.close();
	}
	}
		
	@Override
	public void updArticle(Board board) {
		SqlSession sqlSession = MyBatisManager.getSqlSession().openSession();
		try{
		sqlSession.update("updateBoard", board);
		}catch(Exception e){
		e.printStackTrace();
		}finally{
			sqlSession.commit();
			sqlSession.close();
		}
	}

	@Override
	public void delArticle(int num) {
		SqlSession sqlSession = MyBatisManager.getSqlSession().openSession();
		try{
		sqlSession.delete("deleteBoard", num);
		}catch(Exception e){
	    e.printStackTrace();
		}finally{
		sqlSession.commit();
		sqlSession.close();
	}
	}

	@Override
	public void addArticleCount(int num) {
		SqlSession sqlSession = MyBatisManager.getSqlSession().openSession();
		try{
		sqlSession.insert("updateCount", num);
		}catch(Exception e){
	    e.printStackTrace();
		}finally{
		sqlSession.commit();
		sqlSession.close();
	}
}

	@Override
	public int getBoardCnt() {
	      int cnt = 0;
	      SqlSession sqlSession = MyBatisManager.getSqlSession().openSession();
	      try {
	         cnt = sqlSession.selectOne("getBoardCount");
	      }
	      catch (Exception e) {
	         e.printStackTrace();
	      }
	      finally {
	         sqlSession.close();
	      }
	      return cnt;
	   }

	@Override
	public void addVideo(BoardFile video) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<BoardFile> getBoardFile(int boardnum) {
		List<BoardFile> list = null;
		SqlSession sqlSession = MyBatisManager.getSqlSession().openSession();
		
		try{ //sql을 닫아주기 위함.
			return sqlSession.selectList("getBoardFile");
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			sqlSession.close();
		}
		return list;
	}
	
}

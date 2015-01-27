package dao.mybatis;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import pbean.Board;
import pbean.BoardFile;
import dao.BoardDAO;

@Repository
public class BoardDAOImpl2 extends SqlSessionDaoSupport implements BoardDAO{

	@Override
	public List<Board> getBoardList() {
		return getSqlSession().selectList("getBoardList");
	}

	@Override
	public List<Board> getBoardList(Map<String, Object> map) {
		return getSqlSession().selectList("getBoardListPaging", map);
	}

	@Override
	public Board getBoard(int num) {
		return getSqlSession().selectOne("getBoard" , num);
	}

	@Override
	public void addArticle(Board board) {
		getSqlSession().insert("insertBoard",board);
	}

	@Override
	public void updArticle(Board board) {
		getSqlSession().update("updateBoard", board);
	}

	@Override
	public void delArticle(int num) {
		getSqlSession().delete("deleteBoard", num);
	}

	@Override
	public void addArticleCount(int num) {
		getSqlSession().insert("updateCount", num);
	}

	@Override
	public int getBoardCnt() {
		return getSqlSession().selectOne("getBoardCount");
	}
	@Override
	public void addVideo(BoardFile video) {
		getSqlSession().insert("insertBoardFile",video);
		
	}

	@Override
	public List<BoardFile> getBoardFile(int boardnum) {
		return getSqlSession().selectList("getBoardFile", boardnum);
	}
}

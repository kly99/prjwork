package logic;

import java.util.List;
import java.util.Map;

import dao.BoardDAO;
import pbean.Board;
import pbean.BoardFile;
import vbean.VBoard;

public class BoardLogicImpl implements BoardLogic {

	private BoardDAO boardDAO;

	public void setBoardDAO(BoardDAO boardDAO) {
		this.boardDAO = boardDAO;
	}
	@Override
	public List<Board> getBoardList() {
		return this.boardDAO.getBoardList();
	}
	
	public Board getBoard(int num) {
		return this.boardDAO.getBoard(num);
	}
	@Override
	public void addArticle(VBoard vboard) {
		Board board = new Board(vboard);
/*		board.setNum(vboard.getNum());
		board.setUserid(vboard.getUserid());
		board.setTitle(board.getTitle());
		board.setContent(board.getContent());
		board.setCount(board.getCount());
		board.setRegdate(board.getRegdate());
		board.setFilename(board.getFilename());
		board.setRef(board.getRef());
		board.setRe_step(board.getRe_step());
		board.setRe_level(board.getRe_level());*/
		this.boardDAO.addArticle(board);
		
	}
	@Override
	public void updArticle(VBoard vboard) {
		Board board = new Board(vboard);
		this.boardDAO.updArticle(board);
	}
	
	@Override
	public void delArticle(int num) {
		this.boardDAO.delArticle(num);
	}
	@Override
	public void addArticleCount(int num) {
		this.boardDAO.addArticleCount(num);
	}
	@Override
	public List<Board> getBoardList(Map<String, Object> map) {
		return this.boardDAO.getBoardList(map);
	}
	@Override
	public int getBoardCnt() {
		return this.boardDAO.getBoardCnt();
	}
	@Override
	public List<BoardFile> getBoardFile(int boardnum) {
		return this.boardDAO.getBoardFile(boardnum);
	}
}

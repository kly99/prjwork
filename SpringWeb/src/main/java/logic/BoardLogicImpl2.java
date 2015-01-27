package logic;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.BoardDAO;
import pbean.Board;
import pbean.BoardFile;
import vbean.VBoard;
import vbean.VideoFileItem;

@Service
public class BoardLogicImpl2 implements BoardLogic{
	
	@Autowired
	private BoardDAO boardDAO;
	
	@Override
	public List<Board> getBoardList() {
		return this.boardDAO.getBoardList();
	}

	@Override
	public List<Board> getBoardList(Map<String, Object> map) {
		return this.boardDAO.getBoardList(map);
	}

	@Override
	public Board getBoard(int num) {
		return this.boardDAO.getBoard(num);
	}

	@Transactional
	   public void addArticle(VBoard vboard) {
	      Board board = new Board(vboard);
	      this.boardDAO.addArticle(board);
	      for(VideoFileItem item : vboard.getVideoList())
	      {
	    	  if(!item.getName().equals("")){
	         String filename = item.getName() + ".mp4";
	         int boardnum = board.getNum();
	         BoardFile video = new BoardFile();
	         video.setFilename(filename);
	         video.setBoardnum(boardnum);
	         this.boardDAO.addVideo(video);
	    	  }
	      }
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
	public int getBoardCnt() {
		return this.boardDAO.getBoardCnt();
	}

	@Override
	public List<BoardFile> getBoardFile(int boardnum) {
		return this.boardDAO.getBoardFile(boardnum);
	}
	}


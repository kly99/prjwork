package logic;

import java.util.List;
import java.util.Map;

import pbean.Board;
import pbean.BoardFile;
import vbean.VBoard;

public interface BoardLogic {
	//전체게시물 조회
	public List<Board> getBoardList();
	//부분 게시물 조회
	public List<Board> getBoardList(Map<String, Object> map);
	//게시물 1건 조회
	public Board getBoard(int num);
	//게시물 추가
	public void addArticle(VBoard vboard);
	//게시물 수정
	public void updArticle(VBoard vboard);
	//게시물 삭제
	public void delArticle(int num);
	//조회수 증가
	public void addArticleCount(int num);
	//게시물 건수 조회
	public int getBoardCnt();
	
	//동영상 목록 가져오기
	public List<BoardFile> getBoardFile(int boardnum);
}

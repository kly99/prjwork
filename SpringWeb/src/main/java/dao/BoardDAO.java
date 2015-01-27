package dao;

import java.util.List;
import java.util.Map;

import pbean.Board;
import pbean.BoardFile;

public interface BoardDAO {
	//전체 게시물 조회
	public List<Board> getBoardList();
	//부분 게시물 조회
	public List<Board> getBoardList(Map<String, Object> map);
	//게시물 1건 조회
	public Board getBoard(int num);
	//게시물 추가
	public void addArticle(Board board);
	//게시물 수정
	public void updArticle(Board board);
	//게시물 삭제
	public void delArticle(int num);
	//조회수 증가
	public void addArticleCount(int num);
	//게시물 갯수 취득
	public int getBoardCnt();
	//동영상 추가
	public void addVideo(BoardFile video);
	//동영상 목록 가져오기
	public List<BoardFile> getBoardFile(int boardnum);
	
}

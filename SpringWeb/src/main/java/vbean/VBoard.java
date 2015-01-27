package vbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import pbean.Board;

public class VBoard implements Serializable{
	private static final long serialVersionUID = 1L;
	 private int num;
	 private String userid;
	 private String title;
	 private String content;
	 private int count;
	 private Date regdate;
	 private String filename;
	 private MultipartFile file;
	 private List<VideoFileItem> videoList;

	private int ref;
	 private int re_step;
	 private int re_level;
	 
	public VBoard() {
		this.videoList = new ArrayList<VideoFileItem>();
	}
//	복사 생성자 (매개변수가 있는 생성자) - 맵핑을 하기 위해 생성
	public VBoard(Board board) {
		this.num = board.getNum();
		this.userid = board.getUserid();
		this.title = board.getTitle();
		this.content = board.getContent();
		this.count = board.getCount();
		this.regdate = board.getRegdate();
		this.filename = board.getFilename();
		this.ref = board.getRef();
		this.re_step = board.getRe_step();
		this.re_level = board.getRe_level();
	}
	
	public List<VideoFileItem> getVideoList() {
		return videoList;
	}
	public void setVideoList(List<VideoFileItem> videoList) {
		this.videoList = videoList;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	 public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	public int getRef() {
		return ref;
	}
	public void setRef(int ref) {
		this.ref = ref;
	}
	public int getRe_step() {
		return re_step;
	}
	public void setRe_step(int re_step) {
		this.re_step = re_step;
	}
	public int getRe_level() {
		return re_level;
	}
	public void setRe_level(int re_level) {
		this.re_level = re_level;
	}
}


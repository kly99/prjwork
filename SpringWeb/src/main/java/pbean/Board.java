package pbean;

import java.io.Serializable; // 제목 -> 내용 순으로 읽히지 않을 경우 Serializable을 순서대로 읽힘(?)
import java.util.Date;

import vbean.VBoard;

	//Pbean이란 테이블 db들을 위한 곳
	//Bean 클래스 - 테이블의 칼럼 변수들을 선언해주자.
public class Board implements Serializable{
	//테이블 칼럼명은 소문자로 해주는 것이 좋다.
	 private int num;
	 private String userid;
	 private String title;
	 private String content;
	 private int count;
	 private Date regdate;
	 private String filename;
	 private int ref;
	 private int re_step;
	 private int re_level;
	 
	 public Board() {
	}
	 public Board(VBoard vboard) {
			this.num = vboard.getNum();
			this.userid = vboard.getUserid();
			this.title = vboard.getTitle();
			this.content = vboard.getContent();
			this.count = vboard.getCount();
			this.regdate = vboard.getRegdate();
			this.filename = vboard.getFilename();
			this.ref = vboard.getRef();
			this.re_step = vboard.getRe_step();
			this.re_level = vboard.getRe_level();
	}
	 	 
	 //getter , setter - 인스턴스 변수들이 많을 경우, 생성자보다는 게터,세터를 일반적으로 많이 이용한다.
	 
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

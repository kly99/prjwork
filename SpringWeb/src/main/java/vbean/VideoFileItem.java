package vbean;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

public class VideoFileItem implements Serializable{
	private static final long serialVersionUID = 1L;
	private String name; //비디오 이름
	private MultipartFile file; //비디오 파일
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}

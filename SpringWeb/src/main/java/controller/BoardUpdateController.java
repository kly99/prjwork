package controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import pbean.Board;
import vbean.VBoard;
import logic.BoardLogic;
// SimpleFormController

@Controller
public class BoardUpdateController {
	
	@Autowired
	private BoardLogic boardLogic;
	
	public void setBoardLogic(BoardLogic boardLogic){
		this.boardLogic = boardLogic;
	}
	// JSP 파일명, 즉 뷰에서 읽어드릴 jsp파일명을 이렇게 처리해라. 또는 저 파일명을 읽어와라.
	private String formViewName = "/updateBoardForm";
	
	@RequestMapping(value= "/update.html" , method=RequestMethod.GET)
	public ModelAndView form(@RequestParam("num") int num){
		Board board = this.boardLogic.getBoard(num);
		return new ModelAndView(formViewName, "board", board);
	}
	
	@RequestMapping(value= "/update.html" , method=RequestMethod.POST)
	public String submit(VBoard vboard, HttpServletRequest req) throws IllegalStateException, IOException{
		//파일 업로드
		MultipartFile file = vboard.getFile();
	
		//파일을 업로드 했다면
		if(file.getSize() > 0){
			//파일이름 설정
			vboard.setFilename(file.getOriginalFilename());
			File imageFile = new File(req.getRealPath("/images") , vboard.getFilename());
			file.transferTo(imageFile);
		}
		
		this.boardLogic.updArticle(vboard);
		//스프링에서 되는기능 redirect:
		return "redirect:/boardList.html";
	}
}

package controller;

import logic.BoardLogic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardDeleteController {
	@Autowired
	private BoardLogic boardLogic;

	public void setBoardLogic(BoardLogic boardLogic) {
		this.boardLogic = boardLogic;
	}
	
	@RequestMapping(value="/delete.html",method=RequestMethod.GET)
	public ModelAndView process(@RequestParam("num") int num){
		boardLogic.delArticle(num);
		return new ModelAndView("redirect:/boardList.html");
	}
}

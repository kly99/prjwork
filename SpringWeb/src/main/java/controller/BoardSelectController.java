package controller;

import java.util.List;

import logic.BoardLogic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pbean.Board;
import pbean.BoardFile;

@Controller
public class BoardSelectController {
	
	@Autowired
	private BoardLogic boardLogic;

	public void setBoardLogic(BoardLogic boardLogic) {
		this.boardLogic = boardLogic;
	}
	
	@RequestMapping("/detail.html") //http://detail.html?num= 과 같은 의미가 RequestParam : num값을 넘겨라
	public ModelAndView process(@RequestParam("num") int num){
		Board board = this.boardLogic.getBoard(num);
		this.boardLogic.addArticleCount(num);	
		List<BoardFile> boardfile = this.boardLogic.getBoardFile(num);
		this.boardLogic.getBoardFile(num);
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.setViewName("boardSelect");
		modelAndView.addObject("board",board);
		modelAndView.addObject("boardfile",boardfile);

		return modelAndView;	
	}
}
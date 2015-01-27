package controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller //스프링에게 알린다.
public class LogoutController {
	
	@RequestMapping("/logout") //메인페이지는 index.html이 된다.
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse res)throws Exception{
		ModelAndView modelAndView = new ModelAndView();
	
		HttpSession session = req.getSession();
		session.setAttribute("user", null);
		session.invalidate(); //정보를 지워라.
		
		modelAndView.setViewName("redirect:/login.html"); //뷰 이름을 index로 처리해라.
		return modelAndView;
	}
}
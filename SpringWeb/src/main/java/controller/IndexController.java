package controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller //스프링에게 알린다.
public class IndexController {
	
	@RequestMapping("/index") //메인페이지는 index.html이 된다.
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse res)throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		
		//현재시간
		String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss초").format(Calendar.getInstance().getTime());
		
		//View
		modelAndView.setViewName("index"); //뷰 이름을 index로 처리해라.
		
		//Model
		modelAndView.addObject("now", timestamp); //now 는 모델이름 , timestamp는 실제 모델 객체 
		
		return modelAndView;
	}
}
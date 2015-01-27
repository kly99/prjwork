package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import logic.BoardLogic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import aop.AdminAuthorize;
import aop.Authrorize;
import pbean.Board;

@Controller
public class BoardListController {

	@Autowired
   private BoardLogic boardLogic;

   public void setBoardLogic(BoardLogic boardLogic) {
      this.boardLogic = boardLogic;
   }

   // 페이지사이즈.(한페이지당 글의 갯수)
   private int pageSize;

   // 페이지 블럭 사이즈.(페이지 블럭의 크기)
   private int pageBlockSize;

   public void setPageSize(int pageSize) {
      this.pageSize = pageSize;
   }

   public void setPageBlockSize(int pageBlockSize) {
      this.pageBlockSize = pageBlockSize;
   }
   
   @RequestMapping("/boardList.html")
   @Authrorize
   @AdminAuthorize
   public ModelAndView handleRequest(
         @RequestParam(value = "pageNum", required = false) String pageNum)
   // required = false 널값이 들어와도 받겠다..?
   // true일 경우 포멧에 맞는 데이타가 꼭 들어와야함.
   // String pageNum -> 특정페이지로가라..
         throws Exception {
      if (pageNum == null) {
         pageNum = "1";
      }
      int currentPage = Integer.parseInt(pageNum); // 현재페이지
      int startRow = (currentPage - 1) * pageSize + 1;// 특정페이지의 시작번호
      int endRow = currentPage * pageSize;

      int count = this.boardLogic.getBoardCnt();
      System.out.println("count : "+count+"/ pageSize : "+pageSize);
      int totalPage = (count - 1) / pageSize;
      int prevPage = ((currentPage - 1) / pageBlockSize) * pageBlockSize;
      int nextPage = prevPage + (pageBlockSize + 1);

      nextPage = (nextPage > totalPage) ? totalPage + 1 : nextPage;

      ModelAndView modelAndView = new ModelAndView();

      Map<String, Object> map = new HashMap<String, Object>();
      map.put("start", startRow);
      map.put("end", endRow);

      List<Board> list = this.boardLogic.getBoardList(map);

      modelAndView.setViewName("boardList");
      modelAndView.addObject("list", list);
      modelAndView.addObject("count", count);
      modelAndView.addObject("currentPage", currentPage);
      modelAndView.addObject("totalPage", totalPage);
      modelAndView.addObject("prevPage", prevPage);
      modelAndView.addObject("nextPage", nextPage);
      modelAndView.addObject("pageSize", pageSize);
      return modelAndView;
   }

}
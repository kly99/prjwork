<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/header.jsp" %>    
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>자유게시판(리스트)</title>
<link rel="stylesheet" href="js/colorbox-master/colorbox.css">
<style type="text/css">
	li{float:left; padding-left:30px; list-style-type: none;}
	.pagination{text-align:center}
</style>
<script src="js/jquery-2.1.3.min.js"></script>
<script src="js/jquery.bxslider/jquery.bxslider.min.js"></script>
<script src="js/colorbox-master/jquery.colorbox-min.js"></script>
<script>
    function goPage(page) {
      location.href = 'boardList.html?pageNum=' + page;
    };
   	$(document).ready(function(){
	     $(".colorbox").colorbox({
    	 rel:"colorbox",
    	 transition:"fade", //elastic, fade, none
    	 speed: 400,
    	 opacity: 0
    	 
      });
   });
</script>
</head>
<body>
   <h2 align="center">관리자 게시판</h2>
   <table border="1" width="500" cellpadding="0" cellspacing="0">
      <tr>
         <td><a href="insert.html">글쓰기</a></td>
      </tr>
      <tr>
         <td width="80">번호</td>
         <td width="200">제목</td>
         <td width="80">작성자</td>
         <td width="80">조회수</td>
         <td width="80">파일</td>
         <td width="80">날짜</td>
      </tr>

      <c:forEach var="board" items="${list}">
         <tr>
            <td width="80">${board.num}</td>
            <td width="200"><a href="detail.html?num=${board.num}">${board.title}</a></td>
            <td width="80">${board.userid}</td>
            <td width="80">${board.count}</td>
            <td width="80">
              <c:if test="${board.filename != '' }">
            <a class="colorbox" title="${board.filename }"  href="./images/${board.filename}">${board.filename}</a>
             </c:if>
            <c:if test="${board.filename == null }">
            비었음
            </c:if>
            </td>
            <td width="80"><fmt:formatDate value="${board.regdate}"
                  pattern="yyyy/MM/dd HH:mm:ss" /></td>
         </tr>
      </c:forEach>

   </table>
   count:${count}
   <br /> totalPage:${totalPage}
   <br /> pageSize:${pageSize}
   <br /> currentPage:${currentPage}
   <br /> prevPage:${prevPage}
   <br /> nextPage:${nextPage}
   <br />

   <div class="pagenation" style="padding-left: 150px;">
      <ul>
         <!-- 이전버튼 -->
          <c:if test="${prevPage gt 0 }">
            <li class="prev"><a href="javascript:goPage(${prevPage });">Prev</a>
         </c:if>
         <c:forEach begin="${1 + prevPage}" end="${nextPage - 1}"
                        step="1" varStatus="status">
               <c:choose>
                  <c:when test="${currentPage eq status.index}">
                     <li class="current">${status.index}</li>
                  </c:when>
                  <c:otherwise>
                     <li><a href="javascript:goPage(${status.index });">${status.index}</a></li>
                  </c:otherwise>
               </c:choose>
         </c:forEach>

         <!-- 다음 -->
         <c:if test="${totalPage gt nextPage}">
            <li class="next"><a href="javascript:goPage(${nextPage});">Next</a></li>
         </c:if>
      </ul>
   </div>
</body>
</html>








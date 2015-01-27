<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "/WEB-INF/view/header.jsp" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>자유 게시판(글쓰기)</title>
<script src="js/board.js"></script>

</head>
<body>
   <h2>자유 게시판</h2>
   <form:form modelAttribute="boardForm" name="writeForm" method="post" action="insert.html"  enctype="multipart/form-data">
   <table border="0" width="700" cellpadding="0" cellspacing="0"  >
      <tr><td>글쓰기</td></tr>
      <tr><td>
         
            <table border="1" align="center">
               <tr>
                  <td width="100">제목</td>
                  <td width="400">
                     <input id="inputid" type="text" name="title"/>
                  </td>
               </tr>
               <tr>
                  <td width="100">내용</td>
                  <td width="400">
                     <textarea id="contentid" name="content" rows="10" cols="70"></textarea>
                  </td>
               </tr>
               <tr>
               	<td width="100">파일</td>
               	<td width="400">
                     <input type="file" name="file"  />
                  </td>
               </tr>
                  <tr>
               	<td width="100">비디오 업로드</td>
               	<td width="400">
  					<c:forEach items="${boardForm.videoList }" var="video" varStatus="videoStatus"> <!-- varStatus 변수값? -->
  					<p>
  						<form:input path="videoList[${videoStatus.index }].name" />
						<form:input path="videoList[${videoStatus.index }].file" type="file" />
  					</p>
  					</c:forEach>
                  </td>
                  <tr><td colspan="2">
            <form:errors path="*" element="div"/><!-- *값은 모든에러가 다 출력된다. -->
         </td></tr>
               </tr>
            </table>
            <input type="hidden" name="userid" value="${sessionScope.user.userid}"/>
            <input type="hidden" name="count" value="0"/>
         
      </td></tr>
      <tr><td>
         <input type="button" value="등록" onclick= "javascript:save()"/>
         <input type="button" value="취소" onclick="history.go(-1)"/>
      </td></tr>
   </table>
   </form:form>
   
</body>
</html>
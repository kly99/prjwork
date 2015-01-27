<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "/WEB-INF/view/header.jsp" %>    

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>자유게시판 (글 읽기)</title>
</head>
<body>
	<form name="form1" method="post" action="">
		<table width="700"  border="1">
			<tr>
				<th width="125">글 번호</th>
				<td width="125">${board.num}</td>
				<th width="125">조회수</th>
				<td width="125">${board.count}</td>
			</tr>
			<tr>
				<th width="125">작성자</th>
				<td width="125">${board.userid}</td>
				<th width="125">작성일</th>
				<td width="125"><fmt:formatDate value="${board.regdate}" pattern="yyyy-MM-dd HH:mm" /></td>
			</tr>
			<tr>
				<th width="125">글제목</th>
				<td width="375" colspan="3">${board.title}</td>
			</tr>
			<tr>
				<th width="125">글내용</th>
				<td width="375" colspan="3">
					<textarea rows="13" cols="18" readonly="readonly">${board.content}</textarea>
				</td>
			</tr>
			<tr>
				<th width="125">첨부 파일</th>
				<td width="375" colspan="3">
				<c:if test="${board.filename !=null}">
						<a class="colorbox" href="./images/${board.filename}"
							title="${board.filename}">${board.filename}</a>
					</c:if> 
					<c:forEach var="boardfile" items="${boardfile}">
						<c:if test="${boardfile.filename!=null}"><a class="download" href="download.html?filename=${boardfile.filename}"
							title="${boardfile.filename}">${boardfile.filename}</a></c:if>
					</c:forEach> 
					<c:if test="${board.filename ==null}">
				첨부파일없음
					</c:if>
				
				</td>
			</tr>
		</table>
		<table width="700" border="0" cellpadding="15">
      <tr>
         <td>
            <input type="button" value="목록" onclick="location.href='boardList.html'"/>
            <input type="button" value="수정" onclick="location.href='update.html?num=${board.num}'"/>
            <input type="button" value="삭제" onclick="location.href='delete.html?num=${board.num}'"/>
         </td>
      </tr>
      </table>
	</form>
</body>
</html>
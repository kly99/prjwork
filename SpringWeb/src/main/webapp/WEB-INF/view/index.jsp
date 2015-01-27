<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "/WEB-INF/view/header.jsp" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Hello World</h1>
	<h2>현재 시간 : ${now}</h2>
		<form:form modelAttribute="loginForm">
	<table border="1" >
	
			<tr>
				<td>아이디 : </td>
				<td><form:input path="userid" /></td>
			</tr>	
			
			<tr>
				<td>비밀번호</td>
				<td><form:password path="password" showPassword="true"/></td>
			</tr>
			
			<tr>
				<td colspan="2"><input type="submit" value="로그인" /></td>
			</tr>
	
	</table>
		</form:form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/header.jsp" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
<style type="text/css">
#img1{display:none;}
#img2{display:none;}
span{float: right;'}
</style>
<script src="js/jquery-2.1.3.min.js"></script>
<script>
$(document).ready(function(){
		$("#userid").blur(function(){

			var nm = $("#userid").val();
			$.ajax({
				cache:false,
				type : "POST", 
				url: "userSearchId.json", 
				data: {"userId": nm}, 
				dataType: "json",
				success:function(data){ 
					
				
					if(data.length == 0){
						$("#img2").css("display","block");
						$("#img1").css("display","none");
					}else{
						$("#img1").css("display","block");
						$("#img2").css("display","none");
					}
				},
				error:function(xhr, textStatus, errorThrown){
						//에러 타입
						if(textStatus == "timeout"){
							alert("시간 초과!");
						}else{
							alert("textStatus : " + textStatus);
						}
						alert("errorThrown : " + errorThrown);
				}
				
			});
		});
	});
	</script>
</head>
<body>
   <h1>회원 가입</h1>
   <p>회원 가입 해주시기 바랍니다.</p>
   <table>
      <form:form modelAttribute="signUpForm">
         <tr><td colspan="2">
            <form:errors path="*" element="div"/><!-- *값은 모든에러가 다 출력된다. -->
         </td></tr>
         
         <tr><td>
            <form:label path="userid">아이디</form:label>
         </td><td>
            <form:input path="userid" size="20"/>
            <span id="dupmsg"><img id="img1" alt="" src="images/1.png"><img id="img2" alt="" src="images/2.png"></span>
         </td></tr>
         
         <tr><td>
            <form:label path="password">패스워드</form:label>
         </td><td>
            <form:password path="password" size="20"/>
         </td></tr>
         
         <tr><td>
            <form:label path="name">이름</form:label>
         </td><td>
            <form:input path="name" size="20"/>
         </td></tr>
         
         <tr><td>
            <form:label path="email">이메일</form:label>
         </td><td>
            <form:input path="email" size="20"/>
         </td></tr>
         
         <tr><td colspan="2">
            <input type="submit" value="가입"/>
         </td></tr>
         
      </form:form>
   </table>
</body>
</html>

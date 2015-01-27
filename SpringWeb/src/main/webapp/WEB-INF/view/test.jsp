<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#here{width: 100px; height:100px; background: blue;}
.add{width:300px;}
</style>
<script src="js/jquery-2.1.3.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#change").click(function(){
		$(".here").css("background","yellow");		
	});
});
</script>
</head>
<body>
<div id="here"></div>
<button id="change">CHANGE</button>
</body>
</html>
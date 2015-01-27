<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="js/jquery.bxslider/jquery.bxslider.css">
<style type="text/css">
.div1{width:100px; height: 100px; background: red;}
.div2{width:100px; height: 100px; background: blue;}
img{width:300px; height:300px; padding:50px;}


#btn{width:100px;}
#btn.hover{width:300px; }
.add{display: none;}

</style>
<script src="js/jquery-2.1.3.min.js"></script>
<script src="js/jquery.bxslider/jquery.bxslider.min.js"></script>
<script>
	$(document).ready(function(){
		$(".bxslider").bxSlider({
			mode:'horizontal',
			speed:1000,
			auto:true,
			autoControls:true,
			adaptiveHeight:true,
			captions:false
					
		});
//			alert('jquery test!');
			$("h1").css("color","blue");
			$(".test").css("color","blue");
			$("#love").css("color","red");
			//$("#test1").html("실패는 성공의 어머니").css({"color":"yellow", "background":"blue"});
		/* 	
			var test = $("#test1").text();
			alert(test);
			$("#test1").text('<h1>구구가가 구구가가</h1>')
		
			var tr = $("#travel").val();
			var sp = $("#spot").val();
			alert(tr);
			alert(sp);
			$("#travel").val("WELCOME~");
			$("#spot").val("울릉도");
			
			$("#travel").val("");
			$("#spot").val(""); */
			
			$("#travel").blur(function(){
				/* alert("한국을 들려주셔서 땡유"); */
			});
			
			$("#test1").mouseover(function(){
				$("#test1").css({"background-color":"blue","color":"white","height":"30","font-size":"20px"});
			});
			 $("#test1").mouseout(function(){
				$(this).css({"background-color":"white","color":"black","height":"20","font-size":"11px"});
			});
			$("#spot").change(function(){
				/* alert($(this).val()+"는 어때?"); */
			});
			
	/* 		$("#btnl").dblclick(function(e){
				 var $t = $(e.target);
				 $t.font($t.font()+1);
			}); */
			
			$("#travel").focus(function(){
				/* alert('welcome'); */
			});
			
			$("#btnl").hover(function(){
					$("#btnl").css("width","100px");
					$("#test1").fadeOut("slow");
					$(".div1").addClass(".bdline");
				},
				function(){
					$("#btnl").css("width","50px");
					$("#test1").fadeIn("slow");
				}
			);
		
			$("#btnl2").click(function(){
				$(".div1").slideUp("slow");
			});
			$("#btnl2").dblclick(function(){
			$(".div1").slideDown("slow");
			});
			
			$(".div2 > p").each(function(){
				/* alert($(this).text()); */
			});
			
			$("#btn").hover(function(){
				$("#btn").addClass(".hover");
			});
	});
	
	$(document).ready(function(){
		$("#searchBtn").click(function(){

			var nm = $("#name").val();
			$.ajax({
				cache:false,
				timeout:3000, //3초 이내 결과가 안나오면 에러
				type : "POST", //GET or POST
				url: "userSearch.json", //접속할 URL
				data: {"name": nm}, //파라미터
				dataType: "json", // 출력 데이터 타입 (html, xml, json , text)
				success:function(data){ //성공(OK:200)시 처리
					/* alert("OK : 200"); */
					//테이블로 표시
					//테이블 삭제
					$("#jsonOut > table").remove();
					var theTable = $("<table border='1'>"); // 테이블 요소 작성
					theTable.append("<tr><td>이름</td> <td>비밀번호</td> <td>아이디</td> <td>이메일</td></tr>"); // 테이블에 추가						
					for(i = 0; i <data.length; i++){
						//테이블에 내용 추가
						theTable.append("<tr><td>" + data[i].name +  "</td> <td>" + data[i].password +  "</td>  <td>" + data[i].userid +  "</td>  <td>" + data[i].email +  "</td></tr>");
					}
					//theTable을 jsonOut에 붙인다.
					theTable.appendTo("#jsonOut");
				},
				error:function(xhr, textStatus, errorThrown){
						//에러 타입
						if(textStatus == "timeout"){
							alert("시간 초과!");
						}else{
							alert("textStatus : " + textStatus);
						}
						/* //에러 메시지
						alert("errorThrown : " + errorThrown); */
				}
				
			});
		});
	});
	
</script>
</head>
<body>
	<h1>${sessionScope.user.userid } 님 하이</h1>
	<a href="insert.html">글 쓰기</a>
	<a href="logout.html">LogOut</a>
	<div class ="test">
	<p>I am a student</p>
	</div>
	<div id ="love">
	<p>I am a student</p>
	</div>
	<div id = "test1">
	구슬이 서말이라도 꿰어야 보배<em>하하</em>
	</div>
	<p>
	<input type="text" id="travel" value="한국여행가이드" />
	<select id="spot">
		<option value="제주도">제주도</option>
		<option value="울릉도">울릉도</option>
		<option value="독도" selected="selected">독도</option>
	</select>
	</p>
	<button id="btnl">CLICK</button>
	<button id="btnl2">CLICK</button>
	<div class=div1></div>
	<div class=div2>
		<p>가나다</p>
		<p>라마바</p>
		<p>호오</p>
	</div>
	
	<div class="slider" style="width:300px">
		<ul class="bxslider">
			<li><img src="images/Lighthouse.jpg" title="" /></li>
			<li><img src="images/abc.jpg" title="" /></li>
			<li><img src="images/zzz.jpg" title="" /></li>
			<li><img src="images/def.jpg" title="" /></li>
		</ul>
	</div>
	
	<p>이름 : <input type = "text" id="name" /></p>
	<p><button id="searchBtn">검색</button></p>
	<p><span id="jsonOut">여기에 결과가 출력</span></p>
	
	<p class="ha">가나다라마바자<button id="btn">addClass</button></p>
</body>
</html>
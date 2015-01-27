function save(){
	var tit = document.getElementById("inputid").value.length;
	var con = document.getElementById("contentid").value.length;
	
	var fullfile = document.writeForm.file.value;
	var arr = fullfile.split("\\");
	var filename = arr[arr.length-1];
	
	if(tit == ""){
		alert("글 제목을 입력하세요.");
		tit.focus();
		return false;
	}else if(con == ""){
		alert("글 내용을 입력하세요.");
		con.focus();
		return false;
	}else if(tit > 25){
		alert("제목은 25자 이내로 작성해 주시기 바랍니다.");
		tit.focus();
		return false;
	}else if(con > 250){
		alert("내용은 250자 이내로 작성해 주시기 바랍니다.");
		con.focus();
		return false;
	}else if(filename.length > 20){
		alert("파일이름의 글자 수가 너무 깁니다.(20자 이내)")
		return false;
	}
	var f = document.writeForm;
	f.submit();
}
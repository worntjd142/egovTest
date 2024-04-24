<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script>
  $( function() {
	 $("#btn_submit").click(function(){
		var userid = $("#userid").val();
		var pass = $("#pass").val();
		alert(pass);
		if(userid == ""){
			alert("아이디를 입력해주세요");
			$("#userid").focus();
			return false;
		}
		if(pass == ""){
			alert("패스워드를 입력해주세요");
			$("#pass").focus();
			return false;
		}
		
		$.ajax({
			type:"POST",
			data:"userid="+userid+"&pass="+pass,
			url:"loginProc.do",
			dataType:"text",
			success:function(result){
				if(result == "ok"){
					alert(userid + "님 로그인에 성공하였습니다.");
					$("#frm")[0].reset();
					location.href="main.do";
				}else if(result == "x"){
					alert(userid + " 해당아이디는 없는 아이디입니다");
				}else{
					alert(userid + "님 패스워드가 틀렸습니다");
				}
			},	
			error:function(){
				alert("에러가 발생하였습니다.");
			}
		});
	 }); 
  });
</script>
</head>
<body>
	<%@ include file="topMenu.jsp" %>
	<form name="frm" id="frm">
		<table>
			<caption>로그인 </caption>
			<tr>
				<th><label for="userid">아이디</label></th>
				<td><input type="text" name="userid" id="userid" placeholder="아이디">
				</td>
			</tr>
			<tr>
				<th><label for="pass">패스워드</label></th>
				<td><input type="password" name="pass" id="pass">
				</td>
			</tr>
		</table>
		<div class="div_btn">
			<button type="button" name="btn_submit" id="btn_submit">로그인</button>
			<button type="reset">취소</button>
		</div>
	</form>
</body>
</html>
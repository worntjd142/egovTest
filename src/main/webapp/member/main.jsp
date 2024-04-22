<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인</title>
</head>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<body>

<form id="frm" >
<c:choose>

<c:when test="${sessionScope.id == null}">
<div id="login_box">

	<input type="text" id="id" name="userid" placeholder="아이디"  style="height:30px"> 
	<br>
	<input type="password" id="pw" name="pass" placeholder="비밀번호" style="height: 30px"> 

</div>

	<input type="button" value="로그인" id="btn_submit" >

</c:when>

<c:otherwise>
<div>
	<label>환영합니다.${sessionScope.id}님</label><br>
	<input type="button" value="로그아웃" id="btn_logout">
</div>

</c:otherwise>





</c:choose>
</form>


<script>
$(function(){
	$("#btn_submit").click(function(){
		
		//<form id="frm">의 값을 가져와서 login_data에 초기화.
		var login_data = $("#frm").serialize();
		
		console.log(login_data)
		
		$.ajax({
			type:"post",
			url:"login.do",
			data: login_data,
			dataType: "text",
			
			success: function(login_data){
				console.log(login_data)
				
				if(login_data == "X"){
					
					alert("아이디가 없습니다.");
					
				}else if(login_data == "N"){
					
					alert("아이디 혹은 비밀번호가 틀렸습니다.")
					
					
				}else {
					
					location.href="main.do"
					
				}
				
			},
			error:function(){
				
				alert("매우 언짢음");
			}
			
			
		})
		
	})
	
	$("#btn_logout").click(function(){
		
		$.ajax({
			type: "get",
			url:"logout.do",
			
			success:function(data){
			
				if(data == "bye"){
					location.href="main.do"
				}
			
			},
			
			error:function(){
				
				alert("헐");
				
			}
			
		})
		
		
	})
	
	
	
	
})

</script>



</body>
</html>
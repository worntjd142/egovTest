<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DOG DRIP</title>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
$(function(){
	$("#btn_login").click(function(){
		
		var frm = $("#frm").serialize();
		
		console.log(frm)
		
		$.ajax({
			type:"post",
			url:"insert.do",
			data:frm,
			dataType:"text",
			
			success: function(){
				
				alert("aa");
			},
			
			error: function(){
				alert("error");
			}
			
		})
		
		
	})
	
	
	
	
})

</script>
</head>

<body>

<h1>개드립</h1>

<form id="frm">

<div>
<input type="text" placeholder="아이디" name="userid" id="userid"><br>
<input type="text" placeholder="패스워드" name="pass" id="pass">
<input type="submit" value="로그인" id="btn_login">
</div>

<table border="1">
<caption> 게시판 </caption>

<tr>
<th>제목</th>
<th>작성자</th>
</tr>
<c:forEach items="${board_list}" var="list">
<tr>
<td>
<a href="board_text.do"><c:out value="${list.title}"/></a><label>${list.good}</label>
</td>
<td>
<c:out value="${list.userid}" />
</td>
<td>
<c:out value="${list.wirteday}" />
</td>



</tr>
</c:forEach>




</table>

</form>
</body>
</html>
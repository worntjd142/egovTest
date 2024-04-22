<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
body {
	font-size: 9pt;
	font-colr: #333333;
	font-family: 맑은 고딕;
}

a {
	text-decoration: none;
}

table {
	width: 600px;
	border-collapse: collapse; /* cell 간격 조정*/
}

th, td {
	border: 1px solid #cccccc;
	padding: 3px;
	line-height: 2;
}

.div_btn {
	width: 600px;
	text-align: center;
	margin-top: 5px;
}

caption {
	font-size: 15px;
	font-weight: bold;
	margin-top: 10px;
	padding-bottom: 5px;
}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	String sUID = (String)session.getAttribute("sessionId");
%>
	<table>
		<tr>
			<th><a href="main.do">홈</a></th>
			<th>...</th>
			<%
			if(sUID == null) {
			%>
			<th><a href="memberWrite.do">회원가입</a></th>
			<th><a href="login.do">로그인</a></th>
			<%
			} else {				
			%>
			<th><a href="logout.do">로그아웃</a></th>
			<% 
			}
			%>
		</tr>
	</table>
</body>
</html>
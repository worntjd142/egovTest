<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인</title>
</head>
<body>
	<%@ include file="topMenu.jsp" %>

<table border="1">


<caption>회원가입자</caption>
	<c:forEach items="${data}" var ="member" varStatus="count">
	
	<tr>
	<td>${count.count}. ${member.userid} </td>
	<td>${member.name} </td>
	<td>${member.tel} </td>
	<td>${member.birth} </td>
	<td>${member.address} </td>
	
	</tr>
	</c:forEach>

</table>

</body>
</html>
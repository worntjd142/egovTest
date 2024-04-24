<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 리스트</title>
</head>
<body>
	<%@ include file="topMenu.jsp" %>
	<table>
		<tr>
			<th width="10%">순번 </th>
			<th width="10%">사용자아이디</th>
			<th width="10%">비밀번호
			<th width="10%">이름
			<th width="20%">전화번호
			<th width="30%">주소
		</tr>
		<tr>
			<c:forEach var="list" items="${memberList}">
				<td><c:out value="${list.row }"/> </td>
				<td><c:out value="${list.userid }"/> </td>
				<td><c:out value="${list.pass }"/> </td>
				<td><c:out value="${list.name }"/> </td>
				<td><c:out value="${list.tel }"/> </td>
				<td><c:out value="${list.address }"/> </td>
		</tr>
			</c:forEach>
	</table>
</body>

</html>
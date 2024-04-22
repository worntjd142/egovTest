<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" 	href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
<script>
	// 생년월일 jQuery ui
	$(function() {
		$("#datepicker").datepicker({
			changeMonth : true,
			changeYear : true,
			dateFormat : 'yy-mm-dd'
		});

		// id="btn_submit"을 클릭하면
		$("#btn_submit").click(function() {

			var userid = $("#userid").val();
			var pass = $("#pass").val();
			var name = $("#name").val();

			userid = $.trim(userid);
			pass = $.trim(pass);
			name = $.trim(name);

			if (userid == "") {
				alert("아이디 입력하세요")
				$("#userid").focus();
				return false;
			}

			if (pass == "") {
				alert("비밀번호 입력하세요")
				$("#pass").focus();
				return false;
			}

			if (name == "") {
				alert("이름 입력하세요")
				$("#name").focus();
				return false;
			}

			// 반환 값
			$("#userid").val(userid);
			$("#pass").val(pass);
			$("#name").val(name);

			// 비동기 전송방식의 기능을 가지고 있는 jQuery함수
			// serialize : form안에 데이터를 한방에 보냄
			var formData = jQuery("#frm").serialize();
			//한 번에 전송 가능한 data로 만들 수 있어 많은 data를 보낼 때 필요
			$.ajax({
				//전송 전 셋팅
				type : "POST",
				data : formData,
				url : "memberWriteSave.do",
				dataType : "text", //return type

				//전송 후 셋팅
				success : function(result) {
					if (result == "ok") {
						alert("저장 완료하였습니다.");
						$("#frm")[0].reset();
						//location("login.do");
					} else {
						alert("저장 실패하였습니다.");
					}
				},
				
				error : function() { //문제 발생
					alert("error가 발생하였습니다");
				}
			});
			
			// 아이디 중복체크
			$("#btn_idChk").click(function(){
				
				$.ajax({
					type: "get",
					url: "userid_Chk.do",
					data: {userid : userid},
					dataType: "text",
					
					success : function(message) {						
						if(message == "Y") {
							alert("중복된 아이디 아님");
						} else {
							alert("중복된 아이디")
						}
					},
					error : function() { //문제 발생
						alert("error 발생");
					}					
				});
			});
			
			
		});
	});
</script>
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
<title>회원 등록</title>
</head>
<body>
	<%@ include file="topMenu.jsp" %>
	<form name="frm" id="frm">
		<table>
			<caption>회원등록</caption>
			<tr>
				<th><label for="userid">아이디</label></th>
				<td><input type="text" name="userid" id="userid"
					placeholder="아이디">
					<button type="button" id="btn_idChk">중복체크</button></td>
			</tr>
			<tr>
				<th><label for="pass">패스워드</label></th>
				<td><input type="password" name="pass" id="pass"></td>
			</tr>
			<tr>
				<th><label for="name">이름</label></th>
				<td><input type="text" name="name" id="name" placeholder="이름">
				</td>
			</tr>
			<tr>
				<th><label for="gender">성별</label></th>
				<td><input type="radio" name="gender" id="gender" value="m">남
					<input type="radio" name="gender" id="gender2" value="f">여
				</td>
			</tr>
			<tr>
				<th><label for="birth">생년월일</label></th>
				<td><input type="text" name="birth" id="datepicker"></td>
			</tr>
			<tr>
				<th><label for="tel">연락처</label></th>
				<td><input type="text" name="tel" id="tel"
					placeholder="예):010-0000-0000"></td>
			</tr>
			<tr>
				<th><label for="address">주소</label></th>
				<td><input type="text" name="address" id="address"></td>
			</tr>
		</table>
		<div class="div_btn">
			<button type="button" name="btn_submit" id="btn_submit">저장</button>
			<button type="reset">초기화</button>
			<a href="login.do"><button type="button">로그인</button></a>
		</div>
	</form>
</body>
</html>
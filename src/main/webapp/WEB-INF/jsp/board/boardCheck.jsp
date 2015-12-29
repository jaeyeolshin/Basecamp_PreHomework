<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/include/include-header.jsp" %>
<link rel="stylesheet" type="text/css" href="<c:url value='/css/board/boardCheck.css'/>" />
</head>
<body>
	<div>
	</div>
	<div id="checkDiv">
		<form id="inputForm">
			<input type="hidden" id="BID" name="BID" value="${target.BID }"/>
			<input type="hidden" id="EMAIL" name="EMAIL" value="${target.EMAIL }" />
			<table id="checkTable">
				<tr>
					<th>이메일</th>
					<td>${target.EMAIL }</td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" id="PASSWORD" name="PASSWORD" class="form-control" placeholder="Password" /></td>
				</tr>
				<tr>
					<th></th>
					<td>
						<input type="button" value="확인" id="btnSubmit" class="btn btn-primary" />
						<input type="button" value="취소" id="btnCancel" class="btn btn-default"/>
					</td>
				</tr>
			</table>
		</form>
	</div>
	<%@ include file="/WEB-INF/include/include-body.jsp" %>
	<script>
		$(document).ready(function(){
			$("#btnSubmit").on("click", function(e){ //확인 버튼
				e.preventDefault();
				f_InputCheck($(this));
			});	
			
			$("#btnCancel").on("click", function(e){ //취소 버튼
				e.preventDefault();
				history.back();
			});
		});
		
		
		function f_InputCheck(obj){
			var comSubmit = new ComSubmit("inputForm");
			comSubmit.setUrl("<c:url value='/board/boardEditCheck.do' />");
			comSubmit.submit();
		}
		
	</script>
</body>
</html>
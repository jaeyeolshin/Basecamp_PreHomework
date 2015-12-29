<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/WEB-INF/include/include-header.jsp" %>
<link rel="stylesheet" type="text/css" href="<c:url value='/css/board/boardEdit.css'/>" />
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">

</head>
<body>
	<div id="editDiv">
		<form id="editForm">
			<input type="hidden" id="BID" name="BID" value="${edit.BID }"/>
			<table id="editTable">
				<tr>
					<th>글 번호</th>
					<td>${edit.BID }</td>
				</tr>
				<tr>
					<th>이메일</th>
					<td>${edit.EMAIL }</td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea rows="15" id="BCONTENT" name="BCONTENT">${edit.BCONTENT }</textarea></td>
				</tr>
				<tr>
					<th></th>
					<td>
						<input type="button" id="btnSubmit" value="확인" class="btn btn-primary"/>
						<input type="button" id="btnCancel" value="취소" class="btn btn-default"/>
					</td>
				</tr>
			</table>
		</form>
		
	</div>

	<%@ include file="/WEB-INF/include/include-body.jsp" %>
	<script type="text/javascript">
		$(document).ready(function(){
			$("#btnSubmit").on("click", function(e){ //확인 버튼
				e.preventDefault();
				f_EditBoard();
			});	
			
			$("#btnCancel").on("click", function(e){ //취소 버튼
				e.preventDefault();
				f_EditCancel();
			});
		});
		
		function f_EditBoard(){
			var comSubmit = new ComSubmit("editForm");
			comSubmit.setUrl("<c:url value='/board/boardEdit.do' />");
			comSubmit.submit();
		}
		
		function f_EditCancel(){
			var comSubmit = new ComSubmit();
			comSubmit.setUrl("<c:url value='/board/boardList.do' />");
			comSubmit.submit();
		}
	</script>
</body>
</html>
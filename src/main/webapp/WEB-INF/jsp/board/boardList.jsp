<%@ page language="java" contentType="text/html; charset=UTF-8"  %>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/include/include-header.jsp" %>
<link rel="stylesheet" type="text/css" href="<c:url value='/css/board/boardList.css'/>" />
</head>
<body>
	<div id="listDiv">
		<table class="table" style="width:1000px; word-break:break-all;">
			<thead>
				<tr>
					<th id="docNum">글 번호</th>
					<th id="docEmail">이메일</th>
					<th id="docContent">본문</th>
					<th id="docDate">글 등록시간</th>
					<th id="docEDate">글 수정시간</th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
				<c:when test="${f:length(list) > 0}">
					<c:set var="rowLen" value="${f:length(list)}" />
					<c:forEach items="${list}" var="row" varStatus="status">
						<tr>
							<input type="hidden" id="BID" value="${row.BID}"/>
							<input type="hidden" id="EMAIL" value="${row.EMAIL}" />
							<td>${rowLen-status.index}</td>
							<td>${row.EMAIL}</td>
							<td>${row.BCONTENT }</td>
							<td>${row.BDATE }</td>
							<td>${row.BEDITDATE}</td>
							<td id="editBtnCol"><input type="button"  id="edit${row.BID }" value="수정" class="btn btn-default"/></td>
							<td id="delBtnCol"><input type="button" id="delete${row.BID }" value="삭제" class="btn btn-danger"/></td>
						</tr>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<tr>
						<td colspan="4">조회된 결과가 없습니다.</td>
					</tr>
				</c:otherwise>
			</c:choose>
			</tbody>
		</table>
		<a href="#this" class="btn btn-primary" id="write">방명록 작성</a>
	</div>
	
	<%@ include file="/WEB-INF/include/include-body.jsp" %>
	<script type="text/javascript">
		$(document).ready(function(){
			$("#write").on("click", function(e){ //글쓰기 버튼
				e.preventDefault();
				f_boardWrite();
			});	
			
			$("input[id^='edit']").on("click", function(e){ //제목 
				e.preventDefault();
				if(confirm("수정하시겠습니까?") == true){
					f_boardEdit($(this));
				}else{
					return;
				}
			});
			
			$("input[id^='delete']").on("click", function(e){ //제목 
				e.preventDefault();
				if(confirm("삭제하시겠습니까?") == true){
					f_boardDelete($(this));
				}else{
					return;
				}
			});
		});
		
		
		function f_boardWrite(){
			var comSubmit = new ComSubmit();
			comSubmit.setUrl("<c:url value='/board/boardWrite.do' />");
			comSubmit.submit();
		}
		
		function f_boardEdit(obj){
			var comSubmit = new ComSubmit();
			comSubmit.setUrl("<c:url value='/board/boardCheck.do' />");
			comSubmit.addParam("BID", obj.parent().parent().find("#BID").val());
			comSubmit.addParam("EMAIL", obj.parent().parent().find("#EMAIL").val());
			comSubmit.submit();
		}
		
		function f_boardDelete(obj){
			var comSubmit = new ComSubmit();
			comSubmit.setUrl("<c:url value='/board/boardDelete.do' />");
			comSubmit.addParam("BID", obj.parent().parent().find("#BID").val());
			comSubmit.submit();
		}
	</script>
</body>
</html>
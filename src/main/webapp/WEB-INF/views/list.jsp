<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<c:set var="path" value="${pageContext.request.contextPath}"/> 
<html>
<head>
	<title>Home</title>
	<script type="text/javascript" src="${path}/resources/js/checkbox.js"></script>
</head>
<body>
<hr>
	<header>
		<h2>파일 확장자 차단</h2>
	</header>
	<hr>
	<nav>
		<div>
			파일확장자에 따라 특정 형식의 파일을 첨부하거나 전송하지 못하도록 제한
		</div>
		<div>
			<table>
				<tr>
					<td>고정 확장자</td>
					<td><c:forEach var="flow" items="${flist}" varStatus="status">
							<c:set var="file_check" value="${flow.file_check}"></c:set>
							<c:if test="${not empty file_check}"> <!-- file_check가 null인 경우 제외 -->
								<c:if test="${file_check eq 'n' || state eq '0'}">
									<input type="checkbox" onclick="removeCheck(event,'${path}')" name="file_num" value="${flow.file_num}" >
								</c:if>
								<c:if test="${file_check eq 'y' || state eq '1'}">
									<input type="checkbox" onclick="removeCheck2(event,'${path}')" name="file_num2" value="${flow.file_num}" checked/>
								</c:if>
								${flow.file_extension}
							</c:if>
					</c:forEach></td>
				</tr>
				
				<tr>
					<td>커스텀 확장자</td>
					<td><input type="text" placeholder="확장자 입력" id="file_extension" value="${file_extension}"> 
					<button onclick="add(${total-7},event,'${path}')" >+추가</button> <button onclick="deleteAll(event,'${path}')">전체 삭제</button></td>
					
				</tr>
				
				<tr>
					<td></td>
					<td>
						<div style="border:1px solid; padding:10px;">${total-7}/200 <br>
							<c:forEach var="flow" items="${flist}" varStatus="status">
							<c:set var="file_check" value="${flow.file_check}" ></c:set>
								<c:if test="${empty file_check}">
									<div style="border:1px solid; display: inline-block;">
										${flow.file_extension} <button name="remove_file"  value="${flow.file_extension}" onclick="remove(${status.count-8},event,'${path}')">x</button>
									</div>
								</c:if>
							</c:forEach>
						</div>
					</td>
				</tr>
			</table>
		</div>
	</nav>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>departmentList</title>
</head>
<body>
	<h1>부서목록</h1>
	<%
		// List<Departments> list = (List<Departments>)request.getAttribute("list"); 자바로 list 가져오는방법
		// ${list} el로 줄인방법 
	%>
	<div>
		<a href="${pageContext.request.contextPath}/index">홈으로</a>
	</div>
	<table>
		<thead>
			<tr>
				<th>부서 번호</th>
				<th>부서 이름</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="departments" items="${list}">
				<tr>
					<td>${department.deptNo}</td><!-- <departments.getDepartNo()%> -->
					<td>${department.deptName}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>
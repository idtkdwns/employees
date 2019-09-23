<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>사원 목록</h1>
		<div>
			<a href="${pageContext.request.contextPath}/index">홈으로</a>
		</div>
			<table>
				<thead>
					<tr>
						<th>사원 번호</th>
						<th>사원 생일</th>
						<th>사원 성</th>
						<th>사원 이름</th>
						<th>사원 성별</th>
						<th>입사 날짜</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="employees" items="${list}">
						<tr>
							<td>${employees.getEmpNo()}</td>
							<td>${employees.getBirthDate()}</td>
							<td>${employees.getFirstName()}</td>
							<td>${employees.getLastName()}</td>
							<td>${employees.getGender()}</td>
							<td>${employees.getHireDate()}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
</body>
</html>
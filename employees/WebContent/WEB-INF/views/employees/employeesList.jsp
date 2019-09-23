<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		<form method="get" action="<%=request.getContextPath()%>/employees/getEmployeesList">
			<select name="limit">
				<option value="10">10개씩</option>
				<option value="20">20개씩</option>
				<option value="30">30개씩</option>
				<option value="40">40개씩</option>
				<option value="50">50개씩</option>
			</select>
			<button type="submit" class="btn btn-outline-secondary">확인</button>
		</form>
		<table class="table table-bordered">
			<thead class="table-secondary">
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
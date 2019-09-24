<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index.jsp</title>
</head>
<body>
	<h1>Index</h1>
	<!-- Web app navigation -->
	<h1>테이블 정보</h1>
	<div>
		<table>
			<thead>
			<tbody>
				<tr>
					<td>departments</td>
					<td>${departmentsRowCount}</td>
				</tr>
				<tr>
					<td>employees</td>
					<td>${employeesRowCount}</td>
				</tr>
				<tr>
					<td>dept_manager</td>
					<td>${deptManagerRowCount}</td>
				</tr>
				<tr>
					<td>dept_emp</td>
					<td>${deptEmpRowCount}</td>
				</tr>
				<tr>
					<td>titles</td>
					<td>${titlesRowCount}</td>
				</tr>
				<tr>
					<td>salaries</td>
					<td>${salariesRowCount}</td>
				</tr>
			</tbody>
			</thead>
		</table>
	</div>
	<div>
		<ul>
			<li><a href="${pageContext.request.contextPath}/departments/getDepartmentsList">부서목록</a></li>
			<li><a href="${pageContext.request.contextPath}/employees/getEmployeesList">사원목록</a></li>
		</ul>
	</div>
	
	<div>
		사원목록 
		<li>
			<a href="${pageContext.request.contextPath}/employees/getEmployeesListOrderBy?order=asc"></a>
			<a href="${pageContext.request.contextPath}/employees/getEmployeesListOrderBt?order=desc"></a>
		</li>
		<li>
			<a href="${pageContect.request.contectPath}/titles/getTitlesListDistinct">업무목록(중복 없음)</a>
		</li>
		<li>
			<a href="${pageContect.request.contectPath}">연봉 통계값(count,sum,avg,max,min,std)</a>
		</li>
	</div>
</body>
</html>
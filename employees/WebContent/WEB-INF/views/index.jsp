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
	<div>
		<ul>
			<li><a href="">부서목록</a></li>
			<li><a href="">사원목록</a></li>
		</ul>
	</div>
	<div>
		표현식->employees table total row count: <%=request.getAttribute("employeesRowCount") %>
		EL->employees table row count : %{employees RowCount}
	</div>
</body>
</html>
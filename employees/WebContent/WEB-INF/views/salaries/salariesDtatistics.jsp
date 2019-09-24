<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>salary 연봉 통계값(count,sum,avg,max,min,std)</h1>
	<table>
		<thead>
			<tr>
				<td>count</td>
				<td>sum</td>
				<td>avg</td>
				<td>max</td>
				<td>min</td>
				<td>std</td>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>${map.count}</td>
				<td>${map.sum}</td>
				<td>${map.avg}</td>
				<td>${map.max}</td>
				<td>${map.min}</td>
				<td>${map.std}</td>
			</tr>
		</tbody>
	</table>
</body>
</html>
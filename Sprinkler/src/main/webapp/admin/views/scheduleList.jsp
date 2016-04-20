<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Schedule list</title>
</head>
<body>

	<table border="1">
		<tr>
			<td>Item id</td>
			<td>Zone id</td>
			<td>From</td>
			<td>To</td>
			<td>Recurring</td>
		</tr>
		<c:forEach items="${scheduledItems}" var="item">
			<tr>
				<td>${item.id}</td>
				<td>${item.zoneId}</td>
				<td><fmt:formatDate value="${item.from}"
						pattern="yyyy-MM-dd hh:mm:ss" /></td>
				<td><fmt:formatDate value="${item.to}"
						pattern="yyyy-MM-dd hh:mm:ss" /></td>
				<td>${item.recurring}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
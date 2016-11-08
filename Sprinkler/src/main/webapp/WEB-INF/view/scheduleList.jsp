<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">
<link href="${pageContext.servletContext.contextPath}/style/style.css" rel="stylesheet" type="text/css">
<title>Schedule list</title>
</head>
<body>
	<%@include file="menu.jspf"%>
	
	<div style="text-align: center; margin: 10px auto">
		<a href= "../views/newSchedule.jsp">
			<button type="button" class="btn btn-primary">New Schedule</button>
		</a>
		<a href= "#">
			<button type="button" class="btn btn-primary">Modify Schedule</button>
		</a>
	</div>
	
	<div class="panel panel-default" style="max-width: 90%; margin: 0 auto;text-align: center;">
	<div class="panel-heading">Schedules</div>
		<table class="table table-bordered table-hover table-condensed" >
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
					<td>${item.zone}</td>
					<td><fmt:formatDate value="${item.from}"
							pattern="yyyy-MM-dd hh:mm:ss" /></td>
					<td><fmt:formatDate value="${item.to}"
							pattern="yyyy-MM-dd hh:mm:ss" /></td>
					<td>${item.recurring}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>
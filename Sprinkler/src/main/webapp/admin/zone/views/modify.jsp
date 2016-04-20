<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Modify zone</title>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">

</head>
<body>
	<%@include file="../../../fragments/menu.jspf"%>
	<c:set var="zone" value="${zoneToModify}" />
	<c:out value="${error}"></c:out>
	<form action="modify" method="post">
		<div class="form-group">
			<label for="id">Id</label> <input type="text" class="form-control"
				name="id" id="id" value="${zone.id}">
		</div>
		<div class="form-group">
			<label for="zonename">Name</label> <input type="text"
				class="form-control" name="zonename" id="zonename" value="${zone.name}">
		</div>
		<div class="form-group">
			<label for="consumption">Consumption</label> <input type="text"
				name="consumption" id="consumption" value="${zone.consumption}">
		</div>
		<button type="submit" class="btn btn-default">Submit</button>
	</form>
</body>
</html>
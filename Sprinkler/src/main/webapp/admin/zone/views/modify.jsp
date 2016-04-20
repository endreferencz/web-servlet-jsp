<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Modify zone</title>
</head>
<body>
	<%@include file="../../../fragments/menu.jspf"%>
	<c:set value="${zone}" var="zone">
	<form>
		<div class="form-group">
			<label for="id">Id</label> <input type="text" class="form-control"
				id="id" placeholder="${zone.id}">
		</div>
		<div class="form-group">
			<label for="zonename">Name</label> <input type="text"
				class="form-control" id="zonename" placeholder="${zone.name}">
		</div>
		<div class="form-group">
			<label for="consumption">Consumption</label> <input type="text"
				id="consumption" placeholder="${zone.consumption}">
		</div>
		<button type="submit" class="btn btn-default">Submit</button>
	</form>
	</c:set>
</body>
</html>
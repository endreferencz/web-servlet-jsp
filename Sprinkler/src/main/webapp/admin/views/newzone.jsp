<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7"
	crossorigin="anonymous">
<link href="../style/style.css" rel="stylesheet" type="text/css">
<title>Create new zone</title>
</head>
<body>
		<form method="post" id="loginForm">
		<div class="input-group">
			<span class="input-group-addon" id="basic-addon1">ID</span> <input
				type="text" class="form-control" placeholder="ID"
				aria-describedby="basic-addon1" name="id">
		</div>

		<div class="input-group">
			<span class="input-group-addon" id="basic-addon2">Zonename</span> <input
				type="text" class="form-control" placeholder="Name"
				aria-describedby="basic-addon2" name="zonename">
		</div>
		
		<div class="input-group">
			<span class="input-group-addon" id="basic-addon3">Consumption</span> <input
				type="text" class="form-control" placeholder="Consumption"
				aria-describedby="basic-addon3" name="consumption">
		</div>
		
		<input class="btn btn-default" type="submit" value="Add zone">
		${error}

</body>
</html>
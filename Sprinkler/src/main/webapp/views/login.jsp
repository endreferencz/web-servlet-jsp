<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7"
	crossorigin="anonymous"
	>
	<link href="${pageContext.servletContext.contextPath}/style/style.css" rel="stylesheet" type="text/css">
<title>Login page</title>
</head>
<body>
	<c:if test="fail">
		Invalid username or password!
	</c:if>

	<form method="post" action="j_security_check" id="loginForm">
		<div class="input-group">
			<span class="input-group-addon" id="basic-addon1">Username</span> <input
				type="text" class="form-control" placeholder="Username"
				aria-describedby="basic-addon1" name="j_username">
		</div>

		<div class="input-group">
			<span class="input-group-addon" id="basic-addon2">Password</span> <input
				type="password" class="form-control" placeholder="Password"
				aria-describedby="basic-addon2" name="j_password">
		</div>
		
		<input class="btn btn-default" type="submit" value="Let's Sprinkle!">
	</form>
</body>
</html>
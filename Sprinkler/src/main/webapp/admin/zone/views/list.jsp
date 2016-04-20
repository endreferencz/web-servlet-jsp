<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">

<link href="${pageContext.servletContext.contextPath}/style/style.css" rel="stylesheet" type="text/css">

<title>Admin index</title>
</head>


<body>
	<%@include file="../../../fragments/menu.jspf"%>

	<div style="text-align: center; margin: 10px auto">
<a href= "../newzone">
<button type="button" class="btn btn-primary">New Zone</button>
</a>
</div>

<div class="panel panel-default" style="max-width: 90%; margin: 0 auto">
  <!-- Default panel contents -->
  <div class="panel-heading">Zones</div>
  <!-- Table -->
  <table class="table">
 	<tr>
	<th>ID</th>
	<th>Name</th>
	<th>Consuption (Litre/Hour)</th>
	<th>Operations</th>
	</tr>
   	<c:forEach items="${zones}" var="zone">
   	<tr>
    	<td>${zone.id}</td>
    	<td>${zone.name}</td>
    	<td>${zone.consumption}</td>
    	<td><a href="/Sprinkler/admin/zone/delete?id=${zone.id}"><button type="button" class="btn btn-danger" style="padding: 1px">Delete</button></a></td>
   	</tr>
	</c:forEach>    
  </table>
</div>

</body>
</html>
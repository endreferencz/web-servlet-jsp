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

<title>Admin index</title>
</head>

<nav class="navbar navbar-default">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="/Sprinkler/admin/index">Admin</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
      	<li><a href="#">Log</a></li>
        <li><a href="#">Zones</a></li>
        <li><a href="#">Settings</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="logout">Logout</a></li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>

<body>

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
    	<td><a href="#"><button type="button" class="btn btn-danger" style="padding: 1px">Delete</button></a></td>
   	</tr>
	</c:forEach>    
  </table>
</div>

</body>
</html>
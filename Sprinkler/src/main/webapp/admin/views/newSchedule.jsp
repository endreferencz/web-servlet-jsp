<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7"
	crossorigin="anonymous">
<link href="../style/style.css" rel="stylesheet" type="text/css">
<title>New schedule</title>
</head>
<body>
	<div class="container">
		<div class="page-header">
		    <h1>New Scheduled Item</h1>      
		  </div>
		<form class="form-inline" method="post" action="newSchedule">
			<div class="form-group">
				<label>From: </label> 
				<input type="datetime" class="form-control" name="from" placeholder="yyyy-MM-dd hh:mm:ss"> 
			</div>
			<div class="form-group">
				<label>To: </label> 
				<input type="datetime" class="form-control" name="to" placeholder="yyyy-MM-dd hh:mm:ss"> 
			</div>
				<div class="form-group">
				<label>Zone: </label> 	
				<select name="zoneId" class="form-control" >
					<c:forEach var="zone" items="${zones}" >
						<option value="${zone.id}">
							${zone.name}
				        </option>
					</c:forEach>
				</select> 
			</div>	
			<div class="checkbox">
				<label><input type="checkbox" name="recurring"> Recurring </label>
			</div>
			<button type="submit" class="btn btn-default" >Save</button>
		</form>
	</div>
	
</body>
</html>
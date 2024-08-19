<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="mvc" %>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<title>Spring MVC Form Handling</title>
</head>
<body>
	<h2>User Registration Result</h2>
	<table>
	<tr>
	<td>Name</td>
	<td>${user.name}</td>
	</tr>

	<tr>
    	<td>Last Name</td>
    	<td>${user.lastName}</td>
    </tr>

    <tr>
    	<td>Password (*)</td>
    	<td>${user.password}</td>
    </tr>

    <tr>
    	<td>Detail</td>
    	<td>${user.detail}</td>
    </tr>

    <tr>
    	<td>Birth Date</td>
    	<td>${user.birthDate}</td>
    </tr>

    <tr>
    	<td>Gender</td>
    	<td>${user.gender}</td>
    </tr>

    <tr>
    	<td>Country</td>
    	<td>${user.country}</td>
    </tr>

    <tr>
    	<td>Non Smoking</td>
    	<td>${user.nonSmoking}</td>
    </tr>

	</table>
<a class="btn btn-primary" href="http://localhost:8080/" role="button">Back to Home</a>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ page import="java.util.ArrayList" %> 
 <%@ page import="Data.Admin" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="Admin.css">
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>



<h1>Admin Page Welcome!!</h1>
<form action="/ShowEhdokkaat" method="GET">
<button > Lisää ehdokas </button>

<input type="submit" value="Muokkaa ehdokkaita">

<button> Poista ehdokas </button>

</form>


</body>
</html>
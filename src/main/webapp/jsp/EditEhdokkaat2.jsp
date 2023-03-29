<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ page import="java.util.ArrayList" %> 
  <%@ page import="Data.Ehdokkaat" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="Ehdokkaat.css">
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>


<form action='/UpdateEhdokkaat' method='post'>


<input hidden="hidden" type='text' name='ehdokas_id' value='${requestScope.ehdokas.ehdokas_id}' readonly><br> 

Muokkaa  Sukunimi: <input type='text' name='sukunimi' value='${requestScope.ehdokas.sukunimi}' ><br> 

Muokkaa Etunimi: <input type='text' name='etunimi' value='${requestScope.ehdokas.etunimi}' ><br> 

Muokkaa Puolue: <input type='text' name='puolue' value='${requestScope.ehdokas.puolue}' ><br> 

Muokkaa miksi eduskuntaan: <input  type='text' name='eduskunta' value='${requestScope.ehdokas.eduskunta}' ><br> 

Muokkaa mitä haluaa edistää: <input type='text' name='edistaa' value='${requestScope.ehdokas.edistaa}' ><br> 

 

<input type='submit' name='ok' value='Muokkaa'> 

</form>
</body>
</html>
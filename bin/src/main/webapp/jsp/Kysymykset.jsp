<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ page import="java.util.ArrayList" %> 
 <%@ page import="Data.Kysymys" %> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <link rel="stylesheet" type="text/css" href="main.css">
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
<title></title>

</head>
<body>

<h1> Hyvää paskaa</h1>


<table class="table_center" >


<c:forEach var="kysymys" items="${requestScope.kysymyslist}">
<tr>
<td>
<div class="Kysymykset">
${kysymys.kysymys}
 <div class="form_middle">
 
<form>




<div class="vastauscont">
<input type="radio" name="vastaus" id="inlineRadio1" value="Täysineri" >
<label class="form-check-label" >Täysin eri mieltä</label>

</div>

<div class="vastauscont">
<input  type="radio" name="vastaus" id="inlineRadio2" value="Vähäneri">
<label class="form-check-label" >Jokseenkin eri mieltä</label>

</div>

<div class="vastauscont">

<input type="radio" name="vastaus" id="inlineRadio3" value="Jokseenkinsama">
<label class="form-check-label" >Jokseenkin samaa mieltä</label>
</div>

<div class="vastauscont">

<input type="radio" name="vastaus" id="inlineRadio4" value="Täysinsama">
<label class="form-check-label" >Täysin samaa mieltä</label>
</div >




</form>
</div>
</div>
 
</c:forEach>
<input type="submit" href="" value="Lähetä vastaus!">
</td>

 </tr>

</table>



</body>
</html>
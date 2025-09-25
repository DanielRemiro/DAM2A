<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Pagina de inicio</title>
</head>
<body>
<form action="yieldRandomSolutionWord" method="get">
	<input type="submit">
</form>

<br/>
<br/>
<br/>
<br/>

<form action="checkAnswer" method="post">
	<input type="text" name="userInput" />
</form>


<br/>
<br/>
<br/>
<br/>

<td><c:out value="${feedback}" /></td>
	
	
</body>
</html>
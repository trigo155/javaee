<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"   prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listado</title>
</head>
<body>
	<center>
	<table border="1">
	<tr><th></th><th>Nombre</th><th>Email</th><th>Edad</th></tr>
	
	<c:forEach var="con" items="${requestScope.new_table}">
	
		<th><a href="eliminarContacto?email=${con.email}">Eliminar</a></th>		
			<td>${con.nombre}</td>
			<td>${con.email}</td>
			<td>${con.edad}</td>
		</tr>
		
	</c:forEach>
	
	</table>
	<br><br>
		<a href="toEntrada">Volver</a>
	</center>

</body>
</html>
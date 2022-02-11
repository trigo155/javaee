<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alta</title>
</head>
<body>
 	<center>
	
	<h1 style="color: red;">Formulario para el alta de contactos</h1>
	<form action="altaContacto" method="post">
		<label style="color: green; padding-right: 8px">Nombre:</label><input style="border-radius: 10px; margin-bottom: 10px" type="text" name="nombre"><br>
		<label style="color: red; padding-right: 8px">Email:</label><input style="border-radius: 10px; margin-bottom: 10px" type="text" name="email"><br>
		<label style="color: blue; padding-right: 8px">Edad:</label><input style="border-radius: 10px; margin-bottom: 10px" type="number" name="edad"><br>
				<input style="background-color: yellow; border-radius: 7px" type="submit" value="Alta">

	</form>

</center>

</body>
</html>
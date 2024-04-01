<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SignUp Form</title>
</head>
<body>
	<form action="saveuser" method="post" enctype="multipart/form-data">
		Id: <input type="text" name="id"><br><br>
		Name: <input type="text" name="name"><br><br>
		Email: <input type="email" name="email"><br><br>
		Contact: <input type="text" name="contact"><br><br>
		Password: <input type="text" name="password"><br><br>
		Image: <input type="file" name="image"><br><br>
		<input type="submit">
	</form>
</body>
</html>
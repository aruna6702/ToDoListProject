<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Task</title>
</head>
<body>
	
	<form action="addtask" method="post">
		Task Id: <input type="text" name="taskid"><br><br>
		Task Title: <input type="text" name="tasktitle"><br><br>
		Task Description: <input type="text" name="taskdescription"><br><br>
		Task Priority:
		<input type="radio" value="low" name="taskpriority">Low
		<input type="radio" value="medium" name="taskpriority">Medium
		<input type="radio" value="high" name="taskpriority">High
		<br><br>
		Due Date: <input type="date" name="taskduedate"><br><br>
		<input type="submit">
	</form>
</body>
</html>
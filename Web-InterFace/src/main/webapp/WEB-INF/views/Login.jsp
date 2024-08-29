<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate">
        <meta http-equiv="Pragma" content="no-cache">
        <meta http-equiv="Expires" content="0">
        <link rel="stylesheet" href="/css/Login.css">
        <title>PeoplesMed Login</title>
    </head>
<body>
 <h2>User Information Form</h2>
    <form action="/PeoplesMed/Login/Submit" method="post" >
        <label for="id">ID:</label><br>
        <input type="text" id="id" name="id" required><br><br>

        <label for="name">Name:</label><br>
        <input type="text" id="name" name="name" required><br><br>

        <label for="role">Role:</label><br>
        <input type="text" id="role" name="role" required><br><br>

        <input type="submit" value="Submit">
    </form>
</body>
</html>
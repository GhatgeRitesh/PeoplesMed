<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registration For Doctor's</title>
    <link rel="stylesheet" href="/css/Doctor.css">
</head>
<body>
    <div class="container">
        <div class="form-wrapper">
            <form id="registration-form" action="/Reg/sub/D" method="Post">
                <h2> Registration </h2>
                
                <label for="name">Name:</label>
                <input type="text" id="name" name="name" required>
                
                <label for="email">Email:</label>
                <input type="email" id="email" name="email" required>
                
                <label for="contact">Contact:</label>
                <input type="tel" id="contact" name="contact" required>
                
                <label for="profile">Profile:</label>
                <input type="text" id="profile" name="profile" required>
                
                <label for="degree">Degree:</label>
                <input type="text" id="degree" name="degree" required>
                
                <label for="specialization">Specialization:</label>
                <input type="text" id="specialization" name="specialization" required>
                
                <label for="city">City:</label>
                <input type="text" id="city" name="city" required>
                
                <button type="submit">Submit</button>
            </form>
        </div>
    </div>
</body>
</html>
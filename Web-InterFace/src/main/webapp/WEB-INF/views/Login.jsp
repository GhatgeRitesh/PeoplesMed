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
   <h2>Doctor Information Form</h2>
    <form action="/doc/sign-in" method="POST">
        <label for="docId">Doctor ID:</label><br>
        <input type="number" id="docId" name="docId"><br><br>

        <label for="name">Name:</label><br>
        <input type="text" id="name" name="name" required><br><br>

        <label for="specialization">Specialization:</label><br>
        <input type="text" id="specialization" name="specialization" required><br><br>

        <label for="city">City:</label><br>
        <input type="text" id="city" name="city" required><br><br>

        <label for="contact">Contact:</label><br>
        <input type="tel" id="contact" name="contact" pattern="[0-9]{10}" required><br><br>

        <label for="email">Email:</label><br>
        <input type="email" id="email" name="email" required><br><br>

        <label for="degree">Degree:</label><br>
        <input type="text" id="degree" name="degree" required><br><br>

        <label for="patients">Number of Patients:</label><br>
        <input type="number" id="patient" name="patients" required><br><br>

        <label for="prescriptions">Prescriptions:</label><br>
        <textarea id="prescriptions" name="prescriptions" rows="4" cols="50"></textarea><br><br>

        <label for="schedules">Schedules:</label><br>
        <textarea id="schedules" name="schedules" rows="4" cols="50"></textarea><br><br>

        <input type="submit" value="Submit">
    </form>
</body>
</html>
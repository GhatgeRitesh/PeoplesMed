<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Patient Form</title>
    <link rel="stylesheet" href="/css/Patiant.css">
</head>
<body>
    <div class="container">
        <div class="form-wrapper">
            <form id="applicant-form">
                <h2>Patient Form</h2>
                
                <label for="name">Name:</label>
                <input type="text" id="name" name="name" required>
                
                <label for="gender">Gender:</label>
                <select id="gender" name="gender" required>
                    <option value="">Select Gender</option>
                    <option value="male">Male</option>
                    <option value="female">Female</option>
                </select>
                
                <label for="email">Email:</label>
                <input type="email" id="email" name="email" required>
                
                <label for="contact">Contact:</label>
                <input type="tel" id="contact" name="contact" required>
                
                <fieldset>
                    <legend>Address:</legend>
                    
                    <label for="city">City:</label>
                    <input type="text" id="city" name="city" required>
                    
                    <label for="street-road">Street/Road:</label>
                    <input type="text" id="street-road" name="street-road" required>
                    
                    <label for="pincode">Pincode:</label>
                    <input type="text" id="pincode" name="pincode" required>
                </fieldset>
                
                <button type="submit">Submit</button>
            </form>
        </div>
    </div>
</body>
</html>
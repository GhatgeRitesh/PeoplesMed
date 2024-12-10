<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="/images/favcon1.jpg" class="favcon">
          <title>𝙋𝙚𝙤𝙥𝙡𝙚𝙨𝙈𝙚𝙙</title>
    <link rel="stylesheet" href="/css/PPsign.css">
</head>
<body>
   
    <div class="header">
        <div class="logo">
          <img src="/images/logo.png" alt="Logo" class="logo-img">
          <h3 class="logo-h3">PeoplesMed</h3>
        </div>
        <div class="nav-bar">
          <a href="/home/Welcome">Home</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          <a href="/p/findDoctor">Find a Doctor</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          <a href="#">Services</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          <a href="#">Contact</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        </div>

        <div class="logincontainer">

            <div class="login">
               <button id="toggleButton"> <a href="/login" style="text-decoration: none; color: white;"> Login </a></button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            </div>
          
          
            <div class="signin">
              <button id="toggleButton1"> <a href="/Register/P" style="text-decoration: none; color: white;">SignUp</a></button>
            </div>
            
          </div>
    </div>




    <div class="container">
        <div class="form-wrapper">
            <form action="/Reg/sub/P" id="applicant-form" method="post">
                <h2>Patient Details</h2>
                
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

                *Password should be string having at least 8 character containing 1 symbol 1 lowercase and 1 uppercase with 1 digit .
                <label for="email">Password:</label>
                <input type="text" id="password" name="password" required>
                 <div class="error" id="password-error"></div>
                
                <label for="contact">Contact:</label>
                <input type="tel" id="contact" name="contact" required>
                <label for="age">age:</label>
                <input type="text" id="age" name="age" required>
                
                <fieldset>
                    <legend>Address:</legend>
                    
                    <label for="city">City:</label>
                    <input type="text" id="city" name="city" required>

                </fieldset>
                
                <button type="submit">Submit</button>

                <br> <br>

                <div class="divert">
                 <a href="/Register/D"><span>Sign as Doctor</span></a>
                </div>

            </form>
        </div>
    </div>

<script>
    document.getElementById('password').addEventListener('input', function () {
        validatePassword();
    });

    function validatePassword() {
        var password = document.getElementById('password').value;
        var errorElement = document.getElementById('password-error');

        // Regular expression for password validation
        var passwordRegex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/;

        // Test the password against the regex
        if (!passwordRegex.test(password)) {
            errorElement.textContent = 'Password does not meet the required format.';
        } else {
            errorElement.textContent = ''; // Clear error message if valid
        }
    }
</script>

    
</body>
</html>
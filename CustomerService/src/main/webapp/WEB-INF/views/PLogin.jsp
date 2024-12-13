<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="/images/favcon1.jpg" class="favcon">
          <title>𝙋𝙚𝙤𝙥𝙡𝙚𝙨𝙈𝙚𝙙</title>
    <link rel="stylesheet" href="/css/PLogin.css">
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
              <button id="toggleButton1"> <a href="Register/P" style="text-decoration: none; color: white;">SignUp</a></button>
            </div>
            
          </div>
    </div>


    <div class="form_box">
       
       <div class="form">
        
   <form action="/loginform" method="post">
       <h1>Login</h1>
       <div class="form-group">
           <label for="email">Email</label>
           <input type="text" id="email" placeholder="Email" name="email" required>
       </div>
       <div class="form-group">
           <label for="password">Password</label>
           <div class="hide">
           <input type="password" id="password" placeholder="Password" name="password" required>
           <span class="toggle-eye" onclick="togglePassword()">👁</span>
           </div>
           <div class="error" id="password-error"></div>
       </div>
       <button type="submit">Login</button>
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




    /*      */

  function togglePassword() {
       const passwordField = document.getElementById('password');
       const eyeIcon = document.querySelector('.toggle-eye');

       if(passwordField.type === 'password') {
         passwordField.type = 'text';
         eyeIcon.textContent = '🙈'; // Change icon to "hide"
       } else {
         passwordField.type = 'password';
         eyeIcon.textContent = '👁'; // Change icon to "show"
       }
     }




</script>
</body>
</html>
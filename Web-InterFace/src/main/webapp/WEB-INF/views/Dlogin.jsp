<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
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
          <a href="#">Find a Doctor</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          <a href="#">Services</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          <a href="#">Contact</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        </div>

        <div class="logincontainer">

            <div class="login">
               <button id="toggleButton"> <a href="#" style="text-decoration: none; color: white;"> Login </a></button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            </div>
          
          
            <div class="signin">
              <button id="toggleButton1"> <a href="PPsign.html" style="text-decoration: none; color: white;">SignUp</a></button>
            </div>
            
          </div>
    </div>


    <div class="form_box">
       
       <div class="form">
        
    <form action="/Reg/sub/D" method="post">
            <h1>Login-Doctor</h1>
        <div class="form-group">
            <label for="username">Email</label>
            <input type="text" id="p_username"  placeholder="Email" name="p_username" required>
        </div>
        <div class="form-group">
            <label for="password">Password</label>
            <input type="password" id="p_password"  placeholder="Password" name="p_password" required>
        </div>
        <button type="submit">Login</button>
          <br> <br>
        <a href="/login/P"><samp> Login Patient</samp></a>
          

    </form>
</div>
</div>

</body>
</html>
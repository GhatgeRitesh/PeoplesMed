<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="/css/DDsign.css">
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
              <button id="toggleButton1"> <a href="/Register/D" style="text-decoration: none; color: white;">SignUp</a></button>
            </div>
            
          </div>
    </div>


  


    <div class="container">
        <div class="form-wrapper">
            <form id="registration-form" action="/Reg/sub/D" method="post">
            <h2>Doctor Details</h2>

                            <label for="name">Name:</label>
                            <input type="text" id="name" name="name" required>

                            <label for="email">Email:</label>
                            <input type="email" id="email" name="email" required>

                            <label for="contact">Contact:</label>
                            <input type="text" id="contact" name="contact" required>

                            <label for="contact">Registration No:</label>
                            <input type="text" id="registerNo" name="registerNo" required>

                            <label for="password">Password:</label>
                            <input type="text" id="password" name="password" required>

                            <label for="hospital">Hospital Name:</label>
                            <input type="text" id="hospitalName" name="hospitalName" required>

                            <label for="city">City:</label>
                            <input type="text" id="city" name="city" required>

                            <label for="education">Education:</label>
                            <input type="text" id="education" name="education" required>

                            <label for="specialization">Specialization:</label>
                            <input type="text" id="specialization" name="specialization" required>

                            <label for="experience">Experience:</label>
                            <input type="text" id="experience" name="experience" required>


                <button type="submit">Submit</button>
        <br> <br>

        <a href="/Register/P"><span>Sign as Patient</span></a>

            </form>
        </div>
    </div>








</body>
</html>
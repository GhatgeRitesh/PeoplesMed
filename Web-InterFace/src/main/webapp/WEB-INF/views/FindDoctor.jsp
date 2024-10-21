<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import="java.util.List, com.FrontEnd.Web_InterFace.EntityManager.Users.Doctor" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Find Doctors</title>
     <link rel="stylesheet" href="/css/findDoctors.css">
</head>
<body>
    <div class="header">
        <div class="logo">
          <img src="../images/logo.png" alt="Logo" class="logo-img">
          <h3 class="logo-h3">PeoplesMed</h3>
        </div>
        <div class="nav-bar">
          <a href="../Welcome.html">Home</a>
          <a href="#">Find a Doctor</a>
          <a href="#">Services</a>
          <a href="#">Contact</a>
        </div>

        <div class="logincontainer">

            <div class="login">
               <button id="toggleButton"> <a href="#" style="text-decoration: none; color: white;"> Login </a></button>
            </div>


            <div class="signin">
              <button id="toggleButton1"> <a href="PPsign.html" style="text-decoration: none; color: white;">SignUp</a></button>
            </div>

          </div>
    </div>










<!--  -->
<%
     List<Doctor> list = (List<Doctor>) request.getAttribute("list");

      if(list != null) {
        for(Doctor doc: list){
      %>
        <div class="card_contener">
            <div class="card">
                <img src="../images/doc1.png" alt="">
                <div class="details">
                   <h1><%doc.getName();%></h1>
                    <span><%doc.getSpecialization();%></span>
                    <ul class="ul">
                    <li>Pediatric Neurology</li>
                    <li>Pediatric Neurology</li>
                    <li>Pediatric Neurology</li>
                </ul>
            </div>

          <div class="button"><a href="p/docprofile"+ <%doc.getD_id();%>><button><% doc.getDid(); %></button></div>

            </div>
       <%}%>
<!--  -->

            </div>
        </div>


</body>
</html>
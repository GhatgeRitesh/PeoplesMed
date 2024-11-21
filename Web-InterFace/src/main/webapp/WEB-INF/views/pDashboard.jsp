<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import="java.util.List, com.FrontEnd.Web_InterFace.EntityManager.Users.Patient" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <!DOCTYPE html>
    <html lang="en">
    <head>
      <meta charset="UTF-8">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <title>Doctor List Admin Panel</title>
     <link rel="stylesheet" href="/css/pDashboard.css">
    </head>
    <body>


    	<div class="header1">
    		<div class="logo">
    			<img src="/images/logo.png" alt="Logo" class="logo-img">
    			<h3 class="logo-h3">PeoplesMed</h3>
    		</div>
    		<div class="nav-bar">
                <a href="/home/Welcome">Home</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <a href="/P/findDoctor">Find a Doctor</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <a href="#">Services</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <a href="#">Contact</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
              </div>

    	</div>

        <div class="outer">
      <div class="sidebar" >
        <h2> Admin Panel</h2>
        <hr><hr>
        <div id="mydiv">
        <a href="/P/findDoctor" class="btn">Find Doctors</a>
        <!-- <a href="#" class="btn">Patient</a> -->
        <a href="#" class="btn">Edite Profile</a>
        <a href="../List_Patient.html" class="btn">Patient List</a>
        <a href="#" class="btn">Transactions</a>
      </div>

      </div>

      <div class="container">
        <div class="moveside">
          <div class="image"><img src="/images/menu.jpg" alt="" onclick="sidebar()"> </div>
            <div class="profile">
                <img src="/images/logo.jpg" alt="">
                <div class="name">
                    <span> ${user.name} </span><br>
                    <span >Admin</span>
                </div>

            </div>

        </div>


    <!--  -->





    <!--  -->




        </div>
      </div>


    </div>


      <script>
    const div=document.querySelector('.sidebar');
      function sidebar(){
        if(div.style.display==='block')
      {
        div.style.display = 'none';
      }
      else{
        div.style.display = 'block';
      }
      }

      document.getElementsById("mydiv").addEventListener("click", function(event) {
        if (event.target.classList.contains("btn")) {
            event.target.style.backgroundColor = "lightgreen"; // Change color on click
        }
    });


      </script>
    </body>
    </html>
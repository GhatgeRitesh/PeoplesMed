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
    		<!-- <div class="nav-bar">
    			<a href="../Welcome.html">Home</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    			<a href="../findDoctors/findDoctors.html">Find Doctors</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    			<a href="#">Services</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a
    				href="#">Contact</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    		</div> -->
              <div class="logout">
                <button>Logout</button>
              </div>

    	</div>






       <div class="main">

      <div class="sidebar">
        <div class="profile">
          <img src="https://cdn.pixabay.com/photo/2024/09/03/15/21/ai-generated-9019520_640.png" alt="User Profile">
          <h3>${patient.name}</h3>
          <p>${patient.email}</p>
          <p>${patient.contact}</p>
        </div>
        <hr>
        <ul>
          <li><a href="/home/Welcome">Home</a></li>
          <li><a href="/P/findDoctor">Find Doctors</a></li>
          <li><a href="#">Profile</a></li>
          <li><a href="#">Edit Profile</a></li>
        </ul>
        <hr>


      </div>
      <div class="main-content">
        <div class="stats">
          <div class="card">
            <h2>10</h2>
            <p>Total Visits</p>
          </div>
          <div class="card">
            <h2>5</h2>
            <p>Upcoming Visits</p>
          </div>
          <div class="card">
            <h2>16</h2>
            <p>Total Doctors</p>
          </div>
        </div>

        <div class="bookcards">

          <div class="left_bookcards">

          </div>

          <div class="right_bookcards">

           <br>
             <h2>Latest Appointments</h2>
             <hr>

        <div class="appointments">
          <!-- <h3>Latest Appointments</h3> -->
          <div class="appointment-card">
            <h4>Dr. John Doe</h4>
            <p>Appointment Date: 2022-04-15</p>
            <p>Time: 07:00:00</p>
            <p>Status : Completed</p>
          </div>
          <!-- <a href="#" class="btn">Book Appointment</a> -->
        </div>

        <div class="appointments">

            <!-- <h3>Latest Appointments</h3> -->
            <div class="appointment-card">
              <h4>Dr. John Doe</h4>
              <p>Appointment Date: 2022-04-15</p>
              <p>Time: 07:00:00</p>
              <p>Status : Pending</p>
            </div>
            <!-- <a href="#" class="btn">Book Appointment</a> -->
          </div>

          <div class="appointments">
            <!-- <h3>Latest Appointments</h3> -->
            <div class="appointment-card">
              <h4>Dr. John Doe</h4>
              <p>Appointment Date: 2022-04-15</p>
              <p>Time: 07:00:00</p>
              <p>Status : Not Attended</p>
            </div>
            <!-- <a href="#" class="btn">Book Appointment</a> -->
          </div>

        </div>

        </div>



      </div>




    </div>
    </body>
    </html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import="java.util.List, com.FrontEnd.CustomerService.EntityManager.Users.Patient" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <!DOCTYPE html>
    <html lang="en">
    <head>
      <meta charset="UTF-8">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <title>Dashboard UI</title>
     <link rel="stylesheet" href="/css/pDashBoard.css">
    </head>
    <body>


        <div class="header1">
    		<div class="logo">
    			<img src="../images/logo.png" alt="Logo" class="logo-img">
    			<h3 class="logo-h3">PeoplesMed</h3>
    		</div>

                    <a href="/logout"><button>Logout</button></a>

    	</div>






       <div class="main">
      <div class="sidebar">
        <div class="profile">
          <img src="/images/user.jpg" alt="User Profile">
          <h3>${patient.name}</h3>
          <p>${patient.email}</p>
          <p>${patient.contact}</p>
        </div>
        <hr>
        <ul>
          <li><a href="#">Home</a></li>
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
        <c:forEach var="schedule" items="${schedules}">
        <div class="appointments">
          <!-- <h3>Latest Appointments</h3> -->
          <div class="appointment-card">
          <div class="info">
            <h4>${schedule.docName}</h4>
            <p>Appointment Date: ${schedule.slotDate}
            <p>Time:  ${schedule.slotTime}</p>
            <p>
                Status: <span style="${schedule.status == 'Completed' ? 'color: green; font-weight: bold;' :
                                     schedule.status == 'Pending' ? 'color: orange; font-weight: bold;' :
                                     'color: black; font-weight: normal;'}">
                            ${schedule.status}
                        </span>
            </p>
          </div>

         <div class="infobtn">
           <a href="${schedule.link}" target="_blank" style="text-decoration: none;">
             <button style="
               background-color: #4CAF50;
               color: white;
               border: none;
               padding: 10px 20px;
               text-align: center;
               text-decoration: none;
               display: inline-block;
               font-size: 16px;
               margin: 4px 2px;
               cursor: pointer;
               border-radius: 5px;
               box-shadow: 0 4px 6px rgba(0, 0, 0, 0.2);
               transition: background-color 0.3s ease, transform 0.2s ease;
             "
             onmouseover="this.style.backgroundColor='#45a049'; this.style.transform='scale(1.05)';"
             onmouseout="this.style.backgroundColor='#4CAF50'; this.style.transform='scale(1)';">
               Join Meeting
             </button>
           </a>

           </div>

          </div>
          <!-- <a href="#" class="btn">Book Appointment</a> -->
        </div>
        </c:forEach>

        </div>

        </div>



      </div>




    </div>
    </body>
    </html>
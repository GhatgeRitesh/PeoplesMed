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
                <img src="/images/logo.jpg" alt="Patient logo">
                <div class="name">
                    <span>${patient.name} </span><br>
                    <span >Admin</span>
                </div>

            </div>

        </div>


    <!--  -->
<p style="width:50%; position:relative; margin:auto; height:auto; font-size:1.2rem; color: blue;">User Information </p>
       <!-- Profile Table -->
          <div class="profile-container">
              <table>
                  <tbody>
                      <tr>
                          <th>ID</th>
                          <td>${patient.p_id}</td>
                      </tr>
                      <tr>
                          <th>Name</th>
                          <td>${patient.name}</td>
                      </tr>
                      <tr>
                          <th>Gender</th>
                          <td>${patient.gender}</td>
                      </tr>
                      <tr>
                          <th>Age</th>
                          <td>${patient.age}</td>
                      </tr>
                      <tr>
                          <th>Contact</th>
                          <td>${patient.contact}</td>
                      </tr>
                      <tr>
                          <th>Email</th>
                          <td>${patient.email}</td>
                      </tr>
                      <tr>
                          <th>Address</th>
                          <td>${patient.address}</td>
                      </tr>
                      <tr>
                          <th>City</th>
                          <td>${patient.city}</td>
                      </tr>
                      <tr>
                          <th>Role</th>
                          <td>${patient.role}</td>
                      </tr>
                  </tbody>
              </table>
          </div>


              <p style="width:50%; position:relative; margin:auto; height:auto; font-size:1.2rem; color: blue;">Appointments</p>
<div class="container mt-4">
    <div class="row">
        <!-- Loop through a list of schedules -->
        <c:forEach var="schedule" items="${schedules}">
            <div class="col-md-4">
                <div class="card mb-3">
                    <div class="card-body">
                        <h5 class="card-title">Schedule Details</h5>
                        <p class="card-text"><strong>Schedule ID:</strong> ${schedule.sId}</p>
                        <p class="card-text"><strong>Doctor ID:</strong> ${schedule.dId}</p>
                        <p class="card-text"><strong>Patient ID:</strong> ${schedule.pId}</p>
                        <p class="card-text"><strong>Slot Date:</strong> ${schedule.slotDate}</p>
                        <p class="card-text"><strong>Slot Time:</strong> ${schedule.slotTime}</p>
                        <p class="card-text"><strong>Limit:</strong> ${schedule.limit}</p>
                        <p class="card-text"><strong>Description:</strong> ${schedule.description}</p>
                        <div class="d-flex justify-content-between">
                            <form action="/joinMeeting" method="post">
                                <input type="hidden" name="sId" value="${schedule.sId}">
                                <button type="submit" class="btn btn-primary">Join Meeting</button>
                            </form>
                            <form action="/cancelSchedule" method="post">
                                <input type="hidden" name="sId" value="${schedule.sId}">
                                <button type="submit" class="btn btn-danger">Cancel Schedule</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>

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
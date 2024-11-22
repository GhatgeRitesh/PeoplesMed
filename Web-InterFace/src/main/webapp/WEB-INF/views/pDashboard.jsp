<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import="java.util.List, com.FrontEnd.Web_InterFace.EntityManager.Users.Patient , com.FrontEnd.Web_InterFace.EntityManager.Users.Patient" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <!DOCTYPE html>
    <html lang="en">
    <head>
      <meta charset="UTF-8">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <title>Doctor List Admin Panel</title>
     <link rel="stylesheet" href="/css/pDashboard.css">
     <style>
  /* Reset body margins */
        body {
            margin: 0;
            font-family: Arial, sans-serif;
            background-color: #f9f9f9;
        }

        /* Center the card container */
        .schedule-container {
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
            gap: 20px;
            padding: 20px;
        }

        /* Card styling */
        .schedule-card {
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
            width: 300px;
            padding: 20px;
            text-align: left;
            display: flex;
            flex-direction: column;
            justify-content: space-between;
        }

        /* Card header */
        .card-header {
            font-size: 18px;
            font-weight: bold;
            margin-bottom: 10px;
        }

        /* Highlight based on the limit */
        .schedule-card.red {
            border-left: 6px solid #ff4d4d;
        }

        .schedule-card.green {
            border-left: 6px solid #4caf50;
        }

        /* Property label */
        .schedule-property {
            font-weight: bold;
            color: #555;
        }

              /* Center the profile table container */
              .profile-container {
                  display: flex;
                  justify-content: center;
                  align-items: center;
                  height: 80vh;
              }

              /* Styling for the table */
              table {
                  border-collapse: collapse;
                  width: 40%;
                  background-color: #fff;
                  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
                  border-radius: 8px;
                  overflow: hidden;
              }

              /* Table rows and cells */
              th, td {
                  padding: 12px 20px;
                  text-align: left;
              }

              /* Attribute names column */
              th {
                  width: 30%;
                  background-color: #007bff;
                  color: #fff;
                  text-transform: uppercase;
                  font-size: 14px;
              }

              /* Attribute values column */
              td {
                  background-color: #f9f9f9;
                  color: #333;
              }

              /* Responsive table */
              @media (max-width: 768px) {
                  table {
                      width: 90%;
                  }
                   .schedule-card {
                                  width: 100%;
                              }
              }
     </style>
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
                    <span>${patient.name} </span><br>
                    <span >Admin</span>
                </div>

            </div>

        </div>


    <!--  -->

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

          <div class="schedule-container">
              <c:forEach var="schedule" items="${sc}">
                  <div class="schedule-card ${sc.limit > 5 ? 'red' : 'green'}">
                      <div class="card-header">Schedule ID: ${sc.sId}</div>
                      <p><span class="schedule-property">Doctor ID:</span> ${sc.dId}</p>
                      <p><span class="schedule-property">Patient ID:</span> ${sc.pId}</p>
                      <p><span class="schedule-property">Slot Date:</span> ${sc.slotDate}</p>
                      <p><span class="schedule-property">Slot Time:</span> ${sc.slotTime}</p>
                      <p><span class="schedule-property">Limit:</span> ${sc.limit}</p>
                      <p><span class="schedule-property">Description:</span> ${sc.description}</p>
                  </div>
              </c:forEach>
          </div>




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
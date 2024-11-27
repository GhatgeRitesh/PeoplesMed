<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import="java.util.List, com.FrontEnd.Web_InterFace.EntityManager.Users.Doctor , com.FrontEnd.Web_InterFace.EntityManager.Users.Schedule" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Doctor Profile</title>
    <link rel="stylesheet" href="/css/dDashboard.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.1.3/css/bootstrap.min.css">
</head>
<body>

    <div class="header">
        <div class="logo">
          <img src="/images/logo.png" alt="Logo" class="logo-img">
          <h3 class="logo-h3">PeoplesMed</h3>
        </div>
        <div class="buttons">
            <a href="/home/Welcome"><button>Home</button></a>
            <a href="/logout"><button>Logout</button></a>
        </div>
    </div>

    <div class="container1">
        <div class="moveside">
          <div class="image"><img src="/images/menu.jpg" alt="" onclick="sidebar()"> </div>
            <div class="profile">
                <img src="/images/logo.jpg" alt="Patient logo">
                <div class="name">
                    <span>${doctor.name} </span><br>
                    <span >Admin</span>
                </div>

            </div>

        </div>
    </div>

    <div class="container mt-4">
        <!-- Doctor Profile Section -->
        <div class="row justify-content-center">
            <div class="col-md-6">
                <div class="card profile-card p-4 text-center">
                    <img src="https://via.placeholder.com/150" alt="Doctor Profile Picture">
                    <h3 class="mt-3">Dr. John Doe</h3>
                    <p class="text-muted">Cardiologist</p>
                    <p><strong>Experience:</strong> 15 years</p>
                    <p><strong>Specialization:</strong> Cardiology and Heart Health</p>
                </div>
            </div>
        </div>
    </div>
    <div class="row mt-4">
        <h4 class="text-center mb-3">Schedules</h4>
        <c:forEach var="schedule" items="${schedules}">
            <c:if test="${schedule.PId != null && schedule.slotDate != null && schedule.description != null}">
                <div class="col-md-4 mb-4">
                    <div class="card schedule-card p-3">
                        <h5>Schedule ID: ${schedule.SId}</h5>
                        <p><strong>Doctor ID:</strong> ${schedule.DId}</p>
                        <p><strong>Patient ID:</strong> ${schedule.PId}</p>
                        <p><strong>Slot Date:</strong> ${schedule.slotDate}</p>
                        <p><strong>Slot Time:</strong> ${schedule.slotTime}</p>
                        <p><strong>Limit:</strong> ${schedule.limit} patients</p>
                        <p><strong>Description:</strong>
                            <c:out value="${schedule.description}" default="No description available" />
                        </p>
                        <div class="d-grid gap-2">
                            <button class="btn btn-primary">Join Meeting</button>
                            <button class="btn btn-danger">Cancel Schedule</button>
                        </div>
                    </div>
                </div>
            </c:if>
        </c:forEach>
    </div>



    </div>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>
    </body>
</html>
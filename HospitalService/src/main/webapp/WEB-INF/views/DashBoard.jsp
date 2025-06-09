<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.HospitalService.model.Hospital" %>
    <%@ page import="com.HospitalService.model.HospitalStatus" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Dashboard UI</title>
  <link rel="stylesheet" href="/css/hospital.css">
</head>
<body>

<div class="header1">
  <div class="logo">
    <img src="../images/logo.png" alt="Logo" class="logo-img">
    <h3 class="logo-h3">Hospital</h3>
  </div>
</div>

<div class="main">
  <div class="sidebar">
    <div class="profile">
      <img src="https://tse1.mm.bing.net/th?id=OIP.-kAF_LYtcdjpYb6be7fPngHaE8&pid=Api&P=0&h=180" alt="User Profile">
      <h3>${hospital.name}</h3>
      <p>${hospital.address}</p>
      <p>${hospital.contact}</p>
    </div>
    <hr>
    <ul>
      <li><a href="/Hospital/updateHospitalStatus">Update Hospital Data</a></li>
      <li><a href="/Hospital/addDoctorForm">Add Doctors</a></li>
    </ul>
    <hr>
    <div class="logout">
      <button>Logout</button>
    </div>
  </div>

  <div class="main-content">
    <div class="stats">
      <div class="card">
              <h2>${status.status_1}</h2>
              <p>Hospital Open/Close</p>
      </div>
       <div class="card">
       <p>Present Doctor</p>
                    <h2>${status.presentDoctor}</h2>

       </div>
      <div class="card">
        <h2>${status.ambulanceCount}</h2>
        <p>Total Ambulance</p>
      </div>
      <div class="card">
        <h2>5</h2>
        <p>Upcoming Visits</p>
      </div>
      <div class="card">
        <h2>${status.staffCount}</h2>
        <p>Hospital Staff</p>
      </div>
      <div class="card">
        <h2>${hospital.id}</h2>
        <p>Hospital ID</p>
      </div>
      <div class="card">
        <h2>
          <c:choose>
            <c:when test="${status.icuAvailable}">Yes</c:when>
            <c:otherwise>No</c:otherwise>
          </c:choose>
        </h2>
        <p>ICU Available</p>
      </div>
      <div class="card">
        <h2>
          <c:choose>
            <c:when test="${status.otActive}">Yes</c:when>
            <c:otherwise>No</c:otherwise>
          </c:choose>
        </h2>
        <p>OT Operations</p>
      </div>
    </div>

    <div class="bookcards">
      <h2>Latest Appointments</h2>
      <hr>

      <!-- Example static card; replace with dynamic list if needed -->
      <div class="patient-card">
        <div class="patient-info">
          <p><strong>Patient Name:</strong> John Doe</p>
          <p><strong>Condition:</strong> Serious</p>
          <p><strong>Emergency Type:</strong> Cardiac</p>
          <p><strong>Address:</strong> 123 Main Street, City</p>
          <p><strong>Contact:</strong> +91-9876543210</p>
          <p><strong>Age:</strong> 45</p>
          <p><strong>Ambulance Needed:</strong> Yes</p>
        </div>
        <div class="patient-actions">
          <a href=""><button class="btn yellow" onclick="updateStatus(this, 'Accepted')">Accept</button>
          <button class="btn green" onclick="updateStatus(this, 'Accepted and Ambulance Sent')">Accept & Send Ambulance</button>
          <button class="btn red" onclick="updateStatus(this, 'Rejected')">Reject</button>
          <div class="status-message"></div>
        </div>
      </div>

      <!-- Clone or loop dynamically if needed -->
    </div>
  </div>
</div>

<script>
  function updateStatus(button, message) {
    const card = button.closest('.patient-card');
    const statusDiv = card.querySelector('.status-message');
    statusDiv.textContent = message;
    if (message === "Rejected") {
      statusDiv.style.color = "#f44336";
    } else if (message === "Accepted and Ambulance Sent") {
      statusDiv.style.color = "#4caf50";
    } else {
      statusDiv.style.color = "#fdd835";
    }
  }
</script>

</body>
</html>

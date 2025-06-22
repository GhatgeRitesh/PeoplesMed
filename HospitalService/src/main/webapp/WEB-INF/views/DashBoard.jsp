<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="com.HospitalService.model.Hospital" %>
<%@ page import="com.HospitalService.model.HospitalStatus" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Dashboard UI</title>
  <link rel="stylesheet" href="/css/hospital.css">
  <style>
   .main-content {
     max-width: 1000px;
     margin: 0 auto;
     padding: 20px 10px;
   }

   .dashboard-grid {
     display: grid;
     grid-template-columns: repeat(auto-fit, minmax(130px, 1fr));
     gap: 14px;
     margin-bottom: 30px;
   }

   .dashboard-card {
     height: 100px;
     border-radius: 12px;
     text-align: center;
     padding: 10px 5px;
     background: linear-gradient(to bottom right, #e0e0e0, #ffffff);
     color: #333;
     box-shadow: 0 4px 10px rgba(0,0,0,0.05);
     transition: all 0.3s ease-in-out;
   }

   .dashboard-card:hover {
     transform: translateY(-4px);
     box-shadow: 0 8px 18px rgba(0,0,0,0.1);
   }

   .card-header {
     font-size: 26px;
     margin-bottom: 5px;
   }

   .card-info {
     font-size: 15px;
     font-weight: 600;
     line-height: 1.3;
   }

   .card-info small {
     font-size: 11px;
     opacity: 0.7;
   }

   /* Color themes */
   .green {
     background: linear-gradient(135deg, #b9f6ca, #00c853);
     color: white;
   }

   .red {
     background: linear-gradient(135deg, #ff8a80, #d50000);
     color: white;
   }

   .blue {
     background: linear-gradient(135deg, #82b1ff, #2962ff);
     color: white;
   }

   iframe {
     width: 100%;
     height: 700px;
     border: none;
     border-radius: 12px;
     box-shadow: 0 0 12px rgba(0,0,0,0.15);
   }


  </style>
</head>
<body>

<div class="header1">
  <div class="logo">
    <img src="/images/logo.png" alt="Logo" class="logo-img">
    <h3 class="logo-h3">Hospital Service</h3><br><h6>* Powered by PeoplesMed</h6>
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
    <div class="dashboard-grid">
      <div class="dashboard-card ${status.status_1 == 'open' ? 'green' : 'red'}">
        <div class="card-header">🏥</div>
        <div class="card-info">${status.status_1}<br><small>Status</small></div>
      </div>
      <div class="dashboard-card blue">
        <div class="card-header">👨‍⚕️</div>
        <div class="card-info">${status.presentDoctor}<br><small>Doctors</small></div>
      </div>
      <div class="dashboard-card ${status.ambulanceCount > 0 ? 'green' : 'red'}">
        <div class="card-header">🚑</div>
        <div class="card-info">${status.ambulanceCount}<br><small>Ambulances</small></div>
      </div>
      <div class="dashboard-card blue">
        <div class="card-header">📅</div>
        <div class="card-info">5<br><small>Visits</small></div>
      </div>
      <div class="dashboard-card blue">
        <div class="card-header">👨‍🔧</div>
        <div class="card-info">${status.staffCount}<br><small>Staff</small></div>
      </div>
      <div class="dashboard-card blue">
        <div class="card-header">🆔</div>
        <div class="card-info">${hospital.id}<br><small>Hospital ID</small></div>
      </div>
      <div class="dashboard-card ${status.icuAvailable ? 'green' : 'red'}">
        <div class="card-header">💉</div>
        <div class="card-info">${status.icuAvailable ? 'Yes' : 'No'}<br><small>ICU</small></div>
      </div>
      <div class="dashboard-card ${status.otActive ? 'green' : 'red'}">
        <div class="card-header">🔬</div>
        <div class="card-info">${status.otActive ? 'Yes' : 'No'}<br><small>OT</small></div>
      </div>
    </div>

    <iframe src="/Hospital/Iframe"></iframe>
  </div>


</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
 import="com.EmergencyServcice.Model.HospitalStatusDTO"
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <title>Hospital Dashboard</title>
  <link rel="stylesheet" href="/css/Emergency_Dash.css">
  <style>
    iframe.response-frame {
      width: 100%;
      height: 400px;
      border: 2px solid #ccc;
      margin-top: 15px;
      border-radius: 10px;
      box-shadow: 0 0 10px rgba(0,0,0,0.15);
    }
  </style>
</head>
<body>

  <!-- Emergency Section -->
  <div class="emergency-section">
    <div class="emergency-header">
      <img src="https://img.icons8.com/ios-filled/50/ambulance.png" alt="Ambulance"/>
      <div class="emergency-title">Emergency Service</div>
    </div>
    <div class="emergency-small">*powered by peoplemed</div>
    <div class="back-btn">Back</div>
  </div>

  <!-- Dynamic Hospital Cards -->
  <c:forEach var="hospital" items="${hospitals}">
    <div class="hospital-card">
      <div class="hospital-header">
        <div class="hospital-type ${hospital.type == 'Private' ? 'private' : 'gov'}">
          ${hospital.type}
        </div>
        <div class="status">${hospital.status_1 ? 'Open' : 'Close'}</div>
      </div>

      <div class="hospital-info">
        <h3>${hospital.name}</h3>
        <p>${hospital.address}, ${hospital.city}</p>
      </div>

      <div class="info-grid">
        <div class="box speciality">Speciality: ${hospital.speciality}</div>
        <div class="box">ICU Availability: ${hospital.icuAvailable ? 'Yes' : 'No'}</div>
        <div class="box">Present Doctor: ${hospital.presentDoctor}</div>
        <div class="box ambulance">Ambulance Count: ${hospital.ambulanceCount}</div>
        <div class="box">OT Active: ${hospital.otActive ? 'Yes' : 'No'}</div>
        <div class="box contact-green">Contact: ${hospital.contact}</div>
      </div>

      <button class="request-btn" onclick="acceptRequest(this)">Request Assistance</button>
      <!-- Removed the static accepted message -->
    </div>
  </c:forEach>

  <script>
    function acceptRequest(button) {
      const card = button.closest('.hospital-card');
      button.style.display = 'none';

      // Create and add the iframe
      const iframe = document.createElement('iframe');
      iframe.className = 'response-frame';
      iframe.src = '/EmergencyService/Ifram';        // 🔁 Replace with your real page

      card.appendChild(iframe);
    }

    document.addEventListener("DOMContentLoaded", () => {
      document.querySelectorAll('.status').forEach(statusDiv => {
        const text = statusDiv.textContent.trim().toLowerCase();
        if (text === 'open') {
          statusDiv.classList.add('open');
          statusDiv.classList.remove('close');
        } else {
          statusDiv.classList.add('close');
          statusDiv.classList.remove('open');
        }
      });

      document.querySelectorAll('.box').forEach(box => {
        const text = box.textContent.toLowerCase();
        if (text.includes('icu availability')) {
          box.classList.toggle('green', text.includes('yes'));
          box.classList.toggle('red', text.includes('no'));
        }
        if (text.includes('ot active')) {
          box.classList.toggle('green', text.includes('yes'));
          box.classList.toggle('red', text.includes('no'));
        }
      });

      document.querySelectorAll('.hospital-type').forEach(typeDiv => {
        const text = typeDiv.textContent.trim().toLowerCase();
        if (text === 'private') {
          typeDiv.classList.add('private');
          typeDiv.classList.remove('gov');
        } else {
          typeDiv.classList.add('gov');
          typeDiv.classList.remove('private');
        }
      });
    });
  </script>
</body>
</html>


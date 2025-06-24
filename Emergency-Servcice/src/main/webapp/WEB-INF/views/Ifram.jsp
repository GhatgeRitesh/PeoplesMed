<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
 import="com.EmergencyServcice.Model.Emergency_Requests"
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <title>Emergency Response</title>
  <style>
    body {
      font-family: 'Segoe UI', sans-serif;
      background: #f4f6f8;
      margin: 0;
      padding: 20px;
    }

    .response-container {
      background: #fff;
      max-width: 600px;
      margin: 0 auto;
      padding: 25px 30px;
      box-shadow: 0 4px 20px rgba(0,0,0,0.1);
      border-radius: 12px;
      position: relative;
    }

    .patient-info p {
      font-size: 16px;
      margin: 8px 0;
    }

    .patient-info strong {
      color: #333;
    }

    .loader {
      margin: 25px auto 10px;
      width: 100%;
      max-width: 500px;
      height: 80px;
    }

    .heartbeat-ecg {
      width: 100%;
      height: 100%;
    }

    .heartbeat-ecg path {
      fill: none;
      stroke: #e74c3c;
      stroke-width: 2;
      stroke-dasharray: 1000;
      stroke-dashoffset: 1000;
      animation: draw 3s linear infinite;
    }

    @keyframes draw {
      to {
        stroke-dashoffset: 0;
      }
    }

    .waiting-text {
      text-align: center;
      color: #555;
      font-size: 15px;
      margin-bottom: 20px;
    }

    .status-message {
      margin-top: 20px;
      font-size: 18px;
      font-weight: bold;
      text-align: center;
      padding: 15px;
      border-radius: 8px;
    }

    .accepted {
      background-color: #d4edda;
      color: #155724;
    }

    .rejected {
      background-color: #f8d7da;
      color: #721c24;
    }

    .back-button {
      position: absolute;
      top: 20px;
      right: 20px;
      background-color: #007bff;
      color: #fff;
      border: none;
      padding: 8px 16px;
      font-size: 14px;
      border-radius: 6px;
      cursor: pointer;
      transition: background-color 0.3s ease;
    }

    .back-button:hover {
      background-color: #0056b3;
    }
  </style>
</head>
<body>
<audio id="acceptedSound" src="/audio/accepted.mp3" preload="auto"></audio>
<audio id="acceptedAmbulanceSound" src="/audio/acceptedAMB.mp3" preload="auto"></audio>
<audio id="rejectedSound" src="/audio/rejected.mp3" preload="auto"></audio>
<audio id="pendingSound" src="/audio/pending.mp3" preload="auto"></audio>


  <div class="response-container">
    <button class="back-button" onclick="goBack()">← Back</button>

    <div class="patient-info">
      <p><strong>Patient Name:</strong> ${request.name}</p>
      <p><strong>Condition:</strong> ${request.condition}</p>
      <p><strong>Emergency Type:</strong> ${request.emergencyType}</p>
      <p><strong>Address:</strong> ${request.address}</p>
      <p><strong>Contact:</strong> ${request.contact}</p>
      <p><strong>Age:</strong> ${request.age}</p>
      <p><strong>Ambulance Needed:</strong> <c:choose>
        <c:when test="${request.ambulanceNeed}">Yes</c:when>
        <c:otherwise>No</c:otherwise>
      </c:choose></p>
    </div>

    <div class="loader" id="loader">
      <svg class="heartbeat-ecg" viewBox="0 0 500 80" preserveAspectRatio="none">
        <path d="
          M 0 40
          L 50 40
          L 60 20
          L 70 60
          L 80 40
          L 120 40
          L 130 10
          L 140 70
          L 150 40
          L 200 40
          L 210 20
          L 220 60
          L 230 40
          L 270 40
          L 280 15
          L 290 65
          L 300 40
          L 340 40
          L 350 10
          L 360 70
          L 370 40
          L 500 40
        " />
      </svg>
    </div>

    <div class="waiting-text" id="waitingText">Waiting for hospital response...</div>

    <div class="status-message" id="statusMessage" style="display: none;"></div>
  </div>

  <script>
    const requestId = ${request.id}; // Dynamically insert request ID from backend

    let intervalId = setInterval(getStatus, 5000); // Call every 5s

    function getStatus() {
      fetch('/api/getStatus', {
        method: 'GET'
      })
      .then(response => response.json())
      .then(data => {
        if (data && data.acceptanceStatus) {
          showResult(data.acceptanceStatus);
        }
      })
      .catch(error => {
        console.error('Error fetching status:', error);
      });
    }

   function showResult(status) {
     clearInterval(intervalId);
     document.getElementById('loader').style.display = 'none';
     document.getElementById('waitingText').style.display = 'none';

     const statusDiv = document.getElementById('statusMessage');
     statusDiv.style.display = 'block';
     statusDiv.classList.remove('accepted', 'rejected', 'pending'); // reset classes

     const normalizedStatus = status.toLowerCase();

     if (normalizedStatus.includes('accepted')) {
       statusDiv.textContent = '✅ Request Accepted — Awaiting your arrival at the hospital.';
       statusDiv.classList.add('accepted');
       document.getElementById('acceptedSound').play();
     } else if (normalizedStatus.includes('accepted ambulance')) {
       statusDiv.textContent = '🚑 Request Accepted — Ambulance is on the way to your location.';
       statusDiv.classList.add('accepted');
       document.getElementById('acceptedAmbulanceSound').play();
     } else if (normalizedStatus.includes('rejected')) {
       statusDiv.textContent = '❌ Unfortunately, your request was rejected. Please try another hospital.';
       statusDiv.classList.add('rejected');
       document.getElementById('rejectedSound').play();
     } else {
       statusDiv.textContent = 'ℹ️ Status pending or unrecognized. Please wait or try again.';
       statusDiv.classList.add('pending');
       document.getElementById('pendingSound').play();
     }
   }



    function goBack() {
      window.history.back();
    }
  </script>

</body>
</html>

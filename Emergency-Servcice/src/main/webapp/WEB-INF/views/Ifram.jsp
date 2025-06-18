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
      width: 60px;
      height: 50px;
      animation: moveAmbulance 2s ease-in-out infinite alternate;
    }

    .loader img {
      width: 100%;
      height: 100%;
    }

    @keyframes moveAmbulance {
      0% { transform: translateX(0); }
      100% { transform: translateX(100px); }
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

  <div class="response-container">
    <button class="back-button" onclick="goBack()">← Back</button>

    <div class="patient-info">
      <p><strong>Patient Name:</strong> John Doe</p>
      <p><strong>Condition:</strong> Serious</p>
      <p><strong>Emergency Type:</strong> Cardiac</p>
      <p><strong>Address:</strong> 123 Main Street, City</p>
      <p><strong>Contact:</strong> +91-9876543210</p>
      <p><strong>Age:</strong> 45</p>
      <p><strong>Ambulance Needed:</strong> Yes</p>
    </div>

    <div class="loader" id="loader">
      <img src="https://img.icons8.com/ios-filled/50/ambulance.png" alt="Ambulance Icon"/>
    </div>
    <div class="waiting-text" id="waitingText">Waiting for hospital response...</div>

    <div class="status-message" id="statusMessage" style="display: none;"></div>
  </div>

  <script>
    let intervalId;

    function getStatus() {
      // Simulating a fetch to backend API for status check
      fetch('/api/emergency/status') // 🔁 Replace with your backend URL
        .then(res => res.json())
        .then(data => {
          if (data.status) {
            showResult(data.status);
          }
        })
        .catch(err => {
          console.error("Error fetching status:", err);
        });
    }

    function showResult(status) {
      clearInterval(intervalId);
      document.getElementById('loader').style.display = 'none';
      document.getElementById('waitingText').style.display = 'none';

      const statusDiv = document.getElementById('statusMessage');
      statusDiv.style.display = 'block';

      if (status.toLowerCase().includes('accepted')) {
        statusDiv.textContent = '✅ Accepted: Ambulance on the way!';
        statusDiv.classList.add('accepted');
      } else {
        statusDiv.textContent = '❌ Request Rejected. Please try another hospital.';
        statusDiv.classList.add('rejected');
      }
    }

    function goBack() {
      window.history.back(); // One step back in browser history
    }

    // Check every 5 seconds
    intervalId = setInterval(getStatus, 5000);

    // OPTIONAL: Simulate response for demo
    setTimeout(() => {
      showResult("Accepted and Ambulance on the way");
    }, 10000);
  </script>
</body>
</html>

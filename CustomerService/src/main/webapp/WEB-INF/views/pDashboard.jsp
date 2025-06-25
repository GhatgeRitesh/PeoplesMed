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

<!-- Floating Chatbot -->
<style>
  .chatbot-icon {
    position: fixed;
    bottom: 20px;
    right: 20px;
    cursor: pointer;
    z-index: 1000;
    transition: transform 0.3s ease;
  }

  .chatbot-icon.bounce {
    animation: bounce 0.6s ease;
  }

  @keyframes bounce {
    0% { transform: translateY(0); }
    25% { transform: translateY(-10px); }
    50% { transform: translateY(0); }
    75% { transform: translateY(-6px); }
    100% { transform: translateY(0); }
  }

  .chatbot-icon img {
    width: 60px;
    height: 60px;
    border-radius: 50%;
    box-shadow: 0 0 10px rgba(0,0,0,0.2);
  }

  .chatbot-window {
    display: none;
    flex-direction: column;
    position: fixed;
    bottom: 90px;
    right: 20px;
    width: 560px;
    height: 500px;
    background: #fff;
    border-radius: 14px;
    box-shadow: 0 0 20px rgba(0,0,0,0.3);
    overflow: hidden;
    font-family: 'Segoe UI', sans-serif;
    z-index: 1001;
  }

  .chatbot-header {
    background: linear-gradient(135deg, #0076D1, #005BAA);
    color: white;
    padding: 14px;
    font-size: 16px;
    font-weight: bold;
    display: flex;
    justify-content: space-between;
    align-items: center;
  }

  .chatbot-body {
    flex: 1;
    padding: 12px;
    background-color: #f7f9fb;
    overflow-y: auto;
    display: flex;
    flex-direction: column;
    gap: 10px;
  }

  .chat-message {
    max-width: 85%;
    padding: 12px 16px;
    border-radius: 16px;
    font-size: 14px;
    line-height: 1.4;
    position: relative;
    box-shadow: 0 2px 6px rgba(0,0,0,0.1);
    word-wrap: break-word;
    width: fit-content;
  }

  /* User message on right */
  .chat-message.user {
    background-color: #daf7f6;
    align-self: flex-end;
    margin-left: auto;
    text-align: right;
  }

  /* Bot message on left */
  .chat-message.bot {
    background-color: #e9f0ff;
    align-self: flex-start;
    margin-right: auto;
    text-align: left;
  }

  .timestamp {
    font-size: 10px;
    color: #999;
    margin-top: 4px;
    text-align: right;
  }

  .chatbot-footer {
    display: flex;
    padding: 10px;
    background: #fff;
    border-top: 1px solid #ccc;
  }

  .chatbot-footer input {
    flex: 1;
    padding: 10px;
    border-radius: 10px;
    border: 1px solid #ccc;
    font-size: 14px;
  }

  .chatbot-footer button {
    margin-left: 8px;
    padding: 10px 14px;
    background-color: #0076D1;
    color: white;
    border: none;
    border-radius: 10px;
    cursor: pointer;
  }
</style>
</head>
<body>

<div class="header1">
  <div class="logo">
    <img src="/images/logo.png" alt="Logo" class="logo-img">
    <h3 class="logo-h3">PeoplesMed</h3>
  </div>
  <div class="emergency-button-container">
    <a href="http://localhost:8085/EmergencyService/form" target="_blank">
      <button class="emergency-button">🚨 Emergency</button>
    </a>
    <a href="/logout">
      <button class="logout-button">Logout</button>
    </a>
  </div>
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
      <div class="card TVisits">
        <h2>10</h2>
        <p>Total Visits</p>
      </div>
      <div class="card UVisits">
        <h2>5</h2>
        <p>Upcoming Visits</p>
      </div>
      <div class="card Creadit">
        <h2>16</h2>
        <p>Credit</p>
      </div>
    </div>

    <div class="bookcards">
      <div class="left_bookcards"></div>
      <div class="right_bookcards">
        <br>
        <h2>Latest Appointments</h2>
        <hr>
        <c:forEach var="schedule" items="${schedules}">
          <div class="appointments">
            <div class="appointment-card">
              <div class="info">
                <h4>${schedule.docName}</h4>
                <p>Appointment Date: ${schedule.slotDate}</p>
                <p>Time: ${schedule.slotTime}</p>
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
                  <button style="background-color: #4CAF50; color: white; border: none; padding: 10px 20px;
                    border-radius: 5px; cursor: pointer;">Join Meeting</button>
                </a>
              </div>
            </div>
          </div>
        </c:forEach>
      </div>
    </div>
  </div>
</div>

<!-- Icon -->
<div class="chatbot-icon" onclick="toggleChatbot()" id="chatbotIcon">
  <img src="/images/chatbot.jpeg" alt="PeoplesMed Chatbot"
       onerror="this.onerror=null; this.src='https://cdn-icons-png.flaticon.com/512/4712/4712027.png';">
</div>

<!-- Chat Window -->
<div class="chatbot-window" id="chatbotWindow">
  <div class="chatbot-header">
    PeoplesMed AI Assistant
    <button onclick="toggleChatbot()" style="background:none; border:none; color:white; font-size:18px;">×</button>
  </div>
  <div class="chatbot-body" id="chatBody">
    <div class="chat-message bot">
      👋 Hi! I'm your assistant. Ask me about hospitals, doctors, emergencies, or anything health-related.
      <div class="timestamp">now</div>
    </div>
  </div>
  <div class="chatbot-footer">
    <input type="text" id="userInput" placeholder="Ask about doctors, hospitals..."
           onkeypress="if(event.key === 'Enter') sendMessage()" />
    <button onclick="sendMessage()">Send</button>
  </div>
</div>

<!-- Sounds -->
<audio id="notifySound" src="/audio/notify.mp3" preload="auto"></audio>

<script>
  const notifySound = document.getElementById('notifySound');
  const chatbotIcon = document.getElementById('chatbotIcon');
  const chatBody = document.getElementById('chatBody');

  function toggleChatbot() {
    const chatbot = document.getElementById('chatbotWindow');
    chatbot.style.display = chatbot.style.display === 'flex' ? 'none' : 'flex';
  }

  function playNotify() {
    try {
      notifySound.currentTime = 0;
      notifySound.play();
    } catch (err) {
      console.warn('Sound play failed:', err.message);
    }
  }

  function bounceIcon() {
    chatbotIcon.classList.add('bounce');
    setTimeout(() => chatbotIcon.classList.remove('bounce'), 600);
  }

  function appendMessage(text, sender) {
    const msgDiv = document.createElement('div');
    msgDiv.className = `chat-message ${sender}`;
    msgDiv.innerHTML = text.replace(/\n/g, "<br>");

    const timestamp = document.createElement('div');
    timestamp.className = 'timestamp';
    const now = new Date();
    timestamp.textContent = now.toLocaleTimeString([], { hour: '2-digit', minute: '2-digit' });
    msgDiv.appendChild(timestamp);

    chatBody.appendChild(msgDiv);
    chatBody.scrollTop = chatBody.scrollHeight;
  }

  function sendMessage() {
    const inputElem = document.getElementById('userInput');
    const input = inputElem.value.trim();
    if (!input) return;

    appendMessage(input, 'user');
    inputElem.value = '';

    fetch('/chatbot/ask', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({ message: input })
    })
    .then(res => res.text())
    .then(data => {
      try {
        const maybeJson = JSON.parse(data);
        appendMessage(maybeJson.text || data, 'bot');
        playNotify();
      } catch {
        appendMessage("<h3> Assistant Response </h3>           \n"+data, 'bot');
        playNotify();
      }
    })
    .catch(() => {
      appendMessage("Sorry, I'm having trouble understanding right now.", 'bot');
      playNotify();
    });
  }

  // Icon bounce every 30s for attention
  setInterval(() => {
    bounceIcon();
    playNotify();
  }, 30000);
</script>
</body>
</html>

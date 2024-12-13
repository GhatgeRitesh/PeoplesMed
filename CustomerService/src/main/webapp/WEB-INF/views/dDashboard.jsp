<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import="java.util.List, com.FrontEnd.CustomerService.EntityManager.Users.Doctor" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Doctor's Dashboard</title>
  <link rel="stylesheet" href="/css/Doctor_Dashboard.css">
</head>
<body>


   <div class="header1">
		<div class="logo">
			<img src="../images/logo.png" alt="Logo" class="logo-img">
			<h3 class="logo-h3">PeoplesMed</h3>
		</div>
	<a href="/logout"><button>Logout</button></a>
	</div>





  <div class="dashboard">
    <!-- Sidebar -->
    <aside class="sidebar">
      <div class="sidebar-header">
      <img src="https://img.freepik.com/premium-vector/doctor-profile-with-medical-service-icon_617655-48.jpg" alt="img">
        <h2>${doctor.name}</h2>
      </div>
      <nav class="sidebar-nav">
        <ul>
          <li><a href="#" class="active">Home</a></li>
          <li><a href="#">Appointments</a></li>
          <li><a href="#">Pofile</a></li>
          <li><a href="#">Edit Profile</a></li>

        </ul>
      </nav>
    </aside>

    <!-- Main Content -->
    <div class="main-content">
      <main class="dashboard-content">
        <div class="stats">
          <div class="stat">
            <h2>New Patients Today</h2>
            <p>3</p>
          </div>
          <div class="stat">
            <h2>Old Patients</h2>
            <p>12</p>
          </div>
          <div class="stat">
            <h2>Total Patients</h2>
            <p>15</p>
          </div>
          <div class="stat">
            <h2>Recovered</h2>
            <p>10</p>
          </div>
        </div>
        <section class="patient-list">
          <h2>New Patient List</h2>
          <table>
            <thead>
              <tr>
                <th>#</th>
                <th>First Name</th>
                <th>Date</th>
                <th>Time</th>
                <th>Satus</th>
                <th>Link</th>
              </tr>
            </thead>
            <tbody>
                <c:forEach var="schedule" items="${schedules}" varStatus="status">
                    <tr>
                        <td>${status.index + 1}</td> <!-- Serial number -->
                        <td>${schedule.patName}</td>
                        <td>${schedule.slotDate}</td>
                        <td>${schedule.slotTime}</td>
                        <td>
                            <span style="${schedule.status == 'Completed' ? 'color: green; font-weight: bold;' :
                                          schedule.status == 'Pending' ? 'color: orange; font-weight: bold;' :
                                          'color: black; font-weight: normal;'}">
                                ${schedule.status}
                            </span>
                        </td>
                        <td>
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
                        </td>
                    </tr>
                </c:forEach>
            </tbody>

          </table>
        </section>
      </main>
    </div>
  </div>

  <script src="scripts.js"></script>
</body>
</html>








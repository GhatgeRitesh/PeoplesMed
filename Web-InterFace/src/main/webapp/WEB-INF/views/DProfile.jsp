<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import="java.util.List, com.FrontEnd.CustomerService.EntityManager.Users.Doctor" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <!DOCTYPE html>
    <html lang="en">
    <head>
      <meta charset="UTF-8">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <link rel="icon" href="/images/favcon1.jpg" class="favcon">
            <title>𝙋𝙚𝙤𝙥𝙡𝙚𝙨𝙈𝙚𝙙</title>
      <link rel="stylesheet" href="/css/Doctor_Profile.css">
    </head>
    <body>


       <div class="header1">
    		<div class="logo">
    			<img src="../images/logo.png" alt="Logo" class="logo-img">
    			<h3 class="logo-h3">PeoplesMed</h3>
    		</div>
    	</div>





      <div class="dashboard">
        <!-- Sidebar -->
        <aside class="sidebar">
          <div class="sidebar-header">
            <img src="https://img.freepik.com/free-photo/beautiful-young-female-doctor-looking-camera-office_1301-7807.jpg" alt="Notifications" />
            <h2>Dr.FEDOREL Clinic</h2>
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
          <!--<header class="dashboard-header">-->
          <!--  <div class="clinic-info">-->
          <!--    <h1>PepoleMedic</h1>-->
          <!--  </div>-->
          <!--  <div class="pending-appointments">-->
          <!--    <button id="pendingAppointments" title="Pending Appointments">-->
          <!--      <img src="data:image/jpeg;base64,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" alt="Notifications" />-->
          <!--    </button>-->
          <!--  </div>-->
          <!--</header>-->



           <div class="container">
                        <div class="left-section">
                            <div class="profile-image">
                                <img src="../images/doc3.png" alt="Dr. Karen Dawson">
                            </div>
                            <div class="doctor-info">
                                <h2 id="doctor_name">Dr. Karen Dawson</h2>
                                <h3 id="specialization">Paediatric Surgeon</h3>
                                <!-- <p>Reg. No: <strong>TX1234567</strong></p> -->
                                <p id="ho_name">Medic General Medical Hospital, North Houston, Texas, USA</p>
                            </div>
                        </div>

                        <div class="right-section">
                            <div class="info-section">
                                <h4>Reg. No</h4>
                                <p id="registration_no">TX1234567</p>
                            </div>

                        <div class="right-section">
                            <div class="info-section">
                                <h4 >Education</h4>
                                <p id="education">M.S, M.Ch (Paediatric Surgery)</p>
                            </div>

                            <div class="specialty-section">
                                <h4>Specialization</h4>
                                <div class="specialty-tags" >
                                    <span>Paediatric</span>
                                    <span>Endoscopic</span>
                                    <span>Laparoscopy</span>
                                    <span>Thoracoscopy</span>
                                </div>
                            </div>

                            <div class="details-section">
                                <div class="detail-box">
                                    <h4>Experience</h4>
                                    <p id="experience">22 Years+</p>
                                </div>
                            </div>

                            <div class="hospital-section">
                                <h4>Hospital</h4>
                                <p id="">Medic General Medical Hospital, North Houston, Texas, USA</p>
                            </div>

                            <div class="contact-section">
                                <h4>Contact</h4>
                                <p id="phone">Phone: 1234 567 89055663</p>
                                <p id="email">Email: yourwebaddress@mail.com</p>
                            </div>
                        </div>

                        <!-- <div class="edit">
                            <button>  <a href="editdoctor.html"> Edit</a></button>
                        </div> -->
                    </div>

    </div>






        </div>
      </div>
      <script src="scripts.js"></script>
    </body>
    </html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import="java.util.List, com.FrontEnd.Web_InterFace.EntityManager.Users.Doctor" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="/css/DoctorProifile.css">
</head>
<body>



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
                </div>
           

         
</body>
</html>
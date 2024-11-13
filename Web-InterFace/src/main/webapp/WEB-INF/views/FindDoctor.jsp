<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import="java.util.List, com.FrontEnd.Web_InterFace.EntityManager.Users.Doctor" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Find Doctors</title>
     <link rel="stylesheet" href="/css/findDoctors.css">
</head>
<body>
    <div class="header">
        <div class="logo">
          <img src="/images/logo.png" alt="Logo" class="logo-img">
          <h3 class="logo-h3">PeoplesMed</h3>
        </div>
        <div class="nav-bar">
          <a href="/home/Welcome">Home</a>&nbsp;&nbsp;&nbsp;&nbsp;
          <a href="/P/findDoctor">Find a Doctor</a>&nbsp;&nbsp;&nbsp;&nbsp;
          <a href="#">Services</a>&nbsp;&nbsp;&nbsp;&nbsp;
          <a href="#">Contact</a>&nbsp;&nbsp;&nbsp;&nbsp;
        </div>

        <div class="logincontainer">

            <div class="login">
               <button id="toggleButton"> <a href="#" style="text-decoration: none; color: white;"> Login </a></button>
            </div>


            <div class="signin">
              <button id="toggleButton1"> <a href="PPsign.html" style="text-decoration: none; color: white;">SignUp</a></button>
            </div>

          </div>
    </div>




        <c:forEach var="doctor" items="${list}">
        <div class="carddiv">
              <div class="card">
                  <div class="left">
                  <img src="../images/treat.jpg" alt=""> <br>
                    <p>Dr. ${doctor.name}</p>
                  </div>
                  <div class="right">
                    <div class="info_div">
                      <h4>${doctor.name} Hospital</h4>
                       <p>${doctor.specialization} | ${doctor.experience} experience</p>
                    </div>
                    <div class="info_div">
                   <p><b>Address :</b> <span>Old Kapada galli Latur,Latur Lorem ipsum dolor sit amet.</span></p>
                  <p><b>Degree :</b> <span>${doctor.education} </span></p>
                    </div>
                    <div class="info_div" id="buttondiv">
                     <a href="/P/d/${doctor.d_id}"><button>Book Appointment</button></a>
                          <!-- <a href="#" >Add a Review</a>
                          <div class="review">

                          </div> -->
                    </div>
                  </div>
              </div>
        </div>
	</c:forEach>

            </div>
        </div>


</body>
</html>
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
          <img src="../images/logo.png" alt="Logo" class="logo-img">
          <h3 class="logo-h3">PeoplesMed</h3>
        </div>
        <div class="nav-bar">
          <a href="../Welcome.html">Home</a>
          <a href="#">Find a Doctor</a>
          <a href="#">Services</a>
          <a href="#">Contact</a>
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










<!--
<%
     List<Doctor> list = (List<Doctor>) request.getAttribute("list");

      if(list != null) {
        for(Doctor doc: list){
      %>
        <div class="card_contener">
            <div class="card">
                <img src="/images/doc1.png" alt="">
                <div class="details">
                   <h1><%doc.getName();%></h1>
                    <span><%doc.getSpecialization();%></span>
                    <ul class="ul">
                    <li>Pediatric Neurology</li>
                    <li>Pediatric Neurology</li>
                    <li>Pediatric Neurology</li>
                </ul>
            </div>

          <div class="button"><a href="/p/docprofile"+ <%doc.getD_id();%>><button><% doc.getD_id(); %></button></div>

            </div>
       <%}
       }%>
<!--  --> -->
        <c:forEach var="doctor" items="${list}">
		<div class="card_contener">
			<div class="card">
				<img src="../images/doc1.png" alt="">
				<div class="details">
					<h1>Dr. ${doctor.name}</h1>
					${doctor.d_id}
					<div class="details" style="border:1px solid red; align-items:left;">
					<h3>Education : ${doctor.education}</h3>
					<h3>Experience : ${doctor.experience}</h3>
					</div>
					<span>Specialization</span>
					<ul class="ul">
						<li>${doctor.specialization}</</li>
						<li>${doctor.specialization}</</li>
						<li>${doctor.specialization}</</li>
					</ul>
				</div>
				<div class="button">
					<a href="/p/d/${doctor.d_id}"}>
						<button>Book</button>
					</a>
				</div>

			</div>



		</div>
	</c:forEach>

            </div>
        </div>


</body>
</html>
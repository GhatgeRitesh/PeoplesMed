<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import="java.util.List, com.FrontEnd.CustomerService.EntityManager.Users.Doctor , com.FrontEnd.CustomerService.EntityManager.Users.Appointments" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <link rel="icon" href="/images/favcon1.jpg" class="favcon">
      <title>𝙋𝙚𝙤𝙥𝙡𝙚𝙨𝙈𝙚𝙙</title>
    <link rel="stylesheet" href="/css/BookAppointment.css">
</head>

<script src="https://code.jquery.com/jquery-3.7.1.min.js"
	integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
	crossorigin="anonymous"></script>
	<style>
    .time-button-container {
        display: inline-block;
        margin: 5px;
    }

    .available input[type="radio"] {
        display: none;
    }

    .available label {
        background-color: #007bff;
        color: white;
        padding: 10px 15px;
        border-radius: 8px;
        cursor: pointer;
        margin: 5px;
        display: inline-block;
    }

    .allotted {
        background-color: #dc3545;
        color: white;
        padding: 10px 15px;
        border-radius: 8px;
        margin: 5px;
        display: inline-block;
        cursor: not-allowed;
    }

    .available input[type="radio"]:checked + label {
        background-color: #28a745;
        border-color: #28a745;
    }

    .disabled {
        opacity: 0.6;
        cursor: not-allowed;
    }
</style>
<body>
    
<!--  -->


<div class="header">
  <div class="logo">
    <img src="/images/logo.png" alt="Logo" class="logo-img">
    <h3 class="logo-h3">PeoplesMed</h3>
  </div>
  <div class="nav-bar">
    <a href="/home/Welcome">Home</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <a href="/P/findDoctor">Find a Doctor</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <a href="#">Services</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <a href="#">Contact</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  </div>

  <div class="logincontainer">


      
    </div>
</div>


<!--  -->

  <br>
  	<br>
  	<br>
  	<br>
  	<br>
  	<div class="div_details">
  		<div class="div_cntainer">

  			<div class="div_left">
  				<br>

  				<div class="div_name">
  					<label for="name">${doc.name}</label>
  				</div>

  				<br>
  				<div class="div_card">
  					<div class="div_im_sms">
  						<div class="div_img">
  							<!-- <img src="/images/dr1.jpg" alt=""> -->
  							<img
  								src="https://png.pngtree.com/png-vector/20240127/ourlarge/pngtree-doctor-png-png-image-png-free-png-ai-generative-png-image_11555707.png"
  								alt="">
  						</div>
  						<br>
  						<div class="sms">
  							<a href="">
  								<button>
  									<h4>SMS Todgdfgsd</h4>
  								</button>
  							</a>
  						</div>
  					</div>

  					<div class="div_Container_Spec">
  						<div class="div_specialization">
  							<h1>Specialization</h1>
  							<span>${doc.specialization}</span>
  						</div>

  						<div class="div_Primer">
  							<h1>Primary Consultation Location</h1>
  							<span>${doc.hospitalName}</span>
  							<span>${doc.city}</span>
  						</div>

  					</div>

  				</div>

  				<br> <br>


  				<div class="Doctor_bio">
  					<h2>Quick Bio</h2>
  					<br>
  					<p>The first person to document a surgery was the 6th century
  						BC Indian physician-surgeon, Sushruta. He specialized in cosmetic
  						plastic surgery and even documented an open rhinoplasty
  						procedure.[3] His magnum opus Suśruta-saṃhitā is one of the most
  						important surviving ancient treatises on medicine and is
  						considered a foundational text of both Ayurveda and surgery. The
  						treatise addresses all aspects of general medicine, but the
  						translator G. D. Singhal dubbed Sushruta "the father of surgical
  						intervention" on account.</p>
  				</div>
  				<br>
  				<hr>
  				<hr>
  				<hr>


  				<div class="hospital">
  					<!-- <img src="https://www.moh.gov.et/sites/default/files/styles/large/public/2021-04/medicalservice.jpg?itok=cGkSlaj9" alt="">               -->
  				</div>
  			</div>


  			<div class="div_right">
  				<div class="Apt_book">
  					<h1>My Weekly Schedule</h1>
  					<div class="Apt_book_Hsc">
  						<p>Main Hospitals,old Airport Road</p>
  						<div class="Apt_book_time">
  							<div class="div_spn">
  								<span>09:00AM - 03:00PM</span>
  							</div>
  							<div class="div_day">
  								<div class="day">MON</div>
  								<div class="day">WED</div>
  							</div>
  						</div>
  					</div>

  					<div class="Apt_book_Hsc">
  						<p>Clinic Name , Pune Clinic</p>
  						<div class="Apt_book_time">
  							<div class="div_spn">
  								<span>10:30AM - 12:00PM</span>
  							</div>
  							<div class="div_day">
  								<div class="day">MON</div>
  								<div class="day">SAT</div>
  							</div>
  						</div>
  					</div>



  					<div class="Apt_book_Hsc">
  						<p>Home Clinic,Pune</p>
  						<div class="Apt_book_time">
  							<div class="div_spn">
  								<span>05:00PM - 08:00PM</span>
  							</div>
  							<div class="div_day">
  								<div class="day">MON-SAT</div>

  							</div>
  						</div>
  					</div>

  					<br> <br> <br>

  					<!-- Book Schedule ............. -->
  					<form action="/P/BookSchedule/${doc.d_id}" method="post">
  						<div class="Book_Schedul">
  							<h1>Book Appointment</h1>
  							<div class="Book_div1">
  								<!--  -->
  								 <label for="reason">Reason
  									for Appointment:</label>
  								<textarea id="reason" name="description"
  									placeholder="Describe your symptoms or reason for visit"
  									required></textarea>

  								<label for="email">Date:</label> <input type="date" id="datePicker"
  									name="slotDate" required>&nbsp; &nbsp; &nbsp; &nbsp; <input
  									type="button" class="button-primary"
  									value="Get Slots" onclick="fetchSlots()"> <br>

  								<div id="scheduleContainer"></div>



  								<div class="button-group">
  									<input type="submit" class="button-primary" value="Submit">&nbsp;&nbsp;
  									<div class="available">
  										<div class="dot1"></div>
  										<span>Alloted</span>
  										<div class="dot2"></div>
  										<span>Available</span>
  									</div>
  								</div>


  							</div>

  						</div>
  					</form>



  				</div>
  			</div>
  		</div>
  	</div>

  	<br>
  	<br>

  	<div class="back_button">
  		<a href="/P/findDoctor">
  			<p>Go Back</p>
  		</a>
  	</div>

  	<br>
  	<br>
  	<br>
  	<br>
  	<br>


  	<script type="text/javascript">
  	function fetchSlots() {
  	    const date = document.getElementById("datePicker").value;
  	    console.log("Selected date:", date);
  	    if (!date) {
  	        alert("Please select a date.");
  	        return;
  	    }

  	    $.ajax({
  	        url: '/P/getSchedules/${doc.d_id}?date=' +date,
  	        method: "GET",
  	        success: function (data) {
  	            $("#scheduleContainer").empty();
  	            console.log("Data received:", data);

  	            if (Array.isArray(data) && data.length > 0) {
  	                data.forEach(slot => {
  	                    const slotDiv = $("<div></div>").addClass("time-button-container");

  	                    const radioButton = $("<input>").attr({
  	                        type: "radio",
  	                        name: "slotTime",
  	                        value: slot.slotTime,
  	                        id: "slot-" + slot.slotTime,
  	                    });

  	                    const label = $("<label></label>").attr("for", "slot-" + slot.slotTime)
  	                        .text(slot.slotTime);
  	                        console.log(slot.status);
  	                    if (slot.limit < 5) {
  	                        slotDiv.addClass("available");
  	                        slotDiv.append(radioButton).append(label);
  	                    } else {
  	                        slotDiv.addClass("allotted");
  	                        label.addClass("disabled");
  	                        slotDiv.append(label);
  	                    }

  	                    $("#scheduleContainer").append(slotDiv);
  	                });
  	            } else {
  	                $("#scheduleContainer").append('<div class="error-message">No slots available for the selected date.</div>');
  	            }
  	        },
  	        error: function (xhr, status, error) {
  	            console.error("Error fetching data:", xhr.responseText);
  	            $("#scheduleContainer").html(`<div style="color: red;">Error fetching data. Please try again.</div>`);
  	        }
  	    });
  	}
  	</script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.HospitalService.model.HospitalStatusDTO" %>
    <%@ page import="com.HospitalService.model.HospitalStatus" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1" />
  <title>Doctor Information Form</title>
  <link rel="stylesheet" href="/css/Doctor_Info.css" />
</head>
<body>

  <nav>
    <div class="logo"><img src="./logo.png" alt=""><h4>PeoplesMed</h4></div>

    <a href=" " class="contact-btn">Home</a>
  </nav>

  <div class="form-container">
    <h2>Doctor Information Form</h2>
    <form action="/Hospital/AddDoctor " method="post">

      <label for="name">Name:</label>
      <input type="text" id="name" name="name" placeholder="Enter Doctor's Name" required />

      <label for="speciality">Speciality:</label>
      <input type="text" id="speciality" name="speciality" placeholder="Enter Speciality" />

      <label for="contact">Contact:</label>
      <input type="text" id="contact" name="contact" placeholder="Enter Contact Number" />

      <label for="degree">Degree:</label>
      <input type="text" id="degree" name="degree" placeholder="Enter Degree (e.g., MBBS, MD)" />

      <label for="hospitalId">Hospital ID:</label>
      <input type="text" id="hospitalId" name="hospitalId" value="${hospital.id}" required />

      <button type="submit">Submit</button>
    </form>
  </div>

</body>
</html>

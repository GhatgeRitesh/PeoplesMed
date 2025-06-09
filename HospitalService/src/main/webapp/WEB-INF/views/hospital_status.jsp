<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.HospitalService.model.Hospital" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Hospital Ward Form</title>
  <link rel="stylesheet" href="/css/hospital_Status.css">
</head>
<body>



   <nav>
    <div class="logo"><img src="./logo.png" alt=""><h4>PeoplesMed</h4></div>

    <a href=" " class="contact-btn">Home</a>
  </nav>

  <div class="form-container">
    <h2>Ward Information Form</h2>
    <form action="/Hospital/setStatus" method="post">

      <label for="icuAvailable">ICU Available:</label>
      <select id="icuAvailable" name="icuAvailable" required>
        <option value="">Select</option>
        <option value="true">Yes</option>
        <option value="false">No</option>
      </select>

      <label for="presentDoctor">Present Doctor:</label>
      <input type="text" id="presentDoctor" name="presentDoctor" placeholder="Enter Doctor's Name">

      <label for="otActive">OT Active:</label>
      <select id="otActive" name="otActive" required>
        <option value="">Select</option>
        <option value="true">Yes</option>
        <option value="false">No</option>
      </select>

      <label for="status">Status:</label>
      <select id="status" name="status_1" required>
        <option value="">Select</option>
        <option value="open">Open</option>
        <option value="close">Close</option>
      </select>

      <label for="staffCount">Staff Count:</label>
      <input type="number" id="staffCount" name="staffCount" min="0" placeholder="Number of Staff">

      <label for="ambulanceCount">Ambulance Count:</label>
      <input type="number" id="ambulanceCount" name="ambulanceCount" min="0" placeholder="Number of Ambulances">

      <label for="hospitalId">Hospital ID:</label>
      <input type="text" id="hospitalId" name="hospitalId" value="${hospital_id}" required>

      <button type="submit">Submit</button>
    </form>
  </div>

</body>
</html>

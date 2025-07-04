<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1" />
  <title>Hospital Information Form</title>
  <link rel="stylesheet" href="/css/hospital_Details.css" />
</head>
<body>


  <nav>
    <div class="logo"><img src="./logo.png" alt=""><h4>PeoplesMed</h4></div>

    <a href="http://localhost:8083/home/Welcome " class="contact-btn">Home</a>
  </nav>


  <div class="form-container">
    <h2>Hospital Information Form</h2>
    <form action="/Hospital/Register" method="POST">

      <label for="name">Hospital Name:</label>
      <input type="text" id="name" name="name" placeholder="Enter Hospital Name" required />

      <label for="address">Address:</label>
      <input type="text" id="address" name="address" placeholder="Enter Address" />

      <label for="city">City:</label>
      <input type="text" id="city" name="city" placeholder="Enter City" required />

      <label for="type">Type:</label>
      <input type="text" id="type" name="type" placeholder="e.g., Private, Government" />

      <label for="speciality">Speciality:</label>
      <input type="text" id="speciality" name="speciality" placeholder="e.g., Cardiology, Oncology" />

      <label for="password">Password:</label>
      <input type="password" id="password" name="password" placeholder="Set a Password" required />

      <label for="contact">Contact:</label>
      <input type="text" id="contact" name="contact" placeholder="Enter Contact Number" />

      <label for="icuAvailable">ICU Available:</label>
      <select id="icuAvailable" name="icuAvailable">
        <option value="">Select</option>
        <option value="true">Yes</option>
        <option value="false">No</option>
      </select>

      <label for="otAvailable">OT Available:</label>
      <select id="otAvailable" name="otAvailable">
        <option value="">Select</option>
        <option value="true">Yes</option>
        <option value="false">No</option>
      </select>

      <button type="submit">Submit</button>
    </form>
  </div>

</body>
</html>

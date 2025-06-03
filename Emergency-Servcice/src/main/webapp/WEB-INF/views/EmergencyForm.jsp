<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Emergency Form</title>
  <link rel="stylesheet" href="/css/Form_Emergency.css" />
</head>
<body>

  <nav>
    <div class="logo"><img src="/images/logo.png" alt=""><h4>PeoplesMed</h4></div>
    <!-- <ul>
        <li><a href="#">Home</a></li>
      <li><a href="#">Hospitals</a></li>
      <li><a href="#">Contact</a></li>
    </ul> -->
    <a href=" " class="contact-btn">Home</a>
  </nav>


  <div class="form-container">
    <h2>Emergency Form</h2>
    <form action="/EmergencyService/submitEmergency" method="post" id="emergencyForm">
      <div class="form-group">
        <label>Condition Type:</label>
        <label>
          <input type="radio" name="condition" value="serious"
                 <c:if test="${patient != null and patient.role == 'serious'}">checked</c:if> />
          Serious
        </label>
        <label>
          <input type="radio" name="condition" value="mild"
                 <c:if test="${patient != null and patient.role == 'mild'}">checked</c:if> />
          Mild
        </label>
      </div>

      <div class="form-group">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" value="${patient.name}" />
      </div>

      <div class="form-group">
        <label for="age">Age:</label>
        <input type="text" id="age" name="age" value="${patient.age}" />
      </div>

      <div class="form-group">
        <label for="city">City:</label>
        <input type="text" id="city" name="city" value="${patient.city}" />
      </div>

      <div class="form-group">
        <label for="address">Address:</label>
        <input type="text" id="address" name="address" value="${patient.address}" />
      </div>

      <div class="form-group">
        <label for="contact">Contact:</label>
        <input type="text" id="contact" name="contact" value="${patient.contact}" />
      </div>

      <div class="form-group">
        <label for="emergencyType">Emergency Type:</label>
        <select id="emergencyType" name="emergencyType">
          <option value="accident">Accident</option>
          <option value="fire">Fire</option>
          <option value="cardiac">Cardiac</option>
          <option value="other">Other</option>
        </select>
      </div>

      <div class="form-group">
        <label>Ambulance Need?</label>
        <label>
          <input type="radio" name="ambulanceNeed" value="true"
                 <c:if test="${patient != null and patient.role == 'emergency' or patient.role == 'serious'}">checked</c:if> /> Yes
        </label>
        <label>
          <input type="radio" name="ambulanceNeed" value="false"
                 <c:if test="${patient == null or patient.role != 'emergency'}">checked</c:if> /> No
        </label>
      </div>

      <button type="submit">Get Hospitals / Submit</button>
    </form>


  </div>

  <script>

document.getElementById("emergencyForm").addEventListener("submit", function (e) {
  e.preventDefault();

  const formData = {
    condition: document.querySelector('input[name="condition"]:checked').value,
    city: document.getElementById("city").value,
    address: document.getElementById("address").value,
    contact: document.getElementById("contact").value,
    emergencyType: document.getElementById("emergency").value,
    ambulanceNeed: document.querySelector('input[name="ambulance"]:checked').value,
  };

  alert("Form Submitted!\n" + JSON.stringify(formData, null, 2));
});



// Populate Emergency Types from backend
async function loadEmergencyTypes() {
  try {
    const response = await fetch("http://localhost:8080/api/emergency-types"); // Update with your backend URL
    const types = await response.json();

    const dropdown = document.getElementById("emergency");
    dropdown.innerHTML = ""; // Clear existing

    types.forEach(type => {
      const option = document.createElement("option");
      option.value = type.toLowerCase();
      option.textContent = type;
      dropdown.appendChild(option);
    });
  } catch (error) {
    console.error("Failed to load emergency types:", error);
    alert("Could not load emergency types from server.");
  }
}

// Handle form submission
document.getElementById("emergencyForm").addEventListener("submit", function (e) {
  e.preventDefault();

  const formData = {
    condition: document.querySelector('input[name="condition"]:checked').value,
    city: document.getElementById("city").value,
    address: document.getElementById("address").value,
    contact: document.getElementById("contact").value,
    emergencyType: document.getElementById("emergency").value,
    ambulanceNeed: document.querySelector('input[name="ambulance"]:checked').value,
  };

  alert("Form Submitted!\n" + JSON.stringify(formData, null, 2));
});

// Call this on page load
window.onload = loadEmergencyTypes;


  </script>
</body>
</html>

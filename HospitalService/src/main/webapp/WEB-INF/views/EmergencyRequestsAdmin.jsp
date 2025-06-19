<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.HospitalService.model.Emergency_Requests" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Admin - Emergency Requests</title>
  <style>
    body {
      font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
      background: linear-gradient(to right, #e0eafc, #cfdef3);
      margin: 0;
      padding: 30px;
    }

    h1 {
      text-align: center;
      color: #2c3e50;
      font-size: 32px;
      margin-bottom: 40px;
      text-shadow: 1px 1px 2px rgba(0,0,0,0.1);
    }

    .card-grid {
      display: grid;
      grid-template-columns: repeat(auto-fill, minmax(320px, 1fr));
      gap: 25px;
      padding: 0 15px;
    }

    .card {
      background: white;
      border-radius: 16px;
      padding: 24px;
      box-shadow: 0 6px 16px rgba(0, 0, 0, 0.1);
      transition: transform 0.3s ease, box-shadow 0.3s ease;
    }

    .card:hover {
      transform: translateY(-8px);
      box-shadow: 0 12px 24px rgba(0, 0, 0, 0.15);
    }

    .card p {
      margin: 10px 0;
      font-size: 15px;
      color: #333;
      line-height: 1.5;
    }

    .card strong {
      color: #2c3e50;
    }

    .status {
      font-weight: bold;
      padding: 6px 12px;
      border-radius: 20px;
      display: inline-block;
      font-size: 13px;
      text-transform: capitalize;
      margin-top: 8px;
    }

    .status.accepted {
      background-color: #e6f4ea;
      color: #207544;
      border: 1px solid #c4e3d5;
    }

    .status.rejected {
      background-color: #fdecea;
      color: #b32424;
      border: 1px solid #f5c2c0;
    }

    .status.pending {
      background-color: #fff4e5;
      color: #b36b00;
      border: 1px solid #ffe1b3;
    }
  </style>
</head>
<body>

<h1>Emergency Requests Overview</h1>

<div class="card-grid">
  <c:forEach var="req" items="${requests}">
    <div class="card">
      <p><strong>Name:</strong> ${req.name}</p>
      <p><strong>Age:</strong> ${req.age}</p>
      <p><strong>Condition:</strong> ${req.condition}</p>
      <p><strong>Emergency Type:</strong> ${req.emergencyType}</p>
      <p><strong>Address:</strong> ${req.address}</p>
      <p><strong>City:</strong> ${req.city}</p>
      <p><strong>Contact:</strong> ${req.contact}</p>
      <p><strong>Ambulance Needed:</strong>
        <c:choose>
          <c:when test="${req.ambulanceNeed}">Yes</c:when>
          <c:otherwise>No</c:otherwise>
        </c:choose>
      </p>
      <p>
        <strong>Status:</strong>
        <c:choose>
          <c:when test="${fn:containsIgnoreCase(req.acceptanceStatus, 'accepted')}">
            <span class="status accepted">${req.acceptanceStatus}</span>
          </c:when>
          <c:when test="${fn:containsIgnoreCase(req.acceptanceStatus, 'rejected')}">
            <span class="status rejected">${req.acceptanceStatus}</span>
          </c:when>
          <c:otherwise>
            <span class="status pending">${req.acceptanceStatus}</span>
          </c:otherwise>
        </c:choose>
      </p>
    </div>
  </c:forEach>
</div>

</body>
</html>

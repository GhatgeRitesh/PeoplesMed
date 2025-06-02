<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.HospitalService.model.Hospital" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Registered Hospitals - PeoplesMed</title>
    <link rel="stylesheet" href="/css/welcome.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <style>
        body {
            font-family: 'Segoe UI', sans-serif;
            background-color: #f4f7f9;
            margin: 0;
            padding: 20px;
        }
        h1 {
            text-align: center;
            color: #2c3e50;
            margin-bottom: 30px;
        }
        .hospital-grid {
            display: flex;
            flex-wrap: wrap;
            gap: 20px;
            justify-content: center;
        }
        .hospital-card {
            background-color: white;
            border-radius: 10px;
            box-shadow: 0 4px 10px rgba(0,0,0,0.1);
            width: 300px;
            padding: 20px;
            transition: transform 0.2s ease-in-out;
        }
        .hospital-card:hover {
            transform: translateY(-5px);
        }
        .hospital-card h2 {
            margin: 0;
            font-size: 22px;
            color: #34495e;
        }
        .hospital-attribute {
            margin: 10px 0;
            font-size: 14px;
            color: #555;
        }
        .badge {
            display: inline-block;
            padding: 5px 10px;
            border-radius: 20px;
            font-size: 12px;
            color: white;
            margin-right: 5px;
        }
        .icu { background-color: #27ae60; }
        .ot { background-color: #3498db; }
        .no { background-color: #e74c3c; }
    </style>
</head>
<body>
    <h1>Registered Hospitals</h1>

    <div class="hospital-grid">
        <c:forEach var="h" items="${Hospital}">
            <div class="hospital-card">
                <h2><i class="fas fa-hospital"></i> ${h.name}</h2>
                <div class="hospital-attribute"><strong>City:</strong> ${h.city}</div>
                <div class="hospital-attribute"><strong>Type:</strong> ${h.type}</div>
                <div class="hospital-attribute"><strong>Speciality:</strong> ${h.speciality}</div>
                <div class="hospital-attribute"><strong>Address:</strong> ${h.address}</div>

                <div class="hospital-attribute">
                    <strong>ICU:</strong>
                    <span class="badge ${h.icu_available ? 'icu' : 'no'}">${h.icu_available ? 'Available' : 'Not Available'}</span>
                </div>

                <div class="hospital-attribute">
                    <strong>OT:</strong>
                    <span class="badge ${h.ot_available ? 'ot' : 'no'}">${h.ot_available ? 'Available' : 'Not Available'}</span>
                </div>
            </div>
        </c:forEach>
    </div>
</body>
</html>

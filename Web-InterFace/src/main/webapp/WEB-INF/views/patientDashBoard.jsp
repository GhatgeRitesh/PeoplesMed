<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import="java.util.List, com.FrontEnd.Web_InterFace.EntityManager.Users.Doctor" %>

<!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate">
        <meta http-equiv="Pragma" content="no-cache">
        <meta http-equiv="Expires" content="0">
        <link rel="stylesheet" href="/css/welcome.css">
        <title>Vault Home</title>
    </head>
<body>
 <%
     List<Doctor> list = (List<Doctor>) request.getAttribute("list");
     if (list != null) {
         for (Doctor doctor : list) {
 %>
     <p>Doctor Name: <%= doctor.getName() %></p>
 <%
         }
     } else {
 %>
     <p>No doctors found.</p>
 <%
     }
 %>
</body>
</html>
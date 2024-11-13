<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Error Page</title>
        <style>
            /* Basic styling for the error page */
            body {
                font-family: Arial, sans-serif;
                display: flex;
                justify-content: center;
                align-items: center;
                height: 100vh;
                background-color: #f2f2f2;
            }
            .error-container {
                text-align: center;
                max-width: 500px;
                background: #fff;
                padding: 20px;
                border-radius: 10px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            }
            .error-code {
                font-size: 3em;
                color: #ff6b6b;
            }
            .error-message {
                font-size: 1.5em;
                color: #333;
            }
        </style>
    </head>
    <body>
        <div class="error-container">
            <div class="error-code">
                <c:choose>
                    <c:when test="${not empty status}">
                        Error Code: ${status}
                    </c:when>
                    <c:otherwise>
                        Unknown Error
                    </c:otherwise>
                </c:choose>
            </div>
            <div class="error-message">
                <c:choose>
                    <c:when test="${not empty message}">
                        Message: ${message}
                    </c:when>
                    <c:otherwise>
                        Sorry, something went wrong. Please try again later.
                    </c:otherwise>
                </c:choose>
            </div>
            <div>
                <a href="/home/Welcome" class="error-button"><button>Back to Home<button></a>
            </div>
        </div>
    </body>
    </html>

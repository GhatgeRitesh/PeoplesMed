<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Zoom Link Generated</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #121212; /* Dark theme */
            color: #ffffff; /* White text */
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            flex-direction: column;
        }

        .heading {
            font-size: 28px;
            font-weight: bold;
            color: #0078d4; /* Zoom blue */
            text-transform: uppercase;
            text-align: center;
            margin-bottom: 20px;
            animation: slideIn 3s ease-out;
        }

        @keyframes slideIn {
            0% {
                transform: translateY(-50px);
                opacity: 0;
            }
            100% {
                transform: translateY(0);
                opacity: 1;
            }
        }

        .container {
            text-align: center;
            background-color: #1f1f1f; /* Slightly lighter dark */
            border-radius: 10px;
            padding: 40px;
            box-shadow: 0px 4px 6px rgba(0, 0, 0, 0.3);
            max-width: 400px;
            width: 100%;
        }

        .emoji {
            font-size: 80px; /* Large emoji size */
            margin-bottom: 20px;
            animation: bounce 1.5s infinite;
        }

        @keyframes bounce {
            0%, 100% {
                transform: translateY(0);
            }
            50% {
                transform: translateY(-10px);
            }
        }

        h1 {
            font-size: 24px;
            color: #ffffff;
            margin: 0 0 10px;
        }

        .sub-heading {
            font-size: 16px;
            color: #bbbbbb; /* Light gray for contrast */
            margin: 0 0 20px;
        }

        .btn {
            display: inline-block;
            padding: 12px 20px;
            font-size: 16px;
            color: #ffffff;
            background-color: #0d6efd; /* Blue accent */
            border: none;
            border-radius: 5px;
            text-decoration: none;
            cursor: pointer;
            box-shadow: 0px 3px 6px rgba(0, 0, 0, 0.4);
        }

        .btn:hover {
            background-color: #0056b3; /* Darker blue for hover effect */
        }
    </style>
</head>
<body>
    <!-- Animated Heading -->
    <div class="heading">Zoom - PeoplesMed</div>

    <div class="container">
        <!-- Emoji Section -->
        <div class="emoji">📧</div>

        <!-- Text Content -->
        <h1>Zoom Link Generated!</h1>
        <p>The Zoom meeting link has been successfully created and sent to your registered email address.</p>
        <p>Please continue to proceed.</p>
        <a href="/P/bookingConfirm" class="btn">Continue</a>
    </div>
</body>
</html>


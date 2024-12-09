<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Appointment Confirmed</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background: linear-gradient(135deg, #6a11cb, #2575fc); /* Vibrant gradient */
            color: #fff;
        }
        .container {
            text-align: center;
            background: #ffffff;
            padding: 40px;
            border-radius: 15px;
            box-shadow: 0px 10px 20px rgba(0, 0, 0, 0.2);
            animation: slideIn 0.8s ease-in-out;
            max-width: 400px;
            color: #333;
        }
        .emoji {
            font-size: 60px;
            margin-bottom: 20px;
            animation: bounce 1s infinite;
        }
        @keyframes bounce {
            0%, 100% {
                transform: translateY(0);
            }
            50% {
                transform: translateY(-10px);
            }
        }
        @keyframes slideIn {
            0% {
                transform: translateY(50px);
                opacity: 0;
            }
            100% {
                transform: translateY(0);
                opacity: 1;
            }
        }
        h1 {
            font-size: 28px;
            font-weight: bold;
            margin-bottom: 10px;
            color: #444;
        }
        p {
            font-size: 18px;
            color: #666;
            margin-bottom: 20px;
            line-height: 1.5;
        }
        .btn {
            display: inline-block;
            background-color: #4caf50;
            color: #fff;
            padding: 12px 25px;
            text-decoration: none;
            border-radius: 8px;
            font-size: 18px;
            font-weight: bold;
            transition: all 0.3s;
            box-shadow: 0 5px 15px rgba(0, 0, 0, 0.2);
        }
        .btn:hover {
            background-color: #45a049;
            box-shadow: 0 7px 20px rgba(0, 0, 0, 0.3);
            transform: translateY(-3px);
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="emoji">🎉</div>
        <h1>Appointment Confirmed!</h1>
        <p>
            Your appointment has been successfully scheduled! 📅<br>
        </p>
        <a href="/login/profile" class="btn">Go to Dashboard 🚀</a>
    </div>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Payment Successful</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            font-family: 'Arial', sans-serif;
            background-color: #f6f9fc;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
            flex-direction: column;
        }

        header {
            text-align: center;
            margin-bottom: 30px;
        }

        header h1 {
            font-size: 36px;
            font-weight: 800;
            color: #1a202c;
            margin: 5px 0;
            letter-spacing: 1px;
        }

        header h2 {
            font-size: 20px;
            font-weight: 600;
            color: #4a5568;
            margin: 5px 0 20px;
        }

        .success-card {
            background-color: #ffffff;
            border-radius: 10px;
            box-shadow: 0px 4px 6px rgba(0, 0, 0, 0.1);
            padding: 30px;
            width: 100%;
            max-width: 450px;
            text-align: center;
            position: relative;
        }

        .success-card .icon {
            background-color: #6ae79c;
            width: 40px;
            height: 40px;
            border-radius: 50%;
            display: flex;
            justify-content: center;
            align-items: center;
            margin: 0 auto 20px;
        }

        .success-card .icon svg {
            fill: #ffffff;
            width: 20px;
            height: 20px;
        }

        .success-card h1 {
            font-size: 24px;
            font-weight: bold;
            color: #1a202c;
            margin-bottom: 10px;
        }

        .success-card p {
            font-size: 16px;
            color: #718096;
            margin-bottom: 20px;
            line-height: 1.5;
        }

        .success-card .button {
            text-decoration: none;
            background-color: #000000;
            color: #ffffff;
            padding: 12px 20px;
            border-radius: 5px;
            font-size: 16px;
            font-weight: 600;
            transition: background-color 0.3s ease;
        }

        .success-card .button:hover {
            background-color: #333333;
        }

        /* Confetti Styling */
        .confetti {
            position: absolute;
            width: 100%;
            height: 100%;
            overflow: hidden;
        }

        .confetti span {
            position: absolute;
            width: 10px;
            height: 10px;
            background-color: transparent;
            border-radius: 50%;
            animation: confetti-fall 2.5s ease-in infinite;
        }

        /* Randomly Assign Colors */
        .confetti span:nth-child(1) { background-color: #FF4081; }
        .confetti span:nth-child(2) { background-color: #4CAF50; }
        .confetti span:nth-child(3) { background-color: #2196F3; }
        .confetti span:nth-child(4) { background-color: #FFEB3B; }
        .confetti span:nth-child(5) { background-color: #9C27B0; }
        .confetti span:nth-child(6) { background-color: #FFC107; }
        .confetti span:nth-child(7) { background-color: #FF5722; }
        .confetti span:nth-child(8) { background-color: #673AB7; }

        /* Random Placement */
        .confetti span:nth-child(1) { top: 10%; left: 20%; }
        .confetti span:nth-child(2) { top: 30%; left: 40%; }
        .confetti span:nth-child(3) { top: 50%; left: 70%; }
        .confetti span:nth-child(4) { top: 70%; left: 10%; }
        .confetti span:nth-child(5) { top: 60%; left: 80%; }
        .confetti span:nth-child(6) { top: 20%; left: 60%; }
        .confetti span:nth-child(7) { top: 80%; left: 50%; }
        .confetti span:nth-child(8) { top: 40%; left: 30%; }

        /* Falling Animation */
        @keyframes confetti-fall {
            0% {
                transform: translateY(0) rotate(0deg);
                opacity: 1;
            }
            100% {
                transform: translateY(100vh) rotate(360deg);
                opacity: 0;
            }
        }

        /* Random Colors for Confetti */
        .confetti span:nth-child(2n) {
            background: #4caf50;
        }

        .confetti span:nth-child(3n) {
            background: #2196f3;
        }

        .confetti span:nth-child(4n) {
            background: #ffc107;
        }
    </style>
</head>
<body>
    <header>
        <h1>Stripe Payments</h1>
        <h2> PeoplesMed </h2>
    </header>

    <div class="confetti">
        <span></span><span></span><span></span><span></span>
        <span></span><span></span><span></span><span></span>
        <span></span><span></span><span></span><span></span>
        <span></span><span></span><span></span><span></span>
        <span></span><span></span><span></span><span></span>
        <span></span><span></span><span></span><span></span>
        <span></span><span></span><span></span><span></span>
        <span></span><span></span><span></span><span></span>
        <span></span><span></span><span></span><span></span>
        <span></span><span></span><span></span><span></span>
    </div>


    <div class="success-card">
        <div class="icon">
            <!-- Checkmark SVG Icon -->
            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                <path d="M9 16.2l-4.2-4.2-1.4 1.4L9 19 21 7l-1.4-1.4z"/>
            </svg>
        </div>
        <h1>Payment Succeeded!</h1>
        <p>Thank you ! <br> your Payment has been Successful.</p>
        <a href="/P/ZoomNotice" class="button">Continue Booking Appointment</a>
    </div>
</body>
</html>

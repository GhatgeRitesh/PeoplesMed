<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Payment Failed</title>
    <style>
        /* General Styles */
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background-color: #f44336; /* Red background for failed payment */
        }

        /* Card Container */
        .card {
            background: #fff;
            border-radius: 12px;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.2);
            padding: 24px 32px;
            text-align: center;
            width: 400px;
        }

        /* Icon */
        .icon {
            font-size: 48px;
            color: #f44336;
            margin-bottom: 16px;
        }

        /* Title */
        .card h1 {
            font-size: 28px;
            font-weight: bold;
            margin-bottom: 16px;
            color: #333;
        }

        /* Description */
        .card p {
            font-size: 16px;
            color: #666;
            margin-bottom: 24px;
        }

        /* Button */
        .button {
            display: inline-block;
            padding: 12px 20px;
            font-size: 16px;
            color: #fff;
            background-color: #333;
            border: none;
            border-radius: 8px;
            text-decoration: none;
            cursor: pointer;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.2);
            transition: background-color 0.3s ease;
        }

        .button:hover {
            background-color: #555;
        }

        /* Support Link */
        .support {
            margin-top: 16px;
            font-size: 14px;
        }

        .support a {
            color: #007bff;
            text-decoration: none;
        }

        .support a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <div class="card">
        <!-- Error Icon -->
        <div class="icon">⚠️</div>

        <!-- Title -->
        <h1>Payment Failed</h1>

        <!-- Description -->
        <p>
            Hey there. <br>
            We tried to charge your card, but something went wrong. <br>
            Please update your payment method <strong>OR</strong> try again later.
        </p>

        <!-- Update Payment Button -->
        <a href="/login/profile" class="button">Dashboard</a>

        <!-- Support -->
        <div class="support">
            Have a question? <a href="https://stripecustomersupport.com">Contact Support</a>
        </div>
    </div>
</body>
</html>

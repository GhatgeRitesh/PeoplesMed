<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Zoom API Usage Guide</title>
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap" rel="stylesheet">
        <style>
            /* General Styles */
            body {
                font-family: 'Roboto', sans-serif;
                margin: 0;
                padding: 0;
                background-color: #f4f4f9;
                color: #333;
            }

            header {
                background-color: #2a9d8f;
                color: white;
                padding: 20px;
                text-align: center;
                box-shadow: 0 2px 6px rgba(0, 0, 0, 0.1);
            }

            header h1 {
                margin: 0;
                font-size: 28px;
            }

            main {
                max-width: 900px;
                margin: 40px auto;
                background: white;
                border-radius: 10px;
                box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
                padding: 30px;
            }

            h2 {
                color: #2a9d8f;
                margin-bottom: 10px;
                font-size: 22px;
                border-bottom: 2px solid #2a9d8f;
                display: inline-block;
                padding-bottom: 5px;
            }

            p {
                line-height: 1.8;
                margin: 15px 0;
                font-size: 16px;
            }

            ul {
                list-style: none;
                padding: 0;
            }

            ul li {
                margin: 10px 0;
                font-size: 16px;
                position: relative;
                padding-left: 25px;
            }

            ul li:before {
                content: '✓';
                color: #2a9d8f;
                font-weight: bold;
                position: absolute;
                left: 0;
                top: 0;
            }

            a {
                color: #2a9d8f;
                text-decoration: none;
                font-weight: 500;
            }

            a:hover {
                text-decoration: underline;
            }

            footer {
                text-align: center;
                margin: 30px 0 10px;
                color: #555;
            }

            footer p {
                font-size: 14px;
            }

            /* Buttons */
            .btn {
                display: inline-block;
                background-color: #2a9d8f;
                color: white;
                padding: 10px 20px;
                border-radius: 5px;
                text-decoration: none;
                font-size: 16px;
                font-weight: 500;
                margin-top: 20px;
                transition: background-color 0.3s ease;
            }

            .btn:hover {
                background-color: #21867a;
            }
        </style>
    </head>
    <body>
        <header>
            <h1>PeoplesMed : Zoom API Usage Guide</h1>
        </header>
        <main>
            <h2>Welcome to Zoom Integration</h2>
            <p>
                Our application integrates with Zoom to help you schedule and manage virtual meetings efficiently. To use this feature, it’s mandatory to have a Zoom account.
            </p>
            <h3>Steps to Get Started</h3>
            <ul>
                <li>Register for a free Zoom account if you don’t have one already. Visit <a href="https://zoom.us/signup" target="_blank">Zoom Signup Page</a>.</li>
                <li>Log in to your Zoom account to enable integration with our platform.</li>
                <li>During the authorization process, grant permissions to our application to access Zoom features.</li>
            </ul>
            <h3>Why Is This Necessary?</h3>
            <p>
                The Zoom API requires users to authenticate their accounts for secure and reliable meeting creation. This ensures that your meeting data is protected and accessible only to you.
            </p>
            <h3>Need Help?</h3>
            <p>
                If you encounter issues during the process, feel free to contact our support team at
                <a href="mailto:support@yourdomain.com">support@yourdomain.com</a>.
            </p>
            <a href="https://zoom.us/signup" class="btn">Create Your Zoom Account</a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <a href="/P/zoom/authorize" class="btn">Already Registered Continue</a>
        </main>
        <footer>
            <p>&copy; 2024 Your Application. All rights reserved.</p>
        </footer>
    </body>
    </html>

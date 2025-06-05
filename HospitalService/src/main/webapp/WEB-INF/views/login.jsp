<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Hospital Service Login</title>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;600&display=swap" rel="stylesheet">
    <style>
        * { margin: 0; padding: 0; box-sizing: border-box; }

        body, html {
            height: 100%;
            font-family: 'Poppins', sans-serif;
            background: #101820;
            overflow: hidden;
            color: #fff;
        }

        /* ECG Pulse Animation Line - Extended with more up-downs */
        .ecg-line {
            position: fixed;
            top: 15%;
            left: 0;
            width: 100%;
            height: 80px;
            z-index: 0;
            background: url('data:image/svg+xml;utf8,<svg viewBox="0 0 1600 100" xmlns="http://www.w3.org/2000/svg"><polyline fill="none" stroke="%2300eaff" stroke-width="2" points="0,50 50,50 70,20 90,80 110,50 130,50 150,20 170,80 190,50 210,50 230,20 250,80 270,50 290,50 310,20 330,80 350,50 1600,50" /></svg>') repeat-x;
            background-size: contain;
            animation: moveECG 2s linear infinite;
            opacity: 0.4;
        }

        @keyframes moveECG {
            from { background-position-x: 0; }
            to { background-position-x: -200px; }
        }

        /* DNA Spiral Animation */
        .dna-container {
            position: fixed;
            bottom: -100px;
            left: 10%;
            transform: translateX(-50%);
            width: 20px;
            height: 100vh;
            z-index: 0;
            overflow: hidden;
        }

        .dna-bar {
            width: 100%;
            height: 20px;
            background: linear-gradient(to right, #6f00ff, #00eaff);
            margin: 10px 0;
            border-radius: 50%;
            animation: wave 2s ease-in-out infinite alternate;
        }

        .dna-bar:nth-child(even) {
            animation-delay: 1s;
        }

        @keyframes wave {
            0% { transform: translateX(-20px) rotate(15deg); opacity: 0.6; }
            100% { transform: translateX(20px) rotate(-15deg); opacity: 1; }
        }

        /* Floating Icons (Doctor, Ambulance, fewer Hospital Beds) */
        .floating-icon {
            position: absolute;
            width: 35px;
            height: 35px;
            background: rgba(255, 255, 255, 0.08);
            border-radius: 50%;
            background-size: 65%;
            background-repeat: no-repeat;
            background-position: center;
            animation: float 20s linear infinite;
            z-index: 0;
            filter: drop-shadow(0 0 4px #00eaff);
        }

        @keyframes float {
            from { transform: translateY(100vh); }
            to { transform: translateY(-200px); }
        }

        .login-box {
            background: rgba(0, 0, 0, 0.85);
            padding: 40px 35px;
            border-radius: 15px;
            box-shadow: 0 0 25px rgba(0, 255, 255, 0.1);
            width: 100%;
            max-width: 400px;
            text-align: center;
            position: relative;
            z-index: 2;
        }

        .login-box h1 {
            margin-bottom: 10px;
            font-size: 1.8em;
        }

        .login-box .subtitle {
            font-size: 0.9em;
            font-weight: 300;
            color: #ccc;
            margin-bottom: 30px;
        }

        .form-group {
            margin-bottom: 20px;
            text-align: left;
        }

        .form-group input {
            width: 100%;
            padding: 12px 15px;
            background: transparent;
            border: 2px solid #00eaff;
            border-radius: 10px;
            color: #fff;
            font-size: 1em;
        }

        .form-group input:focus {
            outline: none;
            border-color: #6f00ff;
            box-shadow: 0 0 8px #6f00ff;
        }

        .form-group label {
            display: block;
            margin-bottom: 8px;
            font-weight: 600;
            color: #ddd;
        }

        .submit-btn {
            width: 100%;
            padding: 12px;
            background: linear-gradient(135deg, #00eaff, #6f00ff);
            border: none;
            border-radius: 10px;
            color: white;
            font-weight: bold;
            font-size: 1em;
            cursor: pointer;
            transition: background 0.3s;
        }

        .submit-btn:hover {
            background: linear-gradient(135deg, #6f00ff, #00eaff);
        }

        .footer {
            margin-top: 25px;
            font-size: 0.75em;
            color: #aaa;
        }

        .container {
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
            position: relative;
            z-index: 1;
        }
    </style>
</head>
<body>

<div class="ecg-line"></div>

<div class="dna-container">
    <% for (int i = 0; i < 15; i++) { %>
        <div class="dna-bar"></div>
    <% } %>
</div>

<%-- Floating Icons --%>
<script>
    const icons = [
        'https://img.icons8.com/ios-filled/50/00eaff/hospital-room.png',  // hospital bed
        'https://img.icons8.com/ios-filled/50/00eaff/doctor-male.png',     // doctor
        'https://img.icons8.com/ios-filled/50/00eaff/ambulance.png'        // ambulance
    ];

    for (let i = 0; i < 20; i++) {
        const icon = document.createElement('div');
        icon.classList.add('floating-icon');
        icon.style.left = Math.random() * window.innerWidth + 'px';
        icon.style.animationDuration = (Math.random() * 10 + 15) + 's';
        icon.style.top = Math.random() * 100 + 'vh';
        icon.style.backgroundImage = `url('${icons[i % icons.length]}')`;
        document.body.appendChild(icon);
    }
</script>

<div class="container">
    <div class="login-box">
        <h1>Hospital Service</h1>
        <div class="subtitle">*powered by PeoplesMed</div>
        <form action="/Hospital/login_submission" method="post">
            <div class="form-group">
                <label for="name">Hospital Name</label>
                <input type="text" name="name" id="name" required placeholder="e.g. Avinash Kumar">
            </div>
            <div class="form-group">
                <label for="contact">Phone Number</label>
                <input type="text" name="contact" id="contact" required placeholder="+91 9876543210">
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <input type="password" name="password" id="password" required placeholder="********">
            </div>
            <button class="submit-btn" type="submit">Login</button>
        </form>
        <div class="footer">
            &copy; 2025 PeoplesMed — All rights reserved.
        </div>
    </div>
</div>

</body>
</html>

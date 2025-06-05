<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Hospital Service Login</title>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;600&display=swap" rel="stylesheet">
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body, html {
            height: 100%;
            font-family: 'Poppins', sans-serif;
            background: #1f1c2c;
            color: #fff;
            overflow: hidden;
        }

        canvas#bg {
            position: fixed;
            top: 0;
            left: 0;
            z-index: 0;
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
            transition: border-color 0.3s ease;
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

<canvas id="bg"></canvas>

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

<script>
    const canvas = document.getElementById('bg');
    const ctx = canvas.getContext('2d');
    canvas.width = window.innerWidth;
    canvas.height = window.innerHeight;

    let particlesArray = [];

    class Particle {
        constructor() {
            this.x = Math.random() * canvas.width;
            this.y = Math.random() * canvas.height;
            this.size = Math.random() * 2 + 1;
            this.speedX = Math.random() * 1 - 0.5;
            this.speedY = Math.random() * 1 - 0.5;
        }

        update() {
            this.x += this.speedX;
            this.y += this.speedY;

            if (this.x < 0 || this.x > canvas.width) this.speedX *= -1;
            if (this.y < 0 || this.y > canvas.height) this.speedY *= -1;
        }

        draw() {
            ctx.fillStyle = '#00eaff';
            ctx.beginPath();
            ctx.arc(this.x, this.y, this.size, 0, Math.PI * 2);
            ctx.fill();
        }
    }

    function init() {
        particlesArray = [];
        for (let i = 0; i < 120; i++) {
            particlesArray.push(new Particle());
        }
    }

    function connectParticles() {
        for (let a = 0; a < particlesArray.length; a++) {
            for (let b = a; b < particlesArray.length; b++) {
                const dx = particlesArray[a].x - particlesArray[b].x;
                const dy = particlesArray[a].y - particlesArray[b].y;
                const distance = dx * dx + dy * dy;

                if (distance < 5000) {
                    ctx.strokeStyle = 'rgba(0, 234, 255, 0.1)';
                    ctx.lineWidth = 1;
                    ctx.beginPath();
                    ctx.moveTo(particlesArray[a].x, particlesArray[a].y);
                    ctx.lineTo(particlesArray[b].x, particlesArray[b].y);
                    ctx.stroke();
                }
            }
        }
    }

    function animate() {
        ctx.clearRect(0, 0, canvas.width, canvas.height);
        particlesArray.forEach(p => {
            p.update();
            p.draw();
        });
        connectParticles();
        requestAnimationFrame(animate);
    }

    init();
    animate();

    window.addEventListener('resize', () => {
        canvas.width = window.innerWidth;
        canvas.height = window.innerHeight;
        init();
    });
</script>

</body>
</html>

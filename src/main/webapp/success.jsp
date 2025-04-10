<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Success - Student Management System</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/@lottiefiles/lottie-player@latest"></script>
    <style>
        /* 🌌 Elegant Gradient Background */
        body {
            font-family: "Poppins", sans-serif;
            background: linear-gradient(135deg, #141E30, #243B55);
            height: 100vh;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            color: white;
        }

        /* ✨ Glowing Container */
        .container {
            max-width: 500px;
            background: rgba(255, 255, 255, 0.05);
            padding: 40px 30px;
            border-radius: 15px;
            box-shadow: 0 0 25px rgba(0, 255, 234, 0.1);
            backdrop-filter: blur(12px);
            text-align: center;
            border: 1px solid rgba(255, 255, 255, 0.15);
            animation: fadeIn 1s ease-in-out;
        }

        h2 {
            font-weight: 700;
            margin-top: 20px;
            margin-bottom: 15px;
            color: #00ffe0;
            text-shadow: 0px 0px 15px rgba(0, 255, 234, 0.7);
        }

        /* 🎨 Neon Buttons */
        .btn {
            font-size: 16px;
            padding: 12px 20px;
            margin: 10px 5px;
            border-radius: 10px;
            font-weight: bold;
            text-decoration: none;
            border: none;
            transition: all 0.3s ease-in-out;
        }

        .btn-success {
            background: #00ffbf;
            color: #000;
            box-shadow: 0 0 10px rgba(0, 255, 191, 0.5);
        }

        .btn-success:hover {
            background: #00e6ac;
            box-shadow: 0 0 20px rgba(0, 255, 191, 0.9);
        }

        .btn-primary {
            background: #00bfff;
            color: #000;
            box-shadow: 0 0 10px rgba(0, 191, 255, 0.5);
        }

        .btn-primary:hover {
            background: #009ccc;
            box-shadow: 0 0 20px rgba(0, 191, 255, 0.9);
        }

        /* 🔥 Animation */
        @keyframes fadeIn {
            from { opacity: 0; transform: scale(0.95); }
            to { opacity: 1; transform: scale(1); }
        }
    </style>
</head>
<body>
    <div class="container">
        <lottie-player 
            src="https://assets1.lottiefiles.com/packages/lf20_jtbfg2nb.json"
            background="transparent"
            speed="1"
            style="width: 180px; height: 180px; margin: auto;"
            loop autoplay>
        </lottie-player>

        <h2>Student Registered Successfully!</h2>
        <p><a href="register.jsp" class="btn btn-success">➕ Register Another</a></p>
        <p><a href="index.html" class="btn btn-primary">🏠 Go to Home</a></p>
    </div>
</body>
</html>

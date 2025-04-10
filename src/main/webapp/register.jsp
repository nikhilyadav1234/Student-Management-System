<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Student Registration</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <style>
        /* 🌌 Vibrant Gradient Background */
        body {
            font-family: "Trirong", serif;
            background: linear-gradient(135deg, #141E30, #243B55);
            height: 100vh;
            margin: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            color: white;
        }

        /* 🪞 Glassy Registration Form */
        .container {
            max-width: 440px;
            background: rgba(255, 255, 255, 0.08);
            padding: 35px 30px;
            border-radius: 20px;
            box-shadow: 0px 10px 40px rgba(0, 0, 0, 0.6);
            backdrop-filter: blur(10px);
            border: 1px solid rgba(255, 255, 255, 0.2);
            text-align: center;
        }

        h2 {
            font-weight: 700;
            margin-bottom: 25px;
            color: #00ffe0;
            text-shadow: 2px 2px 20px #000;
        }

        /* 🧊 Input Fields */
        .form-control {
            background: rgba(255, 255, 255, 0.1);
            border: none;
            color: #fff;
            transition: all 0.3s ease-in-out;
        }

        .form-control:focus {
            background: rgba(255, 255, 255, 0.2);
            border: 1px solid #00ffe0;
            box-shadow: 0 0 10px #00ffe0;
        }

        .form-control::placeholder {
            color: rgba(255, 255, 255, 0.6);
        }

        /* ✨ Neon Button */
        .btn-primary {
            background: #00ffe0;
            color: #000;
            font-weight: bold;
            border: none;
            padding: 12px;
            border-radius: 10px;
            box-shadow: 0 0 12px rgba(0, 255, 224, 0.8);
            transition: 0.3s ease-in-out;
        }

        .btn-primary:hover {
            background: #00cfcf;
            box-shadow: 0 0 20px rgba(0, 255, 224, 1);
        }

        .btn-secondary {
            margin-top: 10px;
            background-color: #888;
            color: white;
            border: none;
            padding: 10px;
            border-radius: 10px;
            transition: 0.2s;
        }

        .btn-secondary:hover {
            background-color: #555;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Register Student</h2>
        <form action="RegisterStudentServlet" method="post">
    <div class="mb-4">
        <input type="text" name="name" class="form-control" placeholder="Enter Name" required>
    </div>
    <div class="mb-4">
        <input type="email" name="email" class="form-control" placeholder="Enter Email" required>
    </div>
    <div class="mb-4">
        <input type="text" name="phone" class="form-control" placeholder="Enter Phone Number" required>
    </div>
    <div class="mb-4">
        <input type="text" name="address" class="form-control" placeholder="Enter Address" required>
    </div>
    <div class="mb-4">
        <input type="text" name="branch" class="form-control" placeholder="Enter Branch" required>
    </div>
    <div class="mb-4">
        <input type="text" name="course" class="form-control" placeholder="Enter Course" required>
    </div>
    <div class="mb-4">
        <input type="password" name="password" class="form-control" placeholder="Enter Password" required>
    </div>
    <button type="submit" class="btn btn-primary w-100">Register</button>
</form>

        <a href="index.html" class="btn btn-secondary w-100 mt-3">⬅ Go Back</a>
    </div>
</body>
</html>

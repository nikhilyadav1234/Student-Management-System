<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*, com.student.util.DatabaseConnection" %>

<%
    String id = request.getParameter("id");
    Connection conn = DatabaseConnection.getConnection();
    PreparedStatement stmt = conn.prepareStatement("SELECT * FROM students WHERE id = ?");
    stmt.setInt(1, Integer.parseInt(id));
    ResultSet rs = stmt.executeQuery();

    if (rs.next()) {
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Student</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            font-family: 'Segoe UI', sans-serif;
            background: linear-gradient(135deg, #1d2b64, #f8cdda);
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
            color: #fff;
            margin: 0;
        }

        .edit-form {
            background: rgba(255, 255, 255, 0.07);
            padding: 30px;
            border-radius: 16px;
            box-shadow: 0 15px 35px rgba(0, 0, 0, 0.3);
            backdrop-filter: blur(14px);
            width: 100%;
            max-width: 500px;
        }

        .edit-form h2 {
            text-align: center;
            margin-bottom: 30px;
            color: #00ffe0;
        }

        .form-label {
            font-weight: 600;
            color: #ddd;
        }

        .form-control {
            border-radius: 8px;
            background: rgba(255,255,255,0.1);
            color: #fff;
            border: none;
        }

        .form-control:focus {
            background: rgba(255,255,255,0.15);
            color: #fff;
            box-shadow: none;
        }

        .btn-primary {
            background-color: #00b894;
            border: none;
        }

        .btn-primary:hover {
            background-color: #019874;
        }

        .btn-secondary {
            background-color: #6c757d;
            border: none;
        }

        .btn-secondary:hover {
            background-color: #5a6268;
        }
    </style>
</head>
<body>
    <div class="edit-form">
        <h2>Edit Student Details</h2>
        <form action="UpdateStudentServlet" method="post">
            <input type="hidden" name="id" value="<%= rs.getInt("id") %>">
            <div class="mb-3">
                <label class="form-label">Name:</label>
                <input type="text" name="name" class="form-control" value="<%= rs.getString("name") %>" required>
            </div>
            <div class="mb-3">
                <label class="form-label">Email:</label>
                <input type="email" name="email" class="form-control" value="<%= rs.getString("email") %>" required>
            </div>
            <div class="mb-3">
                <label class="form-label">Course:</label>
                <input type="text" name="course" class="form-control" value="<%= rs.getString("course") %>" required>
            </div>
            <div class="d-flex justify-content-between">
                <button type="submit" class="btn btn-primary px-4">Update</button>
                <a href="ViewStudents" class="btn btn-secondary px-4">Go Back</a>
            </div>
        </form>
    </div>
</body>
</html>

<%
    } else {
        out.println("<h3 style='color:red; text-align:center;'>Error: Student not found!</h3>");
    }
    conn.close();
%>

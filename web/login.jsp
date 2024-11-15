<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
     <link href="styles.css" rel="stylesheet">
</head>
<body>
    <!-- Navigation Bar -->
    <div class="navbar">
        <a href="index.html">Home</a>
        <div>
            <a href="#" style="margin-right: 20px;">Contact Us</a>
            <a href="#" style="margin-right: 20px;">About Us</a>
        </div>
    </div>

    <!-- Page Content -->
    <div class="page-content">
        <div class="container mt-5">
            <div class="row">
                <div class="col-md-6">
                    <img src="./images/log.jpg" alt="Image" style="max-width: 100%; height: auto; margin-bottom: 20px;">
                </div>
                <div class="col-md-6">
                    <div class="login-form">
                        <h2>User Login</h2>
                        <% if (request.getAttribute("loginError") != null) {%>
                        <div class="alert alert-danger">
                            <%= request.getAttribute("loginError")%>
                        </div>
                        <% }%>
                        
                        <form action="/JobPortalApplication/login" method="post">
                            <div class="mb-3">
                                <label for="email" class="form-label">Email</label>
                                <input type="email" class="form-control" id="email" name="email" required>
                            </div>
                            <div class="mb-3">
                                <label for="password" class="form-label">Password</label>
                                <input type="password" class="form-control" id="password" name="password" required>
                            </div>
                            <button type="submit" class="btn btn-primary">Login</button>
                            <p class="mt-3">Don't have an account? <a href="register.jsp">Register here</a></p>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Footer -->
    <div class="footer">
        &copy; 2023 Job Portal Application
    </div>
</body>
</html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>User Registration</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="styles.css" rel="stylesheet">
    </head>
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
    <div class="page-content">
        <div class="container mt-5">
            <div class="row">
                <div class="col-md-6">
                    <img src="./images/register.jpg" alt="Image" style="max-width: 100%; height: auto; margin-bottom: 10px; alignment-adjust: central">
                </div>
                <div class="col-md-6">
                    <div class="register-form">
                        <h2>User Registration</h2>
                        <% if (request.getAttribute("registrationError") != null) {%>
                        <div class="alert alert-danger">
                            <%= request.getAttribute("registrationError")%>
                        </div>
                        <% }%>
                        <form action="/JobPortalApplication/register" method="post">
                            <div class="mb-2">
                                <label for="firstName" class="form-label">First Name</label>
                                <input type="text" class="form-control" id="firstName" name="firstName" required>
                            </div>
                            <div class="mb-2">
                                <label for="lastName" class="form-label">Last Name</label>
                                <input type="text" class="form-control" id="lastName" name="lastName" required>
                            </div>
                            <div class="mb-2">
                                <label for="address" class="form-label">Address</label>
                                <input type="text" class="form-control" id="address" name="address" required>
                            </div>
                            <div class="mb-2">
                                <label for="mobile" class="form-label">Mobile</label>
                                <input type="tel" class="form-control" id="mobile" name="mobile" required>
                            </div>
                            <div class="mb-2">
                                <label for="email" class="form-label">Email</label>
                                <input type="email" class="form-control" id="email" name="email" required>
                            </div>
                            <div class="mb-2">
                                <label for="nic" class="form-label">NIC</label>
                                <input type="text" class="form-control" id="nic" name="nic" required>
                            </div>
                            <div class="mb-2">
                                <label for="dob" class="form-label">Date of Birth</label>
                                <input type="date" class="form-control" id="dob" name="dob" required>
                            </div>
                            <div class="mb-2">
                                <label for="password" class="form-label">Password</label>
                                <input type="password" class="form-control" id="password" name="password" required>
                            </div>
                            <div class="mb-2">
                                <label for="role" class="form-label">Role</label>
                                <select class="form-select" id="role" name="role" required>
                                    <option value="admin">Admin</option>
                                    <option value="job_seeker">Job Seeker</option>
                                    <option value="recruiter">Recruiter</option>
                                </select>
                            </div>
                            <button type="submit" class="btn btn-primary">Register</button>
                        </form>
                    </div>
                </div>
            </div>
            </body>
            </html>

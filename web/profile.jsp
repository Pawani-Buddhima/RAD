<%@ page import="classes.User" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>User Profile</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="styles.css" rel="stylesheet">
    </head>
    <body>
        <div class="navbar">
            <a href="index.html">Home</a>
            <div>
                <a href="#" style="margin-right: 10px;">Contact Us</a>
                <a href="#" style="margin-right: 10px;">About Us</a>
            </div>
        </div>
        <div class="container mb-1">
            <h2>User Profile</h2>
            <% if (request.getAttribute("profileUpdateError") != null) {%>
            <div class="alert alert-danger">
                <%= request.getAttribute("profileUpdateError")%>
            </div>
            <% }%>
            <form action="/JobPortalApplication/update-profile" method="post">
                <div class="mb-1">
                    <label for="firstName" class="form-label">First Name</label>
                    <input type="text" class="form-control" id="firstName" name="firstName" value="<%= request.getParameter("firstName")%>" required>
                </div>
                <div class="mb-1">
                    <label for="lastName" class="form-label">Last Name</label>
                    <input type="text" class="form-control" id="lastName" name="lastName" value="<%= request.getParameter("lastName")%>" required>
                </div>
                <div class="mb-1">
                    <label for="address" class="form-label">Address</label>
                    <input type="text" class="form-control" id="address" name="address" value="<%= request.getParameter("address")%>" required>
                </div>
                <div class="mb-1">
                    <label for="mobile" class="form-label">Mobile</label>
                    <input type="tel" class="form-control" id="mobile" name="mobile" value="<%= request.getParameter("mobile")%>" required>
                </div>
                <div class="mb-1">
                    <label for="email" class="form-label">Email</label>
                    <input type="email" class="form-control" id="email" name="email" value="<%= request.getParameter("email")%>" required>
                </div>
                <div class="mb-1">
                    <label for="nic" class="form-label">NIC</label>
                    <input type="text" class="form-control" id="nic" name="nic" value="<%= request.getParameter("nic")%>" required>
                </div>
                <div class="mb-1">
                    <label for="dob" class="form-label">Date of Birth</label>
                    <input type="date" class="form-control" id="dob" name="dob" value="<%= request.getParameter("dob")%>" required>
                </div>
                <button type="submit" class="btn btn-primary">Update Profile</button>
            </form>
            
        </div>

    </body>
</html>

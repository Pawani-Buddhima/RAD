<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Job Seeker Dashboard</title>
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
    <div class="container mt-5">
        <div class="row">
            <div class="col-md-6">
                <h2>Welcome, Job Seeker!</h2>
                <p>Your dashboard provides you with options to manage your profile and view job listings.</p>
            </div>
            <div class="col-md-6">
                <h3>Feedbacks</h3>
                <p><a href="/JobPortalApplication/feedback.jsp">Give your feedback</a></p>
                
            </div>
        </div>
        
        <div class="row mt-5">
            <div class="col-md-6">
                <h3>Profile</h3>
                <p><a href="/JobPortalApplication/profile.jsp">Edit your profile</a></p>
            </div>
        </div>
        
        <div class="row mt-5">
            <div class="col-md-6">
                <h3>Job Listings</h3>
                <p><a href="/JobPortalApplication/job_search.jsp">Search and apply for jobs</a></p>
            </div>
        </div>
    </div>
    
    <!-- Footer -->
    <div class="footer">
        &copy; 2023 Job Portal Application
    </div>
</body>
</html>

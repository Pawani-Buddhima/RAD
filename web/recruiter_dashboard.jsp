<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Recruiter Dashboard</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="styles.css" rel="stylesheet">
        <style>
            .image-container {
                max-width: 100%;
                width: 200px; 
                margin: 0 auto; 
                border-radius: 5px;
                overflow: hidden;
                box-shadow: 0px 0px 5px rgba(0, 0, 0, 0.1);
                margin-bottom: 20px;
            }

            .image-container img {
                width: 100%;
                height: auto;
            }
           
        </style>
    </head>
    <body>
        <div class="navbar">
            <a href="index.html">Home</a>
            <div>
                <a href="#" style="margin-right: 10px;">Contact Us</a>
                <a href="#" style="margin-right: 10px;">About Us</a>
            </div>
        </div>
        <div class="container">
            <div class="header">
                <h2>Welcome!</h2>
                <p>Your dashboard provides you with options to manage your job listings and view applications.</p>
            </div>

            <div class="content">
                <div class="section">
                    <h3>Job Listings</h3>
                    <div class="image-container">
                        <img src="/JobPortalApplication/images/job_posting.jpg" alt="Job Listings">
                    </div>
                    <p><a href="/JobPortalApplication/post_job.jsp">Post a new job listing</a></p>
                    <p><a href="/JobPortalApplication/LoadMyJobList">Manage your job listings</a></p>
                </div>

                <div class="section">
                    <h3>Applications</h3>
                    <div class="image-container">
                        <img src="/JobPortalApplication/images/icon.jpg" alt="Applications">
                    </div>
                    <p><a href="/JobPortalApplication/view_applications.jsp">View received applications</a></p>
                </div>
            </div>


            <div class="footer">
                &copy; 2023 Job Portal Application
            </div>
        </div>
    </body>
</html>


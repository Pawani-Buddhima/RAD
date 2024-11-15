<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Manage Jobs</title>
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
            <h2>Manage Jobs</h2>
            <!-- Display list of jobs here -->
            <table class="table">
                <thead>
                    <tr>
                        <th>Job ID</th>
                        <th>Title</th>
                        <th>Type</th>
                        <th>Requirements</th>
                        <th>Description</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <!-- Loop through job listings and display them -->
                    <c:forEach var="job" items="${jobListings}">
                        <tr>
                            <td>${job.id}</td>
                            <td>${job.title}</td>
                            <td>${job.type}</td>
                            <td>${job.requirements}</td>
                            <td>${job.description}</td>
                            <td>
                                <a href="${pageContext.request.contextPath}/edit-job?jobId=${job.id}" class="btn btn-primary">Edit</a>
                                <a href="${pageContext.request.contextPath}/delete-job?jobId=${job.id}" class="btn btn-danger">Delete</a>


                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>

<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="classes.Application" %>
<%@ page import="classes.JobListing" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Admin Dashboard</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <div class="container mt-5">
            <h2>Admin Dashboard</h2>
            
            <% 
        List<Application> applications = (List<Application>) request.getAttribute("applications");
        List<JobListing> jobListings = (List<JobListing>) request.getAttribute("jobListings");
        %>


            <h3>Applications</h3>
            <table class="table">
                <thead>
                    <tr>
                        <th>App ID</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Email</th>
                        <th>Mobile</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="application" items="${applications}">
                    <tr>
                        <td>${application.app_id}</td>
                        <td>${application.first_name}</td>
                        <td>${application.last_name}</td>
                        <td>${application.email}</td>
                        <td>${application.mobile}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

            <h3>Job Listings</h3>
            <table class="table">
                <thead>
                    <tr>
                        <th>Job ID</th>
                        <th>Title</th>
                        <th>Type</th>
                        <th>Requirement</th>
                        <th>Description</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="jobListing" items="${jobListings}">
                    <tr>
                        <td>${jobListing.id}</td>
                        <td>${jobListing.title}</td>
                        <td>${jobListing.type}</td>
                        <td>${jobListing.requirements}</td>
                        <td>${jobListing.description}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>


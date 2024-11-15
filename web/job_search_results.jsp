<%@page import="java.util.List"%>
<%@page import="classes.JobListing"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Job Search Results</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <div class="container mt-5">
            <h2>Job Search Results</h2>

            <%

                List<JobListing> jobListings = (List<JobListing>) request.getAttribute("jobListings");
            %>

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
                        <td><a href="apply_job.jsp" class="btn btn-primary">Apply</a></td>
                        
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>

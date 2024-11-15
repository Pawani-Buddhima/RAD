<%@ page import="classes.JobListing" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Job</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h2>Edit Job</h2>
        <form action="/JobPortalApplication/update-job" method="post">
            <% JobListing jobListing = (JobListing) request.getAttribute("jobListing"); %>
            <input type="hidden" name="jobId" value="<%= jobListing.getId() %>">
            <div class="mb-3">
                <label for="title" class="form-label">Title</label>
                <input type="text" class="form-control" id="title" name="title" value="<%= jobListing.getTitle() %>" required>
            </div>
            <div class="mb-3">
                <label for="type" class="form-label">Type</label>
                <select class="form-select" id="type" name="type" required>
                    <option value="full_time" <%= jobListing.getType().equals("full_time") ? "selected" : "" %>>Full Time</option>
                    <option value="part_time" <%= jobListing.getType().equals("part_time") ? "selected" : "" %>>Part Time</option>
                    <option value="contract" <%= jobListing.getType().equals("contract") ? "selected" : "" %>>Contract</option>
                </select>
            </div>
            <div class="mb-3">
                <label for="requirements" class="form-label">Requirements</label>
                <textarea class="form-control" id="requirements" name="requirements" rows="3" required><%= jobListing.getRequirements() %></textarea>
            </div>
            <div class="mb-3">
                <label for="description" class="form-label">Description</label>
                <textarea class="form-control" id="description" name="description" rows="5" required><%= jobListing.getDescription() %></textarea>
            </div>
            <button type="submit" class="btn btn-primary">Update Job</button>
        </form>
    </div>
</body>
</html>


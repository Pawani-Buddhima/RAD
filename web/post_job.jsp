<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Post Job Listing</title>
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
        <h2>Post Job Listing</h2>
        <form action="/JobPortalApplication/post-job" method="post">
            <div class="mb-3">
                <label for="title" class="form-label">Job Title</label>
                <input type="text" class="form-control" id="title" name="title" required>
            </div>
            <div class="mb-3">
                <label for="type" class="form-label">Job Type</label>
                <select class="form-select" id="type" name="type" required>
                    <option value="full_time">Full Time</option>
                    <option value="part_time">Part Time</option>
                    <option value="contract">Contract</option>
                </select>
            </div>
            <div class="mb-3">
                <label for="requirement" class="form-label">Job Requirements</label>
                <textarea class="form-control" id="requirement" name="requirement" rows="4" required></textarea>
            </div>
            <div class="mb-3">
                <label for="description" class="form-label">Job Description</label>
                <textarea class="form-control" id="description" name="description" rows="6" required></textarea>
            </div>
            <button type="submit" class="btn btn-primary">Post Job</button>
        </form>
    </div>
</body>
</html>

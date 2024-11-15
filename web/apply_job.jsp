<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Apply for Job</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <div class="container mt-5">
            <h2>Apply for Job</h2>

            <% if (request.getAttribute("applicationError") != null) {%>
            <div class="alert alert-danger">
                <%= request.getAttribute("applicationError")%>
            </div>
            <% }%>
            <form action="/JobPortalApplication/applyjob" method="post" enctype="multipart/form-data">
                <div class="mb-3">
                    <label for="firstName" class="form-label">First Name</label>
                    <input type="text" class="form-control" id="firstName" name="firstName" required>
                </div>
                <div class="mb-3">
                    <label for="lastName" class="form-label">Last Name</label>
                    <input type="text" class="form-control" id="lastName" name="lastName" required>
                </div>
                <div class="mb-3">
                    <label for="email" class="form-label">Email</label>
                    <input type="email" class="form-control" id="email" name="email" required>
                </div>
                <div class="mb-3">
                    <label for="mobile" class="form-label">Mobile</label>
                    <input type="tel" class="form-control" id="mobile" name="mobile" required>
                </div>
                <div class="mb-3">
                    <label for="resume" class="form-label">Resume</label>
                    <input type="file" class="form-control" id="resume" name="resume" required>
                </div>
                <a href="${pageContext.request.contextPath}/applyjob?AppId=${application.app_id}" class="btn btn-primary" type="submit">Submit Application</a>
            </form>
        </div>
    </body>
</html>


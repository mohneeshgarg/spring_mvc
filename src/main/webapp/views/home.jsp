<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
<a class="navbar-brand" href="/" class="ml-auto">Twitter</a>
<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
</button>
<div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav ml-auto">
    <core:if test="${flag==true}" >
        <li class="nav-item active">
            <a class="nav-link" href="/messages">Messages</a>
        </li>
        <li class="nav-item active">
            <a class="nav-link" href = "/tweet/new">New Tweet</a>
        </li>

            <li class="nav-item">
                <a class="nav-link" href="/user">Profile</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/logout">Logout</a>
            </li>
        </core:if>
        <core:if test="${flag==false}" >
            <li class="nav-item">
                <a class="nav-link" href="/login">Login</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/register">Signup</a>
            </li>
        </core:if>
    </ul>
</div>
</nav>
<div class="container">
<h1 class="text-center mt-4">
All Tweets
</h1>
    <core:forEach items="${tweets}" var="tweet">
        <div class="card text-white bg-primary mb-3 col-6 offset-3">
          <div class="card-header">Tweet</div>
          <div class="card-body">
            <h5 class="card-title">${tweet.get('ownerName')}</h5>
            <p class="card-text">${tweet.get('body')}</p>
          </div>
        </div>
    </core:forEach>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>
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
    </ul>
</div>
</nav>
<div class="container">
<div class="float-right mt-4">
<a href="/user/${id}/messages/new"><button class="btn btn-primary">New Message</button></a>
</div>
<br>
<div class="mt-auto">
<h2 class="text-center">Sent Messages</h2>
<core:if test="${sent.size() > 0}">
<core:forEach items="${sent}" var="message">
        <div class="card text-white bg-success mb-3 offset-3 col-6">
          <div class="card-header">Sent Message</div>
          <div class="card-body">
            <h5 class="card-title">${message.get('receiverName')}</h5>
            <p class="card-text">${message.get('body')}</p>
          </div>
        </div>
</core:forEach>
</core:if>
<core:if test="${sent.size()==0}">
<button class="btn btn-danger mb-4 col-6 offset-3"> You have not sent many message yet </button>
</core:if>
<h2 class="text-center">Received Messages</h2>
<core:if test="${received.size() > 0}">
<core:forEach items="${received}" var="message">
        <div class="card text-white bg-primary mb-3 offset-3 col-6">
          <div class="card-header">Received Message</div>
          <div class="card-body">
            <h5 class="card-title">${message.get('senderName')}</h5>
            <p class="card-text">${message.get('body')}</p>
          </div>
        </div>
</core:forEach>
</core:if>
<core:if test="${received.size()==0}">
<button class="btn btn-danger mb-4 col-6 offset-3"> You have not received many message yet </button>
</core:if>
</div>
</div>
</body>
</html>
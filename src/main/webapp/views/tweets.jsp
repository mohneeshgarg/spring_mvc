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
<div class="container">
<h2 class="text-center my-4"> Hey Admin, You can view and delete all the tweets! </h2>
    <core:forEach items="${tweets}" var="tweet">
        <div class="card text-white bg-primary mb-3 col-6 offset-3">
          <div class="card-header">Tweet</div>
          <div class="card-body">
            <h5 class="card-title">${tweet.get('ownerName')}</h5>
            <p class="card-text">${tweet.get('body')}</p>
          </div>
           <div class="card-footer">
             <form action="/admin/tweet/delete/${tweet.get('tweetId')}">
              <button class="btn btn-danger"> Delete </button>
              </form>
            </div>
        </div>
    </core:forEach>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<title>Admin Page</title>
</head>
<body>
<div class="container">
    <div class="mt-5 col-6 offset-3">
    <h1 > Welcome to admin Page </h1>
        <div class="offset-2">
            <a href="/admin/tweets"> <button class="btn btn-primary btn-lg"> Tweets </button></a>
            <a href="/admin/users"> <button class="btn btn-danger btn-lg d-inline"> Users </button></a>
        </div>
    </div>
</div>
</body>
</html>
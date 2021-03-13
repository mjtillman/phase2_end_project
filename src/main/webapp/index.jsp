<%--
  Created by IntelliJ IDEA.
  User: mjtillman
  Date: 3/11/21
  Time: 11:44
To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  String message = "";
  if (request.getAttribute("message") != null) {
    message = request.getAttribute("message").toString();
  }
%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Super Secret Website - Please Log In</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
</head>
<body class="bg-dark">
<nav class="navbar navbar-dark container-fluid" style="background-color: #000000;" >
  <a href="index.jsp" class="navbar-brand">Super Secret Website</a>
  <form action="/register" method="get">
    <button class="btn btn-secondary btn-sm" type="submit">Register</button>
  </form>
</nav>
<main>
  <div class="card text-center mx-auto mt-3" style="width: 18rem;
    background-color: #e9ecef;">
    <img src="./images/locks.jpeg" class="card-img-top" alt="locks">
    <div class="card-body">
      <h5 class="card-title">Login</h5>
      <div class="card-text mb-1">
        <% out.println(message); %>
      </div>
      <form action="/login" method="post">
        <div class="form-floating mb-1">
          <input placeholder="Username" type="text" name="username" class="form-control form-control-sm" id="username" required />
          <label for="username" >
            Username</label>
        </div>
        <div class="form-floating mb-3">
          <input placeholder="Password" type="password" name="password" class="form-control" id="password" required />
          <label for="password">Password</label>
        </div>
    </div>
    <div class="card-footer">
      <button type="submit" class="btn btn-secondary btn-sm">Login</button>
      </form>
    </div>
  </div>
</main>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>
</body>
</html>

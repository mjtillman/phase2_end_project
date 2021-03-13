<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  String username = "";
  if (request.getAttribute("login_username") != null) {
    username = request.getAttribute("login_username").toString();
  }
%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Super Secret Website - Login Success</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
</head>
<body class="bg-dark">
<nav class="navbar navbar-dark container-fluid" style="background-color: #000000;" >
  <a href="index.jsp" class="navbar-brand">Super Secret Website</a>
  <form action="/" method="get">
    <button class="btn btn-secondary btn-sm" type="submit">Logout</button>
  </form>
</nav>
<main>
  <div class="card text-center mx-auto mt-3" style="width: 18rem;
    background-color: #e9ecef;">
    <img src="./images/locks.jpeg" class="card-img-top" alt="locks">
    <div class="card-body">
      <h5 class="card-title">
        <% out.println("Welcome, " + username + "!"); %></h5>
      <p class="card-text">
        You have successfully logged in!
      </p>
    </div>
    <div class="card-footer">
      <form action="/" method="post">
        <button type="submit" class="btn btn-secondary btn-sm">Logout</button>
      </form>
    </div>
  </div>
</main>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>
</body>
</html>


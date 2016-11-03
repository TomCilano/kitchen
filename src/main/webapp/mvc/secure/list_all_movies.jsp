<%--
  Created by IntelliJ IDEA.
  User: jasonskipper
  Date: 11/1/16
  Time: 12:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%
    response.setHeader("Cache-Control", "no-store, must-revalidate");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <!-- Latest compiled and minified CSS -->
    <script
            src="https://code.jquery.com/jquery-3.1.1.min.js"
            integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
            crossorigin="anonymous"></script>
    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
          integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
            crossorigin="anonymous"></script>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
          integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
            crossorigin="anonymous"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

</head>

<body>

<div class="container">
<div class="header clearfix">
    <nav>
        <ul class="nav nav-pills pull-right">
            <li role="presentation"><a href="/mvc/secure/movie/favs">Home</a></li>
            <li role="presentation" class="active"><a href=""/mvc/secure/movie/list?page=<c:out value="${thisPage}"/>"">Movies</a></li>
            <li role="presentation"><a href="/mvc/secure/admin/users">Users</a></li>
            <li role="presentation"><a href="/mvc/open/logout">Logout</a></li>
        </ul>
    </nav>
    <h3 class="text-muted">All Movies</h3>
</div>


<div class="row marketing">
<div class="col-lg-6">
<h4>Here's your list of Every Single Movie on planet Earth</h4>

<p/>

<table class="table">
<thead>
<tr>
    <th>Action</th>
    <th>Title</th>
    <th>Description</th>
    <th>Rating</th>
    <th>Length (mins)</th>
    <th>Poster</th>
</tr>
</thead>
<tbody>
    <div class="container">
        <h2>Button Sizes</h2>
        <a href="/mvc/secure/movie/list?page=<c:out value="${thisPage - 1}"/>" class="btn btn-info" role="button">Link Button</a>
        <a href="/mvc/secure/movie/list?page=<c:out value="${thisPage + 1}"/>" class="btn btn-info" role="button">Link Button</a>

    </div>
<c:forEach items="${all_movies}" var="aMovie">
    <tr>
        <td><a href="/mvc/secure/user/favs/add?id=<c:out value="${aMovie.id}"/>">Add Fav</a></td>
        <td><c:out value="${aMovie.title}"/></td>
        <td><c:out value="${aMovie.description}"/></td>
        <td><c:out value="${aMovie.rating}"/></td>
        <td><c:out value="${aMovie.minutes}"/></td>
        <td><img width="85" src="<c:out value="${aMovie.remoteUrl}"/>"/></td>
    </tr>
</c:forEach>
    </div>
    </tbody>
    </table>
    </div>
</div>
<footer class="footer">
    <p>&copy; 2016 Company, Inc.</p>
</footer>
</body>
    </html>


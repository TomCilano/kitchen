<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Login Here</title>
</head>
<body>
<div>
    <c:out value="${message}"/>
</div>
<form action="/mvc/open/login" method="post">
    <div>
        User: <input type="text" name="username"/>
    </div>
    <div>
        Password: <input type="password" name="password"/>
    </div>
    <input type="submit" name="Login">
</form>
</body>
</html>


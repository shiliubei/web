<%@ page import="java.util.ArrayList" %>
<%@ page import="models.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <a href="/admin/UsersList">Users list</a>
    <div>
        Add user
    </div>
    <form method="post" action="/admin/Add">
        <input type="text" name="name"> <br>
        <input type="text" name="password"><br>
        <input type="text" name="role"><br>
        <input type="submit" value="Add user">
    </form>
</div>
</body>
</html>
<%@ page import="java.util.ArrayList" %>
<%@ page import="models.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div >
    <a href="/admin/UsersList">Users list</a>
    <div>
        Add user
    </div>
    <form method="post" action="/admin/edit">
        <input type="hidden" name="id"  value="<c:out value='${user.id}' />" /> <br>
        <input type="text" name="name"  value="<c:out value='${user.name}' />" /> <br>
        <input type="text" name="password" value="<c:out value='${user.password}'  />" /> <br>
        <input type="text" name="role" value="<c:out value='${user.role}'  />" /> <br>
        <input type="submit" value="Edit user">
    </form>
</div>
</body>
</html>
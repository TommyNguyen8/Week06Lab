<%-- 
    Document   : register
    Created on : Oct 14, 2020, 4:04:10 PM
    Author     : 791662
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <form method="Post" action="ShoppingList">
            Username:
            <input type="text" name="username" value="${username}">
            <input type="hidden" name="action" value="register">
            <input type="submit" value="Register name">
        </form>
            ${message}
    </body>
</html>

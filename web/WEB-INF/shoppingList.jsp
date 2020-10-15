<%-- 
    Document   : shoppingList
    Created on : Oct 14, 2020, 4:04:43 PM
    Author     : 791662
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        Hello, ${username} <br><br>
        <a href="ShoppingList?action=logout">Logout</a>
        <h2>List</h2>
        
        <form method="post" action="ShoppingList">
            Add item:
            <input type="text" name="item" value="${item}">
            <input type="submit" value="Add">
            <input type="hidden" name="action" value="add">
        </form>
 
        <form method="post" action="ShoppingList"> 
            <ul>
                <c:forEach var="shopLists" items="${shopList}">
                    <li><input type="radio" name="itemList" value="${shopLists}">${shopLists}</li>
                </c:forEach>
            </ul>
            <input type="submit" value="Delete">
            <input type="hidden" name="action" value="delete">
        </form>
    </body>
</html>

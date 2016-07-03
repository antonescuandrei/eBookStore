<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="page" value="${pageContext.request.servletPath}" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" href="favicon.ico">
        <link rel="stylesheet" type="text/css" href="styles/style.css">
        <title>eBookStore</title>
    </head>
    <body>
        <div id="topBar">
            <c:choose>
                <c:when test="${fn:endsWith(page, 'index.jsp')}">
                    <a class="active">eBookStore</a>
                </c:when>
                <c:otherwise>
                    <a href="index.jsp" title="Return to index">eBookStore</a>
                </c:otherwise>
            </c:choose>
        </div>
        <ul id="topMenu">
            <li>
                <c:choose>
                    <c:when test="${fn:endsWith(page, 'index.jsp')}">
                        <a class="active">Home</a>
                    </c:when>
                    <c:otherwise>
                        <a href="index.jsp" title="Return to index">Home</a>
                    </c:otherwise>
                </c:choose>
            </li>
            <li>
                <c:choose>
                    <c:when test="${fn:endsWith(page, 'allBooksSuccess.jsp')}">
                        <a class="active">All books</a>
                    </c:when>
                    <c:otherwise>
                        <a href="allBooks.jsp" title="View all books">All books</a>
                    </c:otherwise>
                </c:choose>
            </li>
            <li>
                <c:choose>
                    <c:when test="${fn:endsWith(page, 'findBooks.jsp')}">
                        <a class="active">Find books</a>
                    </c:when>
                    <c:otherwise>
                        <a href="findBooks.jsp" title="Search for books">Find books</a>
                    </c:otherwise>
                </c:choose>
            </li>
            <li>
                <c:choose>
                    <c:when test="${fn:endsWith(page, 'addBook.jsp')}">
                        <a class="active">Add book</a>
                    </c:when>
                    <c:otherwise>
                        <a href="addBook.jsp" title="Add a new book">Add book</a>
                    </c:otherwise>
                </c:choose>
            </li>
        </ul>
        <div id ="content">
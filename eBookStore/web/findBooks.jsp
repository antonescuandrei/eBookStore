<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="/header.jsp" />

<h1>Find books</h1>
<p>Write a book title in the field below to search for it.</p>

<c:if test="${error}">
    <p class="error">Error! Please check your input and try again.</p>
</c:if>

<form method="post" action="bookFind.jsp">
    <ul id="form">
        <li>
            <label for="title">Title:</label>
            <input type="text" name="title" id="title" value="${title}" />
        </li>
        <li>
            <input type="submit" value="Find" />
        </li>
    </ul>
</form>

<jsp:include page="/footer.jsp" />
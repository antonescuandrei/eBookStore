<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="/header.jsp" />

<c:remove var="resubmit" scope="session" />

<h1>Edit book</h1>
<p>Change book details using the form below.</p>

<c:if test="${error}">
    <p class="error">Error! Please check your input and try again.</p>
</c:if>

<form method="post" action="mergeBook.jsp">
    <ul id="form">
        <li>
            <label for="title">Title:</label>
            <input type="text" name="title" id="title" value="${title}" />
        </li>
        <li>
            <label for="isbn">ISBN:</label>
            <input type="text" name="isbn" id="isbn" value="${isbn}" />
        </li>
        <li>
            <label for="author">Author:</label>
            <input type="text" name="author" id="author" value="${author}" />
        </li>
        <li>
            <label for="price">Price:</label>
            <input type="text" name="price" id="price" value="${price}" />
        </li>
        <li>
            <input type="submit" value="Save" />
        </li>
    </ul>
    <input type="hidden" name="bookId" value="${bookId}" />
    <input type="hidden" name="version" value="${version}" />
</form>

<jsp:include page="/footer.jsp" />
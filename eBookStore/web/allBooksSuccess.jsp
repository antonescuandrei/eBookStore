<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<jsp:include page="/header.jsp" />

<h1>All books</h1>
<c:choose>
    <c:when test="${empty allBooks}">
        <p>There are no books available.</p>
    </c:when>
    <c:otherwise>
        <p>Here are all the available books.</p>
        <form method="post" action="removeBook.jsp">
            <table id="books">
                <tr>
                    <th>Title</th>
                    <th>ISBN</th>
                    <th>Author</th>
                    <th>Price</th>
                    <th>Action</th>
                </tr>
                <c:forEach items="${allBooks}" var="ebook">
                    <tr>
                        <td>${ebook.title}</td>
                        <td>${ebook.isbn}</td>
                        <td>${ebook.author}</td>
                        <td>
                            <fmt:setLocale value="ro_RO" />
                            <fmt:formatNumber type="currency" value="${ebook.price}" />
                        </td>
                        <td><input type="submit" class="remove" name="remove" value="${ebook.id}" title="Remove this book" /></td>
                    </tr>
                </c:forEach>
            </table>
        </form>
    </c:otherwise>
</c:choose>

<jsp:include page="/footer.jsp" />
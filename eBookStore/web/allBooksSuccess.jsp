<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<jsp:include page="/header.jsp" />

<h1>All books</h1>
<p>Here are all the available books.</p>

<table id="books">
    <tr>
        <th>Title</th>
        <th>ISBN</th>
        <th>Author</th>
        <th>Price</th>
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
        </tr>
    </c:forEach>
</table>

<jsp:include page="/footer.jsp" />
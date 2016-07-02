<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<jsp:include page="/header.jsp" />

<h1>Found books</h1>
<c:choose>
    <c:when test="${empty foundBooks}">
        <p>There are no books that have a title like '${title}'.</p>
    </c:when>
    <c:otherwise>
        <p>Here are all the books that have a title like '${title}'.</p>

        <table id="books">
            <tr>
                <th>Title</th>
                <th>ISBN</th>
                <th>Author</th>
                <th>Price</th>
            </tr>
            <c:forEach items="${foundBooks}" var="ebook">
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
    </c:otherwise>
</c:choose>

<jsp:include page="/footer.jsp" />
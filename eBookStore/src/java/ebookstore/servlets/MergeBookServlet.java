package ebookstore.servlets;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import ebookstore.domain.Ebook;
import ebookstore.services.BookManagementService;

public class MergeBookServlet extends HttpServlet {
    @Inject
    BookManagementService manager;
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title").trim();
        String isbn = request.getParameter("isbn").trim();
        String author = request.getParameter("author").trim();
        double price = NumberUtils.toDouble(request.getParameter("price").trim(), 0d);
        int bookId = NumberUtils.toInt(request.getParameter("bookId"), 0);
        int version = NumberUtils.toInt(request.getParameter("version"), 0);
        
        HttpSession session = request.getSession();
        
        if ((session.getAttribute("resubmit") == null) && (bookId > 0) && (version >= 0)) {
            RequestDispatcher dispatch;

            if (StringUtils.isBlank(title) || StringUtils.isBlank(isbn) || StringUtils.isBlank(author) || (price <= 0d)) {
                request.setAttribute("title", title);
                request.setAttribute("isbn", isbn);
                request.setAttribute("author", author);
                request.setAttribute("price", price);
                request.setAttribute("bookId", bookId);
                request.setAttribute("version", version);
                request.setAttribute("error", true);

                dispatch = getServletContext().getRequestDispatcher("/editBookForm.jsp");
            } else {
                request.setAttribute("title", title);
                
                session.setAttribute("resubmit", true);
                
                Ebook ebook = manager.getBook(bookId);
                
                if ((ebook != null) && (version == ebook.getVersion())) {
                    ebook.setTitle(title);
                    ebook.setIsbn(isbn);
                    ebook.setAuthor(author);
                    ebook.setPrice(price);
                    
                    if (manager.mergeBook(ebook))
                        dispatch = getServletContext().getRequestDispatcher("/editBookSuccess.jsp");
                    else
                        dispatch = getServletContext().getRequestDispatcher("/editBookFailure.jsp");
                } else
                    dispatch = getServletContext().getRequestDispatcher("/editBookFailure.jsp");
            }

            dispatch.forward(request, response);
        } else
            response.sendRedirect(request.getContextPath() + "/allBooks.jsp");
    }
}
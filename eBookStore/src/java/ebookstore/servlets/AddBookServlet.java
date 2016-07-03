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

public class AddBookServlet extends HttpServlet {
    @Inject
    BookManagementService manager;
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title").trim();
        String isbn = request.getParameter("isbn").trim();
        String author = request.getParameter("author").trim();
        double price = NumberUtils.toDouble(request.getParameter("price").trim(), 0d);
        
        HttpSession session = request.getSession();
        
        if (session.getAttribute("resubmit") == null) {
            RequestDispatcher dispatch;

            if (StringUtils.isBlank(title) || StringUtils.isBlank(isbn) || StringUtils.isBlank(author) || (price <= 0d)) {
                request.setAttribute("title", title);
                request.setAttribute("isbn", isbn);
                request.setAttribute("author", author);
                request.setAttribute("price", price);
                request.setAttribute("error", true);

                dispatch = getServletContext().getRequestDispatcher("/addBook.jsp");
            } else {
                Ebook ebook = new Ebook(title, isbn, author, price);

                manager.addBook(ebook);

                request.setAttribute("title", title);
                
                session.setAttribute("resubmit", true);
                
                dispatch = getServletContext().getRequestDispatcher("/addBookSuccess.jsp");
            }

            dispatch.forward(request, response);
        } else
            response.sendRedirect(request.getContextPath() + "/addBook.jsp");
    }
}
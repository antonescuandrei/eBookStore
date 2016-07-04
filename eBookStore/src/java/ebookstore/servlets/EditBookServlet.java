package ebookstore.servlets;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;

import org.apache.commons.lang3.math.NumberUtils;

import ebookstore.domain.Ebook;
import ebookstore.services.BookManagementService;

public class EditBookServlet extends HttpServlet {
    @Inject
    BookManagementService manager;
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int bookId = NumberUtils.toInt(request.getParameter("edit"), 0);
        
        if (bookId > 0) {
            Ebook ebook = manager.getBook(bookId);
            
            if (ebook != null) {
                request.setAttribute("title", ebook.getTitle());
                request.setAttribute("isbn", ebook.getIsbn());
                request.setAttribute("author", ebook.getAuthor());
                request.setAttribute("price", ebook.getPrice());
                request.setAttribute("bookId", ebook.getId());
                request.setAttribute("version", ebook.getVersion());
                
                RequestDispatcher dispatch = getServletContext().getRequestDispatcher("/editBookForm.jsp");
                
                dispatch.forward(request, response);
                
                return;
            }
        }
        
        response.sendRedirect(request.getContextPath() + "/allBooks.jsp");
    }
}
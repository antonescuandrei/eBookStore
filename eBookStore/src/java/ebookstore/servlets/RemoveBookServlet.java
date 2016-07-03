package ebookstore.servlets;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;

import org.apache.commons.lang3.math.NumberUtils;

import ebookstore.services.BookManagementService;

public class RemoveBookServlet extends HttpServlet {
    @Inject
    BookManagementService manager;
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int bookId = NumberUtils.toInt(request.getParameter("remove"), 0);
        
        if (bookId > 0)
            manager.removeBook(bookId);
            
        response.sendRedirect(request.getContextPath() + "/allBooks.jsp");
    }
}
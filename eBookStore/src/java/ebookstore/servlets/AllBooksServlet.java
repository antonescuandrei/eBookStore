package ebookstore.servlets;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;

import ebookstore.domain.Ebook;
import ebookstore.services.BookManagementService;

public class AllBooksServlet extends HttpServlet {
    @Inject
    BookManagementService manager;
    
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Ebook> allBooks = manager.getAllBooks();
        
        request.setAttribute("allBooks", allBooks);
        
        RequestDispatcher dispatch = getServletContext().getRequestDispatcher("/getAllBooks.jsp");
        dispatch.forward(request, response);
    }
}
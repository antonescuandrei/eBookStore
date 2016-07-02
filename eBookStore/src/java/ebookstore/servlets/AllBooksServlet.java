package ebookstore.servlets;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;

import ebookstore.services.BookManagementService;

public class AllBooksServlet extends HttpServlet {
    @Inject
    BookManagementService manager;
    
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("allBooks", manager.getAllBooks());
        
        RequestDispatcher dispatch = getServletContext().getRequestDispatcher("/allBooksSuccess.jsp");
        dispatch.forward(request, response);
    }
}
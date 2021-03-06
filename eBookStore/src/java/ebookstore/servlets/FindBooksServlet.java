package ebookstore.servlets;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;

import org.apache.commons.lang3.StringUtils;

import ebookstore.services.BookManagementService;

public class FindBooksServlet extends HttpServlet {
    @Inject
    BookManagementService manager;
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title").trim();
        
        RequestDispatcher dispatch;
            
        request.setAttribute("title", title);

        if (StringUtils.isBlank(title)) {
            request.setAttribute("error", true);

            dispatch = getServletContext().getRequestDispatcher("/findBooks.jsp");
        } else {
            request.setAttribute("foundBooks", manager.findBooksByTitle(title));
                
            dispatch = getServletContext().getRequestDispatcher("/findBooksSuccess.jsp");
        }

        dispatch.forward(request, response);
    }
}
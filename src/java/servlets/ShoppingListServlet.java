package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 791662
 */
public class ShoppingListServlet extends HttpServlet 
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        
        if(session.getAttribute("username") == null)
        {
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp")
                    .forward(request, response);
            return;
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp")
                .forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        
        String action = request.getParameter("action");
        String username = request.getParameter("username");
        
        if(action.equals("logout"))
        {
            session.invalidate();
            session = request.getSession();
            request.setAttribute("message", "You have successfully logged out");
        }
        
        if(action.equals("register"))
        {
            session.setAttribute("username", username);
            response.sendRedirect("ShoppingList");
            return;
        }
    }
}

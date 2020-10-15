package servlets;

import java.io.IOException;
import java.util.ArrayList;
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
        
        String action = request.getParameter("action");
        
        if(action != null)
        {
            session.invalidate();
            session = request.getSession();
            request.setAttribute("message", "You have successfully logged out");
            
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
        
        ArrayList<String> shopList = new ArrayList<>();
        
        String action = request.getParameter("action");
        String username = request.getParameter("username");
        
        if(action.equals("register"))
        {
            session.setAttribute("username", username);
            response.sendRedirect("ShoppingList");
            return;
        }
        
        if(action.equals("add"))
        {
            shopList = (ArrayList<String>) session.getAttribute("shopList");
            
            if(shopList == null)
            {
                shopList = new ArrayList<>();
            }
            
            String item = request.getParameter("item");
            
            shopList.add(item);
            
            request.setAttribute("item", item);
       
            session.setAttribute("shopList", shopList);
            
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp")
                    .forward(request, response);
            
            return;
        }
        
        if(action.equals("delete"))
        {
            shopList = (ArrayList<String>) session.getAttribute("shopList");
            
            if(shopList == null)
            {
                shopList = new ArrayList<>();
            }
            
            String removeItem = request.getParameter("itemList");
            
            shopList.remove(removeItem);
            
            session.setAttribute("shopList", shopList);
            
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp")
                    .forward(request, response);
        }
    }
}

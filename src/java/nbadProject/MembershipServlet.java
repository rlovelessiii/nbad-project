/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nbadProject;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author bobbysmedley
 */
@WebServlet(name = "MembershipServlet", urlPatterns = {"/MembershipServlet"})
public class MembershipServlet extends HttpServlet {
    
    ArrayList<User> users = new ArrayList();
    
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String url = "";
        HttpSession session = request.getSession();
        String action = request.getParameter("action");

        if(action.equals("login")){
            url = "/login.jsp";
        }
        else if (action.equals("logout")) {
            url = "/index.jsp";
            session.removeAttribute("loggedIn");
        }
        else if(action.equals("signup")){
            url = "/signup.jsp";
        }
        
        getServletContext().getRequestDispatcher(url).forward(request, response);
                
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        String action = request.getParameter("action");

        if(action.equals("login")){
            for (User user: users) {
                if (user.getPassword().equals(request.getParameter("password"))) {
                    session.setAttribute("user", user);
                    getServletContext().getRequestDispatcher("/products.jsp").forward(request, response);
                }
            }
            response.sendRedirect("/nbadProject/membership?action=login");
        }
        else if(action.equals("signup")){
            
            String firstName = request.getParameter("firstname");
            String lastName = request.getParameter("lastname");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            
            if (firstName.equals("") || lastName.equals("") || email.equals("") || password.equals("") || !email.contains("@") || password.length() < 8) {
                getServletContext().getRequestDispatcher("/signup.jsp").forward(request, response);
            }
            
            User user = new User();
            user.setFirstName(request.getParameter("firstname"));
            user.setLastName(request.getParameter("lastname"));
            user.setEmail(request.getParameter("email"));
            user.setPassword(request.getParameter("password"));
            users.add(user);
            session.setAttribute("users", users);
            getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
        }
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

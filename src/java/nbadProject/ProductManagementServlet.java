/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nbadProject;

import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author bobbysmedley
 */
public class ProductManagementServlet extends HttpServlet {
    
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
        String productCode = "";
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        
        User user = (User) session.getAttribute("user");
        
        if (user != null) {
            
            switch (action) {
                case "displayProducts":
                    List<Product> products = ProductTable.selectProducts();
                    session.removeAttribute("code");
                    session.removeAttribute("description");
                    session.removeAttribute("price");
                    url = "/products.jsp";
                    break;
                case "displayProduct":
                    productCode = request.getParameter("code");
                    if (ProductTable.exists(productCode)) {
                        Product product = ProductTable.selectProduct(productCode);
                        session.setAttribute("code", product.getCode());
                        session.setAttribute("description", product.getDescription());
                        session.setAttribute("price", product.getPrice());
                        break;
                    } // fall through
                case "addProduct":
                    url = "/product.jsp";
                    break;
                case "deleteProduct":
                    productCode = request.getParameter("code");
                    if (ProductTable.exists(productCode)) {
                        Product product = ProductTable.selectProduct(productCode);
                        session.setAttribute("code", product.getCode());
                        session.setAttribute("description", product.getDescription());
                        session.setAttribute("price", product.getPrice());
                        break;
                    }
                    url = "/confirmDelete.jsp";
                    break;
            }
            getServletContext().getRequestDispatcher(url).forward(request, response);
        }
        else {
            getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
        }
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
        User user = (User) session.getAttribute("user");
        String action = request.getParameter("action");
        String productCode = request.getParameter("productCode");
        
        if (user != null) {
            
            switch (action) {
                case "addProduct":
                    
                    String code = request.getParameter("code");
                    String description = request.getParameter("description");
                    String price = request.getParameter("price");
                    
                    // new product
                    if (productCode.isEmpty()) {
                        Product product = new Product();
                        product.setCode(code);
                        product.setDescription(description);
                        product.setPrice(Double.valueOf(price));
                        ProductTable.insertProduct(product);
                    }
                    else { // update product
                        if (ProductTable.exists(productCode)) {
                            Product product = ProductTable.selectProduct(productCode);
                            product.setCode(code);
                            product.setDescription(description);
                            product.setPrice(Double.valueOf(price));
                        }
                    }
                    getServletContext().getRequestDispatcher("/products.jsp").forward(request, response);
                    break;
                case "deleteProduct":
                    if (ProductTable.exists(productCode)) {
                        Product product = ProductTable.selectProduct(productCode);
                        ProductTable.deleteProduct(product);
                    }
                    getServletContext().getRequestDispatcher("/products.jsp").forward(request, response);
                    break;
            }
            
        }
        else {
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

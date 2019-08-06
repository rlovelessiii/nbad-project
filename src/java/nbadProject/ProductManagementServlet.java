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
                    request.setAttribute("products", products);
                    url = "/products.jsp";
                    break;
                case "displayProduct":
                    productCode = request.getParameter("productCode");
                    if (ProductTable.exists(productCode)) {
                        Product product = ProductTable.selectProduct(productCode);
                        request.setAttribute("code", product.getCode());
                        request.setAttribute("description", product.getDescription());
                        request.setAttribute("price", product.getPrice());
                    } // fall through
                case "addProduct":
                    url = "/product.jsp";
                    break;
                case "deleteProduct":
                    productCode = request.getParameter("productCode");
                    if (ProductTable.exists(productCode)) {
                        Product product = ProductTable.selectProduct(productCode);
                        request.setAttribute("code", product.getCode());
                        request.setAttribute("description", product.getDescription());
                        request.setAttribute("price", product.getPrice());
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
        String url = "/login.jsp";
        
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
                            ProductTable.updateProduct(product);
                        }
                    }
                    url = "/products.jsp";
                    break;
                case "deleteProduct":
                    if (ProductTable.exists(productCode)) {
                        Product product = ProductTable.selectProduct(productCode);
                        ProductTable.deleteProduct(product);
                    }
                    url = "/products.jsp";
                    break;
            }
            
        }
        List<Product> products = ProductTable.selectProducts();
        request.setAttribute("products", products);
        getServletContext().getRequestDispatcher(url).forward(request, response);
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

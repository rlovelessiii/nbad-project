package nbadProject;

import java.sql.*;
import java.util.*;

public class ProductTable {
    
    static String url = "jdbc:mysql://localhost:3306/store";
    static String username = "projectuser";
    static String password = "p@$$w0rd";

    static Connection con = null;
    static PreparedStatement ps = null;
    static ResultSet rs = null;
    
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }

    }

    public static List<Product> selectProducts() {
        
        List<Product> list = new LinkedList();
        String query = "SELECT * FROM products";
        
        try {
            con = DriverManager.getConnection(url, username, password);
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                String code = rs.getString("code");
                String desc = rs.getString("description");
                Double price = rs.getDouble("price");
                Product product = new Product(code, desc, price);
                list.add(product);
            }
        }
        catch (SQLException e) {
            System.out.println(e);
        }
        return list;
        
    }

    public static Product selectProduct(String productCode) {
        
        Product product = null;
        String query = "SELECT * FROM products WHERE code = ?";
        
        try {
            con = DriverManager.getConnection(url, username, password);
            ps = con.prepareStatement(query);
            ps.setString(1, productCode);
            rs = ps.executeQuery();
            while (rs.next()) {
                String code = rs.getString("code");
                String desc = rs.getString("description");
                Double price = rs.getDouble("price");
                product = new Product(code, desc, price);
            }
        }
        catch (SQLException e) {
            System.out.println(e);
        }
        return product;
        
    }

    public static boolean exists(String productCode) {
        
        boolean exists = false;
        String query = "SELECT * FROM products WHERE code = ?";
        
        try {
            con = DriverManager.getConnection(url, username, password);
            ps = con.prepareStatement(query);
            ps.setString(1, productCode);
            rs = ps.executeQuery();
            while (rs.next()) {
                exists = true;
            }
        }
        catch (SQLException e) {
            System.out.println(e);
        }
        return exists;
        
    }    
    
    public static void saveProducts(List<Product> products) {
        
        for (Product product: products) {
            insertProduct(product);
        }
        
    }

    public static void insertProduct(Product product) {
        
        String query = "INSERT INTO products (code,description,price) VALUES (?,?,?)";
        
        try {
            con = DriverManager.getConnection(url, username, password);
            ps = con.prepareStatement(query);
            ps.setString(1, product.getCode());
            ps.setString(2, product.getDescription());
            ps.setDouble(3, product.getPrice());
            ps.executeQuery();
        }
        catch (SQLException e) {
            System.out.println(e);
        }
        
    }

    public static void updateProduct(Product product) {
        
        String query = "UPDATE products SET description = ?, price = ? WHERE code = ?";
        
        try {
            con = DriverManager.getConnection(url, username, password);
            ps = con.prepareStatement(query);
            ps.setString(1, product.getDescription());
            ps.setDouble(2, product.getPrice());
            ps.setString(3, product.getCode());
            ps.executeQuery();
        }
        catch (SQLException e) {
            System.out.println(e);
        }
        
    }

    public static void deleteProduct(Product product) {
        
        String query = "DELETE FROM products WHERE code = ?";
        
        try {
            con = DriverManager.getConnection(url, username, password);
            ps = con.prepareStatement(query);
            ps.setString(1, product.getCode());
            ps.executeQuery();
        }
        catch (SQLException e) {
            System.out.println(e);
        }
        
    }    
}

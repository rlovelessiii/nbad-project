package nbadProject;

import java.sql.*;
import java.io.*;
import java.util.*;

public class UserTable {
	
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
    
    public static void addRecord(User user) throws IOException {
        
        String query = "INSERT INTO users (firstName,lastName,email,password) VALUES (?,?,?,?)";
        
        try {
            con = DriverManager.getConnection(url, username, password);
            ps = con.prepareStatement(query);
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getPassword());
            ps.executeUpdate();
        }
        catch (SQLException e) {
            System.out.println(e);
        }
        
    }

    public static User getUser(String emailAddress) throws IOException {
        
        User user = null;
        String query = "SELECT * FROM users WHERE email = ?";
        
        try {
            con = DriverManager.getConnection(url, username, password);
            ps = con.prepareStatement(query);
            ps.setString(1, emailAddress);
            rs = ps.executeQuery();
            while (rs.next()) {
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                String email = rs.getString("email");
                String password = rs.getString("password");
                user = new User(firstName, lastName, email, password);
            }
        }
        catch (SQLException e) {
            System.out.println(e);
        }
        return user;
        
    }

    public static ArrayList<User> getUsers() throws IOException {
        
        ArrayList<User> users = new ArrayList();
        String query = "SELECT * FROM users";
        
        try {
            con = DriverManager.getConnection(url, username, password);
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                String email = rs.getString("email");
                String password = rs.getString("password");
                User user = new User(firstName, lastName, email, password);
                users.add(user);
            }
        }
        catch (SQLException e) {
            System.out.println(e);
        }
        return users;
        
    }

    public static HashMap<String, User> getUsersMap() throws IOException {
        
        HashMap<String, User> usersHash = new HashMap();
        String query = "SELECT * FROM users";
        
        try {
            con = DriverManager.getConnection(url, username, password);
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                String id = String.valueOf(rs.getInt("id"));
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                String email = rs.getString("email");
                String password = rs.getString("password");
                User user = new User(firstName, lastName, email, password);
                usersHash.put(id, user);
            }
        }
        catch (SQLException e) {
            System.out.println(e);
        }
        return usersHash;
        
    }
}

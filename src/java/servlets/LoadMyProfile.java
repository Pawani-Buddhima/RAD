/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import classes.DatabaseManager;
import classes.User;
import classes.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoadMyProfile extends HttpServlet {

   @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            Connection connection = DatabaseManager.getConnection();
            UserDAO userDAO = new UserDAO(connection);
        List<User> users = userDAO.getAllUsers();
        
            request.setAttribute("users", users);
            request.getRequestDispatcher("/job_seeker_dashboard.jsp").forward(request, response);
        }catch(Exception e){
            
        }
    }
}
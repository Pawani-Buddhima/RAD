
package servlets;

import classes.DatabaseManager;
import classes.JobListing;
import classes.JobListingDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoadMyJobList extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoadMyJobList</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoadMyJobList at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            Connection connection = DatabaseManager.getConnection();
            JobListingDAO jobListingDAO = new JobListingDAO(connection);
            List<JobListing> jobListings = jobListingDAO.getAllJobListings(); // Your method to retrieve job listings
        
            request.setAttribute("jobListings", jobListings);
            request.getRequestDispatcher("/manage_jobs.jsp").forward(request, response);
        }catch(Exception e){
            
        }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JobSeekerDashboardServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // You can implement job seeker-specific dashboard activities here
        // For example, redirect to job_seeker_dashboard.jsp or perform specific actions
        request.getRequestDispatcher("/JobPortalApplication/job_seeker_dashboard.jsp").forward(request, response);
    }
}
  
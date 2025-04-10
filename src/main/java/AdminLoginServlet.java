import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;

public class AdminLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Fixed admin credentials
        if ("admin".equals(username) && "admin123".equals(password)) {
            HttpSession session = request.getSession();
            session.setAttribute("adminLoggedIn", true);
            response.sendRedirect("admin-dashboard.jsp");
        } else {
            request.setAttribute("error", "Invalid admin credentials");
            RequestDispatcher rd = request.getRequestDispatcher("index.html");
            rd.forward(request, response);
        }
    }
}

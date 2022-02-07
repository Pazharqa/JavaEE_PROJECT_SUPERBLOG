package servlets;

import db.DBManager;
import model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AuthServlet", value = "/auth")
public class AuthServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userEmail = request.getParameter("userEmail");
        String userPassword = request.getParameter("userPassword");
        User user = DBManager.getUserByEmail(userEmail);

        String redirect = "/login.jsp?emailError";

        if (user != null) {
            redirect = "/login.jsp?passwordError";
            if (user.getPassword().equals(userPassword)) {
                request.getSession().setAttribute("CURRENT_USER", user);
                response.sendRedirect("/main");
            } else {
                request.getRequestDispatcher(redirect).forward(request, response);
            }
        } else {
            request.getRequestDispatcher(redirect).forward(request, response);
        }
    }
}

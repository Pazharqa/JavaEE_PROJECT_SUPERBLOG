package servlets;

import db.DBManager;
import model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "EditUserServlet", value = "/edit-user")
public class EditUserServlet extends HttpServlet {
    Long id;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        request.setAttribute("blogs", DBManager.getAllBlogs());
        User user = (User) request.getSession().getAttribute("CURRENT_USER");
        id = user.getId();
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String fullname = request.getParameter("fullname");

        user = new User(id, login, password, email, fullname);
        DBManager.editUser(user);
        response.sendRedirect("/profile.jsp");
    }
}

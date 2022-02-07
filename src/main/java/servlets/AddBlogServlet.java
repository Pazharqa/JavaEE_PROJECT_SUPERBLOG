package servlets;

import db.DBManager;
import model.Blog;
import model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AddBlogServlet", value = "/add-blog")
public class AddBlogServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String blogTitle = request.getParameter("title");
        String blogText = request.getParameter("text");
        HttpSession session = request.getSession();
        User currentUser = (User) session.getAttribute("CURRENT_USER");
        DBManager.addBlog(new Blog(null, blogTitle, blogText, currentUser.getId()));
        response.sendRedirect("/main");
    }
}

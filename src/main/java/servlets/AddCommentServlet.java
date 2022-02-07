package servlets;

import db.DBManager;
import model.Comment;
import model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AddCommentServlet", value = "/add-comment")
public class AddCommentServlet extends HttpServlet {
    Long id;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Long blog_id = Long.parseLong(request.getParameter("blogID"));
        System.out.println(blog_id);
        String commentText = request.getParameter("commentText");
        HttpSession session = request.getSession();
        User currentUser = (User) session.getAttribute("CURRENT_USER");
        System.out.println("author id "+ currentUser.getId());
        DBManager.addComment(new Comment(null, commentText, currentUser.getId(), blog_id));
        response.sendRedirect("/main");
    }
}

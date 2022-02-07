package servlets;

import com.google.gson.Gson;
import com.google.gson.JsonParser;
import db.DBManager;
import model.Comment;
import model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "CommentsServlet", value = "/comments")
public class CommentsServlet extends HttpServlet {
    Long blog_id;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long blogId = Long.parseLong(request.getParameter("blogId"));
        List<Comment> comments = DBManager.getCommentsByBlogID(blogId);
        System.out.println("here1");
        String commentsJSON = new Gson().toJson(comments);
        System.out.println(commentsJSON);
        PrintWriter out = response.getWriter();
        out.println(commentsJSON);

/*        Long blogId = Long.parseLong(request.getParameter("blogId"));
        blog_id = blogId;
        request.setAttribute("blogs", DBManager.getAllBlogs());
        request.setAttribute("comments", DBManager.getCommentsByBlogID(blogId));
        request.getRequestDispatcher("/index.jsp").forward(request, response);*/
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

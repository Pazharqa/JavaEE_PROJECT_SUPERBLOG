package servlets;

import db.DBManager;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "MainServlet", value = "/main")
public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DBManager.connectToDB();
        request.setAttribute("blogs", DBManager.getAllBlogs());
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String search = request.getParameter("keyWord");
        request.setAttribute("blogs", DBManager.getBlogsBySearchWord(search));
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}

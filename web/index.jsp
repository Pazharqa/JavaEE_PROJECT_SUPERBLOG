<!DOCTYPE HTML>
<%@ page import="model.Blog" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="db.DBManager" %>
<%@ page import="model.Comment" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 02.02.2022
  Time: 20:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="head.jsp"%>
<body>
<div class="container">
    <%@include file="nav.jsp"%>
    <%
    List<Blog> blogs = (ArrayList) request.getAttribute("blogs");
    Long id;
    %>
    <div class="row">
        <div class="col-sm-8">
            <% for (Blog b : blogs) { %>
            <div class="blog-item">
                <h3><%=b.getTitle()%></h3>
                <p><%=b.getText()%></p>
                <small>Author: <%=DBManager.authorNameByBlogID(b.getId())%></small>
                <%--<a id="getCommentsButton" href="javascript:void(0)" onclick="getAllCommentsByBlogId(<%=b.getId()%>)">Comments</a>--%>
                <a href="/comments?blogId=<%=b.getId()%>">Comments</a>
                <%
                    if (request.getAttribute("comments") != null) {
                        ArrayList<Comment> comments = (ArrayList<Comment>) request.getAttribute("comments");
                        for (Comment comment : comments) {
                            if (b.getId() == comment.getBlogID()) {%>
                <p><b>Cooment by: <%=DBManager.userNameByCommentID(comment.getId())%></b></p><p><%=comment.getComment()%></p>
                                <%          }
                                        }
                                    }
                                %>
              <%  if (currentUser != null) { %>
                <a class="btn btn-primary" href="#" data-bs-toggle="modal" data-bs-target="#addComment" >Add comment</a>
                <div class="modal fade" id="addComment">
                    <div class="modal-dialog modal-lg">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title">Add comment</h5>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                <form action="/add-comment?blogID=<%=b.getId()%>" method="post">
                                    <%System.out.println(b.getId());%>
                                    <div class="mb-3">
                                        <label for="commentText" class="form-label">Текст</label>
                                        <textarea name="commentText" id="" cols="30" rows="10" id="commentText"></textarea>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                        <button type="submit" class="btn btn-primary">Add comment</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                <% } %>
            </div>
            <%}%>
        </div>
        <div class="col-sm-4">
            <%
                             if (currentUser != null) {
            %>
            <a href="/profile.jsp"><h2>Welcome to BlogSpace, <%=currentUser.getLogin()%></h2></a>
            <%} else {%>
            <h2>Welcome to BlogSpace!</h2>
            <% } %>
        </div>
    </div>
</div>
<!-- Modal add Comment-->

</body>
</html>

<%@ page import="model.User" %>
<%@ page import="db.DBManager" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 02.02.2022
  Time: 20:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="head.jsp"%>
<header>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container-fluid">
            <form class="d-flex" action="/main" method="post" >
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success" type="submit">Search</button>
            </form>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">

                    <%
                        User currentUser = (User) session.getAttribute("CURRENT_USER");
                    if (currentUser != null) {
                    %>

                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="/main">All blogs</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" aria-current="page" href="#" data-bs-toggle="modal" data-bs-target="#addNewBlog">ADD BLOG</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/logout">Sign out</a>
                    </li>
                    <%} else {%>
                    <li class="nav-item">
                        <a class="nav-link" aria-current="page" href="/main">All blogs</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" href="/auth">Sign in</a>
                    </li>
                        <%}%>
                </ul>
            </div>
        </div>
    </nav>
</header>
<!-- Modal add new Blog -->
<div class="modal fade" id="addNewBlog">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">ADD BLOG</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form action="/add-blog" method="post">
                    <div class="mb-3">
                        <label for="title" class="form-label">Title</label>
                        <input type="text" class="form-control" id="title" name="title">
                    </div>
                    <div class="mb-3">
                        <label for="text" class="form-label">Text</label><br>
                        <textarea name="text" cols="90" rows="10" id="text"></textarea>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                        <button type="submit" class="btn btn-primary">Create Blog</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

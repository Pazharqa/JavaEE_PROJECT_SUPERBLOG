<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 02.02.2022
  Time: 20:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="head.jsp"%>
<body>
<div class="container">
    <%@include file="nav.jsp"%>
    <div class="row">
        <div class="col-lg-5 mt-5 m-auto">
            <form action="/auth" method="post">
                <h3>LOGIN</h3>
                <%
                    if (request.getParameter("emailError") != null) {
                %>
                <div class="alert alert-danger d-flex align-items-center" role="alert">
                    <svg class="bi flex-shrink-0 me-2" width="24" height="24" role="img" aria-label="Danger:"><use xlink:href="#exclamation-triangle-fill"/></svg>
                    <div>
                        Such Email does not exist!
                    </div>
                </div>
                <%
                    }
                %>

                <%
                    if (request.getParameter("passwordError") != null) {
                %>
                <div class="alert alert-danger d-flex align-items-center" role="alert">
                    <svg class="bi flex-shrink-0 me-2" width="24" height="24" role="img" aria-label="Danger:"><use xlink:href="#exclamation-triangle-fill"/></svg>
                    <div>
                        Password is wrong!
                    </div>
                </div>
                <%
                    }
                %>

                <%
                    if (request.getParameter("regSuccess") != null) {
                %>
                <div class="alert alert-success d-flex align-items-center" role="alert">
                    <svg class="bi flex-shrink-0 me-2" width="24" height="24" role="img" aria-label="Danger:"><use xlink:href="#exclamation-triangle-fill"/></svg>
                    <div>
                        Successfully registered!
                    </div>
                </div>
                <%
                    }
                %>
                <div class="mb-3">
                    <label for="userEmail" class="form-label">Email:</label>
                    <input type="text" class="form-control" name="userEmail" id="userEmail">
                </div>
                <div class="mb-3">
                    <label for="userPassword" class="form-label">Password:</label>
                    <input type="password" class="form-control" name="userPassword" id="userPassword">
                </div>
                <div class="modal-footer">
                    <a href="" data-bs-toggle="modal" data-bs-target="#register">
                        Do not have account? Create new!
                    </a>
                    <button type="submit" class="btn btn-primary">Login</button>

                </div>
            </form>
        </div>
    </div>
</div>

<!-- Modal -->
<div class="modal fade" id="register" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Registration</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form action="/register" method="post">
                    <div class="mb-3">
                        <label for="login" class="form-label">Login</label>
                        <input type="text" class="form-control" name="login" id="login">
                    </div>
                    <div class="mb-3">
                        <label for="password" class="form-label">Password</label>
                        <input type="password" class="form-control" name="password" id="password">
                    </div>
                    <div class="mb-3">
                        <label for="fullname" class="form-label">Full Name</label>
                        <input type="text" class="form-control" name="fullname" id="fullname">
                    </div>
                    <div class="mb-3">
                        <label for="email" class="form-label">Email</label>
                        <input type="email" class="form-control" name="email" id="email">
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                        <button type="submit" class="btn btn-primary">Create new account</button>
                    </div>
                </form>
            </div>
            </div>

        </div>
    </div>
</body>
</html>

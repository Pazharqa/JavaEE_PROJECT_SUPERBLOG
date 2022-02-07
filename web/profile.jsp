<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 05.02.2022
  Time: 5:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="head.jsp"%>
<%@include file="nav.jsp"%>
<body>
<div class="row">
    <div class="ms-auto">
    <a href="/main" class="btn btn-primary">BACK</a>
    </div>
    <div class="col-lg-5 m-auto">

        <%
            System.out.println(currentUser);
        %>

        <h2><%=currentUser.getFullname()%></h2>
        <h2><%=currentUser.getLogin()%></h2>
        <p><%=currentUser.getPassword()%></p>
        <p><%=currentUser.getEmail()%></p>
        <a href="/edit-user" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#edit-user">Edit</a>
        <a href="" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#delete-user" style="background-color: red">Remove profile</a>

    </div>
</div>
<div class="modal fade" id="delete-user" >
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel1">Delete Profile?</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <a href="/index.jsp" class="btn btn-secondary" data-bs-dismiss="modal">Close</a>
                <a href="/delete-user" class="btn btn-primary" style="background-color: red">Remove</a>
            </div>

        </div>
    </div>
</div>
<div class="modal fade" id="edit-user" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Edit Profile</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form action="/edit-user" method="post">
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
                        <button type="submit" class="btn btn-primary">Save changes</button>
                    </div>
                </form>
            </div>
        </div>

    </div>
</div>
</body>
</html>

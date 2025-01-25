<%@page contentType="text/html" pageEncoding="UTF-8" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
      <!DOCTYPE html>
      <html lang="en">

      <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="HoaSatoru - Dự án laptopshop" />
        <meta name="author" content="HoaSatoru" />
        <title>Dashboard - HoaSatoru</title>
        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/style.min.css" rel="stylesheet" />
        <link href="/css/styles.css" rel="stylesheet" />
        <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
         
 <script 
 src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script> 
  
                 <script> 
                     $(document).ready(() => { 
                         const avatarFile = $("#avatarFile"); 
                         avatarFile.change(function (e) { 
                             const imgURL = URL.createObjectURL(e.target.files[0]); 
                             $("#avatarPreview").attr("src", imgURL); 
                             $("#avatarPreview").css({ "display": "block" }); 
                         }); 
                     }); 
                 </script>
      </head>

      <body class="sb-nav-fixed">
        <jsp:include page="../layout/header.jsp" />
        <div id="layoutSidenav">
          <jsp:include page="../layout/sidebar.jsp" />
          <div id="layoutSidenav_content">
            <div class="container-fluid px-4">
              <h1 class="mt-4">Manage Users</h1>
              <ol class="breadcrumb mb-4">
                <li class="breadcrumb-item "><a href="/admin">Dashboard</a></li>
                <li class="breadcrumb-item "><a href="/admin/user">Users</a></li>
                <li class="breadcrumb-item active">Create</li>
              </ol>
              <div class="row">
                <div class="col-6 mx-auto">
                  <h3>Create a user</h3>
                  <hr />
                  <form:form action="/admin/user/create" method="post" modelAttribute="newUser" class="row">
                    <div class="mb-3 col-12 col-md-6">
                      <label class="form-label">Email</label>
                      <form:input type="email" path="email" class="form-control" />

                    </div>
                    <div class="mb-3 col-12 col-md-6">
                      <label class="form-label">Password</label>
                      <form:input type="password" path="password" class="form-control" />
                    </div>
                    <div class="mb-3 col-12 col-md-6">
                      <label class="form-label">Phone Number</label>
                      <form:input type="text" path="phone" class="form-control" />
                    </div>
                    <div class="mb-3 col-12 col-md-6">
                      <label class="form-label">Full Name</label>
                      <form:input type="text" path="fullName" class="form-control" />
                    </div>
                    <div class="mb-3 col-12">
                      <label class="form-label">Address</label>
                      <form:input type="text" path="address" class="form-control" />
                    </div>
                    <div class="mb-3 col-12 col-md-6">
                      <label class="form-label">Role</label>
                      <select class="form-select" aria-label="Default select example">
                        <option selected>ADMIN</option>
                        <option value="1">One</option>
                        <option value="2">Two</option>
                        <option value="3">Three</option>
                      </select>
                    </div>
                    <div class="mb-3 col-12 col-md-6">


                      <label for="avatarFile" class="form-label">Avatar: </label>
                      <input class="form-control" type="file" id="avatarFile" accept=".ipg, .png, .jpeg">

                    </div>
                    <div class="mb-3 col-12">
                      <img style="max-height: 250px; display: none;" alt="avatar preview" id="avatarPreview" />

                    </div>
                    <div class="mb-5 col-12">
                      <button type="submit" class="btn btn-primary">Create</button>
                    </div>


                  </form:form>

                </div>

              </div>
            </div>
            <jsp:include page="../layout/footer.jsp" />
          </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
          crossorigin="anonymous"></script>
        <script src="/js/scripts.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/umd/simple-datatables.min.js"
          crossorigin="anonymous"></script>
        <script src="/js/datatables-simple-demo.js"></script>
      </body>

      </html>
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
        <title>Detail user ${user.id}</title>
        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/style.min.css" rel="stylesheet" />
        <link href="/css/styles.css" rel="stylesheet" />
        <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
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
                <li class="breadcrumb-item active">Detail</li>
              </ol>
              <div class="row">
                <div class="col-6 mx-auto">
                <h2>Detail user with id = ${user.id}</h2>
              <hr />
              <div class="card" style="width: 60%;">
                <div class="card-header">
                  User information
                </div>
                <ul class="list-group list-group-flush">
                  <li class="list-group-item">ID: ${user.id}</li>
                  <li class="list-group-item">Email: ${user.email}</li>
                  <li class="list-group-item">FullName: ${user.fullName}</li>
                  <li class="list-group-item">Role: ${user.role.getName()}</li>
                  <li class="list-group-item">Address: ${user.address}</li>
                </ul>
              </div>
              <a href="/admin/user" class="btn btn-success mt-3">Back</a>

              </div>
            </div>
            
          </div>
          <jsp:include page="../layout/footer.jsp" />
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
          crossorigin="anonymous"></script>
        <script src="/js/scripts.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/umd/simple-datatables.min.js"
          crossorigin="anonymous"></script>
        <script src="/js/datatables-simple-demo.js"></script>
      </body>

      </html>
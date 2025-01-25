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
        <title>Update user ${user.id}</title>
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
                <li class="breadcrumb-item active">Update</li>
              </ol>
              <div class="row">
                <div class="col-6 mx-auto">
                  <h3>Update a user</h3>
                  <hr />
                  <form:form action="/admin/user/update" method="post" modelAttribute="user">
                    <div class="mb-3 " hidden>
                      <label class="form-label ">ID</label>
                      <form:input type="text" path="id" class="form-control" />
                    </div>
                    <div class="mb-3">
                      <label class="form-label">Email</label>
                      <form:input type="email" path="email" class="form-control" disabled="true" />

                    </div>
                    <div class="mb-3">
                      <label class="form-label">Phone Number</label>
                      <form:input type="text" path="phone" class="form-control" />
                    </div>
                    <div class="mb-3">
                      <label class="form-label">Full Name</label>
                      <form:input type="text" path="fullName" class="form-control" />
                    </div>
                    <div class="mb-3">
                      <label class="form-label">Address</label>
                      <form:input type="text" path="address" class="form-control" />
                    </div>

                    <button type="submit" class="btn btn-warning">Update</button>

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
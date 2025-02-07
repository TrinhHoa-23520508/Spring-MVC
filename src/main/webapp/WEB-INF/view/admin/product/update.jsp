<%@page contentType="text/html" pageEncoding="UTF-8" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
      <!DOCTYPE html>
      <html lang="en">

      <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="HoaSatoru - Dự án laptopshop" />
        <meta name="author" content="HoaSatoru" />
        <title>Update product</title>
        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/style.min.css" rel="stylesheet" />
        <link href="/css/styles.css" rel="stylesheet" />
        <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

        <script>
          $(document).ready(() => {
            const productFile = $("#productFile");
            productFile.change(function (e) {
              const imgURL = URL.createObjectURL(e.target.files[0]);
              $("#productPreview").attr("src", imgURL);
              
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
              <h1 class="mt-4">Manage Products</h1>
              <ol class="breadcrumb mb-4">
                <li class="breadcrumb-item "><a href="/admin">Dashboard</a></li>
                <li class="breadcrumb-item "><a href="/admin/product">Products</a></li>
                <li class="breadcrumb-item active">Update</li>
              </ol>
              <div class="row">
                <div class="col-6 mx-auto">
                  <h3>Update a product</h3>
                  <hr />
                  <form:form action="/admin/product/update" method="post" modelAttribute="updateProduct" class="row"
                    enctype="multipart/form-data">
                    <spring:bind path="name">
                    <div class="mb-3 col-12 col-md-6">
                      <label class="form-label">Name: </label>
                      <form:input type="text" path="name" class="form-control ${status.error?'is-invalid':''}" />
                      <form:errors path = "name" cssClass = "invalid-feedback"/>
                    </div>
                  </spring:bind>
                  <spring:bind path="price">
                    <div class="mb-3 col-12 col-md-6">
                      <label class="form-label">Price: </label>
                      <form:input type="number" path="price" class="form-control ${status.error?'is-invalid':''}" />
                      <form:errors path = "price" cssClass = "invalid-feedback"/>
                    </div>
                  </spring:bind>
                  <spring:bind path="detailDesc">
                    <div class="mb-3 col-12 ">
                      <label class="form-label">Detail description: </label>
                      <form:textarea class="form-control ${status.error?'is-invalid':''}" path="detailDesc" rows="3"></form:textarea>
                      <form:errors path="detailDesc" cssClass="invalid-feedback"/>
                    </div>
                  </spring:bind>
                  <spring:bind path = "shortDesc">
                    <div class="mb-3 col-12 col-md-6">
                      <label class="form-label">Short description: </label>
                      <form:input type="text" path="shortDesc" class="form-control ${status.error?'is-invalid':''}" />
                      <form:errors path="shortDesc" cssClass="invalid-feedback"/>
                    </div>
                  </spring:bind>
                  <spring:bind path="quantity">
                    <div class="mb-3 col-12 col-md-6">
                      <label class="form-label">Quantity: </label>
                      <form:input type="number" placeholder="0" path="quantity" class="form-control ${status.error?'is-invalid':''}" />
                      <form:errors path = "quantity" cssClass="invalid-feedback"/>
                    </div>
                  </spring:bind>
                    <div class="mb-3 col-12 col-md-6">
                      <label class="form-label">Factory: </label>
                      <form:select class="form-select" aria-label="Default select example" path="factory">
                        <form:option value="APPLE">Apple (MacBook)</form:option>
                        <form:option value="ASUS">Asus</form:option>
                        <form:option value="LENOVO">Lenovo</form:option>
                        <form:option value="DELL">Dell</form:option>
                        <form:option value="LG">LG</form:option>
                        <form:option value="ACER">Acer</form:option>
                      </form:select>
                    </div>
                    <div class="mb-3 col-12 col-md-6">
                      <label class="form-label">Target: </label>
                      <form:select class="form-select" aria-label="Default select example" path="target">
                        <form:option value="GAMING">Gaming</form:option>
                        <form:option value="SINHVIEN-VANPHONG">Sinh viên - Văn phòng</form:option>
                        <form:option value="THIET-KE-DO-HOA">Thiết kế đồ họa</form:option>
                        <form:option value="MONG-NHE">Mỏng nhẹ</form:option>
                        <form:option value="DOANH-NHAN">Doanh nhân</form:option>
                      </form:select>
                    </div>
                    <div class="mb-3 col-12 col-md-6">


                      <label for="productFile" class="form-label">Image: </label>
                      <input class="form-control" type="file" id="productFile" accept=".jpg, .png, .jpeg"
                        name="productFile">

                    </div>
                    <div class="mb-3 col-12">
                      <img style="max-height: 250px; display:block;" alt="product preview" id="productPreview" src ="/images/product/${updateProduct.image}" />

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
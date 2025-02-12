<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
        <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
            <!DOCTYPE html>
            <html lang="en">

            <head>
                <meta charset="utf-8" />
                <meta http-equiv="X-UA-Compatible" content="IE=edge" />
                <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
                <meta name="description" content="" />
                <meta name="author" content="" />
                <title>Login - Laptopshop</title>
                <link href="/css/styles.css" rel="stylesheet" />
                <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
            </head>

            <body class="bg-primary">
                <div id="layoutAuthentication">
                    <div id="layoutAuthentication_content">
                        <main>
                            <div class="container">
                                <div class="row justify-content-center">
                                    <div class="col-lg-5">
                                        <div class="card shadow-lg border-0 rounded-lg mt-5">
                                            <div class="card-header">
                                                <h3 class="text-center font-weight-light my-4">Login</h3>
                                            </div>
                                            <div class="card-body">
                                                <form:form method="post" action="/login"
                                                    modelAttribute="loginUser">
                                                    <div class="form-floating mb-3">
                                                        <spring:bind path="email">
                                                            <form:input class="form-control ${status.error ? 'is-invalid' : ''}" 
                                                                type="email" placeholder="name@example.com" path="email" />
                                                            <label>Email address</label>
                                                            <form:errors path="email" cssClass="invalid-feedback" />
                                                        </spring:bind>
                                                    </div>
                                                    
                                                
                                                    <div class="row mb-3">
                                                        <div class="col-md-12">
                                                            <spring:bind path="confirmPassword">
                                                            <div class="form-floating mb-3 mb-md-0">
                                                                <form:input class="form-control ${status.error?'is-invalid':''}" type="password"
                                                                    placeholder="Create a password" path="password" />
                                                                <label>Password</label>
                                                                <form:errors path="confirmPassword" cssClass="invalid-feedback"/>
                                                            </div>
                                                        </spring:bind>
                                                        </div>
                                                       
                                                    </div>
                                                    <div class="mt-4 mb-0">
                                                        <div class="d-grid">
                                                            <button class="btn btn-primary btn-block">
                                                                Login
                                                            </button>
                                                        </div>
                                                    </div>
                                                </form:form>
                                            </div>
                                            <div class="card-footer text-center py-3">
                                                <div class="small"><a href="/register">Need an account? Sign up!</a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </main>
                    </div>

                </div>
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
                    crossorigin="anonymous"></script>
                <script src="/js/scripts.js"></script>
            </body>

            </html>
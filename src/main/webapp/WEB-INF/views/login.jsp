<%--
  Created by IntelliJ IDEA.
  User: gerar
  Date: 20/12/2022
  Time: 21:38
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="cs" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<cs:layout title="Login" admin="false">
<div>
  <section>
    <!-- Logo -->
    <div class="col-xl-2 col-lg-2 col-md-1">
      <div style="padding: 15px">
        <a href="index"><img src="<c:url value="/images/logoCoralloSmart.png"/>" width="120px" height="120px"
                        alt=""></a>
      </div>
    </div>
  </section>

  <section class="vh-100" style="height: 42%">
    <div class="container-fluid h-custom">
      <div class="row d-flex justify-content-center align-items-center h-100">
        <div class="col-md-9 col-lg-6 col-xl-5">
          <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/draw2.webp"
               class="img-fluid" alt="Sample image">
        </div>

        <!--form-->
        <div class="col-md-8 col-lg-6 col-xl-4 offset-xl-1">
          <form action="checkLogin" name="loginForm" id="loginForm" method="post">
            <p class="font-italic text-muted mb-1">${messaggio}</p>
            <!-- Email input -->
            <div class="form-outline mb-4">
              <input type="email" name="email" id="form3Example3" class="form-control form-control-lg"
                     placeholder="Enter a valid email address" />
              <label class="form-label" for="form3Example3">Email address</label>
            </div>

            <!-- Password input -->
            <div class="form-outline mb-3">
              <input type="password" name="password" id="form3Example4" class="form-control form-control-lg"
                     placeholder="Enter password" />
              <label class="form-label" for="form3Example4">Password</label>
            </div>
            <div class="text-center text-lg-start mt-4 pt-2">
              <!--<a type="button" class="btn btn-primary btn-lg"
                      style="padding-left: 2.5rem; padding-right: 2.5rem; color: white">Login</a>
              !-->
              <!--submit-->
              <button type="submit" class="btn btn-primary btn-lg"
                      style="padding-left: 2.5rem; padding-right: 2.5rem; color: white">Login</button>

              <p class="small fw-bold mt-2 pt-1 mb-0">Don't have an account? <a href="registrazione"
                                                                                class="link-danger">Register</a></p>
            </div>
          </form>
        </div>
      </div>
    </div>
  </section>
</div>
</cs:layout>
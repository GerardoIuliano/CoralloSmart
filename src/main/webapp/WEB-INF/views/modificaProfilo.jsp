<%--
  Created by IntelliJ IDEA.
  User: gerar
  Date: 20/12/2022
  Time: 21:38
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="cs" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<cs:layout title="Registration" admin="false">



  <div id="wrapper">
  <c:choose>
  <c:when test="${utente != null}">
    <c:when test="${utente.isTipo() == false}">
      <cs:sidebarArpa/>
    </c:when>
    <c:when test="${utente.isTipo() == true}">
      <cs:sidebar/>
    </c:when>
  </c:when>
  </c:choose>
    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column " style="padding: 20px">
      <!-- Main Content -->
      <div class=section-top-border">
        <h3>Modifica Profilo</h3>
        <div>
          <!--Contenuto-->
          <div>
            <section class="vh-100" style="height: 42%">
              <div class="container-fluid h-custom">
                <div class="row d-flex justify-content-center align-items-center h-100">
                  <div class="col-md-9 col-lg-6 col-xl-5">
                    <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/draw2.webp"
                         class="img-fluid" alt="Sample image">
                  </div>

                  <!--form-->
                  <div class="col-md-8 col-lg-6 col-xl-4 offset-xl-1">
                    <form action="checkModificaProfilo" name="registrationForm" id="registrationForm" method="post">

                      <!-- messaggio -->
                      <p name="message" class="font-italic text-muted mb-1">${messaggio}</p>

                      <input type="hidden" id="idUtente" name="idUtente" value=${utente.getId()}>

                      <!-- Email input -->
                      <div class="form-outline mb-4">
                        <input type="email" name="email" id="email" oninput="validaEmail('registrationForm')" class="form-control form-control-lg"
                               placeholder="Enter a valid email address" />
                        <label class="form-label" for="email">Email address: ${utente.getEmail()}</label>
                      </div>

                      <!-- Password input -->
                      <div class="form-outline mb-3">
                        <input type="password" name="password" id="password" oninput="validaPassword('registrationForm')" class="form-control form-control-lg"
                               placeholder="Enter password" />
                        <label class="form-label" for="password">Password: (must contain: one lowercase, uppercase, number and not less than 8 characters)</label>
                      </div>

                      <!-- PasswordConferma input -->
                      <div class="form-outline mb-3">
                        <input type="password" name="passwordConferma" id="passwordConferma" oninput="validaPassword('registrationForm')" class="form-control form-control-lg"
                               placeholder="Enter password again" />
                        <label class="form-label" for="passwordConferma">Repeat Password</label>
                      </div>

                      <!-- Username input -->
                      <div class="form-outline mb-3">
                        <input type="text" name="username" id="username" oninput="validaUsername('registrationForm')" class="form-control form-control-lg"
                               placeholder="Enter username" />
                        <label class="form-label" for="username">username: ${utente.getUsername()}</label>
                      </div>

                      <!-- name input -->
                      <div class="form-outline mb-3">
                        <input type="text" name="name" id="name" oninput="validaNome('registrationForm')" class="form-control form-control-lg"
                               placeholder="Enter name" />
                        <label class="form-label" for="name">name: ${utente.getNome()}</label>
                      </div>

                      <!-- cognome input -->
                      <div class="form-outline mb-3">
                        <input type="text" name="cognome" id="cognome" oninput="validaCognome('registrationForm')" class="form-control form-control-lg"
                               placeholder="Enter cognome" />
                        <label class="form-label" for="cognome">cognome: ${utente.getCognome()}</label>
                      </div>

                      <!-- codiceFiscale input -->
                      <div class="form-outline mb-3">
                        <input type="text" name="codiceFiscale" id="codiceFiscale" oninput="validaCodiceFiscale('registrationForm')" class="form-control form-control-lg"
                               placeholder="Enter codice fiscale" />
                        <label class="form-label" for="codiceFiscale">codice fiscale: ${utente.getCodiceFiscale()}</label>
                      </div>

                      <!-- telefono input -->
                      <div class="form-outline mb-3">
                        <input type="text" name="telefono" id="telefono" oninput="validaTelefono('registrationForm')" class="form-control form-control-lg"
                               placeholder="Enter telefono" />
                        <label class="form-label" for="telefono">telefono: ${utente.getTelefono()}</label>
                      </div>

                      <div class="text-center text-lg-start mt-4 pt-2">
                        <!--<a type="button" class="btn btn-primary btn-lg"
                                style="padding-left: 2.5rem; padding-right: 2.5rem; color: white">Login</a>
                        !-->
                        <!--submit-->
                        <button name="submit" type="button" onclick="chekUpdateForm('registrationForm')" class="btn btn-primary btn-lg"
                                style="padding-left: 2.5rem; padding-right: 2.5rem; color: white">Update</button>
                      </div>
                    </form>
                  </div>
                </div>
              </div>
            </section>
          </div>
        </cs:layout>
        </div>
      </div>
    </div>
  </div>
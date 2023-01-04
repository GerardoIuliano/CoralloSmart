<%--
  Created by IntelliJ IDEA.
  User: attil
  Date: 1/2/2023
  Time: 5:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="cs" tagdir="/WEB-INF/tags" %>

<cs:layout title="Area Personale"/>

<div id="wrapper">
  <cs:sidebar/>
  <!-- Content Wrapper -->
  <div id="content-wrapper" class="d-flex flex-column " style="padding: 20px">
    <!-- Main Content -->
    <div class=section-top-border">
      <h3>Il Mio Profilo</h3>
      <div>
        <div class="container py-5">
          <div class="card mb-4">
            <div class="card-body">
              <div class="row">
                <div class="col-sm-3">
                  <p class="mb-0">Username</p>
                </div>
                <div class="col-sm-9">
                  <p class="text-muted mb-0">${utente.getUsername()}</p>
                </div>
              </div>
              <hr>
              <div class="row">
                <div class="col-sm-3">
                  <p class="mb-0">Nome</p>
                </div>
                <div class="col-sm-9">
                  <p class="text-muted mb-0">${utente.getNome()}</p>
                </div>
              </div>
              <hr>
              <div class="row">
                <div class="col-sm-3">
                  <p class="mb-0">Cognome</p>
                </div>
                <div class="col-sm-9">
                  <p class="text-muted mb-0">${utente.getCognome()}</p>
                </div>
              </div>
              <hr>
              <div class="row">
                <div class="col-sm-3">
                  <p class="mb-0">Codice Fiscale</p>
                </div>
                <div class="col-sm-9">
                  <p class="text-muted mb-0">${utente.getCodiceFiscale()}</p>
                </div>
              </div>
              <hr>
              <div class="row">
                <div class="col-sm-3">
                  <p class="mb-0">Email</p>
                </div>
                <div class="col-sm-9">
                  <p class="text-muted mb-0">${utente.getEmail()}</p>
                </div>
              </div>
              <hr>
              <div class="row">
                <div class="col-sm-3">
                  <p class="mb-0">Numero di Telefono</p>
                </div>
                <div class="col-sm-9">
                  <p class="text-muted mb-0">${utente.getTelefono()}</p>
                </div>
              </div>
            </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
<!-- End of Page Wrapper -->



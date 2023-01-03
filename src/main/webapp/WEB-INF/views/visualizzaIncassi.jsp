<%--
  Created by IntelliJ IDEA.
  User: attil
  Date: 1/3/2023
  Time: 12:42 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="cs" tagdir="/WEB-INF/tags" %>

<cs:layout title="Area Personale"/>

<div id="wrapper">
  <cs:sidebarArpa/>
  <!-- Content Wrapper -->
  <div id="content-wrapper" class="d-flex flex-column " style="padding: 20px">
    <!-- Main Content -->
    <div class=section-top-border">
      <h3>Incassi</h3>

      <div>
        <table class="table align-middle mb-0 bg-white">
          <thead class="bg-light">
          <tr>
            <th>ID</th>
            <th>Data versamento</th>
            <th>Importo Versato</th>
          </tr>
          </thead>
          <tbody>
          <tr>
            <td>
              <p class="fw-normal mb-1">1546442</p>
            </td>
            <td>
              <p class="fw-normal mb-1">15/09/22</p>
            </td>
            <td>
              <p class="fw-normal mb-1">1500€</p>
            </td>
          </tr>

          <tr>
            <td>
              <p class="fw-normal mb-1">1546442</p>
            </td>
            <td>
              <p class="fw-normal mb-1">15/09/22</p>
            </td>
            <td>
              <p class="fw-normal mb-1">1500€</p>
            </td>
          </tr>

          <tr>
            <td>
              <p class="fw-normal mb-1">1546442</p>
            </td>
            <td>
              <p class="fw-normal mb-1">15/09/22</p>
            </td>
            <td>
              <p class="fw-normal mb-1">1500€</p>
            </td>
          </tr>
          </tbody>
        </table>

        <h4>Totale Contributi Incassati: 8000€</h4>
      </div>
    </div>
  </div>
</div>
<!-- End of Page Wrapper -->



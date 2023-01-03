<%--
  Created by IntelliJ IDEA.
  User: attil
  Date: 1/3/2023
  Time: 1:19 AM
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
      <h3>Stato Dispositivi</h3>
      <div>
        <table class="table align-middle mb-0 bg-white">
          <thead class="bg-light">
          <tr>
            <th>Posizione</th>
            <th>Qualità</th>
            <th>Data Immersione</th>
            <th>DO Sensor</th>
            <th>ORP Sensor</th>
            <th>pH Sensor</th>
            <th>Turbidity Sensor</th>
            <th>TDS Sensor</th>
            <th>Temp Sensor</th>
          </tr>
          </thead>
          <tbody>
          <tr>
            <td>
              <p class="fw-normal mb-1">
                40.637333, 14.635842</p>
            </td>
            <td>
              <p class="fw-normal mb-1">Alto</p>
            </td>
            <td>
              <p class="fw-normal mb-1">15/06/2022</p>
            </td>
            <td>
              <p class="fw-normal mb-1">Connesso</p>
            </td>
            <td>
              <p class="fw-normal mb-1">Connesso</p>
            </td>
            <td>
              <p class="fw-normal mb-1">Non Connesso</p>
            </td>
            <td>
              <p class="fw-normal mb-1">Connesso</p>
            </td>
            <td>
              <p class="fw-normal mb-1">Non Connesso</p>
            </td>
            <td>
              <p class="fw-normal mb-1">Connesso</p>
            </td>
          </tr>

          <tr>
            <td>
              <p class="fw-normal mb-1">
                40.637333, 14.635842</p>
            </td>
            <td>
              <p class="fw-normal mb-1">Alto</p>
            </td>
            <td>
              <p class="fw-normal mb-1">15/06/2022</p>
            </td>
            <td>
              <p class="fw-normal mb-1">Connesso</p>
            </td>
            <td>
              <p class="fw-normal mb-1">Connesso</p>
            </td>
            <td>
              <p class="fw-normal mb-1">Non Connesso</p>
            </td>
            <td>
              <p class="fw-normal mb-1">Connesso</p>
            </td>
            <td>
              <p class="fw-normal mb-1">Non Connesso</p>
            </td>
            <td>
              <p class="fw-normal mb-1">Connesso</p>
            </td>
          </tr>

          <tr>
            <td>
              <p class="fw-normal mb-1">
                40.637333, 14.635842</p>
            </td>
            <td>
              <p class="fw-normal mb-1">Alto</p>
            </td>
            <td>
              <p class="fw-normal mb-1">15/06/2022</p>
            </td>
            <td>
              <p class="fw-normal mb-1">Connesso</p>
            </td>
            <td>
              <p class="fw-normal mb-1">Connesso</p>
            </td>
            <td>
              <p class="fw-normal mb-1">Non Connesso</p>
            </td>
            <td>
              <p class="fw-normal mb-1">Connesso</p>
            </td>
            <td>
              <p class="fw-normal mb-1">Non Connesso</p>
            </td>
            <td>
              <p class="fw-normal mb-1">Connesso</p>
            </td>
          </tr>
          </tbody>
        </table>
      </div>
    </div>
  </div>
</div>
<!-- End of Page Wrapper -->



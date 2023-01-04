<%--
  Created by IntelliJ IDEA.
  User: attil
  Date: 1/3/2023
  Time: 1:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="cs" tagdir="/WEB-INF/tags" %>

<cs:layout title="Area Personale"/>

<div id="wrapper">
  <cs:sidebarArpa/>
  <!-- Content Wrapper -->
  <div id="content-wrapper" class="d-flex flex-column " style="padding: 20px">
    <!-- Main Content -->
    <div class=section-top-border">
      <h3>Monitoraggio</h3>
      <div>
        <div class = "order-filter">
        <form action = "ricercaData" method = "post" id = "search-date">

          <label for = "fromDate">Ricerca per data</label><br>
          <label for = "fromDate">Da</label>
          <input type = "date" name = "fromDate" id = "fromDate" required>

          <div id = "in-toDate">
            <label for = "toDate">&nbsp;A</label>
            <input type = "date" name = "toDate" id = "toDate" required>
          </div>

          <button type = "submit">Cerca</button>
        </form>
        </div>

        <table class="table align-middle mb-0 bg-white">
          <thead class="bg-light">
          <tr>
            <th>Data Ricezione</th>
            <th>Posizione Dispositivo IoT</th>
            <th>Dissolved Oxygen (mg/l)</th>
            <th>Oxidation-reduction potential (millivolts)</th>
            <th>pH</th>
            <th>Turbidity (FNU)</th>
            <th>Total Dissolved Solids (mg/l)</th>
            <th>Temp Sensor (°C)</th>
          </tr>
          </thead>
          <tbody>
          <c:forEach items="${rilevamenti}" var="rilevamento">
          <tr>
            <td>
              <p class="fw-normal mb-1">${sdf.format(rilevamento.getDataRicezione())}</p>
            </td>
            <td>
              <p class="fw-normal mb-1">
                ${rilevamento.getLatitudine()}, ${rilevamento.getLongitudine()}</p>
            </td>
            <td>
              <p class="fw-normal mb-1">${rilevamento.getDissolvedOxygen()}</p>
            </td>
            <td>
              <p class="fw-normal mb-1">${rilevamento.getOxidationReductionPotential()}</p>
            </td>
            <td>
              <p class="fw-normal mb-1">${rilevamento.getPHTurbidity()}</p>
            </td>
            <td>
              <p class="fw-normal mb-1">${rilevamento.getTurbidity()}</p>
            </td>
            <td>
              <p class="fw-normal mb-1">${rilevamento.getTotalDissolvedSolids()}</p>
            </td>
            <td>
              <p class="fw-normal mb-1">${rilevamento.getTemperatura()}</p>
            </td>
          </tr>
          </c:forEach>
          </tbody>
        </table>
      </div>
    </div>
  </div>
</div>
<!-- End of Page Wrapper -->

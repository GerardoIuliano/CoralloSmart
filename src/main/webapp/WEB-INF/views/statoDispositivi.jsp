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
          <c:forEach items="${dispositivi}" var="dispositivo">
          <tr>
            <td>
              <p class="fw-normal mb-1">${dispositivo.getLatitudine()}, ${dispositivo.getLongitudine()}</p>
            </td>
            <td>
              <p class="fw-normal mb-1">${dispositivo.getQualita()}</p>
            </td>
            <td>
              <p class="fw-normal mb-1">${dispositivo.getDataImmersione().getDate()}/${dispositivo.getDataImmersione().getMonth()}/${dispositivo.getDataImmersione().getYear()}</p>
            </td>
            <td>
              <c:choose>
                 <c:when test="${dispositivo.getDOSensor() == 0}">
                 <p class="fw-normal mb-1">Non installato</p>
                 </c:when>
                 <c:when test="${dispositivo.getDOSensor() == 1}">
                   <p class="fw-normal mb-1">Connesso</p>
                 </c:when>
                 <c:when test="${dispositivo.getDOSensor() == 2}">
                   <p class="fw-normal mb-1">Non connesso</p>
                 </c:when>
              </c:choose>
               </td>
               <td>
                 <c:choose>
                 <c:when test="${dispositivo.getORPSensor() == 0}">
                   <p class="fw-normal mb-1">Non installato</p>
                 </c:when>
                 <c:when test="${dispositivo.getORPSensor() == 1}">
                   <p class="fw-normal mb-1">Connesso</p>
                 </c:when>
                 <c:when test="${dispositivo.getORPSensor() == 2}">
                   <p class="fw-normal mb-1">Non connesso</p>
                 </c:when>
                 </c:choose>
               </td>
               <td>
                 <c:choose>
                 <c:when test="${dispositivo.getPHSensor() == 0}">
                   <p class="fw-normal mb-1">Non installato</p>
                 </c:when>
                 <c:when test="${dispositivo.getPHSensor() == 1}">
                   <p class="fw-normal mb-1">Connesso</p>
                 </c:when>
                 <c:when test="${dispositivo.getPHSensor() == 2}">
                   <p class="fw-normal mb-1">Non connesso</p>
                 </c:when>
                 </c:choose>
               </td>
               <td>
                 <c:choose>
                 <c:when test="${dispositivo.getTurbiditySensor() == 0}">
                   <p class="fw-normal mb-1">Non installato</p>
                 </c:when>
                 <c:when test="${dispositivo.getTurbiditySensor() == 1}">
                   <p class="fw-normal mb-1">Connesso</p>
                 </c:when>
                 <c:when test="${dispositivo.getTurbiditySensor() == 2}">
                   <p class="fw-normal mb-1">Non connesso</p>
                 </c:when>
                 </c:choose>
               </td>
               <td>
                 <c:choose>
                 <c:when test="${dispositivo.getTDSSensor() == 0}">
                   <p class="fw-normal mb-1">Non installato</p>
                 </c:when>
                 <c:when test="${dispositivo.getTDSSensor() == 1}">
                   <p class="fw-normal mb-1">Connesso</p>
                 </c:when>
                 <c:when test="${dispositivo.getTDSSensor() == 2}">
                   <p class="fw-normal mb-1">Non connesso</p>
                 </c:when>
                 </c:choose>
               </td>
               <td>
                 <c:choose>
                 <c:when test="${dispositivo.getTempSensor() == 0}">
                   <p class="fw-normal mb-1">Non installato</p>
                 </c:when>
                 <c:when test="${dispositivo.getTempSensor() == 1}">
                   <p class="fw-normal mb-1">Connesso</p>
                 </c:when>
                 <c:when test="${dispositivo.getTempSensor() == 2}">
                   <p class="fw-normal mb-1">Non connesso</p>
                 </c:when>
                 </c:choose>
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



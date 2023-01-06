<%@ page import="java.util.List" %>
<%@ page import="org.corallosmart.models.modelsVoucher.Voucher" %><%--
  Created by IntelliJ IDEA.
  User: attil
  Date: 1/3/2023
  Time: 5:27 PM
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
      <h3>Contributi e Voucher</h3>
      <div>
        <table class="table align-middle mb-0 bg-white">
          <thead class="bg-light">

          <tr>
            <th>ID</th>
            <th>Data versamento</th>
            <th>Importo Versato</th>
            <th>Voucher</th>
          </tr>
          </thead>
          <tbody>
          <%
            List<Voucher> vouchers = (List<Voucher>) session.getAttribute("vouchers");
            Integer index = (Integer) session.getAttribute("index");
          %>
          <c:forEach items="${contributi}" var="contributo">
          <tr>
            <td>
              <p class="fw-normal mb-1">${contributo.id}</p>
            </td>
            <td>
              <p class="fw-normal mb-1">${sdf.format(contributo.data)}</p>
            </td>
            <td>
              <p class="fw-normal mb-1">${contributo.importo}</p>
            </td>
            <td>
              <c:choose>
                <c:when test="${contributo.idVoucher2 != 0}">
                  <p class="fw-normal mb-1"><%= vouchers.get(index).getDescrizione()%></p>
                  <%index++;%>
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

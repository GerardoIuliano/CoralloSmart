<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="cs" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script src="https://kit.fontawesome.com/d2fb96c0f6.js" crossorigin="anonymous"></script>


<cs:layout title="Gestione Voucher"/>

<div id="wrapper">
  <cs:sidebarArpa/>
  <!-- Content Wrapper -->
  <div id="content-wrapper" class="d-flex flex-column " style="padding: 20px">
    <!-- Main Content -->
    <div class=section-top-border">
      <h3>Gestione Voucher</h3>
      <div class="voucher-list">
        <c:forEach items="${listaVoucher}" var="vou">
          <div class="voucher-box column">
            <h3 class="id-voucher"> VOUCHER CON ID: ${vou.id} </h3>
            <div class="voucher-info row">
              <form  class="info column" method="post" action="modificaVoucher" id="modifica">
                <label for="descrizione">DESCRIZIONE</label>
                <input type="text" id="descrizione" name="descrizione" value="${vou.descrizione}">
                <div class="sub-info row">
                  <div class="campo-importo column">
                    <label for="importo">IMPORTO PER SBLOCCARLO</label>
                    <input type="text" id="importo" class="input-field inactive" name="importo" value="${vou.importo}">
                  </div>
                  <button type="submit" class="btn btn-primary" name="id" value="${vou.id}">Modifica</button>
                </div>
              </form>
              <form class="delete column" method="get" action="eliminaVoucher">
                  <button type="submit" class="trash" name="id" value="${vou.id}"> <i class="fa-solid fa-trash fa-4x"></i> </button>
              </form>
            </div>
          </div>
        </c:forEach>
      </div>
    </div>
  </div>
</div>


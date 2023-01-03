<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="cs" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<cs:layout title="AggiungiVoucher">
  <cs:header/>
  <cs:sidebarArpa/>

  <div align="center">
  <c:if test="${errore!=null}"> <H1 color="red">${errore}</H1></c:if>
  </div>
  <c:forEach items="${listaVoucher}" var="vou">
    <div class="product-info-line">
      <div class="box row">
        <form method="post" action="modificaVoucher" id="modifica" class="product-data-row row">
          <div class="voice size-l">
            <label for="id">VOUCHER CON ID:</label>
            <input type="text" id="id" class="input-field inactive" name="id" value="${vou.id}" readonly>
          </div>
          <div class="voice size-l">
            <label for="descrizione">DESCRIZIONE</label>
            <input type="text" id="descrizione" class="input-field inactive" name="descrizione" value="${vou.descrizione}">
          </div>
          <div class="voice size-l">
            <label for="importo">IMPORTO PER SBLOCCARLO</label>
            <input type="text" id="importo" class="input-field inactive" name="importo" value="${vou.importo}">
          </div>
          <div>
            <button type="submit" class="active-edit-button">Modifica</button>
          </div>
        </form>

        <form method="get" action="eliminaVoucher" id="data-product-id_prodotto" class="delete row">
          <div class="voice last">
            <button type="submit" class="active-accent-button" name="id" value="${vou.id}">Elimina</button>
          </div>
        </form>

      </div>
    </div>
  </c:forEach>

  <cs:footer/>
</cs:layout>


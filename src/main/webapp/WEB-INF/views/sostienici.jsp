<%@ page import="java.util.HashMap" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="cs" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<cs:layout title="Sostienici" admin="false">
    <cs:header/>

    <section class="vh-100" style="height: 42%">
        <div class="container-fluid h-custom">
            <div class="row d-flex justify-content-center align-items-center h-100">



               <form action="checkout" name="sostieniciform" id="sostieniciform" method="get">

                   <!--Vouchers-->
                   <h1 name="voucher">
                       <c:forEach var="voucher" items="${listaVoucher}">
                            <li>
                                <c:out value="${voucher.getImporto()}"/>
                                <c:out value="${voucher.getDescrizione()}"/>
                            </li>
                       </c:forEach>
                   </h1>
                   <p id="voucherSelezionato"></p>

                   <div id="lifepog">
                       <p>Sostienici: </p>
                       <input oninput='numerator(event, ${listaGson})' type="number" class="currentlife" name="importo" max="10000" min="0" value="0">
                       <div id="lifeslash" contenteditable="false">
                           <p></p>
                       </div>
                       <input hidden oninput="denominator(event)" type="number" class="totallife" max="100" min="0" value="100">
                   </div>
                   <div class="lifebar">
                       <progress value="0" max="100" class="barlife"> </progress>
                   </div>

                   <button type="button" class="btn btn-primary btn-lg" name="confermaInput" onclick="validateInput()"
                           style="padding-left: 2.5rem; padding-right: 2.5rem; color: white">Conferma</button>


               </form>

        </div>
    </div>
</section>


    <cs:footer/>
</cs:layout>
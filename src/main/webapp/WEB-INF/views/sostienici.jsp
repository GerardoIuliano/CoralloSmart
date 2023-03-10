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
                   <div class="text-center">
                   <h1>Ecco i possibili voucher che potrai ricevere in cambio di un contributo!</h1>
                   <!--Vouchers-->
                   <div class="text-left">
                   <h3 name="voucher">
                       <c:forEach var="voucher" items="${listaVoucher}">
                           <li>
                               <i class="fas fa-gift"></i>
                               <c:out value="${voucher.getDescrizione()}"/>
                           </li>
                       </c:forEach>
                   </h3>
                   </div>
                   <div id="lifepog" style="padding-top: 20px">
                       <h2 style="color: black">Cosa aspetti, dai il tuo contributo! </h2>
                       <i class="fas fa-euro-sign" style="padding-right: 5px"></i><input oninput='numerator(event, ${listaGson})' type="number" class="currentlife" name="importo" max="10000" min="0" value="0">
                       <div id="lifeslash" contenteditable="false">
                           <p></p>
                       </div>
                       <input hidden oninput="denominator(event)" type="number" class="totallife" max="100" min="0" value="100">
                   </div>
                   <div class="lifebar" style="margin: auto">
                       <progress value="0" max="100" class="barlife" > </progress>
                   </div>

                   <button type="button" class="btn btn-primary btn-lg" name="confermaInput" onclick="validateInput()"
                           style="padding-left: 2.5rem; padding-right: 2.5rem; color: white">Conferma</button>

                   <h2><p style="color: green" id="voucherSelezionato" ></p></h2>
                   </div>
               </form>
        </div>
    </div>
</section>


    <cs:footer/>
</cs:layout>
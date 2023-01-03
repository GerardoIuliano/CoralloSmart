<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="cs" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<cs:layout title="Sostienici" admin="false">
    <cs:header/>

    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <h1 class="h3 mb-0 text-gray-800">Sostienici</h1>
    </div>

   <form action="checkout" name="sostieniciform" id="sostieniciform" method="get">
       <div id="lifepog">
           <input oninput="numerator(event)" type="number" class="currentlife" name="importo" max="10000" min="0" value="0">
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




    <cs:footer/>
</cs:layout>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="cs" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<cs:layout title="Sostienici" admin="false">
    <cs:header/>

    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <h1 class="h3 mb-0 text-gray-800">Sostienici</h1>
    </div>

   <form action="checkout" name="sostieniciform" id="sostieniciform" method="get">
        <div class="progress">
         <div class="progress-done">

        </div>

        </div>

        <div class="inputContainer">
            <div>
              <h3>Importo €</h3>
                 <input class="input" type="number"/>
            </div>
        </div>
       <button type="submit" class="btn btn-primary btn-lg"
               style="padding-left: 2.5rem; padding-right: 2.5rem; color: white">Conferma</button>

   </form>




    <cs:footer/>
</cs:layout>
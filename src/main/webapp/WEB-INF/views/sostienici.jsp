<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="cs" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" href="src/main/webapp/css/style.css">
<cs:layout title="Sostienici" admin="false">
    <cs:header/>

    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <h1 class="h3 mb-0 text-gray-800">Sostienici</h1>
    </div>

   <form action="" name="sostieniciform" id="sostieniciform" method="get">
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
   </form>

    <script src="src/main/webapp/js/progress.js"></script>


    <cs:footer/>
</cs:layout>
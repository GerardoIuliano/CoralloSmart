<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="cs" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<cs:layout title="Sostienici" admin="false">
    <cs:header/>

    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <h1 class="h3 mb-0 text-gray-800">Sostienici</h1>
    </div>

    <form class="form-inline" action="">
        <div class="form-group mb-2">
            <label for="staticEmail2" class="sr-only">Email</label>
            <input type="text" readonly class="form-control-plaintext" id="staticEmail2" value="Importo €">
        </div>
        <div class="form-group mx-sm-3 mb-2">
            <label for="inputPassword2" class="sr-only">Password</label>
            <input type="number" class="form-control" id="inputPassword2" placeholder="40,00">
        </div>
        <button type="submit" class="btn btn-primary mb-2">Conferma</button>
    </form>

    <div class="container">
        <div class="progress">
            <div class="progress-bar progress-bar-success" role="progressbar" style="width:33%">

            </div>
            <div class="progress-bar progress-bar-warning" role="progressbar" style="width:33%">

            </div>
            <div class="progress-bar progress-bar-danger" role="progressbar" style="width:34%">

            </div>
        </div>
    </div>
















    <cs:footer/>
</cs:layout>
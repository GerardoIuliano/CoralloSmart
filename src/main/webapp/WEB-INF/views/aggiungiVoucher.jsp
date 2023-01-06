<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="cs" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<cs:layout title="AggiungiVoucher"/>

<div id="wrapper">
    <cs:sidebarArpa/>
    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column " style="padding: 20px">
        <!-- Main Content -->
        <div class=section-top-border">
            <h3>Aggiungi Voucher</h3>
            <div>
                <form action="clickAggiungiVoucher" name="VoucherForm" id="VoucherForm" method="post">
                    <div class="form-group">
                        <label for="descrizione">Inserisci la descrizione del Voucher:</label>
                        <input type="text" class="form-control" name="descrizione" id="descrizione" placeholder="Descrizione">
                    </div>
                    <div class="form-group">
                        <label for="importo">Inserisci l'importo minimo da versare per ottenere il Voucher:</label>
                        <input type="text" class="form-control" name="importo" id="importo" placeholder="Importo">
                    </div>
                    <button type="submit" class="btn btn-primary">Aggiungi Voucher</button>
                </form>
            </div>
        </div>
    </div>
</div>


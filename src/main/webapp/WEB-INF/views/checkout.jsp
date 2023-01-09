<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="cs" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<cs:layout title="Checkout" admin="false">


<html lang="it">
<head>
    <meta charset="utf-8">
    <meta name="robots" content="noindex, nofollow">

    <title>Checkout</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">


</head>
<body>

<section>
    <!-- Logo -->
    <div class="col-xl-2 col-lg-2 col-md-1">
        <div style="padding: 15px">
            <a href="index"><img src="<c:url value="/images/logoCoralloSmart.png"/>" width="120px" height="120px"
                                 alt=""></a>
        </div>
    </div>
</section>

<section class="vh-100" style="height: 42%">
    <div class="container-fluid h-custom">
        <div class="row d-flex justify-content-center align-items-center h-100">


<div class='container'>
    <div class='row' style='padding-top:25px; padding-bottom:25px;'>
        <div class='col-md-12'>
            <div id='mainContentWrapper'>
                <div class="col-md-8 col-md-offset-2">
                    <h2 style="text-align: center;">
                        RIVEDI LE INFORMAZIONI INSERITE E COMPLETA IL CHECKOUT
                    </h2>

                    <div class="shopping_cart">


                        <!--form-->
                        <form class="form-horizontal" role="form" action="operazioneCompletata" method="post" id="payment-form" name="formPagamento">



                            <div class="panel-group" id="accordion">
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <h4 class="panel-title">
                                            <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne">Review
                                                Your Order</a>
                                        </h4>
                                    </div>
                                    <div id="collapseOne" class="panel-collapse collapse in">
                                        <div class="panel-body">
                                            <div class="items">
                                                <div class="col-md-9">
                                                    <table class="table table-striped">
                                                        <tr>
                                                            <td>
                                                                <ul>
                                                                    <c:choose>
                                                                        <c:when test="${isVoucher != null}">
                                                                            <c:choose>
                                                                                <c:when test="${isVoucher == true}">
                                                                                    <li>VOUCHER:</li>
                                                                                    <li>${voucher.getImporto()}</li>
                                                                                    <li>${voucher.getDescrizione()}</li>
                                                                                </c:when>
                                                                            </c:choose>
                                                                        </c:when>
                                                                    </c:choose>

                                                                </ul>
                                                            </td>
                                                            <td>
                                                                <b></b>
                                                            </td>
                                                        </tr>
                                                    </table>
                                                </div>
                                                <div class="col-md-3">
                                                    <div style="text-align: center;">
                                                        <h3>Contributo da versare</h3>
                                                        <h4><span style="color:green;">importo: ${importo} €</span></h4>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                </div>
                            </div>

                            </div>
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <h4 class="panel-title">

                                    </h4>
                                </div>

                                    <div class="panel-body">
                                        <span class='payment-errors'></span>
                                        <fieldset>
                                            <legend>Quale metodo di pagamneto scegli?</legend>
                                            <div class="form-group">
                                                <label class="col-sm-3 control-label" for="name-on-card">Name on
                                                    Card</label>
                                                <div class="col-sm-9">



                                                    <!--Name on Card-->
                                                    <input type="text" class="form-control" stripe-data="name" name="nome" oninput="validaCardName('formPagamento')"
                                                           id="nome" placeholder="Card Holder's Name" required name="nome">





                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-3 control-label" for="card-number">Card
                                                    Number</label>
                                                <div class="col-sm-9">



                                                    <!--Card Number-->
                                                    <input type="text" class="form-control" stripe-data="number" oninput="validaNumeroCarta('formPagamento')"
                                                           id="card-number" placeholder="Debit/Credit Card Number" required name="card-number">




                                                    <br/>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-3 control-label" for="card-exp-month">Expiration
                                                        Date</label>
                                                    <div class="col-sm-9">
                                                        <div class="row">
                                                            <div class="col-xs-3">




                                                                <!--Expiration Date-->
                                                                <select class="form-control col-sm-2" oninput="validaExpMonth('formPagamento')"
                                                                        data-stripe="exp-month" id="card-exp-month"
                                                                        style="margin-left:5px;" required name="expMonth">
                                                                    <option>Month</option>
                                                                    <option value="01">1</option>
                                                                    <option value="02">2</option>
                                                                    <option value="03">3</option>
                                                                    <option value="04">4</option>
                                                                    <option value="05">5</option>
                                                                    <option value="06">6</option>
                                                                    <option value="07">7</option>
                                                                    <option value="08">8</option>
                                                                    <option value="09">9</option>
                                                                    <option value="10">10</option>
                                                                    <option value="11">11</option>
                                                                    <option value="12">12</option>
                                                                </select>






                                                            </div>
                                                            <div class="col-xs-3">




                                                                <!--Expiration Date-->
                                                                <select class="form-control" data-stripe="exp-year" oninput="validaExpYear('formPagamento')"
                                                                        id="card-exp-year" required name="expYear">
                                                                    <option value="2023">2023</option>
                                                                    <option value="2024">2024</option>
                                                                    <option value="2025">2025</option>
                                                                    <option value="2026">2026</option>
                                                                    <option value="2027">2027</option>
                                                                    <option value="2028">2028</option>
                                                                    <option value="2029">2029</option>
                                                                    <option value="2030">2030</option>
                                                                    <option value="2031">2031</option>
                                                                </select>





                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-3 control-label" for="card-cvc">Card CVC</label>
                                                    <div class="col-sm-3">







                                                        <!--Card CVC-->
                                                        <input type="text" class="form-control" stripe-data="cvc" oninput="validaCVV('formPagamento')"
                                                               id="card-cvc" placeholder="Security Code" required name="card-cvc">








                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-sm-offset-3 col-sm-9">
                                                    </div>
                                                </div>
                                            </div>
                                        </fieldset>

                                        <button type="button" class="btn btn-success btn-lg" style="width:100%;" name="pagaBtn" onclick="checkPaymentForm('formPagamento')">Paga
                                            Ora
                                        </button>
                                        <br/>
                                        <div style="text-align: left;"><br/>
                                            By submiting this order you are agreeing to our <a href="/legal/billing/">universal
                                                billing agreement</a>, and <a href="/legal/terms/">terms of service</a>.
                                            If you have any questions about our products or services please contact us
                                            before placing this order.
                                        </div>
                                    </div>

                            </div>
                        </form>
                    </div>
                </div>
                </form>
            </div>
        </div>
    </div>
</div>
        </div>
    </div>
</section>
</body>

</html>

</cs:layout>
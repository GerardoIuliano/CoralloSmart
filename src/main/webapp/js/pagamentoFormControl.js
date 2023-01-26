const statoField = {
    START: 2,
    TRUE: true,
    FALSE: false,
};


var nomeCartaOK=statoField.START;
var numeroCartaOK=statoField.START;
var expMonthOk=statoField.START;
var expYearOK= statoField.START;
var cvvOk= statoField.START;


function validaCardName(form) {
    var input = document.forms[form]['nome'];
    if (input.value.length > 7 && input.value.length <= 60 && input.value.match(/^[A-Z][a-z]+\s[A-Z][a-z]+$/)) {
        input.style.border = borderOk;
        nomeCartaOK = true;
    } else {
        input.style.border = borderNo;
        numeroCartaOK = false;
    }
}


function validaNumeroCarta(form) {
    var input = document.forms[form]['card-number'];
    if (input.value.length > 0 && input.value.length <= 30 && input.value.match(/^(?:4[0-9]{12}(?:[0-9]{3})?|[25][1-7][0-9]{14}|6(?:011|5[0-9][0-9])[0-9]{12}|3[47][0-9]{13}|3(?:0[0-5]|[68][0-9])[0-9]{11}|(?:2131|1800|35\d{3})\d{11})$/)) {
        input.style.border = borderOk;
        numeroCartaOK = true;
    } else {
        input.style.border = borderNo;
        numeroCartaOK = false;
    }
}

function validaExpMonth(form) {
    var input = document.forms[form]['expMonth'];
    if (input.value != null) {
        input.style.border = borderOk;
        expMonthOk = true;
    } else {
        input.style.border = borderNo;
        expMonthOk = false;
    }
}


function validaExpYear(form) {
    var input = document.forms[form]['expYear'];
    if (input.value != null) {
        input.style.border = borderOk;
        expYearOK = true;
    } else {
        input.style.border = borderNo;
        expYearOK = false;
    }
}


function validaCVV(form) {
    var input = document.forms[form]['card-cvc'];
    if (input.value.match(/^[0-9]{3,4}$/)) {
        input.style.border = borderOk;
        cvvOk = true;
    } else {
        input.style.border = borderNo;
        cvvOk = false;

    }

}


function checkPaymentForm(form) {

    if (nomeOk != false & numeroCartaOK != false & expMonthOk != false & expYearOK != false & cvvOk != false) {
        var payBtn = document.forms[form]['pagaBtn'];
        payBtn.type = "submit";

        var message = document.forms[form]['message'];
        message.innerHTML = '';
    } else {
        var submitBtn = document.forms[form]['submit'];
        submitBtn.type = "button";

        var message = document.querySelector('.message');
        message.innerHTML = 'Verifica che tutti i campi siano correttamente compilati';
    }
}

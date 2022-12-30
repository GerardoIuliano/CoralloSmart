//Funzioni javascript per validare i campi del form di registrazione turista

var borderOk = '2px solid #070';
var borderNo = '2px solid #f00';
var usernameOk = false;
var passwordOk = false;
var nomeOk = false;
var emailOk = false;
var cognomeOk = false;

function validaUsername() {
    var input = document.forms['registrationForm']['username'];
    if (input.value.length >= 6 && input.value.match(/^[0-9a-zA-Z]+$/)) {
        input.style.border = borderOk;
        usernameOk = true;
    } else {
        input.style.border = borderNo;
        usernameOk = false;
    }
    cambiaStatoRegistrami();
}

function validaPassword() {
    var inputpw = document.forms['registrationForm']['password'];
    var inputpwconf = document.forms['registrationForm']['passwordConferma'];
    var password = inputpw.value;
    if (password.length >= 8 && password.toUpperCase() != password
        && password.toLowerCase() != password && /[0-9]/.test(password)) {
        inputpw.style.border = borderOk;

        if (password == inputpwconf.value) {
            inputpwconf.style.border = borderOk;
            passwordOk = true;
        } else {
            inputpwconf.style.border = borderNo;
            passwordOk = false;
        }
    } else {
        inputpw.style.border = borderNo;
        inputpwconf.style.border = borderNo;
        passwordOk = false;
    }
    cambiaStatoRegistrami();
}

function validaNome() {
    var input = document.forms['registrationForm']['nome'];
    if (input.value.trim().length > 0 && input.value.match(/^[ a-zA-Z\u00C0-\u00ff]+$/)) {    //escludiamo caratteri accentati, numeri e caratteri speciali
        input.style.border = borderOk;
        nomeOk = true;
    } else {
        input.style.border = borderNo;
        nomeOk = false;
    }
    cambiaStatoRegistrami();
}

function validaCognome() {
    var input = document.forms['registrationForm']['cognome'];
    if (input.value.trim().length > 0 && input.value.match(/^[ a-zA-Z\u00C0-\u00ff]+$/)) {
        input.style.border = borderOk;
        cognomeOk = true;
    } else {
        input.style.border = borderNo;
        cognomeOk = false;
    }
    cambiaStatoRegistrami();
}

function validaEmail() {
    var input = document.forms['registrationForm']['email'];
    if (input.value.match(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w+)+$/)) {
        input.style.border = borderOk;
        emailOk = true;
    } else {
        input.style.border = borderNo;
        emailOk = false;
    }
}

//TODO capire perché il messaggio non viene visualizzato
function chekRegistrationForm() {
    if (emailOk) {
        var submitBtn = document.forms['registrationForm']['submit'];
        submitBtn.type = "submit";

        var message = document.forms['registrationForm']['message'];
        message.value = '';
    } else {
        var submitBtn = document.forms['registrationForm']['submit'];
        submitBtn.type = "button";

        var message = document.forms['registrationForm']['message'];
        message.value = '*Verifica che tutti i campi siano correttamente compilati*';
    }
}

function test(){
    var input = document.forms['registrationForm']['submit'];
    if(true){
        document.forms['registrationForm']['message'].value = 'è stato premuto';
    }else{
        input.type = "submit";
    }
}

/**funzione per i suggerimenti la ricerca con ajax
 function ricerca(valore) {
    var datalist = document.getElementById("ricerca_datalist");
    if (valore.length == 0) {        //nessun suggerimento, l'utente ha iniziato a digitare e poi ha cancellato
        datalist.innerHTML = "";
        return;
    }

    var xhttp = new XMLHttpRequest();
    xhttp.responseType = "json";
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            datalist.innerHTML = "";        //cancello contenuto attuale del datalist

            for (var i in this.response) {
                var option = document.createElement("option");
                option.value = this.response[i];
                datalist.appendChild(option);
            }
        }
    };
    xhttp.open("GET", "servlet_ricerca_ajax?query=" + encodeURIComponent(valore), true);
    xhttp.send();
}
 $('.deleteLido').on('click', function () {
    return confirm('Sei sicuro di voler cancellare questo lido?');
});
 */
function validaNewPassword() {
    var input = document.forms['modificaCredenzialiForm']['newPassword'];
    var password = input.value;
    if (password.length >= 8 && password.toUpperCase() != password
        && password.toLowerCase() != password && /[0-9]/.test(password)) {
        input.style.border = borderOk;
    } else {
        input.style.border = borderNo;
    }
}

function validaOldPassword() {
    var input = document.forms['modificaCredenzialiForm']['oldPassword'];
    var password = input.value;
    if (password.length >= 8 && password.toUpperCase() != password
        && password.toLowerCase() != password && /[0-9]/.test(password)) {
        input.style.border = borderOk;
    } else {
        input.style.border = borderNo;
    }
}
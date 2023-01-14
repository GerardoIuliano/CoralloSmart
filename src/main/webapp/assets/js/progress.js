//Select the progress bar by its class
const progress = document.querySelector('.barlife');

// Set the progress bar's value based off the top input
const numerator = (e, listaGson) => {
    importo = e.target.value;
    progress.value = importo;
    voucherSelezionato = document.getElementById("voucherSelezionato");
    var voucherSbloccato
    listaGson.sort((a,b) => a.importo - b.importo)
    voucherSbloccato = checkVoucher(listaGson, importo)
    if(voucherSbloccato != null){
        voucherSelezionato.innerHTML = "Con questo contributo riceverai il voucher: "+voucherSbloccato["descrizione"]
    }else{
        voucherSelezionato.innerHTML = ""
    }
}

// Set the progress bars max value based off the bottom input
const denominator = (e) => {
    progress.max = e.target.value;

}

function checkVoucher(list, imp){
    var voucher = null
    list.forEach(v => {
        if(imp >= v["importo"]){
            voucher = v
        }
    })
    return voucher
}
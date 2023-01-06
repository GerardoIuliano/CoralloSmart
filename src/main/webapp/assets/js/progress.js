//Select the progress bar by its class
const progress = document.querySelector('.barlife');

// Set the progress bar's value based off the top input
const numerator = (e, listaGson) => {
    importo = e.target.value;
    console.log(importo);

    progress.value = importo;

    voucherSelezionato = document.getElementById("voucherSelezionato");
    console.log("lista voucher: " + listaGson);
    /*for(var voucher in listaGson){
        console.log("voucher: " + voucher);
        if(voucher.importo >= importo){
            voucherSelezionato.innerHTML = voucher.importo;
        }
    }*/
}

// Set the progress bars max value based off the bottom input
const denominator = (e) => {
    progress.max = e.target.value;

}

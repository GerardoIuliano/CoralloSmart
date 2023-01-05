//Select the progress bar by its class
const progress = document.querySelector('.barlife');

// Set the progress bar's value based off the top input
const numerator = (e, listaGson) => {
    progress.value = e.target.value;
    console.log(e.target.value);
    voucherSelezionato = document.getElementById("voucherSelezionato");
    for(var voucher in listaGson){
        if(voucher.importo >= e.target.value){
            voucherSelezionato.innerHTML = voucher.importo;
        }
    }
}

// Set the progress bars max value based off the bottom input
const denominator = (e) => {
    progress.max = e.target.value;

}

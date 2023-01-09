const imp=document.querySelector('.currentlife');
function validateInput(){
    if(imp.value>0){
        var submitBtn = document.forms["sostieniciform"]['confermaInput'];
        submitBtn.type = "submit";}
    else{

        alert ( "L'importo deve essere maggiore di 0" );
        imp.focus();




    }

}
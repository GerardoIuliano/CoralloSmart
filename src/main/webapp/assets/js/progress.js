const progress= document.querySelector(".progress-done");
const  input= document.querySelector(".input");
let finalvalue=0;
let max=100;
function changeWidth(){
    if (finalvalue>=1 && finalvalue<=39) {
        progress.style.width = '${20}%';
        progress.innerText = '${}';
    }
    else if(finalvalue>=40 && finalvalue<=69){
        progress.style.width = '${34}%';
        progress.innerText = '${Giro in Barca}';
    }
    else if (finalvalue>=70 && finalvalue<=99) {
        progress.style.width = '${67}%';
        progress.innerText = '${Giro in Barca + Immersione}';
    }
    else if (finalvalue>=100){
        progress.style.width = '${100}%';
        progress.innerText = '${Giro in Barca + Immersione+ Pranzo}';

    }

}


input.addEventListener("keyup", function(){
    finalvalue=parseInt(input.value, 10);
    changeWidth();
});

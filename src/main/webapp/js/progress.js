const progress= document.querySelector(".progress-done");
const  input= document.querySelector(".input");
let finalvalue=0;
let max=100;
function changeWidth(){
    progress.style.width='${(finalvalue/max)*100}%';
    progress.innerText='${Math.ceil((finalvalue/max)*100)}%';

}


input.addEventListener("keyup", function(){
    finalvalue=parseInt(input.value, 10);
    changeWidth();
});

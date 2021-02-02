
document.addEventListener("DOMContentLoaded", ()=>{

    animacion();
});

function animacion(){
    const tiempo = document.querySelector('#num');
    const cont = document.querySelector('.contador');
    const iniciar = document.querySelector('#iniciar');
    const parar = document.querySelector('#parar');

    let si;

    iniciar.addEventListener('click', ()=>{
        let t = tiempo.value;
        cont.style.color = 'black';
        if (t >= 0 && isNaN()){
            si = setInterval(() => {
                cont.innerHTML = t;
                t--;
                if (t<0){
                    cont.style.color = 'red';
                    clearInterval(si);
                }
            }, 1000);
        }else if (t < 0 && isNaN()){
            alert('No es un número positivo');
        }else{
            alert('No es un número');
        }
        
    });

    parar.addEventListener('click', ()=>{
        cont.style.color = 'red';
        clearInterval(si);
    });

}

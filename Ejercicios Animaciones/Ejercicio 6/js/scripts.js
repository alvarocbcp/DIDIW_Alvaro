document.addEventListener("DOMContentLoaded", ()=>{
    animacion();
});

function animacion(){
    
    var item = document.querySelector('.movil');
    var contenedor = document.querySelector('.fijo');

    var leftRight = 0;
    var upDown = 0;


    document.addEventListener('keypress', (event)=>{
        var num = document.querySelector('.num').value;
        if(event.code == 'KeyW'){
            //Up
            upDown -= parseInt(num);
            item.style.top = upDown + "px";
            item.style.transition = '2ms';
        }
        else if(event.code == 'KeyS'){
            //Down
            upDown += parseInt(num);
            item.style.top = upDown + "px";
            item.style.transition = '2ms';
        }
        else if(event.code == 'KeyA'){
            //Left
            leftRight -= parseInt(num);
            item.style.left = leftRight + "px";
            item.style.transition = '2ms';
        }
        else if(event.code === 'KeyD'){
            //Right
            leftRight += parseInt(num);
            item.style.left = leftRight + "px";
            item.style.transition = '2ms';
        }
    });

  setInterval(() => {
      localizar(contenedor, item);
  }, 2);
    
}
function localizar(contenedor, item){
    let contenedorL = contenedor.getBoundingClientRect().left;
    let contenedorR = contenedor.getBoundingClientRect().right;
    let contenedorT = contenedor.getBoundingClientRect().top;
    let contenedorB = contenedor.getBoundingClientRect().bottom;

    let itemL = item.getBoundingClientRect().left;
    let itemR = item.getBoundingClientRect().right;
    let itemT = item.getBoundingClientRect().top;
    let itemB = item.getBoundingClientRect().bottom;

    if(itemL>contenedorL && itemR<contenedorR && itemT>contenedorT && itemB<contenedorB){
        item.style.backgroundColor = "royalblue";
    }else{
        item.style.backgroundColor = "greenyellow";
    }
}
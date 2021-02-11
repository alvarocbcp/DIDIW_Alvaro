//Imports de otros ficheros js
import { actualizar as actualizarSnake, dibujar as dibujarSnake, SNAKE_SPEED, getSnakeHead, snakeIntersection } from './snake.js';
import { actualizar as actualizarApple, dibujar as dibujarApple } from './apple.js';
import { outsideGrid } from './grid.js';

document.addEventListener('DOMContentLoaded',()=>{
    console.log("DOM cargado");
    aplicacion();
});

function aplicacion(){

    var juego = document.querySelector(".container-juego");

    class ElementoIntroduccion extends HTMLElement{
        constructor(){
            super();

            this.attachShadow({mode : "open"});
            
            this.templateIntro = document.querySelector("#intro");

            this.instrucciones = document.importNode(this.templateIntro.content, true);

        }

        connectedCallback(){
            this.shadowRoot.appendChild(this.instrucciones);
            var start = this.shadowRoot.querySelector(".boton-start");
            start.addEventListener('click', ()=>{
                this.empezar();
            })
        }

        empezar(){
            var botonEmpezar = this.shadowRoot.querySelector(".boton-start");
            this.shadowRoot.querySelector(".container-instrucciones").style.display = "none";
        }
    }

    customElements.define('elemento-introduccion', ElementoIntroduccion);
    

    //Funciones juego
    let lastRenderTime = 0;
    let gameOver = false;
    const tablero = document.getElementById('tablero');

    document.addEventListener('keydown', e=>{
        switch(e.key){
            case 'ArrowUp':
                break
            case 'ArrowDown':
                break
            case 'ArrowLeft':
                break
            case 'ArrowRight':
                break
            default:
                function principal(currentTime){
                    if(gameOver){
                        return
                    }
                    window.requestAnimationFrame(principal);
                    const secondsSinceLastRender = (currentTime - lastRenderTime) / 1000;
                    if(secondsSinceLastRender < 1 / SNAKE_SPEED) return;
                    console.log("Render");
                    lastRenderTime = currentTime;  
                    
                    actualizar();
                    dibujar();
                }
            
                window.requestAnimationFrame(principal);
            
                function actualizar(){
                    actualizarSnake();
                    actualizarApple();
                    checkMuerte();
                }
            
                function dibujar(){
                    tablero.innerHTML = '';
                    dibujarSnake(tablero);
                    dibujarApple(tablero);
                }
            
                function checkMuerte(){
                    gameOver = outsideGrid(getSnakeHead()) || snakeIntersection()
                }
        }
        
    })
    

    
}
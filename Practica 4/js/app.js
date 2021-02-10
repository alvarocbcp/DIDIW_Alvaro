document.addEventListener('DOMContentLoaded',()=>{
    console.log("DOM cargado");
    aplicacion();
});

function aplicacion(){

    class ElementoIntroduccion extends HTMLElement{
        constructor(){
            super();

            this.attachShadow({mode : "open"});
            
            this.templateIntro = document.querySelector("#intro");

            this.instrucciones = document.importNode(this.templateIntro.content, true);

        }

        connectedCallback(){
            this.shadowRoot.appendChild(this.instrucciones);
            this.shadowRoot.querySelector(".boton-start").addEventListener('click', ()=>{
                this.empezar();
            })
        }

        empezar(){
            var botonEmpezar = this.shadowRoot.querySelector(".boton-start");
            this.shadowRoot.querySelector(".container-instrucciones").style.display = "none";
        }
    }

    customElements.define('elemento-introduccion', ElementoIntroduccion);

    class ElementoJuego extends HTMLElement{
        constructor(){
            super();

            this.attachShadow({mode : "open"});

            this.templateJuego = document.querySelector("#juego");
            this.juego = document.importNode(this.templateJuego.content, true);
        }

        connectedCallback(){
            this.shadowRoot.appendChild(this.juego);
        }
    }

    customElements.define('elemento-juego', ElementoJuego);
}
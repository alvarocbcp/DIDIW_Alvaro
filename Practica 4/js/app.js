document.addEventListener('DOMContentLoaded',()=>{
    console.log("DOM cargado");
    aplicacion();
});

function aplicacion(){

    class MyCustomElement extends HTMLElement{
        constructor(){
            super();
            this.textContent = "Mi custom element";
        }
    }

    customElements.define('my-custom-element', MyCustomElement);
}
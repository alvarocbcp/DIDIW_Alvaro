
document.addEventListener('DOMContentLoaded', () => {
    console.log('DOM Cargado!');
    animacion();
});


function animacion(){
    const items = document.querySelectorAll('.parr');

    let to;
    let i = 1;

    items.forEach(item => {
        to = setTimeout(() => {
            item.style.display = 'block';
        }, 1000 * i);
        i++;

        item.addEventListener('click', () => {
            i = 0;
            clearTimeout(to);
            ocultar(items);
        });
    });

    function ocultar(items){
        items.forEach(item => {
            item.style.display = 'none';
        });
        animacion();
    }
}

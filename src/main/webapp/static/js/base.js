
var btn = document.querySelectorAll('.button__add-cart');
btn.forEach(item =>{
    item.addEventListener('mouseover', ()=> {

        var icon = item.querySelectorAll('.button__icon')
        icon.forEach(i=>{
            i.classList.add('fa-bounce');
        })
    });

    item.addEventListener('mouseout', function() {
        var icon = item.querySelectorAll('.button__icon')
        icon.forEach(i=>{
            i.classList.remove('fa-bounce');
            i.classList.remove('fa-cart-circle-check');
            i.classList.add('fa-cart-shopping');
        })
        item.style.backgroundColor = '#181818';
    });
    item.addEventListener('click', function() {
        var icon = item.querySelectorAll('.button__icon')
        icon.forEach(i=>{
            i.classList.remove('fa-cart-shopping');
            i.classList.add('fa-cart-circle-check');
        })
        item.style.backgroundColor = '#261CE9';

    });
});


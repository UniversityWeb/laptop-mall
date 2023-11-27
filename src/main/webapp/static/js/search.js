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

var resetIcon = document.getElementById('reset-icon');

resetIcon.addEventListener('click', function() {
    resetIcon.classList.add('fa-spin')
})
resetIcon.addEventListener('mouseout', function() {
    resetIcon.classList.remove('fa-spin')
})

const inputElement = document.getElementById('input-element');
var clearbtn = document.getElementById('clear-btn-search')
inputElement.addEventListener('input', function(event) {
    clearbtn.style.opacity = '100%'
    clearbtn.style.cursor='pointer'
    if (inputElement.value == ''){
        clearbtn.style.opacity = '0%'
    }
});

clearbtn.addEventListener('click',()=>{
    inputElement.value=''
    clearbtn.style.opacity= '0%'
})

var sortBtn = document.getElementById('sort-btn')
var sortContain =  document.getElementById('sort-container')
sortBtn.addEventListener('mouseover',()=>{
    if(sortContain.style.display=='flex')
        sortContain.style.display='none'
    else
        sortContain.style.display='flex'

})

sortBtn.addEventListener('mouseout',()=>{
    sortContain.style.display='none'
})

var swiper = new Swiper(".mySwiper", {
    pagination: {
        el: ".swiper-pagination",
        clickable: true,
        renderBullet: function (index, className) {
            return '<span class="' + className + '">' + (index + 1) + "</span>";
        },
    },
});


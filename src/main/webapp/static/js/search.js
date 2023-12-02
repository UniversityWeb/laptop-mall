

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

//

function filterProducts() {
    var priceFilter = document.getElementsByName('priceFilter')
    var selectedPrice = null;
    for (var i = 0; i < priceFilter.length; i++) {
        if (priceFilter[i].checked) {
            selectedPrice = priceFilter[i].value;
            break;
        }
    }
    console.log(selectedPrice)
    var productList = document.getElementById("productList");
    var products = productList.getElementsByClassName("search__product-result");

    for (var i = 0; i < products.length; i++) {
        var product = products[i];
        var productPrice = parseInt(product.querySelector(".product__price").textContent);

        if (selectedPrice === "all" || productPrice <= parseInt(selectedPrice)) {
            product.style.display = "flex";
        } else {
            product.style.display = "none";
        }
    }

}


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



// Get brand name

var brandElements = document.querySelectorAll('#productList .product__brand');
var brands = new Set();
brandElements.forEach(function(brandElement) {
    brands.add(brandElement.value);
});

var brandSelect = document.getElementById('brandSelect');
brands.forEach(function(brand) {
    var option = document.createElement('option');
    option.value = brand;
    option.text = brand;
    brandSelect.add(option);
});

// Filter brand name
var allBrands = Array.from(brandElements).map(function(brandElement) {
    return brandElement.value;
});
brandSelect.addEventListener('change', function () {
    var selectedBrand = brandSelect.value;

    brandElements.forEach(function(brandElement, index) {
        var productItem = brandElement.closest('.search__product-result');
        if (selectedBrand === 'All' || brandElement.value === selectedBrand) {
            productItem.style.display = 'flex';
        } else {
            productItem.style.display = 'none';
        }
    });
});

// category

var categoryElements = document.querySelectorAll('#productList .product__category');
var allCategorys = Array.from(categoryElements).map(function(categoryElement) {
    return categoryElement.value;
});

var categorySelect = document.getElementById('categorySelect');

categorySelect.addEventListener('change', function () {
    var selectedCategory = categorySelect.value;

    categoryElements.forEach(function(categoryElement, index) {
        console.log(categoryElement.value)
        var productItem = categoryElement.closest('.search__product-result');
        if (selectedCategory === 'All' || convertCategoryName(categoryElement.value) === selectedCategory) {
            productItem.style.display = 'flex';
        } else {
            productItem.style.display = 'none';
        }
    });
});

function  convertCategoryName(eName){
    if (eName == 'LAPTOP')
        return 'Laptop'
    if (eName == 'MECHANICAL_KEYBOARD')
        return 'Keyboard'
    if (eName == 'MONITOR')
        return 'Monitor'
}

// Sort

var productElements = document.querySelectorAll('#productList .search__product-result');

var sortLtoH = document.getElementById('sortLtoH');
var sortHtoL = document.getElementById('sortHtoL');
var sortAtoZ = document.getElementById('sortAtoZ');
var sortZtoA = document.getElementById('sortZtoA');

sortLtoH.addEventListener('click', function () {
    sortProducts('asc');
});

sortHtoL.addEventListener('click', function () {
    sortProducts('desc');
});

sortAtoZ.addEventListener('click', function () {
    sortProducts('asc', 'name');
});

sortZtoA.addEventListener('click', function () {
    sortProducts('desc', 'name');
});

function sortProducts(order, sortBy = 'price') {
    var sortedProducts = Array.from(productElements).sort(function (a, b) {
        var valueA, valueB;

        if (sortBy === 'price') {
            valueA = parseFloat(a.querySelector('.product__price').textContent);
            valueB = parseFloat(b.querySelector('.product__price').textContent);
        } else if (sortBy === 'name') {
            valueA = a.querySelector('.product__name').textContent;
            valueB = b.querySelector('.product__name').textContent;
        }

        if (order === 'asc') {
            return valueA - valueB;
        } else {
            return valueB - valueA;
        }
    });

    productElements.forEach(function (productElement) {
        productElement.remove();
    });

    sortedProducts.forEach(function (sortedProduct) {
        document.getElementById('productList').appendChild(sortedProduct);
    });
}

/// reset

document.getElementById('reset-icon').addEventListener('click', () => {
    document.querySelectorAll('select').forEach(s=>{
        s.value = 'All';
        s.item(0).selected=true
    })
    location.reload(true)
    document.getElementById('radio-price0').checked = true;
});
var imageItems = document.querySelectorAll(".prod_img-item")
var prodImgFull = document.getElementById('prod_img-full');
var itemSeletedIndex = 0
var backImgProd = document.getElementById('backImgProd')
var nextImgProd = document.getElementById('nextImgProd')
prodImgFull.src = imageItems[0].querySelector('img').src

imageItems.forEach(function(item,index){
    item.addEventListener('click', function() {
        itemSeletedIndex = index
        prodImgFull.src = imageItems[index].querySelector('img').src
        highLightItem()
    });
});

backImgProd.addEventListener('click',()=>{
    itemSeletedIndex -=1
    if (itemSeletedIndex <0) {
        itemSeletedIndex = imageItems.length-1
    }
    prodImgFull.src = imageItems[itemSeletedIndex].querySelector('img').src
    highLightItem()
})

nextImgProd.addEventListener('click',()=>{
    itemSeletedIndex +=1
    if (itemSeletedIndex >= imageItems.length) {
        itemSeletedIndex = 0
    }
    prodImgFull.src = imageItems[itemSeletedIndex].querySelector('img').src
    highLightItem()
})


function highLightItem(){
    imageItems.forEach(function(item,index){
        if(itemSeletedIndex == index)
            item.querySelector('img').classList.add("prod_img-item-selected")
        else
            item.querySelector('img').classList.remove("prod_img-item-selected")
    })
}

function copyToClipboard() {
    var copyText = document.getElementById("prod-id");
    copyText.select();
    document.execCommand("copy");
    alert("PRODUCT ID: " + copyText.value);
}


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

var inputElement = document.getElementById('inputMount')
var buttonElementAdd = document.getElementById('plusBtn')
var buttonElementMinus = document.getElementById('subBtn')
buttonElementAdd.addEventListener('click', function () {
    var currentValue = parseInt(inputElement.value);
    currentValue++;
    inputElement.value = currentValue;
});
buttonElementMinus.addEventListener('click', function () {
    var currentValue = parseInt(inputElement.value);
    if(currentValue>0){
        currentValue--;
    }
    else {
        currentValue = 0;
    }
    inputElement.value = currentValue;
});

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
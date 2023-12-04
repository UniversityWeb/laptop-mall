// var imgList = document.getElementById("imgList")
// var imgInput  = document.getElementById("imgInput")
// imgInput.onchange = (e)=>{
//     for (i =0; i<imgInput.files.length;i++){
//         var newItem = document.createElement("li");
//
//         newItem.innerHTML = `
//         <div class="img-bottom">
//             <i class="delete-icon fa-solid fa-trash"></i>
//         </div>
//         <img src="${URL.createObjectURL(imgInput.files[i])}" alt="">
//     `;
//         newItem.classList.add("img-item");
//         imgList.appendChild(newItem);
//     }
// }
//
//Search JS
const inputElementProd = document.getElementById('input-element-prod');
var clearbtnProd = document.getElementById('clear-btn-search-prod')
inputElementProd.addEventListener('input', function(event) {
    clearbtnProd.style.opacity = '100%'
    clearbtnProd.style.cursor='pointer'
    if (inputElementProd.value == ''){
        clearbtnProd.style.opacity = '0%'
    }
});

clearbtnProd.addEventListener('click',()=>{
    inputElementProd.value=''
    clearbtnProd.style.opacity= '0%'
})


//sort
var sortBtn = document.getElementById('sort-btn')
var sortContain =  document.getElementById('sort-container')
var newProdBtn = document.getElementById('newProd-btn')
var newProdContain =  document.getElementById('newProd-container')
var filterBtn = document.getElementById('filter-btn')
var filterContain =  document.getElementById('filter-container')
sortBtn.addEventListener('click',()=>{
    newProdContain.style.display='none'
    filterContain.style.display='none'
    if(sortContain.style.display=='flex')
        sortContain.style.display='none'
    else
        sortContain.style.display='flex'

})
//filter

filterBtn.addEventListener('click',()=>{
    sortContain.style.display='none'
    newProdContain.style.display='none'
    if(filterContain.style.display=='flex')
        filterContain.style.display='none'
    else
        filterContain.style.display='flex'

})
//newProd

newProdBtn.addEventListener('click',()=>{
    sortContain.style.display='none'
    filterContain.style.display='none'
    if(newProdContain.style.display=='flex')
        newProdContain.style.display='none'
    else
        newProdContain.style.display='flex'

})

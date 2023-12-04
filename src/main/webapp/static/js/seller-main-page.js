var imgList = document.getElementById("imgList")
var imgInput  = document.getElementById("imgInput")
imgInput.onchange = (e)=>{
    for (i =0; i<imgInput.files.length;i++){
        var newItem = document.createElement("li");

        newItem.innerHTML = `
        <div class="img-bottom">
            <i class="delete-icon fa-solid fa-trash"></i>
        </div>
        <img src="${URL.createObjectURL(imgInput.files[i])}" alt="">
    `;
        newItem.classList.add("img-item");
        imgList.appendChild(newItem);
    }
}

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
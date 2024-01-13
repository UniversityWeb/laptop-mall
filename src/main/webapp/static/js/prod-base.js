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

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
var filterBtn = document.getElementById('filter-btn')
var filterContain =  document.getElementById('filter-container')
sortBtn.addEventListener('click',()=>{
    // newProdContain.style.display='none'
    filterContain.style.display='none'
    if(sortContain.style.display=='flex')
        sortContain.style.display='none'
    else
        sortContain.style.display='flex'

})
//filter

filterBtn.addEventListener('click',()=>{
    sortContain.style.display='none'
    // newProdContain.style.display='none'
    if(filterContain.style.display=='flex')
        filterContain.style.display='none'
    else
        filterContain.style.display='flex'

})

confirmModal = document.getElementById("modal-confirm")
confirmMess = document.getElementById("confirmMess")
confirmProdID = document.getElementById("confirmProdID")
confirmAction = document.getElementById("confirmAction")
function openConfirmModal(proID){
    if(confirmModal.style.display == "flex")
        closeModalSearch()
    else
    {
        confirmMess.innerHTML="Are you sure you want to delete the "+proID +" product?";
        confirmProdID.value=proID;
        confirmAction.value="delete"
        confirmModal.style.display = "flex";

    }

}

function closeModalConfirm() {
    confirmModal.style.display = "none";
}
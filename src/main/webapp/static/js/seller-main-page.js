
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

//
// //sort
var newBtn = document.getElementById('new-btn')
var newContain =  document.getElementById('new-container')
newBtn.addEventListener('click',()=>{
    if(newContain.style.display=='flex')
        newContain.style.display='none'
    else
        newContain.style.display='flex'
})

confirmModal = document.getElementById("modal-confirm")
notifyModal = document.getElementById("notify-modal")
confirmMess = document.getElementById("confirmMess")
confirmProdID = document.getElementById("confirmProdID")

function openConfirmModal(proID){
    confirmMess.innerHTML="Are you sure you want to delete the "+proID +" product?";
    confirmProdID.value=proID;
    confirmModal.style.display = "flex";
}

function closeModalConfirm() {
    confirmModal.style.display = "none";
}

function closeModalNotify(){
    notifyModal.style.display = "none";
}
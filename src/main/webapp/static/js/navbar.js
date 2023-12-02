var modal_search = document.getElementById("modal-search");
function openModalSearch() {
    if(modal_search.style.display == "flex")
        closeModalSearch()
    else
        modal_search.style.display = "flex";
}

function closeModalSearch() {
    modal_search.style.display = "none";
}

//Search JS
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
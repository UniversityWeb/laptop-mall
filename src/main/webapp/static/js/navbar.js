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
const inputElementNav = document.getElementById('input-element-nav');
var clearbtnNav = document.getElementById('clear-btn-search-nav')
inputElementNav.addEventListener('input', function(event) {
    clearbtnNav.style.opacity = '100%'
    clearbtnNav.style.cursor='pointer'
    if (inputElementNav.value == ''){
        clearbtnNav.style.opacity = '0%'
    }
});

clearbtnNav.addEventListener('click',()=>{
    inputElementNav.value=''
    clearbtnNav.style.opacity= '0%'
})
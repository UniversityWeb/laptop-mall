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
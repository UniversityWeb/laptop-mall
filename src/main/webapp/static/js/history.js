document.addEventListener("DOMContentLoaded", function () {
    const urlParams = new URLSearchParams(window.location.search);
    const tabParam = urlParams.get('tab') || '1';

    const buttons = document.querySelectorAll('.history-menu-choose');
    buttons.forEach(button => button.classList.remove('active'));

    const selectedButton = document.querySelector(`.history-menu-choose[value="${tabParam}"]`)
    if (selectedButton){
        selectedButton.classList.add("active");
        console.log("active")
    }
})
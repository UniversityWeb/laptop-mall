var category = document.getElementById("category")
var laptopContent = document.getElementById("laptopContent")
var keyboardContent = document.getElementById("keyboardContent")
var monitorContent = document.getElementById("monitorContent")
category.addEventListener('change', function () {
    laptopContent.style.display = 'none';
    keyboardContent.style.display = 'none';
    monitorContent.style.display = 'none';
    var categoryValue = category.value;
    if(categoryValue == "LAPTOP")
        laptopContent.style.display = 'flex';
    if(categoryValue == "MECHANICAL_KEYBOARD")
        keyboardContent.style.display = 'flex';
    if(categoryValue == "MONITOR")
        monitorContent.style.display = 'flex';
});

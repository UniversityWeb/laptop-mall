document.addEventListener("DOMContentLoaded", function () {
    const urlParams = new URLSearchParams(window.location.search);
    const tabParam = urlParams.get('tab') || 'ALL';

    const buttons = document.querySelectorAll('.history-menu-choose');
    buttons.forEach(button => button.classList.remove('active'));

    const selectedButton = document.querySelector(`.history-menu-choose[value="${tabParam}"]`)
    if (selectedButton){
        selectedButton.classList.add("active");
        console.log("active")
    }
})

document.addEventListener("DOMContentLoaded", function () {
    var orderProcess = document.getElementById('order-process-container');
    var orderedStep = document.getElementById('odered-status');
    var paymentStep = document.getElementById('payment-status');
    var shippingStep = document.getElementById('shipping-status');
    var resultStep = document.getElementById('result-status');

    var orderStatus = orderProcess.getAttribute('order-status');
    var paymentStatus = orderProcess.getAttribute('payment-status');

    if (orderStatus === 'RETURNED' || orderStatus === 'CANCELLED'){
        setActiveOrUnactive(orderedStep, "unactive");
        setActiveOrUnactive(paymentStep, "unactive");
        setActiveOrUnactive(shippingStep, "unactive");
        setActiveOrUnactive(resultStep, "unactive");
    }
    else{
        if(orderStatus === "DELIVERED"){
            setActiveOrUnactive(orderedStep, "active");
            setActiveOrUnactive(paymentStep, "active");
            setActiveOrUnactive(shippingStep, "active");
            setActiveOrUnactive(resultStep, "active");
        }
        else{
            if (orderStatus === "SHIPPED"){
                setActiveOrUnactive(orderedStep, "active");
                setActiveOrUnactive(paymentStep, "active");
                setActiveOrUnactive(shippingStep, "active");
            }
            else{
                if (paymentStatus === "AUTHORIZED"){
                    setActiveOrUnactive(paymentStep, "active");
                }
                setActiveOrUnactive(orderedStep, "active");
            }
        }
    }
})

function setActiveOrUnactive(element, status){
    element.classList.add(status);
}

function submitControlForm(action){
    const controlForm = document.getElementById("controlForm");
    controlForm.action = action;
    controlForm.submit();
}
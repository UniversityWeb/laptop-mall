function showPayment(paymentMethod) {
    var cashPaymentContent = document.querySelector('.cash_payment');
    var momoPaymentContent = document.querySelector('.momo_payment');
    var vnpayPaymentContent = document.querySelector('.vnpay_payment');
    var paymentMethodInput = document.querySelector('input[name="paymentMethod"]');


    if (paymentMethod === 'cash_payment') {
        if(cashPaymentContent.style.display === 'none'){
            cashPaymentContent.style.display = 'block';
            momoPaymentContent.style.display = 'none';
            vnpayPaymentContent.style.display = 'none';
            paymentMethodInput.value = 'CASH_ON_DELIVERY';
        }
        else{
            cashPaymentContent.style.display = 'none';
            paymentMethodInput.value = null;
        }
    }
    if (paymentMethod === 'momo_payment') {

        if(momoPaymentContent.style.display === 'none'){
            cashPaymentContent.style.display = 'none';
            momoPaymentContent.style.display = 'block';
            vnpayPaymentContent.style.display = 'none';
            paymentMethodInput.value = 'MOMO';
        }
        else{
            momoPaymentContent.style.display = 'none';
            paymentMethodInput.value = null;
        }
    }
    if (paymentMethod === 'vnpay_payment') {

        if(vnpayPaymentContent.style.display === 'none'){
            cashPaymentContent.style.display = 'none';
            momoPaymentContent.style.display = 'none';
            vnpayPaymentContent.style.display = 'block';
            paymentMethodInput.value = 'VNPAY';
        }
        else{
            vnpayPaymentContent.style.display = 'none';
            paymentMethodInput.value = null;
        }
    }
}
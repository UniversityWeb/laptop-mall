function showPayment(paymentMethod) {
    var cashPaymentContent = document.querySelector('.cash_payment');
    var momoPaymentContent = document.querySelector('.momo_payment');
    var paymentMethodInput = document.querySelector('input[name="paymentMethod"]');


    if (paymentMethod === 'cash_payment') {
        if(cashPaymentContent.style.display === 'none'){
            cashPaymentContent.style.display = 'block';
            momoPaymentContent.style.display = 'none';
            paymentMethodInput.value = 'Cash Payment';
        }
        else{
            cashPaymentContent.style.display = 'none';
            momoPaymentContent.style.display = 'none';
        }
    } else if (paymentMethod === 'momo_payment') {

        if(momoPaymentContent.style.display === 'none'){
            cashPaymentContent.style.display = 'none';
            momoPaymentContent.style.display = 'block';
            paymentMethodInput.value = 'Momo Payment';
        }
        else{
            cashPaymentContent.style.display = 'none';
            momoPaymentContent.style.display = 'none';
        }
    }
}
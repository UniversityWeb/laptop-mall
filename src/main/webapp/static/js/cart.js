function submitForm(formId) {
    let formSubmit = document.getElementById(formId);
    if (formSubmit) {
        formSubmit.submit();
    } else {
        console.log(`Form with ID "${formId}" not found.`);
    }
}
function validateForm() {
    let email = document.getElementById("email").value;
    let phone = document.getElementById("phone").value;
    let aadhar = document.getElementById("aadhar").value;

    let emailPattern = /^[^ ]+@[^ ]+\.[a-z]{2,3}$/;
    let phonePattern = /^[6-9]\d{9}$/;
    let aadharPattern = /^\d{12}$/;

    if (!email.match(emailPattern)) {
        alert("Enter a valid email address.");
        return false;
    }

    if (!phone.match(phonePattern)) {
        alert("Enter a valid phone number.");
        return false;
    }

    if (!aadhar.match(aadharPattern)) {
        alert("Enter a valid 12-digit Aadhar number.");
        return false;
    }

    return true;
}

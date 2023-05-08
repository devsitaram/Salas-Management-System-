/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

<!-- customer details register validation-->
function validateForm() {
    var id = document.forms["messageForm"]["userId"].value;
    var name = document.forms["messageForm"]["userName"].value;
    var email = document.forms["messageForm"]["userEmail"].value;
    var address = document.forms["messageForm"]["userAddress"].value;
    var phoneNo = document.forms["messageForm"]["userPhoneNo"].value;
    var newPassword = document.forms["messageForm"]["newPassword"].value;
    var confirmPassword = document.forms["messageForm"]["confirmPassword"].value;
    var message = document.forms["messageForm"]["feedback"].value;

    /* Alert the message when the empty fields are present "Please enter your values"
     *  but valied the form than given "Thank your Feedback" 
     *  */
    if (id == "" || name == "" || email == "" || address == "" || phoneNo == "") {
        alert("Empty fields fund! Please enter the valid personal information.");
    } else {
        if (newPassword == "" || confirmPassword == "") {
            alert("The password is empty!");
        } else {
            // id validation
            if (idValidation(id)) {
                // name validation
                if (nameValidation(name)) {
                    // email validation
                    if (emailValidatio(email)) {
                        // address validation
                        if (addressVlidation(address)) {
                            // phone number validation
                            if (phoneNoValidation(phoneNo)) {
                                if (!(newPassword == confirmPassword)) {
                                    alert("Please confirm your password!");
                                } else {
                                    var xhr = new XMLHttpRequest();
                                    xhr.open("POST", "../RegisterServlet");
                                    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
                                    xhr.onreadystatechange = function () {
                                        if (this.readyState === XMLHttpRequest.DONE && this.status === 200) {
                                            alert(this.responseText);
                                        }
                                    };
                                    xhr.send("userId=" + id + "&userName=" + name + "&userEmail=" + email + "&userAddress=" + address + "&userPhoneNo=" + phoneNo + "&confirmPassword=" + confirmPassword);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    
}
    
// validation for email, name, id, password, address, phone number etc.
// email vallidation
function idValidation(id) {
    var idPattern = /^\d{3}$/;
    // check the id
    if (!id.match(idPattern)) {
        alert("ID is not valid. must be three digit.: " + id);
        return false;
    } else {
        return true;
    }
}
    

// email vallidation
function nameValidation(name) {
    var namePattern = /^[A-Za-z]+(\s[A-Za-z-]+)?$/;
    // check the name
    if (!name.match(namePattern)) {
        alert("Name is not valid: " + name);
        return false;
    } else {
        return true;
    }
}
    

// email vallidation
function emailValidatio(email) {
    var emaliPattern = /^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/;
    // chcek the email
    if (!email.match(emaliPattern)) {
        alert("Email is not valid: " + email);
        return false;
    } else {
        return true;
    }
}
    

// address vallidation
function addressVlidation(address) {
    var addressPattern = /^[A-Za-z]/;
    // chcek the address
    if (!address.match(addressPattern)) {
    alert("Address is not valid: " + address);
        return false;
    } else {
        return true;
    }
}

// phone number vallidation
function phoneNoValidation(phoneNo) {
    var numberPattern = /^(97|98)\d{8}$/;
    // chcek the phone number
    if (!phoneNo.match(numberPattern)) {
        alert("Phone number is not valid. must be 10 digit: " + phoneNo);
        return false;
    } else {
        return true;
    }
}


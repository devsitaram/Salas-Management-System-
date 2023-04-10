<%-- 
    Document   : validations
    Created on : Apr 8, 2023, 10:46:05 AM
    Author     : Lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!-- customer details register validation-->
function registerValidate() {
    var id = document.forms["registerForm"]["userId"].value;
    var name = document.forms["registerForm"]["userName"].value;
    var email = document.forms["registerForm"]["userEmail"].value;
    var address = document.forms["registerForm"]["userAddress"].value;
    var phoneNo = document.forms["registerForm"]["userPhoneNo"].value;
    var gender = document.forms["registerForm"]["genderDetails"].value;	
    var newPassword = document.forms["registerForm"]["newPassword"].value;	
    var confirmPassword = document.forms["registerForm"]["confirmPassword"].value;	
    /* Alert the message when the empty fields are present "Please enter your values" but valied the form than given "Thank your Feedback" */
    if (id == ""||name == ""||email == ""||phoneNo == ""||gender == ""||newPassword == ""||confirmPassword == "") 
    {
        alert("The fields is empty!");
    }

    else
    {
        alert("Your details is successfully register")
    }
}
<%-- 
    Document   : home
    Created on : Apr 15, 2023, 11:17:36 AM
    Author     : Lenovo
--%>

<%@page import="com.salemamagementsystem.controller.CustomerDatabaseUtil"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <link rel="stylesheet" href="../css/register.css"/>
        <title>Register page</title>
        <style>
            .password_textfields {
                width: 55%;
                height: 20px;
                padding: 10px;
                margin-top: 5px;
                border-radius: 12px;
                border: 1.5px solid lightgrey;
                outline-color: graytext;
                transition: all 0.3s cubic-bezier(0.19, 1, 0.22, 1);
                box-shadow: 0px 0px 20px -20px;
            }
        </style>
    </head>
    <body name="body">
	<div class="maindiv">
            <div style="background-color:none; height: 80px; width: 100%; margin: auto; text-align: center;">
                            <!-- in the table tag uset to modified ther form heading -->
                <table style="background-color: red; height: 80px; border: 5px; width: 100%; text-align: center; box-shadow: dark;">
                    <tr><td style="background-color: yellow; font-size: 40px;">NEW FORM</td></tr>
                </table>
            </div><br></br>
            
            <H2 style="color: #232222; text-align: center; margin-top: 10px;">Sign Up</H2>
            <div style="height: 300px; width: 100%; margin-top: 30px;">
                <h1 style="font-family:roboto; text-align: center;">Please register details</h1> 
                <h4 style="text-align: center;">Enter the valid details</h4>

                <div style="margin-top: 40px; padding-left: 100px;">
                    <form name="messageForm" >
                        <div>
                            <p><h4>Presonal information</h4></p>
                            <p>User Id: <input class="input_textfields" style="margin-left: 20px;" type="number" name="userId"></p>
                            <p>Username: <input class="input_textfields" style="margin-left: 3px;" type="text" name="userName"></p>
                            <p>Email: <input class="input_textfields" style="margin-left: 30px;" type="text" name="userEmail"></p>
                            <p>Address: <input class="input_textfields" style="margin-left: 15px;" type="text" name="userAddress"></p>
                            <p>Phone No: <input class="input_textfields" style="margin-left: 5px;" type="text" name="userPhoneNo"></p><br>

                            <p><h4>Enter the strong password and confirm again!</h4></p>

                            <p>Password: <input class="password_textfields" style="margin-left: 5px;" type="password" name="newPassword"></p>
                            <p>Confirm: <input class="password_textfields" style="margin-left: 10px;" type="password" name="confirmPassword"></p><br>

                            <p><h4>Optional information</h4></p>
                            <p>Gender:
                                <input style="margin-left: 30px;" type="radio" name="genderDetails" value="male"/> Male
                                <input style="margin-left: 15px;" type="radio" name="genderDetails" value="female"/> Female
                                <input style="margin-left: 15px;" type="radio" name="genderDetails" value="Others"/> Others
                            </p>
                            <p>Feedback: <input class="password_textfields" style="margin-left: 5px;" type="text" name="feedback"></p>
                            <p>Remember: <input style="margin-left: 10px;" type="checkbox" name="checkbox"></p><br>

                            <p style="margin-left: 120px;">
                                <button class="button" style="width: 50%; color: white; background: #525ff4" onclick="validateForm()">Register</button>
                                <!--<input class="button" type="submit" value="Register" style="width: 50%; background: #525ff4">-->
                            </p><br></br>
                        </div>
                    </form>
                </div>

		<script type="text/javascript">
                    function validateForm() {
                        var id = document.forms["messageForm"]["userId"].value;
                        var name = document.forms["messageForm"]["userName"].value;
                        var email = document.forms["messageForm"]["userEmail"].value;
                        var address = document.forms["messageForm"]["userAddress"].value;
                        var phoneno = document.forms["messageForm"]["userPhoneNo"].value;
                        var newPassword = document.forms["messageForm"]["newPassword"].value;
                        var confirmPassword = document.forms["messageForm"]["confirmPassword"].value;
                        var message = document.forms["messageForm"]["feedback"].value;
                            
                        /* Alert the message when the empty fields are present "Please enter your values" but valied the form than given "Thank your Feedback" */
                        if (id=="" || name == "" || email == "" || address == "" || phoneno == "") {
                                alert("Empty fields fund! Please enter the valid personal information.");
                        } else {
                            if(newPassword == "" || confirmPassword == "") {
                                alert("The password is empty!");
                            } else {
                                if (newPassword.equals(onfirmPassword)) {
                                    alert("Please confirm your password!"); <!-- show the message -->
                                } else {
                                    var xhr = new XMLHttpRequest();
                                    xhr.open("POST", "../RegisterServlet");
                                    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
                                    xhr.onreadystatechange = function() {
                                        if (this.readyState === XMLHttpRequest.DONE && this.status === 200) {
                                            alert(this.responseText);
                                        }
                                    };
                                    xhr.send("userId=" + id + "&userName=" + name + "&userEmail=" + email + "&userAddress=" + address + "&userPhoneNo=" + phoneno + "&confirmPassword=" + confirmPassword);
//                                    alert("Register successful. Thank!");
                                }
                            }
                        }
                    }
		</script>
            </div>
	</div>
    </body>
    <script type="text/javascript">
        function registerValidate() {
//            // initialize the variable and get tex from getElementById
//            var isNew = true;
//            
////            var id = document.getElementById("userId").value;
////            var name = document.getElementById("userName").value;
////            var email = document.getElementById("userEmail").value;
////            var address = document.getElementById("userAddress").value;
////            var phoneNo = document.getElementById("userPhoneNo").value;
////            var gender = document.getElementById("genderDetails").value;
////            var newPassword = document.getElementById("newPassword");
////            var conPassword = document.getElementById("confirmPassword");	
//
//            var isUserId = false;
//            /* Alert the message when the empty fields are present "Please enter your values" but valied the form than given "Thank your Feedback" */
//            if (id == ""||name == ""||email == ""||address == ""||phoneNo == ""||newPassword == ""||conPassword == "") {
//                alert("The fields is empty!");
//            } else if (!isUserName) {
//                alert("Please enter the valid username and password!");
//            } else {
//                if ($("#registerForm").valid()) {
//                    var url = "";
//                    var data = "";
//                    var method = "";
//                }
//                
//                // check the is new is true or not
//                if(isNew){
//                    url = "add.jsp";
//                    data = $("#registerForm").serialize();
//                    method = "POST";
//                }
//                
//                // used the ajax 
//                $.ajax({
//                    type: method,
//                    url: url,
//                    dataType: 'JSON',
//                    data: data,
//                    
//                    // call the success funcation
//                    success: function (data) {
//                        alert("Your details is successfully register");
//                    }
//                });
//            }
        }
    </script>
</html>

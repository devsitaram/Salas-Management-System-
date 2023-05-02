<%-- 
    Document   : register
    Created on : May 1, 2023, 3:05:51 PM
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
    </head>
    <body class="body">
        <div style="height: 80px; width: 100%; margin: auto; text-align: center;">
            <!-- in the table tag uset to modified ther form heading -->
            <table style="height: 80px; width: 100%; text-align: center;">
                <tr><td style="font-size: 40px;">REGISTER FORM</td></tr>
            </table>
        </div><br></br>
        <div>
            <!--this is the right side of div where some of register information-->
            <div class="mainDivRight">
                <p>
                <h1>Sale Management System</h21><br>
                    <h4 style="text-align: justify; padding-right: 35px; font-family: sans-serif">A sales management system is normally a 
                        software, that facilitates effective sales workflow. The software helps users manage sales, monitor performance, 
                        streamline processes, and track results. A sales management system adds predictability and forecasting capacity and 
                        ensures your sales department process is repeatable and measurable.
                    </h4>
                </p>
                <p>
                    <image src="../images/img_register.jpg" style="width: 95%; height: 500px; margin-right: 50px"/>
                </p><br>
                <p>
                    <h3 style="text-align: justify; padding-right: 30px;">You have give the some information for register details. So, 
                            Please follow the given step by step and successfully register your details and gook luck.
                    </h3>
                    <h3>-> User id must be unique number/integer only three digits.</h3>
                    <h3>-> User name must be String where enter the full name.</h3>
                    <h3>-> email must be need the email pattern.</h3>
                    <h3>-> Address must be String.</h3>
                    <h3>-> Phone number must be integer/number and start to 98/97 total 10 digits.</h3>
                    <h3>-> Password must be strong and again conform.</h3>
                    <h3>-> Gender and feedback is optional information.</h3>
                </p>
                <p style="text-align: right; margin-right: 20px;">
                    <a class="button" style="width: 10%; color: black; font-size: 30px; text-decoration: none;" href="../pages/login.jsp">< Back</a>
                </p>
                
            </div>
            
            <!--this is the left side div where the user can register the valid details-->
            <div class="mainDivleft">
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
                        <script src="../javascript/javascript.js" type="text/javascript"/>
                    </div>

                <!--javascript for validation-->
    		<script type="text/javascript">
                        function validateForm() {
                            var id = document.forms["messageForm"]["userId"].value;
                            var name = document.forms["messageForm"]["userName"].value;
                            var email = document.forms["messageForm"]["userEmail"].value;
                            var address = document.forms["messageForm"]["userAddress"].value;
                            var phoneNo = document.forms["messageForm"]["userPhoneNo"].value;
                            var newPassword = document.forms["messageForm"]["newPassword"].value;
                            var confirmPassword = document.forms["messageForm"]["confirmPassword"].value;
                            var message = document.forms["messageForm"]["feedback"].value;


                            /* Alert the message when the empty fields are present "Please enter your values" but valied the form than given "Thank your Feedback" */
                            if (id == "" || name == "" || email == "" || address == "" || phoneNo == "") {
                                    alert("Empty fields fund! Please enter the valid personal information.");
                            } else {
                                if(newPassword == "" || confirmPassword == "") {
                                    alert("The password is empty!");
                                } else {
                                    // id validation
                                    if(idValidation(id)){
                                        // name validation
                                        if(nameValidation(name)){
                                            // email validation
                                            if(emailValidatio(email)){
                                                // address validation
                                                if(addressVlidation(address)){
                                                    // phone number validation
                                                    if(phoneNoValidation(phoneNo)){
                                                        if (!(newPassword == confirmPassword)) {
                                                            alert("Please confirm your password!");
                                                        } else {
                                                            var xhr = new XMLHttpRequest();
                                                            xhr.open("POST", "../RegisterServlet");
                                                            xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
                                                            xhr.onreadystatechange = function() {
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
                            if(!email.match(emaliPattern)){
                                alert("Email is not valid: "+email);
                                return false;
                            } else {
                                return true;
                            }
                        }

                        // address vallidation
                        function addressVlidation(address) {
                            var addressPattern =  /^[A-Za-z]/;    
                            // chcek the address
                            if(!address.match(addressPattern)){
                                alert("Address is not valid: "+address);
                                return false;
                            } else {
                                return true;
                            }
                        }

                        // phone number vallidation
                        function phoneNoValidation(phoneNo) {
                            var numberPattern =  /^(97|98)\d{8}$/;
                            // chcek the phone number
                            if(!phoneNo.match(numberPattern)){
                                alert("Phone number is not valid. must be 10 digit: "+phoneNo);
                                return false;
                            } else {
                                return true;
                            }
                        }
                    </script>

                </div>
            </div>
        </div>
    </body> 
</html>

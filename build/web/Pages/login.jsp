<%-- 
    Document   : login
    Created on : Apr 24, 2023, 7:22:23 AM
    Author     : Lenovo
--%>
<%@page import="com.salemamagementsystem.controller.CustomerDatabaseUtil"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ page session="true" %>
<!--session tracking-->

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../css/login.css"/>
        <script src="Slider.JS" type="text/javascript"></script>
        <title>Login Page</title>
    </head>
    
    <%-- display error message if it exists --%>
    <c:if test="${not empty errorMessage}">
        <style>
            .form{
                text-align: center;
                height: auto;
                width: 100%
            }
            /* // input text fields css*/
            .input_textfields {
                width: 30%;
                height: 20px;
                padding: 10px;
                margin-top: 15px;
                border-radius: 12px;
                border: 1.5px solid lightgrey;
                outline-color: graytext;
                transition: all 0.3s cubic-bezier(0.19, 1, 0.22, 1);
                box-shadow: 0px 0px 20px -20px;
            }
            /* button css*/
            .button{
                width: 15%;
                background-color: #525ff4;
                height: 40px;
                margin-top: 25px;
                padding-left: 30px;
                padding-right: 30px;
                border-radius: 9px;
                border: none;
                text-align: center;
                font-family: Arial, Helvetica, sans-serif;
                font-size: medium;
                color: white;
                text-decoration: none;
            }
            .button:hover {
                box-shadow: 7px 5px 56px -14px #0015ff;
                transform: scale(1.05);
                transition: 0.5s;
            }
            .body{
                background-image: url(../pages/register.jsp);
            }
        </style>
    </c:if>

    <body name="body">
        <!-- this is the input text fields and button field -->
        <div style="height: 300px; width: 100%; margin-top: 50px; background-image: url(../pages/register.jsp)">
            <h1 style="font-family:roboto; text-align: center">Login to Your Account</h1>
            <h4 style="text-align: center">Enter the valid Username and password</h4>

            <%-- display error message if it exists --%>
            <p style="color: red; text-align: center">${errorMessage}</p>
            <form action="../LoginServlet" method="post" class="form" name="loginform">

                <input class="input_textfields" placeholder="UsernameEmail" type="email||text" name="userName"><br>
                <input class="input_textfields" placeholder="Password" type="password" name="userPassword"><br>

                <input class="button" type="submit" value="Login" onClick="loginValidate()" style="width: 20%; background-color: #525ff4"/>
            </form>
        </div><br></br>

        <!-- this is the second options login the system with social media -->
        <div style="height: 100px; width: 100%; text-align: center;">
            <h4><u>Or</u></h4>
            <h3>If you have no any account please go to register your details!</h3>
            <p>2023@BuyToSale</p>
        </div>
    </body>
    <script type="text/javascript">
//        function loginValidate() {
//            // initialize the variable and get tex from getElementById
//            var isNew = true;
//            
//            var id = document.getElementById("userId").value;
//            var password = document.getElementById("newPassword");
//
//            var isUserId = false;
//            /* Alert the message when the empty fields are present "Please enter your values" but valied the form than given "Thank your Feedback" */
//            if (id == "" ||password == "") {
//                alert("The fields is empty!");
//            } else if (!isUserName) {
//                alert("Please enter the valid username and password!");
//            } else {
//                if ($("#loginform").valid()) {
//                    var url = "";
//                    var data = "";
//                    var method = "";
//                }
//                
//                // check the is new is true or not
//                if(isNew){
//                    url = "add.jsp";
//                    data = $("#loginform").serialize();
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
//                        alert("Login successful.");
//                    }
//                });
//            }
//        }
    </script>
    
</html>

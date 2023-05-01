<%-- 
    Document   : login
    Created on : Apr 24, 2023, 7:22:23 AM
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
        <link rel="stylesheet" href="../css/login.css"/>
        <script src="Slider.JS" type="text/javascript"></script>
        <title>Login Page</title>
    </head>
    <body name="body">
        <div class="maindiv">

            <!-- this is the left side or login page content -->
            <div class="leftdiv">
                <!-- this is the logo and title of the company -->
                <div style="height: auto; width: 100%; margin: 20px;">
                    <div style="width: 6%; height: 100%; margin: 10px; text-align: center; float: left">
                        <div class="loader">
                            <div class="face">
                                <div class="circle"></div>
                            </div>
                            <div class="face">
                                <h3 style="color: black;">B2S</h3>
                                <div class="circle"></div>
                            </div>
                        </div>
                    </div>
                    <div style="width: 90%; height: 100%; float: right; margin-top: 10px; padding-left: 2px">
                        <h3>Buy To Sale</h3>   	 
                    </div>
                </div>

                <!-- this is the input text fields and button field -->
                <div style="height: 300px; width: 100%; margin-top: 130px">
                    <h1 style="font-family:roboto; text-align: center">Login to Your Account</h1> 
                    <h4 style="text-align: center">Enter the valid Username and password</h4>
                    <form action="../LoginServlet" method="post" class="form" name="loginform">
                        <input class="input_textfields" placeholder="UsernameEmail" type="email||text" name="userName"><br>
                        <input class="input_textfields" placeholder="Password" type="password" name="userPassword"><br>
                        <input class="button" type="submit" value="Login" style="width: 35%; background-color: #525ff4;" />
                    </form>
                </div>

                <!-- this is the second options login the system with social media -->
                <div style="height: 100px; width: 100%; text-align: center;">
                    <h4><u>Or</u></h4>
                    <h3>If you have no any account please go to register your details!</h3>
                    <ul style="font-family: Arial, Helvetica, sans-serif;">
                        <i>2023@BuyToSale</i>                  
                    </ul>
                </div>
            </div>

            <!-- this is the sign up content or right side div #d2e74a -->
            <div class="rightdiv">
                <h1 style="margin-top: 170px; margin-bottom: 30px;">New Here?</h1>
                <li style="display: inline">Register and discover a great</li><br></br>
                <li style="display: inline">amount of new opportunities!</li><br></br>
                <button class="button" style="width: 45%; background-color: #d2e74a;" >
                    <a class="btnText" href="../pages/register.xhtml">Register</a>
                </button>
            </div>
        </div>
    </body>
    
<!--    <script  type="text/javascript">
        function validateForm() {
            var username = document.forms["loginform"]["UsernameEmail"].value;
            var password = document.forms["loginform"]["Password"].value;
            if ((un === username) && (pw === password)) {
                window.location = "home.xhtml";
                return false;
            } else {
                alert ("Login was unsuccessful, please check your username and password");
            }
            
            if(username === password) {
            alert("Welcome");
                window.location="sec.html";
                return false;
            } else {
                alert("Please Try again!");
                return false;
            }
        }
    <!--</script>-->
</html>

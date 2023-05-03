<%-- 
    Document   : blog
    Created on : May 4, 2023, 12:25:11 AM
    Author     : Lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <sql:setDataSource var="dbConnection" driver="org.apache.derby.client.ClientAutoloadedDriver"
                           url ="jdbc:derby://localhost:1527/saledb" user="admin" password="admin"/>
        <title>Blog Page</title>
        <link rel="stylesheet" href="../css/blog.css"/>
    </head>
    <style>
        .header{
            height: 90px; 
            width: 100%;  
            padding: 15px; 
            overflow: visible;
            background-color: whitesmoke
        }
        /*// logo anomations*/
        .loader {
            width: 6em;
            height: 6em;
            font-size: 10px;
            position: relative;
            display: flex;
            align-items: center;
            justify-content: center;
        }
        .loader .face {
            position: absolute;
            border-radius: 50%;
            border-style: solid;
            animation: animate023845 3s linear infinite;
        }
        .loader .face:nth-child(1) {
            width: 100%;
            height: 100%;
            color: rgb(22, 255, 22);
            border-color: currentColor transparent transparent currentColor;
            border-width: 0.2em 0.2em 0em 0em;
            --deg: -45deg;
            animation-direction: normal;
        }
        .loader .face:nth-child(2) {
            width: 70%;
            height: 70%;
            color: rgb(0, 64, 255);
            border-color: currentColor currentColor transparent transparent;
            border-width: 0.2em 0em 0em 0.2em;
            --deg: -135deg;
            animation-direction: reverse;
        }
        .loader .face .circle {
            position: absolute;
            width: 50%;
            height: 0.1em;
            top: 50%;
            left: 50%;
            background-color: transparent;
            transform: rotate(var(--deg));
            transform-origin: left;
        }
        .loader .face .circle::before {
            position: absolute;
            top: -0.5em;
            right: -0.5em;
            content: '';
            width: 1em;
            height: 1em;
            background-color: currentColor;
            border-radius: 50%;
            box-shadow: 0 0 2em,
                0 0 4em,
                0 0 6em,
                0 0 8em,
                0 0 10em,
                0 0 0 0.5em rgba(255, 255, 0, 0.1);
        }
        @keyframes animate023845 {
            to {
                transform: rotate(1turn);
            }
        }
        ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
            overflow: hidden;
        }
        .input_textfields{
            margin-left: 25px;
            width: 200px;
        }
        /* Navication bar codepen*/
        .navicationbar{
            height: 85%;
            width: 450px;
            margin-top: 6px;
            margin-right: -20px;
            float: right;
            overflow: visible;
            border-radius: 10px;
        }
        ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
            overflow: visible;
        }
        li a {
            float: left;
            display: block;
            color: #666;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
            border-radius: 6%;
        }
        li a:hover {
            overflow: visible;
            transform: translateY(15%);
            transition: 0.50s;
            box-shadow: rgba(66, 255, 170, 0.368) 0px 13px 47px 5px, rgb(82, 111, 115) 0px 8px 16px 1px;
        }
        li a.active {
            margin-right: 5px;
            color: #2243ff;
            background-color: #f3f3f3;
            transition: 0.70s;
        }
        li a.active:hover{
            box-shadow: rgba(66, 255, 170, 0.368) 0px 13px 47px 5px, rgb(82, 111, 115) 0px 8px 16px 1px;

        }

        /* menu icon */
        .menu {
            height: 50%;
            width: 45px;
            margin-right: 40px;
            float: right;
            text-align: center;
            margin-top: 15px;
        }
        .iconLine{
            height: 3px;
            width: 20px;
            margin: 5px;
            background-color: #666;
        }
    </style> 
    <body style="width: 100%; height: auto; text-align: center">
        <!-- this is the header section-->
        <header class="header">

            <div style=" width: 300px; height: 100%; float: left; margin-left: 20px;">
                <div style="width: 25%; float: left;">
                    <div class="loader">
                        <div class="face">
                            <div class="circle"></div>
                        </div>
                        <div class="face">
                            <div class="circle"></div>
                        </div>
                    </div>
                </div>

                <div style="width: 50%; height: 100%; padding-top: 15px; float: right; margin-right: 70px;">
                    <h3>BuyToSale</h3>   	 
                </div>
            </div>

            <!-- menu icon -->
            <div class="menu" style="margin-right: 15px;">
                <a href="">
                    <div class="iconLine"></div>
                    <div class="iconLine"></div>
                    <div class="iconLine"></div>
                </a>
            </div>
            
            <!--this is the navication bar-->
            <div class="navicationbar">
                <ul>
                    <li><a href="home.xhtml">Home</a></li>
                    <li><a href="product.xhtml">Product</a></li>
                    <li><a href="contact.xhtml">Contact</a></li>
                    <li><a class="active" href="blog.jsp">Blog</a></li>
                    <li><a href="about.xhtml">About</a></li>
                </ul>
            </div>
        </header>

        <div class="about-section">
            <h1>About Us Page</h1>
            <p>Some text about who we are and what we do.</p>
            <p>Resize the browser window to see that this page is responsive by the way.</p>
        </div>

        <div style="height: auto; width: 100%; text-align: center">
            <!--// show the customer details-->
            <h1>Information about Sales management</h1>

            <sql:query var="customers" dataSource="${dbConnection}">
                SELECT * From ADMIN.customers
            </sql:query>
            <table border="1">
                <thead>
                    <tr>
                        <th> Customer Id</th>
                        <th> Customer Name </th>
                        <th> Customer Email</th>
                        <th> Customer Address </th>
                        <th> Phone Number</th>
                        <th> Password</th>
                    </tr>
                </thead>
                <c:forEach var="customer" items="${customers.rows}">
                    <tr>
                        <td><c:out value="${customer.customer_id}"/></td>
                        <td><c:out value="${customer.customer_name}"/></td>
                        <td><c:out value="${customer.email}"/></td>
                        <td><c:out value="${customer.address}"/></td>            
                        <td><c:out value="${customer.phone_no}"/></td>
                        <td><c:out value="${customer.password}"/></td>
                    </tr>
                </c:forEach>
            </table>

        </div>



        <div class="footer">
            <img src="../images/img_footer_bar.png" alt="alt" style="width: 100%"/>
        </div>
    </body>
    <style>
        *{
            padding: 0;
            margin: 0;
        }
        body {
            overflow-x: hidden;
            overflow-y: scroll;
            font-family: Arial, Helvetica, sans-serif;
            margin: 0;
        }

        html {
            box-sizing: border-box;
        }

        *, *:before, *:after {
            box-sizing: inherit;
        }
        
        .column {
            width: 33.3%;
            margin-bottom: 16px;
            padding: 0 8px;
            background-color: white;
            margin-left: 400px;
            margin-top: 50px;
            margin-bottom: 50px;
        }

        .card {
            box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
            margin: 8px;
        }

        .about-section {
            padding: 50px;
            text-align: center;
            background-color: #474e5d;
            color: white;
        }

        .container {
            padding: 0 16px;
        }
        .row {
            background-color: red;
            text-align: center;
        }
        .container::after, .row::after {
            content: "";
            clear: both;
            display: table;
        }

        .title {
            color: grey;
        }

        .button {
            border: none;
            outline: 0;
            display: inline-block;
            padding: 8px;
            color: white;
            background-color: #000;
            text-align: center;
            cursor: pointer;
            width: 100%;
        }

        .button:hover {
            background-color: #555;
        }

        @media screen and (max-width: 650px) {
            .column {
                width: 100%;
                display: block;
            }
        }
        .footer {
            height: 150px;
            width: 100%;
        }
    </style>
</html>    

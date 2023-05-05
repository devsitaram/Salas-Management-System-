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
                <div style="width: 20%; float: left;">
                    <div class="loader">
                        <div class="face">
                            <div class="circle"></div>
                        </div>
                        <div class="face">
                            <div class="circle"></div>
                        </div>
                        <h3 style="color: black;">BTS</h3>
                    </div>
                </div>

                <div style="width: 50%; height: 100%; padding-top: 15px; float: right; margin-right: 80px;">
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
            <h1>Blog Page</h1><br>
            <p>Some text about who we are and what we do.</p>
            <p>Resize the browser window to see that this page is responsive by the way.</p><br>
            <h1>Information about Sales management</h1>
        </div>

        <div style="height: auto; width: 100%;">

            <!--// show the customer details-->
            <center>
                <div class="display_data">

                    <div style=" width: 65%;">
                        <h1>Customer details</h1>
                        <h4 style="margin: 10px">UPDATED ON APRIL 30, 2023 BY SITA RAM TAMANG</h4>
                    </div>

                    <div style="width: 65%; margin-top: 20px; font-size: 18px; text-align: justify;">
                        <p>
                            In a sales management system, customers play a crucial role as they are 
                            the primary source of revenue for the organization. Managing customers 
                            effectively involves maintaining a comprehensive database of customer 
                            information, including their contact details, purchase history, preferences, 
                            and feedback. This data can be used to create targeted marketing campaigns, 
                            personalized offers, and improve customer service. In addition, analyzing 
                            customer behavior and trends can provide valuable insights that can be used 
                            to optimize sales strategies and enhance customer satisfaction.
                        </p>
                    </div>

                    <div class="navbar">
                        <!--//show the customers details where insert, update and delete if the data is unnecessary-->
                        <div class="dropdown">
                            <button class="dropbtn">Customers<i class="fa fa-caret-down"></i></button>

                            <div class="dropdown-content">
                                <center>
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
                                </center>
                            </div>
                        </div>
                    </div>

            </center>

            <!--// show the customer details-->
            <center>
                <div class="display_data">

                    <div style=" width: 65%;">
                        <h1>Supplier details</h1>
                        <h4 style="margin: 10px">UPDATED ON APRIL 30, 2023 BY SITA RAM TAMANG</h4>
                    </div>

                    <div style="width: 65%; margin-top: 20px; font-size: 18px; text-align: justify;">
                        <p>
                            In a sales management system, suppliers are key players in ensuring the availability 
                            and quality of products or services offered by an organization. Managing suppliers 
                            effectively involves maintaining a database of supplier information, including their 
                            contact details, product offerings, pricing, and delivery schedules. By monitoring 
                            supplier performance, organizations can ensure that they are receiving the best value 
                            for their money and that products are delivered on time and to the expected standard. 
                            This data can also be used to negotiate better deals, optimize inventory management, 
                            and streamline procurement processes. 
                        </p>
                    </div>

                    <div class="navbar">
                        <!--//show the customers details where insert, update and delete if the data is unnecessary-->
                        <div class="dropdown">
                            <button class="dropbtn">Supplier<i class="fa fa-caret-down"></i></button>

                            <div class="dropdown-content">
                                <center>
                                    <sql:query var="suppliers" dataSource="${dbConnection}">
                                        SELECT * From ADMIN.suppliers
                                    </sql:query>
                                    <table border="1">
                                        <thead>
                                            <tr>
                                                <th> Supplier Id</th>
                                                <th> Supplier Name </th>
                                                <th> Supplier Mail</th>
                                                <th> Location</th>
                                                <th> Contact No</th>
                                            </tr>
                                        </thead>
                                        <c:forEach var="supplier" items="${suppliers.rows}">
                                            <tr>
                                                <td><c:out value="${supplier.supplier_id}"/></td>
                                                <td><c:out value="${supplier.supplier_name}"/></td>
                                                <td><c:out value="${supplier.mail}"/></td>
                                                <td><c:out value="${supplier.location}"/></td>            
                                                <td><c:out value="${supplier.contact_no}"/></td>
                                            </tr>
                                        </c:forEach>
                                    </table>
                                </center>
                            </div>
                        </div>
                    </div>
                </div>
            </center>


            <!--// show the customer details-->
            <center>
                <div class="display_data">

                    <div style=" width: 65%;">
                        <h1>Item details</h1>
                        <h4 style="margin: 10px">UPDATED ON APRIL 30, 2023 BY SITA RAM TAMANG</h4>
                    </div>

                    <div style="width: 65%; margin-top: 20px; font-size: 18px; text-align: justify;">
                        <p>
                            In a sales management system, items refer to the products or services that 
                            are sold by an organization. Managing items effectively involves maintaining 
                            a comprehensive database of item information, including their names, descriptions, 
                            prices, availability, and other relevant details. This data can be used to create 
                            accurate and up-to-date catalogues, track inventory levels, and analyze sales trends. 
                            By monitoring item performance, organizations can identify which items are popular 
                            and which ones are not.
                        </p>
                    </div>

                    <div class="navbar">
                        <!--//show the customers details where insert, update and delete if the data is unnecessary-->
                        <div class="dropdown">
                            <button class="dropbtn">Items<i class="fa fa-caret-down"></i></button>

                            <div class="dropdown-content">
                                <center>
                                    <sql:query var="items" dataSource="${dbConnection}">
                                        SELECT * From ADMIN.items
                                    </sql:query>
                                    <table border="1">
                                        <thead>
                                            <tr>
                                                <th> Item No</th>
                                                <th> Item Name </th>
                                                <th> Prices </th>
                                                <th> Item Qty </th>
                                                <th> Supply Date</th>
                                                <th> Supplier Id</th>
                                            </tr>
                                        </thead>
                                        <c:forEach var="item" items="${items.rows}">
                                            <tr>
                                                <td><c:out value="${item.item_no}"/></td>
                                                <td><c:out value="${item.item_name}"/></td>
                                                <td><c:out value="${item.prices}"/></td>
                                                <td><c:out value="${item.item_qty}"/></td>            
                                                <td><c:out value="${item.supply_date}"/></td>
                                                <td><c:out value="${item.supplier_id}"/></td>
                                            </tr>
                                        </c:forEach>
                                    </table>
                                </center>
                            </div>
                        </div>
                    </div>

            </center>


            <!--// show the customer details-->
            <center>
                <div class="display_data">

                    <div style=" width: 65%;">
                        <h1>Payment details</h1>
                        <h4 style="margin: 10px">UPDATED ON APRIL 30, 2023 BY SITA RAM TAMANG</h4>
                    </div>

                    <div style="width: 65%; margin-top: 20px; font-size: 18px; text-align: justify;">
                        <p>
                            In a sales management system, payment refers to the process of receiving 
                            and processing payments from customers for products or services sold. 
                            Managing payments effectively involves providing customers with a variety 
                            of payment options, such as credit cards, debit cards, PayPal, and other 
                            electronic payment methods. Payment information must be collected securely 
                            and stored in compliance with relevant regulations and standards. A successful 
                            sales management system should also include features that allow for easy payment
                            processing, such as automated invoicing, payment reminders, and payment tracking. 
                            By managing payments effectively, organizations can ensure that they receive timely 
                            and accurate payments, reduce the risk of fraud, and improve customer satisfaction.
                        </p>
                    </div>

                    <div class="navbar">
                        <!--//show the customers details where insert, update and delete if the data is unnecessary-->
                        <div class="dropdown">
                            <button class="dropbtn">Payment<i class="fa fa-caret-down"></i></button>

                            <div class="dropdown-content">
                                <center>
                                    <sql:query var="payments" dataSource="${dbConnection}">
                                        SELECT * From ADMIN.payments
                                    </sql:query>
                                    <table border="1">
                                        <thead>
                                            <tr>
                                                <th> Payment No</th>
                                                <th> Amounts </th>
                                                <th> Payment Date</th>
                                                <th> Remarks </th>
                                            </tr>
                                        </thead>
                                        <c:forEach var="payment" items="${payments.rows}">
                                            <tr>
                                                <td><c:out value="${payment.payment_no}"/></td>
                                                <td><c:out value="${payment.amounts}"/></td>
                                                <td><c:out value="${payment.payment_date}"/></td>
                                                <td><c:out value="${payment.remarks}"/></td>
                                            </tr>
                                        </c:forEach>
                                    </table>
                                </center>
                            </div>
                        </div>
                    </div>

            </center>


            <!--// show the customer details-->
            <center>
                <div class="display_data">

                    <div style=" width: 65%;">
                        <h1>Order details</h1>
                        <h4 style="margin: 10px">UPDATED ON APRIL 30, 2023 BY SITA RAM TAMANG</h4>
                    </div>

                    <div style="width: 65%; margin-top: 20px; font-size: 18px; text-align: justify;">
                        <p>
                            In a sales management system, order refers to the process of receiving and 
                            fulfilling customer requests for products or services. Managing orders 
                            effectively involves maintaining a streamlined and efficient process for 
                            receiving and processing orders, including online orders, phone orders, or 
                            in-store orders. Orders must be processed accurately, and the system should 
                            provide real-time inventory management, allowing the organization to ensure 
                            that the ordered items are available for delivery or pickup. The system should 
                            also provide features that allow for easy order tracking and updates, such as 
                            automated order confirmation and shipment notifications. By managing orders 
                            effectively, organizations can ensure that customers receive their requested 
                            products or services promptly and accurately, improving customer satisfaction 
                            and loyalty.
                        </p>
                    </div>

                    <div class="navbar">
                        <!--//show the customers details where insert, update and delete if the data is unnecessary-->
                        <div class="dropdown">
                            <button class="dropbtn">Order<i class="fa fa-caret-down"></i></button>

                            <div class="dropdown-content">
                                <center>
                                    <sql:query var="orders" dataSource="${dbConnection}">
                                        SELECT * From ADMIN.orders
                                    </sql:query>
                                    <table border="1">
                                        <thead>
                                            <tr>
                                                <th> Order No</th>
                                                <th> Order Date </th>
                                                <th> Order Qty</th>
                                                <th> Descriptions </th>
                                                <th> Item No</th>
                                                <th> Payment No</th>
                                                <th> Customer Id</th>
                                            </tr>
                                        </thead>
                                        <c:forEach var="order" items="${orders.rows}">
                                            <tr>
                                                <td><c:out value="${order.order_no}"/></td>
                                                <td><c:out value="${order.order_date}"/></td>
                                                <td><c:out value="${order.order_qty}"/></td>
                                                <td><c:out value="${order.descriptions}"/></td>            
                                                <td><c:out value="${order.item_no}"/></td>
                                                <td><c:out value="${order.payment_no}"/></td>
                                                <td><c:out value="${order.customer_id}"/></td>
                                            </tr>
                                        </c:forEach>
                                    </table>
                                </center>
                            </div>
                        </div>
                    </div>

            </center>

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

        .navbar {
            width: 130px;
            overflow: visible;
            float: left;
            border-radius: 9px;
            margin: 30px;
            text-align: center;
            margin-left: 205px;
            font-family: Arial, Helvetica, sans-serif;
        }
        .navbar a {
            color: white;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
        }
        .dropdown {
            width: 130px;
            float: left;
            overflow: visible;
        }
        .dropdown .dropbtn {
            border-radius: 9px;
            border: none;
            outline: none;
            color: white;
            padding: 14px 16px;
            background-color: grey;
            font: inherit;
        }
        .navbar a:hover, .dropdown:hover .dropbtn {
            overflow: visible;
            transform: translateY(-15%);
            transition: 0.50s;
            box-shadow: rgba(66, 255, 170, 0.468) 0px 13px 47px 5px, rgb(82, 111, 215) 0px 8px 16px 5px;
        }
        .dropdown-content {
            padding: 20px;
            width: 100%;
            margin-left: -230px;
            margin-bottom: 20px;
            display: none;
            position: absolute;
            background-color: white;
            height: auto;
            padding: auto;
        }
        .dropdown:hover .dropdown-content {
            display: block;
        }

        .display_data{
            height: auto;
            width: 100%;
            padding: 20px;
            margin-top: 20px;
            margin-bottom: 80px;
        }
    </style>
</html>    

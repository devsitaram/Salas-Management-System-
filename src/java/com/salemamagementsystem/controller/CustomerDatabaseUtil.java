package com.salemamagementsystem.controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import com.salemamagementsystem.model.CustomerModelBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import resources.SaleConstants;

@RequestScoped
@ManagedBean(name = "customerDbBean")
@SessionScoped
public class CustomerDatabaseUtil {

    // customer table's global variables and also create an object of customer class, supplier class, payment class, item class and order class
    CustomerModelBean customerModelBean = new CustomerModelBean();
    // create an object SaleConstants class
    SaleConstants saleConstants = new SaleConstants();
    DriverConnection driverConnection = new DriverConnection();
    Connection connection; // create an object of driver connection
    Statement statement;
    ResultSet resultSet;

    // get all the customer detials from data bases
    public ResultSet getCustomerData() {
        try {
            connection = driverConnection.getDatabaseConnection();
            statement = (Statement) connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            resultSet = statement.executeQuery(saleConstants.GET_ALL_CUSTOMER_DATA);
            return resultSet;
        } catch (ClassNotFoundException | SQLException ex) {
            return null;
        }
    }

    // login to check the username and password
    public Boolean loginUser(String username, String password) {
        if (username == null || password == null) {
            return false;
        } else {
            try {
                // establish database connection
                connection = driverConnection.getDatabaseConnection();
                // create statement
                statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
                // execute query
                resultSet = statement.executeQuery(saleConstants.SELCT_CUSTOMER_DNAME_PASSWORD);
                // check each record in the result set
                while (resultSet.next()) {
                    String customerName = resultSet.getString("customer_name");
                    String customerPassword = resultSet.getString("password");
                    // check if the username and password match
                    if ((customerName.equals(username)) && (customerPassword.equals(password))) {
                        // close objects and return true
                        resultSet.close();
                        statement.close();
                        connection.close();
                        return true;
                    }
                }

                // close objects and return false
                resultSet.close();
                statement.close();
                connection.close();
                return false;

            } catch (ClassNotFoundException | SQLException ex) {
                // handle ClassNotFoundException
                ex.printStackTrace();
                return false;

            } finally {
                // make sure to close connection object in case of any exception
                try {
                    if (connection != null) {
                        connection.close();
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    // insert the customer data
    public void insertCustomer(int customerId, String customerName, String email, String address, String phoneNo, String password) {

        if (customerId == 0 || customerName == null || email == null || address == null || phoneNo == null || null == password) {
            System.out.println("the input fields is empty!");
        } else {
            try {
                // driver connection error
                connection = driverConnection.getDatabaseConnection();
                PreparedStatement preStatementOrder = connection.prepareStatement(saleConstants.INSERT_CUSTOMER_ALL_DATA);
                // set/insert the  data
                preStatementOrder.setInt(1, customerId);
                preStatementOrder.setString(2, customerName);
                preStatementOrder.setString(3, email);
                preStatementOrder.setString(4, address);
                preStatementOrder.setString(5, phoneNo);
                preStatementOrder.setString(6, password);
                // exexute to insert data
                preStatementOrder.executeUpdate();
                statement.close();
                connection.close();

            } catch (ClassNotFoundException | SQLException ex) {
                // handle ClassNotFoundException
                ex.printStackTrace();
            } finally {
                // make sure to close connection object in case of any exception
                try {
                    if (connection != null) {
                        connection.close();
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    // update the customer data
    public void updateCustomerData(String name, String email, String address, String phoneNo, String password, int customerId) throws ClassNotFoundException {
        if (customerId == 0 || name == null || email == null || address == null || phoneNo == null || null == password) {
            System.out.println("the input fields is empty!");
        } else {
            try {
                connection = driverConnection.getDatabaseConnection();
                PreparedStatement updateStatement = connection.prepareStatement(saleConstants.UPDATE_CUSTOMER_DATA);
                updateStatement.setString(1, name);
                updateStatement.setString(2, email);
                updateStatement.setString(3, address);
                updateStatement.setString(4, phoneNo);
                updateStatement.setString(5, password);
                updateStatement.setInt(6, customerId);

                updateStatement.executeUpdate(); // retur
            } catch (SQLException ex) {
                System.out.println("Failed: " + customerId);
            }
        }
    }

//     deleteCustomerData methods can be delete the customer data
    public void deleteCustomer(int customerId) {
//        if (customerId == 0) {
//            System.out.println("The customer id is empty!");
//        } else {
            try {
                PreparedStatement deleteStatement = connection.prepareStatement(saleConstants.DELETE_CUSTOMER_DATA);
                deleteStatement.setInt(1, customerId);
                if (deleteStatement.executeUpdate() >= 0) {
                    System.out.println("Sucess");
                } else {
                    System.out.println("Failed");
                }
            } catch (SQLException ex) {
                System.out.println("Failed: " + customerId);
            }
//        }
    }

    // insert the customer data
    public Boolean insertCustomerData(int customerId, String customerName, String email, String address, String phoneNo, String password) {
        if (customerId == 0 || customerName == null || email == null || address == null || phoneNo == null || null == password) {
            System.out.println("the input fields is empty!");
            return false;
        } else {
            try {
                // driver connection error
                connection = driverConnection.getDatabaseConnection();
                PreparedStatement preStatementOrder = connection.prepareStatement(saleConstants.INSERT_CUSTOMER_ALL_DATA);
                // set/insert the  data
                preStatementOrder.setInt(1, customerId);
                preStatementOrder.setString(2, customerName);
                preStatementOrder.setString(3, email);
                preStatementOrder.setString(4, address);
                preStatementOrder.setString(5, phoneNo);
                preStatementOrder.setString(6, password);
                // exexute to insert data
                preStatementOrder.executeUpdate();

                statement.close();
                connection.close();
                return true;

                // System.out.println("Customer Id: "+customerId);
                // System.out.println("Customer Name: "+customerName);
                // System.out.println("Customer email: "+email);
                // System.out.println("Customer address: "+address);
                // System.out.println("Customer phone No: "+phoneNo);
                // System.out.println("Customer password: "+password);
            } catch (ClassNotFoundException | SQLException ex) {
                // handle ClassNotFoundException
                ex.printStackTrace();
                return false;
            } finally {
                // make sure to close connection object in case of any exception
                try {
                    if (connection != null) {
                        connection.close();
                        return false;
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    return false;
                }
            }
        }
    }
}

// get all customer data from databses and check to insert the valid data (customer data are register)
//    public void insertCustomerData(int customer_id, String customer_name, String email, String address, String phone_no, String password) {
//        try {
//            connection = driverConnection.getDatabaseConnection();
//            Statement statement = (Statement) connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
//            ResultSet rsCustomersData = statement.executeQuery(saleConstants.GET_CUSTOMER_DATA);
// while loop
//            while (rsCustomersData.next()) {
// get the customer details and store the veriable
//                customerId = rsCustomersData.getInt("customer_id");
//                customerName = rsCustomersData.getString("customer_name");
//                customerEmail = rsCustomersData.getString("email"); // must be uniques
//                customerAddress = rsCustomersData.getString("address");
//                customerPhone = rsCustomersData.getString("phone_no"); // must be uniques
//                customerPassword = rsCustomersData.getString("password");
// check the if statements
//                if (!password.equals(customerPassword) && !customer_name.equals(customerName)) {
//                    if (!phone_no.equals(customerPhone)) {
//                        if (!email.equals(customerEmail)) {
//                            // data insert in databases 
//                            PreparedStatement preStatementCustomer = connection.prepareStatement(saleConstants.INSERT_CUSTOMER_ALL_DATA);
//                            // set the  data
//                            preStatementCustomer.setInt(1, customer_id);
//                            preStatementCustomer.setString(2, customer_name);
//                            preStatementCustomer.setString(3, email);
//                            preStatementCustomer.setString(4, address);
//                            preStatementCustomer.setString(5, phone_no);
//                            preStatementCustomer.setString(6, password);
////                            System.out.println("Id: " + customerId + " Name: " + customerName + " Email: " + customerEmail + " Address: " + customerAddress + " Phone: " + customerPhone + " Password: " + customerPassword);
//                            // exexute to insert data
//                            preStatementCustomer.executeUpdate();
//                            // Close the result set, statement, and connection
//                            rsCustomersData.close();
//                            statement.close();
//                            connection.close();
//                        } else {
//                            System.out.println("The email must be unique");
//                            break;
//                        }
//                    } else {
//                        System.out.println("The phone number must be unique");
//                        break;
//                    }
//                } else {
//                    System.out.println("The password must be unique");
//                    break;
//                }
////            }
//        } catch (ClassNotFoundException | SQLException ex) {
//            System.out.println("Customer Id must be uniqe: " + ex);
//        }
//    }

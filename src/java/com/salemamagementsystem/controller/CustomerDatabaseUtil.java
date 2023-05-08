package com.salemamagementsystem.controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import resources.SaleConstants;

/**
 * this is the item database Util class where the direct the connect 
 * the data to get the data, insert, update and delete in the data base
 * @author Lenovo
 */
@RequestScoped
@ManagedBean(name = "customerDbBean")
@SessionScoped
public class CustomerDatabaseUtil {

    // customer table's global variables and also create an object of customer class, supplier class, payment class, item class and order class
    // create an object SaleConstants class
    SaleConstants saleConstants = new SaleConstants();
    DriverConnection driverConnection = new DriverConnection();
    Connection connection = null; // create an object of driver connection
    Statement statement = null;
    ResultSet resultSet = null;

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
                statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
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
        // check the system where all the paremeter is empty or not empty
        if (customerId == 0 || customerName == null || email == null || address == null || phoneNo == null || null == password) {
            System.out.println("the input fields is empty!");
        } else {
            try {
                // driver connection error
                connection = driverConnection.getDatabaseConnection();
                PreparedStatement preStatementCustomer = connection.prepareStatement(saleConstants.INSERT_CUSTOMER_ALL_DATA);
                // set/insert the  data
                preStatementCustomer.setInt(1, customerId);
                preStatementCustomer.setString(2, customerName);
                preStatementCustomer.setString(3, email);
                preStatementCustomer.setString(4, address);
                preStatementCustomer.setString(5, phoneNo);
                preStatementCustomer.setString(6, password);
                // exexute to insert data
                preStatementCustomer.executeUpdate();

            } catch (ClassNotFoundException | SQLException ex) {
                // handle ClassNotFoundException
                ex.printStackTrace();
            } finally {
                // make sure to close connection object in case of any exception
                try {
                    // check the diver connection is null or not
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
            } finally {
                // make sure to close connection object in case of any exception
                try {
                    // check the diver connection is null or not
                    if (connection != null) {
                        connection.close();
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

//     deleteCustomerData methods can be delete the customer data
    public void deleteCustomer(int customerId) {
//        if (customerId == 0) {
//            System.out.println("The customer id is empty!");
//        } else {  
//  
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

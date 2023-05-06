/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.salemamagementsystem.controller;

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
 *
 * @author Lenovo
 */
@RequestScoped
@ManagedBean(name = "orderDbBean")
@SessionScoped
public class OrderDatabaseUtil {
    SaleConstants saleConstants = new SaleConstants();
    DriverConnection driverConnection = new DriverConnection();
    Connection connection = null; // create an object of driver connection
    Statement statement = null;
    
    // get the orders details
    public ResultSet getOrderData() {
        try {
            connection = driverConnection.getDatabaseConnection();
            statement = (Statement) connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            ResultSet resultSet = statement.executeQuery(saleConstants.GET_ALL_ORDER_DATA);
            return resultSet;
        } catch (ClassNotFoundException | SQLException ex) {
            return null;
        }
    }
    
    // insert the new data in databases
    public void insertOrderData(int orderNo, String orderDate, int orderQty, String descriptions, int itemNo, int paymentNo, int customerId) {
        try {
            connection = driverConnection.getDatabaseConnection();
            PreparedStatement insertStatement = connection.prepareStatement(saleConstants.INSERT_ORDER_ALL_DATA);
            insertStatement.setInt(1, orderNo);
            insertStatement.setString(2, orderDate);
            insertStatement.setInt(3, orderQty);
            insertStatement.setString(4, descriptions);
            insertStatement.setInt(5, itemNo);
            insertStatement.setInt(6, paymentNo); 
            insertStatement.setInt(7, customerId);
            // insert data in the databse
            insertStatement.executeUpdate();
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Supplier data cannot insert.");
        }
    }
    
    // update the orders data
    public void updateOrderData(String orderDate, int orderQty, String descriptions, int itemNo, int paymentNo, int customerId, int orderNo) throws ClassNotFoundException{
        try{
            connection = driverConnection.getDatabaseConnection();
            PreparedStatement updateStatement = connection.prepareStatement(saleConstants.UPDATE_ORDER_DATA);
            updateStatement.setString(1, orderDate);
            updateStatement.setInt(2, orderQty);
            updateStatement.setString(3, descriptions);
            updateStatement.setInt(4, itemNo);
            updateStatement.setInt(5, paymentNo); 
            updateStatement.setInt(6, customerId);
            updateStatement.setInt(7, orderNo);
             
            updateStatement.executeUpdate(); 
        } catch(SQLException ex){
            System.out.println("Failed: "+orderNo);
        }
    }
    
    // delete orders data from database
    public void deleteOrder(int orderNo) {
        try{
            PreparedStatement deleteStatement = connection.prepareStatement(saleConstants.DELETE_ORDER_DATA);
            deleteStatement.setInt(1, orderNo);
            if(deleteStatement.executeUpdate()>=0){
                System.out.println("Sucess");
            }else{
                System.out.println("Failed");
            }
        }catch(SQLException ex){
            System.out.println("SQLException: "+orderNo);
        }  
    }
}

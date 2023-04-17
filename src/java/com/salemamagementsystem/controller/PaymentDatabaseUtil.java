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
@ManagedBean(name = "paymentDbBean")
@SessionScoped
public class PaymentDatabaseUtil {
    
    // create an object SaleConstants class
    SaleConstants saleConstants = new SaleConstants();
    DriverConnection driverConnection = new DriverConnection();
    Connection connection; // create an object of driver connection
    
    // get the all payments data
    public ResultSet getPaymentData() {
        try {
            connection = driverConnection.getDatabaseConnection();
            Statement statement = (Statement) connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            ResultSet resultSet = statement.executeQuery(saleConstants.GET_ALL_PAYMENT_DATA);
            return resultSet;
        } catch (ClassNotFoundException | SQLException ex) {
            return null;
        }
    }
    
     // insert the new data in databases
    public void insertPaymentData(int paymentNo, double amounts, String paymentDate, String remarks) {
        try {
            connection = driverConnection.getDatabaseConnection();
            PreparedStatement insertStatement = connection.prepareStatement(saleConstants.INSERT_PAYMENT_ALL_DATA);
            insertStatement.setInt(1, paymentNo);
            insertStatement.setDouble(2, amounts);
            insertStatement.setString(3, paymentDate);
            insertStatement.setString(4, remarks);
//            insertStatement.setInt(4, customerId);

            insertStatement.executeUpdate();
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Payment data cannot insert.");
        }
    }
    
    // update the suppliers data
    public void updatePaymentData(double amounts, String paymentDate, String remarks, int paymentNo) throws ClassNotFoundException{
        try{
            connection = driverConnection.getDatabaseConnection();
            PreparedStatement updateStatement = connection.prepareStatement(saleConstants.UPDATE_PAYMENT_DATA);
            updateStatement.setDouble(1, amounts);
            updateStatement.setString(2, paymentDate);
            updateStatement.setString(3, remarks);
            updateStatement.setInt(4, paymentNo); 

            updateStatement.executeUpdate(); 
        } catch(SQLException ex){
            System.out.println("Failed: "+paymentNo);
        }
    }
    
    // delete suppliers data from database
    public void deletePayment(int paymentNo) {
        try{
            PreparedStatement deleteStatement = connection.prepareStatement(saleConstants.DELETE_PAYMENT_DATA);
            deleteStatement.setInt(1, paymentNo);
            if(deleteStatement.executeUpdate()>=0){
                System.out.println("Sucess");
            }else{
                System.out.println("Failed");
            }
        }catch(SQLException ex){
            System.out.println("Failed: "+paymentNo);
        }  
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.salemamagementsystem.controller;

/**
 *
 * @author Lenovo
 */

import com.salemamagementsystem.model.SupplierModelBean;
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
@ManagedBean(name = "supplierDbBean")
@SessionScoped
public class SupplierDatabaseUtil {
    int supplierId;
    String supplierName;
    String supplierMail;
    String supplierLocation;
    String supplierContactNo;
    
    // create an object SaleConstants class
    SupplierModelBean supplierModelBean = new SupplierModelBean();
    SaleConstants saleConstants = new SaleConstants();
    DriverConnection driverConnection = new DriverConnection();
    Connection connection; // create an object of driver connection
    
    public ResultSet getSupplierData() {
        try {
            connection = driverConnection.getDatabaseConnection();
            Statement statement = (Statement) connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            ResultSet resultSet = statement.executeQuery(saleConstants.GET_ALL_SUPPLIER_DATA);
            return resultSet;
        } catch (ClassNotFoundException | SQLException ex) {
            return null;
        }
    }
    
     // insert the new data in databases
    public void insertSupplierData(int supplierId, String name, String mail, String location, String contactNo) {
        try {
            connection = driverConnection.getDatabaseConnection();
            PreparedStatement insertStatement = connection.prepareStatement(saleConstants.INSERT_SUPPLER_ALL_DATA);
            insertStatement.setInt(1, supplierId);
            insertStatement.setString(2, name);
            insertStatement.setString(3, mail);
            insertStatement.setString(4, location);
            insertStatement.setString(5, contactNo);

            insertStatement.executeUpdate();
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Supplier data cannot insert.");
        }
    }
    
    // update the suppliers data
    public void updateSupplierData(String name, String mail, String location, String contactNo, int supplierId) throws ClassNotFoundException{
        try{
            connection = driverConnection.getDatabaseConnection();
            PreparedStatement updateStatement = connection.prepareStatement(saleConstants.UPDATE_SUPPLIER_DATA);
            updateStatement.setString(1, name);
            updateStatement.setString(2, mail);
            updateStatement.setString(3, location);
            updateStatement.setString(4, contactNo);
            updateStatement.setInt(5, supplierId); 

            updateStatement.executeUpdate(); 
        } catch(SQLException ex){
            System.out.println("Failed: "+supplierId);
        }
    }
    
    // delete suppliers data from database
    public void deleteSupplier(int supplier_id) {
        try{
            PreparedStatement deleteStatement = connection.prepareStatement(saleConstants.DELETE_SUPPLIER_DATA);
            deleteStatement.setInt(1, supplier_id);
            if(deleteStatement.executeUpdate()>=0){
                System.out.println("Sucess");
            }else{
                System.out.println("Failed");
            }
        }catch(SQLException ex){
            System.out.println("Failed: "+supplier_id);
        }  
    }
    
    
    
}

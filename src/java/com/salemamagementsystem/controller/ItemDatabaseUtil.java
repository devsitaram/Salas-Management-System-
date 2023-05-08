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
 * this is the item database Util class where the direct the connect 
 * the data to get the data, insert, update and delete in the data base
 * @author Lenovo
 */
@RequestScoped
@ManagedBean(name = "itemDbBean")
@SessionScoped
public class ItemDatabaseUtil {

    SaleConstants saleConstants = new SaleConstants();
    DriverConnection driverConnection = new DriverConnection();
    Connection connection; // create an object of driver connection

    // get the items details
    public ResultSet getItemsData() {
        try {
            connection = driverConnection.getDatabaseConnection();
            Statement statement = (Statement) connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            ResultSet resultSet = statement.executeQuery(saleConstants.GET_ALL_ITEM_DATA);
            return resultSet;
        } catch (ClassNotFoundException | SQLException ex) {
            return null;
        }
    }

    // insert the new data in databases
    public void insertItemData(int itemNo, String itemName, double prices, int itemQty, String sypplyDate, int supplierId) {
        if (itemNo == 0 || itemName == null || prices == 0 || itemQty == 0 || itemQty == 0 || sypplyDate == null || supplierId == 0) {
            System.out.println("The fields is empty!");
        } else {
            try {
                connection = driverConnection.getDatabaseConnection();
                PreparedStatement insertStatement = connection.prepareStatement(saleConstants.INSERT_ITEM_ALL_DATA);
                insertStatement.setInt(1, itemNo);
                insertStatement.setString(2, itemName);
                insertStatement.setDouble(3, prices);
                insertStatement.setInt(4, itemQty);
                insertStatement.setString(5, sypplyDate);
                insertStatement.setInt(6, supplierId);

                insertStatement.executeUpdate();
            } catch (ClassNotFoundException | SQLException ex) {
                System.out.println("Supplier data cannot insert.");
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

    // update the suppliers data
    public void updateItemData(String itemName, double prices, int itemQty, String supplyDate, int supplierId, int itemNo) throws ClassNotFoundException {
        if (itemNo == 0 || itemName == null || prices == 0 || itemQty == 0 || itemQty == 0 || supplyDate == null || supplierId == 0) {
            System.out.println("The fields is empty!");
        } else {
            try {
                connection = driverConnection.getDatabaseConnection();
                PreparedStatement updateStatement = connection.prepareStatement(saleConstants.UPDATE_ITEM_DATA);
                updateStatement.setString(1, itemName);
                updateStatement.setDouble(2, prices);
                updateStatement.setInt(3, itemQty);
                updateStatement.setString(4, supplyDate);
                updateStatement.setInt(5, supplierId);
                updateStatement.setInt(6, itemNo);

                updateStatement.executeUpdate();
            } catch (SQLException ex) {
                System.out.println("Failed: " + supplierId);
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

    // delete suppliers data from database
    public void deleteItem(int itemNo) {
        try {
            PreparedStatement deleteStatement = connection.prepareStatement(saleConstants.DELETE_ITEM_DATA);
            deleteStatement.setInt(1, itemNo);
            if (deleteStatement.executeUpdate() >= 0) {
                System.out.println("Sucess");
            } else {
                System.out.println("Failed");
            }
        } catch (SQLException ex) {
            System.out.println("SQLException: " + itemNo);
        }
    }
}

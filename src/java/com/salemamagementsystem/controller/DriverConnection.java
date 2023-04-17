/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.salemamagementsystem.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import resources.SaleConstants;


/**
 *
 * @author Lenovo
 */
public class DriverConnection {
    
    // connect to the databses driver
    public Connection getDatabaseConnection() throws SQLException, ClassNotFoundException {
        SaleConstants saleConstants = new SaleConstants(); // create an object of SaleConstants class
        Class.forName(saleConstants.JDBC_DRIVER);
        Connection connection = DriverManager.getConnection(saleConstants.DB_URL);
        return connection;
    }
    
}

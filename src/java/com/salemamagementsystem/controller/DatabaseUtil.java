package com.salemamagementsystem.controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import com.salemamagementsystem.model.CustomerBean;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import resources.SaleConstants;

@RequestScoped
@ManagedBean(name="customerDbBean")
@SessionScoped 
public class DatabaseUtil {

    // customer table's global variables
    int customerId;
    String customerName;
    String customerEmail;
    String customerAddress;
    String customerPhone;
    String customerPassword;
                
    // create an object
    SaleConstants saleConstants = new SaleConstants();
    CustomerBean customerBean = new CustomerBean();
        
    // connect to the databses
    public Connection getDatabaseConnection() throws SQLException, ClassNotFoundException {
        Class.forName(saleConstants.JDBC_DRIVER);
        Connection connection = DriverManager.getConnection(saleConstants.DB_URL);
        return connection;
    }

    // get all the customer detials from data bases
    public ResultSet getAddresses() {
        try{
            Connection connection = getDatabaseConnection();
            Statement statement = (Statement) connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, 
                ResultSet.CONCUR_READ_ONLY);
           ResultSet resultSet = statement.executeQuery(saleConstants.GET_ALL_CUSTOMER_DATA);
           // register the customer data
           insertCustomerData(500,"Sitaram Theeng","sita1123@gmail.com","Ktm","9810183450","12fwjf"); //
           return resultSet;
        } catch (ClassNotFoundException | SQLException ex) {
            return null;
        }
    }
    
    // get all customer data from databses and check to insert the valid data (customer data are register)
    public void insertCustomerData(int customer_id, String customer_name, String email, String address, String phone_no, String password){
        try{ 
            Connection connection = getDatabaseConnection();
            Statement statement = (Statement) connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, 
                ResultSet.CONCUR_READ_ONLY);
            ResultSet rsCustomersData = statement.executeQuery(saleConstants.GET_ALL_CUSTOMER_DATA);
            // while loop
            while (rsCustomersData.next()) {
                // get the customer details and store the veriable
                customerId = rsCustomersData.getInt("customer_id");
                customerName = rsCustomersData.getString("customer_name"); 
                customerEmail = rsCustomersData.getString("email"); // must be uniques
                customerAddress = rsCustomersData.getString("address");
                customerPhone = rsCustomersData.getString("phone_no"); // must be uniques
                customerPassword = rsCustomersData.getString("password");  
                // check the if statements
                if(customer_name.equals(customerName)&& password.equals(customerPassword)){
                    System.out.println("The password must be unique");
                    break;
                } else {
                    if(phone_no.equals(customerPhone)){
                        System.out.println("The phone number must be unique");
                        break;
                    } else {
                        if(email.equals(customerEmail)){
                            System.out.println("The email must be unique");
                            break;
                        } else {
                            // data insert in databases 
                            PreparedStatement preStatementCustomer = connection.prepareStatement(saleConstants.INSERT_CUSTOMER_ALL_DATA);
                            // set the  data
                            preStatementCustomer.setInt(1, customer_id);
                            preStatementCustomer.setString(2, customer_name);
                            preStatementCustomer.setString(3, email);
                            preStatementCustomer.setString(4, address);
                            preStatementCustomer.setString(5, phone_no);
                            preStatementCustomer.setString(6, password);
                            // exexute to insert data
                            preStatementCustomer.executeUpdate();
                        }
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Customer Id must be uniqe: "+ex);
        }
    }
    
    
    
    public void getInsertCustomerData(int customer_id, String Customer_name, String email, String address, String phone_no, String password){
        try{
            Connection connection = getDatabaseConnection();         
            PreparedStatement psInsertStatement = connection.prepareStatement(saleConstants.INSERT_CUSTOMER_ALL_DATA);
     
            psInsertStatement.setString(1, Customer_name);
            psInsertStatement.setString(2, email);
            psInsertStatement.setString(3, address);
            psInsertStatement.setString(4, phone_no);
            psInsertStatement.setString(5, password);
            psInsertStatement.setInt(6, customer_id);

            
            psInsertStatement.executeUpdate(); // update 
            
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
    } 
     
     
     
     
     
     
     
     
     
    // ge data from databses
//    public ResultSet getCustomerData(){
//        try{
//            Connection connection = getDatabaseConnection();
//            Statement statement = (Statement) connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
//                    ResultSet.CONCUR_READ_ONLY);
//           ResultSet resultSet = statement.executeQuery(saleConstants.GET_CUSTOMER_ALL_DATA);
//           return resultSet;
//        } catch (ClassNotFoundException | SQLException ex) {
//            return null;
//        }
//    }  
  
    
//    insert the new data in databases (INSERT INTO students Values (100, 'Sona', MAD, sona12@gmail.com, 9807243843))
//    public void addStudentAddress (int londonmet_Id, String name, String honors, String email, String phone) throws ClassNotFoundException, SQLException{
//        Connection connection = getDatabaseConnection();
//        PreparedStatement insertStatement = connection.prepareStatement(saleConstants.GET_CUSTOMER_ALL_DATA);
//        insertStatement.setInt(1, londonmet_Id);
//        insertStatement.setString(2, name);
//        insertStatement.setString(3, honors);
//        insertStatement.setString(4, email);
//        insertStatement.setString(5, phone);
//
//        insertStatement.executeUpdate();
//    }

    // update data in databases (Update students Set name = Sana, honors = MAD, email = sana12@gmail.com, phone = 9890990000 WHERE londonmet_id = 100;)
//    public void updateAddress(String name, String honors, String email, String phone, int londonmet_Id) throws SQLException, ClassNotFoundException{
//        
//        Connection connection = getDatabaseConnection();
//        PreparedStatement updateStatement = connection.prepareStatement(saleConstants.UPDATE_QUERY);
//        updateStatement.setString(1, name);
//        updateStatement.setString(2, honors);
//        updateStatement.setString(3, email);
//        updateStatement.setString(4, phone);
//        updateStatement.setInt(5, londonmet_Id); 
//            
//        updateStatement.executeUpdate();// return the int data but this methods have return types is void
//    }
    
    // delete from databases (DELETE FROM students WHERE LONDONMET_ID = 100;)
//    public void deleteAddress(int londonmet_Id)throws SQLException, ClassNotFoundException{
//        
//        Connection connection = getDatabaseConnection();
//        PreparedStatement deleteStatement = connection.prepareStatement(saleConstants.DELEDE_QUERY);
//        deleteStatement.setInt(1, londonmet_Id);
//        
//        deleteStatement.executeUpdate();
//    }
    
    // get result 
//    public String getResult(){
//        if(customerBean.customer_name!=null||customerBean.email!=null||customerBean.phone_no!=null){
//            return "<p style=\"background: yellow; width: 200px; padding: 5px/>Customer Name: " +customerBean.getCustomer_name()+"<br/> Address: "+customerBean.getAddress()+"<br/> Email: "+customerBean.getEmail()+"<br/> Phone No: "+customerBean.getPhone_no()+"</p>";
//        } else {
//            return "";
//        }
//    }
}

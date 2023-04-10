package com.salemamagementsystem.controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import com.salemamagementsystem.model.CustomerModelBean;
import com.salemamagementsystem.model.ItemModelBean;
import com.salemamagementsystem.model.OrderModelBean;
import com.salemamagementsystem.model.PaymentModelBean;
import com.salemamagementsystem.model.SupplierModelBean;
import java.sql.Connection;
import java.sql.DriverManager;
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
public class DatabaseUtil {

    // customer table's global variables and also create an object of customer class, supplier class, payment class, item class and order class
    CustomerModelBean customerModelBean = new CustomerModelBean();
    int customerId;
    String customerName;
    String customerEmail;
    String customerAddress;
    String customerPhone;
    String customerPassword;
    
    SupplierModelBean supplierModelBean = new SupplierModelBean();
    int supplierId;
    String supplierName;
    String supplierMail;
    String supplierLocation;
    String supplierContactNo;
    
    ItemModelBean itemModelBean = new ItemModelBean();
    int itemNo;
    String itemName;
    double itmePrices;
    int itemQty;
    String sullpyDate;
    
    PaymentModelBean paymentModelBean = new PaymentModelBean();
    int paymentNo;
    double payAmounts;
    String paymentDate;
    String payRemarks;
    
    OrderModelBean orderModelBean = new OrderModelBean();
    int orederNo;
    String orderDate;
    String orderQty;
    String orderDescriptions;
    
    // create an object SaleConstants class
    SaleConstants saleConstants = new SaleConstants();
    Connection connection; // create an object of driver connection

    // connect to the databses driver
    public Connection getDatabaseConnection() throws SQLException, ClassNotFoundException {
        Class.forName(saleConstants.JDBC_DRIVER);
        connection = DriverManager.getConnection(saleConstants.DB_URL);
        return connection;
    }

    // get all the customer detials from data bases
    public ResultSet getCustomerData() {
        try {
            connection = getDatabaseConnection();
            Statement statement = (Statement) connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            ResultSet resultSet = statement.executeQuery(saleConstants.GET_ALL_CUSTOMER_DATA);
           
            
//        insertOrderData(440, "05-04-2023", 5, "Foode odrer", 404, 904, 400);     
                    
            
            return resultSet;
        } catch (ClassNotFoundException | SQLException ex) {
            return null;
        }
    }

    // login to check the username and password
    public String loginUser(String username, String password) {
        if (customerModelBean.customerName == null || customerModelBean.password == null) {
            return "<p style=\"background: yellow; width: 200px; padding: 5px/> Username: " 
                    + customerModelBean.getCustomerName()+ "<br/> Password: " + customerModelBean.getPassword()+"</p>";
        } else {
            System.out.println("Invalid username and password!");
            return "";
        }
    }

    // get all customer data from databses and check to insert the valid data (customer data are register)
    public void insertCustomerData(int customer_id, String customer_name, String email, String address, String phone_no, String password) {
        try {
            connection = getDatabaseConnection();
            Statement statement = (Statement) connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rsCustomersData = statement.executeQuery(saleConstants.GET_CUSTOMER_DATA);
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
                if (!password.equals(customerPassword) && !customer_name.equals(customerName)) {
//                    if (!phone_no.equals(customerPhone)) {
//                        if (!email.equals(customerEmail)) {
                            // data insert in databases 
                            PreparedStatement preStatementCustomer = connection.prepareStatement(saleConstants.INSERT_CUSTOMER_ALL_DATA);
                            // set the  data
                            preStatementCustomer.setInt(1, customer_id);
                            preStatementCustomer.setString(2, customer_name);
                            preStatementCustomer.setString(3, email);
                            preStatementCustomer.setString(4, address);
                            preStatementCustomer.setString(5, phone_no);
                            preStatementCustomer.setString(6, password);
//                            System.out.println("Id: " + customerId + " Name: " + customerName + " Email: " + customerEmail + " Address: " + customerAddress + " Phone: " + customerPhone + " Password: " + customerPassword);
                            // exexute to insert data
                            preStatementCustomer.executeUpdate();
                            // Close the result set, statement, and connection
                            rsCustomersData.close();
                            statement.close();
                            connection.close();
//                        } else {
//                            System.out.println("The email must be unique");
//                            break;
//                        }
//                    } else {
//                        System.out.println("The phone number must be unique");
//                        break;
//                    }
                } else {
                    System.out.println("The password must be unique");
                    break;
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Customer Id must be uniqe: " + ex);
        }
    }

    
    
    public void insertOrderData(int order_no, String order_date, int order_qty, String descriptions, int item_no, int payment_no, int customer_id){
        try{
            // data insert in databases 
            PreparedStatement preStatementOrder = connection.prepareStatement(saleConstants.INSERT_CUSTOMER_ALL_DATA);
            // set/insert the  data
            preStatementOrder.setInt(1, order_no);
            preStatementOrder.setString(2, order_date);
            preStatementOrder.setInt(3, order_qty);
            preStatementOrder.setString(4, descriptions);
            preStatementOrder.setInt(5, item_no);
            preStatementOrder.setInt(6, payment_no);
            preStatementOrder.setInt(7,customer_id);
            // exexute to insert data
            preStatementOrder.executeUpdate();
        }catch(SQLException ex){
            System.out.println("Order Id valid data:" + ex);
        }
    }
    
    
    
    
    
    // update the customer data
    public void updateCustomerData(String name, String email, String address, String phone_no, String password, int customer_id) throws SQLException, ClassNotFoundException{
        connection = getDatabaseConnection();
        PreparedStatement updateStatement = connection.prepareStatement(saleConstants.UPDATE_CUSTOMER_DATA);
        updateStatement.setString(1, name);
        updateStatement.setString(2, email);
        updateStatement.setString(3, address);
        updateStatement.setString(4, phone_no);
         updateStatement.setString(4, password);
        updateStatement.setInt(6, customer_id); 
            
        updateStatement.executeUpdate(); // return the int data but this methods have return types is void
    }
    
    /**
     * all the given below methods are delete methods where unnecessary data was delete from database table
     * @param customer_id,supplier_id,item_no,payment_no,order_no
     * @throws SQLException
     * @throws ClassNotFoundException
     * deleteCustomerData methods can be delete the customer data,
     * deleteSupplierData methods can be delete the supplier data,
     * deleteItemDaata methods can be delete the item data,
     * deletePaymentData methods can be delete the payment data,
     * deleteOrderData methods can be delete the order data
     */
    // delete customer data from database
    public void deleteCustomerData(int customer_id)throws SQLException, ClassNotFoundException{
        connection = getDatabaseConnection();
        PreparedStatement deleteStatement = connection.prepareStatement(saleConstants.DELEDE_CUSTOMER_DATA);
        deleteStatement.setInt(1, customer_id);
        deleteStatement.executeUpdate();
    }
    
    // delete supplier data from database
    public void deleteSupplierData(int supplier_id)throws SQLException, ClassNotFoundException{
        connection = getDatabaseConnection();
        PreparedStatement deleteStatement = connection.prepareStatement(saleConstants.DELEDE_SUPPLIER_DATA);
        deleteStatement.setInt(1, supplier_id);
        deleteStatement.executeUpdate();
    }
    
    // delete item data from database
    public void deleteItemDaata(int item_no)throws SQLException, ClassNotFoundException{
        connection = getDatabaseConnection();
        PreparedStatement deleteStatement = connection.prepareStatement(saleConstants.DELEDE_ITEM_DATA);
        deleteStatement.setInt(1, item_no);
        deleteStatement.executeUpdate();
    }
    
    // delete payment data from database
    public void deletePaymentData(int payment_no)throws SQLException, ClassNotFoundException{
        connection = getDatabaseConnection();
        PreparedStatement deleteStatement = connection.prepareStatement(saleConstants.DELEDE_PAYMENT_DATA);
        deleteStatement.setInt(1, payment_no);
        deleteStatement.executeUpdate();
    }
    
    // delete order data from database
    public void deleteOrderData(int order_no)throws SQLException, ClassNotFoundException{
        connection = getDatabaseConnection();
        PreparedStatement deleteStatement = connection.prepareStatement(saleConstants.DELEDE_ORDER_DATA);
        deleteStatement.setInt(1, order_no);
        deleteStatement.executeUpdate();
    }
    
    
    
    
//    public void getInsertCustomerData(int customer_id, String Customer_name, String email, String address, String phone_no, String password) {
//        try {
//            Connection connection = getDatabaseConnection();
//            PreparedStatement psInsertStatement = connection.prepareStatement(saleConstants.INSERT_CUSTOMER_ALL_DATA);
//
//            psInsertStatement.setString(1, Customer_name);
//            psInsertStatement.setString(2, email);
//            psInsertStatement.setString(3, address);
//            psInsertStatement.setString(4, phone_no);
//            psInsertStatement.setString(5, password);
//            psInsertStatement.setInt(6, customer_id);
//
//            psInsertStatement.executeUpdate(); // update 
//
//        } catch (ClassNotFoundException | SQLException ex) {
//            System.out.println(ex);
//        }
//    }

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

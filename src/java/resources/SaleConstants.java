/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package resources;

/**
 *
 * @author Lenovo
 */
public class SaleConstants {
    // connection to driver and localhost derby databases
    public final String JDBC_DRIVER = "org.apache.derby.client.ClientAutoloadedDriver";
    public final String DB_URL = "jdbc:derby://localhost:1527/saledb";
    // this are get the all data from each table
    public final String GET_ALL_CUSTOMER_DATA = "Select * from ADMIN.customers";
    public final String GET_ALL_SUPPLIER_DATA = "Select * from ADMIN.suppliers";
    public final String GET_ALL_ITEM_DATA = "Select * from ADMIN.items";
    public final String GET_ALL_PAYMENT_DATA = "Select * from ADMIN.payments";
    public final String GET_ALL_ORDER_DATA = "Select * from ADMIN.orders";
    // insert the data in the databases table
    public final String INSERT_CUSTOMER_ALL_DATA = "INSERT INTO ADMIN.customers Values (?, ?, ?, ?, ?, ?)";
    public final String INSERT_SUPPLER_ALL_DATA = "INSERT INTO ADMIN.suppliers Values (?, ?, ?, ?, ?, ?)";
    public final String INSERT_ITEM_ALL_DATA = "INSERT INTO ADMIN.items Values (?, ?, ?, ?, ?)";
    public final String INSERT_PAYMENT_ALL_DATA = "INSERT INTO ADMIN.payments Values (?, ?, ?, ?)";
    public final String INSERT_ORDER_ALL_DATA = "INSERT INTO ADMIN.orders Values (?, ?, ?, ?, ?, ?, ?)";
    // Update the data in the databases table
    public final String UPDATE_CUSTOMER = "Update ADMIN.customers Set customer_name = ?, email = ?, address = ?, phone_no = ?, password = ? WHERE customer_id = ?";
    public final String UPDATE_SUPPLIER = "USpdate ADMIN.supplier Set supplier_name = ?, mail = ?, location = ?, contact_no = ? WHERE supplier_id = ?";
    public final String UPDATE_ITEM = "Update ADMIN.items Set customer_name = ?, email = ?, address = ?, phone_no = ? WHERE item_no = ?";
    public final String UPDATE_PAYMENT = "Update ADMIN.payments Set amounts = ?, payment_date = ?, remarks = ? WHERE payment_no = ?";
    public final String UPDATE_ORDER = "Update ADMIN.orders Set order_date = ?, order_qty = ?, descriptions = ?, item_no =?, payment_no = ?, customer_id = ? WHERE order_no = ?";
    // delete data from databses
    public final String DELEDE_CUSTOMER = "DELETE FROM ADMIN.customers WHERE CUSTOMER_ID = ?";
    public final String DELEDE_SUPPLIER = "DELETE FROM ADMIN.supplires WHERE SUPPLIER_ID = ?";
    public final String DELEDE_ITEM = "DELETE FROM ADMIN.items WHERE ITEM_NO = ?";
    public final String DELEDE_PAYMENT = "DELETE FROM ADMIN.payments WHERE PAYMENT_NO = ?";
    public final String DELEDE_ORDER = "DELETE FROM ADMIN.orders WHERE ORDER_NO = ?";
}

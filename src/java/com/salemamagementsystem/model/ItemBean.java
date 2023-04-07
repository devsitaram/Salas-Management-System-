/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.salemamagementsystem.model;

/**
 *
 * @author Lenovo
 */
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.apache.derby.client.am.Decimal;

@ManagedBean(name="itemDbBean")
@SessionScoped 
public class ItemBean {
    int item_no;
    String item_name;
    Decimal prices;
    String item_qty;
    int supplier_id;
    String supply_date;

    public int getItem_no() {
        return item_no;
    }

    public void setItem_no(int item_no) {
        this.item_no = item_no;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public Decimal getPrices() {
        return prices;
    }

    public void setPrices(Decimal prices) {
        this.prices = prices;
    }

    public String getItem_qty() {
        return item_qty;
    }

    public void setItem_qty(String item_qty) {
        this.item_qty = item_qty;
    }

    public int getSupplier_id() {
        return supplier_id;
    }

    public void setSupplier_id(int supplier_id) {
        this.supplier_id = supplier_id;
    }

    public String getSupply_date() {
        return supply_date;
    }

    public void setSupply_date(String supply_date) {
        this.supply_date = supply_date;
    }
}

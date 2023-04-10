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

@ManagedBean(name="paymentDbBean")
@SessionScoped 
public class PaymentModelBean {
    int payment_no;
    Double amounts;
    String payment_date;
    String remarks;

    public int getPayment_no() {
        return payment_no;
    }

    public void setPayment_no(int payment_no) {
        this.payment_no = payment_no;
    }

    public Double getAmounts() {
        return amounts;
    }

    public void setAmounts(Double amounts) {
        this.amounts = amounts;
    }

    public String getPayment_date() {
        return payment_date;
    }

    public void setPayment_date(String payment_date) {
        this.payment_date = payment_date;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}

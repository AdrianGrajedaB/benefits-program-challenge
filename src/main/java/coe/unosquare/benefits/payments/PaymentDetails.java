/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coe.unosquare.benefits.payments;

import coe.unosquare.benefits.creditcards.CreditCard;
import java.time.LocalDate;

/**
 *
 * @author adrian.grajeda
 */
public class PaymentDetails {
    
    private final LocalDate date;
    private final PaymentType type;
    private CreditCard creditCard;
    private Double totalAmount;
    private Double discount;
    private Double finalAmount;

    public PaymentDetails(PaymentType type) {
        this.date = LocalDate.now();
        this.type = type;
    }

    public PaymentDetails(PaymentType type, CreditCard creditCard) {
        this(type);
        this.creditCard = creditCard;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public LocalDate getDate() {
        return date;
    }

    public PaymentType getType() {
        return type;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Double getFinalAmount() {
        return finalAmount;
    }

    public void setFinalAmount(Double finalAmount) {
        this.finalAmount = finalAmount;
    }
    
    
    
    
    
}

/*
 *  PaymentDetails
 *  1.0
 *  3/6/2023 16:00
 *  Copyright (c) 2023 Unosquare
 *  Any illegal reproduction of this content will result in immediate legal action.
 */
package coe.unosquare.benefits.payments;

import coe.unosquare.benefits.creditcards.CreditCard;
import java.time.LocalDate;

/**
 * Hold the important information of {@link Order}'s payment.
 * @author adrian.grajeda
 */
public class PaymentDetails {
    
    /** the Date of the payment. */
    private final LocalDate date;
    /** the type of the payment. */
    private final PaymentType type;
    /**  the credit card used in the payment. */
    private CreditCard creditCard;
    /** the total amount of the order. */
    private Double totalAmount;
    /** the discount's percentage, if any. */
    private Double discount;
    /** the final amount to pay, after any discount. */
    private Double finalAmount;

    /**
     * Creates a new instance of this class..
     * @param type the type of the payment
     */
    public PaymentDetails(PaymentType type) {
        this.date = LocalDate.now();
        this.type = type;
    }

    /**
     * Creates a new instance of this class..
     * @param type the type of the payment
     * @param creditCard the credit card
     */
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

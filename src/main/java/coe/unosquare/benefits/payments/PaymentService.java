/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coe.unosquare.benefits.payments;

import coe.unosquare.benefits.creditcards.CreditCard;
import coe.unosquare.benefits.order.Order;

/**
 *
 * @author adrian.grajeda
 */
public interface PaymentService {
    
    public PaymentDetails processPayment(Order order, final CreditCard creditCard);
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coe.unosquare.benefits.payments;

import coe.unosquare.benefits.creditcards.CreditCard;
import coe.unosquare.benefits.creditcards.CreditCardParser;
import coe.unosquare.benefits.order.Order;

/**
 *
 * @author adrian.grajeda
 */
public final class PayOrderManager {

    private PayOrderManager() {
    }

    public static PaymentDetails payOrder(final Order order, final CreditCard creditCard) {
        final PaymentService paymentService = PaymentServiceFactory.createPaymentService(creditCard);
        return paymentService.processPayment(order, creditCard);
    }

    public static PaymentDetails payOrder(final Order order, final String creditCardType) {
        final CreditCard creditCard = CreditCardParser.parseFromString(creditCardType);
        return payOrder(order, creditCard);
    }

}

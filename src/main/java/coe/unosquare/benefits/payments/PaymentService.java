/*
 *  PaymentService
 *  1.0
 *  3/6/2023 16:00
 *  Copyright (c) 2023 Unosquare
 *  Any illegal reproduction of this content will result in immediate legal action.
 */
package coe.unosquare.benefits.payments;

import coe.unosquare.benefits.creditcards.CreditCard;
import coe.unosquare.benefits.order.Order;

/**
 * Represent the business logic to process a payment.
 *
 * @author adrian.grajeda
 */
public interface PaymentService {

    /**
     * Process the {@link Order}'s payment.
     *
     * @param order the order type
     * @param creditCard the credit card
     * @return the {@link PaymentDetails} of this payment
     */
    PaymentDetails processPayment(Order order, final CreditCard creditCard);

}

/*
 *  PayOrderManager
 *  1.0
 *  3/6/2023 16:00
 *  Copyright (c) 2023 Unosquare
 *  Any illegal reproduction of this content will result in immediate legal action.
 */
package coe.unosquare.benefits.payments;

import coe.unosquare.benefits.creditcards.CreditCard;
import coe.unosquare.benefits.creditcards.CreditCardParser;
import coe.unosquare.benefits.order.Order;

/**
 * Main class that handle all the logic to pay an {@link Order}.
 *
 * @author adrian.grajeda
 */
public final class PayOrderManager {

    /**
     * Default private constructor.
     */
    private PayOrderManager() {
    }

    /**
     * Main method that process the {@link Order}'s payment.
     *
     * @param order the order
     * @param creditCard the credit card
     * @return the {@link PaymentDetails}
     */
    public static PaymentDetails payOrder(final Order order, final CreditCard creditCard) {
        final PaymentService paymentService = PaymentServiceFactory.createPaymentService(creditCard);
        return paymentService.processPayment(order, creditCard);
    }

    /**
     * Main method that process the {@link Order}'s payment.
     *
     * @param order the order
     * @param creditCardType the credit card's type
     * @return the {@link PaymentDetails}
     */
    public static PaymentDetails payOrder(final Order order, final String creditCardType) {
        final CreditCard creditCard = CreditCardParser.parseFromString(creditCardType);
        return payOrder(order, creditCard);
    }

}

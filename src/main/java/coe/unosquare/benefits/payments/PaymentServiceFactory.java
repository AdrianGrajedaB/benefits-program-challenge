/*
 *  PaymentServiceFactory
 *  1.0
 *  3/6/2023 16:00
 *  Copyright (c) 2023 Unosquare
 *  Any illegal reproduction of this content will result in immediate legal action.
 */
package coe.unosquare.benefits.payments;

import coe.unosquare.benefits.creditcards.CreditCard;
import coe.unosquare.benefits.discounts.MasterCardDiscountProcessor;
import coe.unosquare.benefits.discounts.NoDiscountProcessor;
import coe.unosquare.benefits.discounts.VisaDiscountProcessor;

/**
 * Creates a new instance of {@link PaymentService}.
 * @author adrian.grajeda
 */
public final class PaymentServiceFactory {

    private PaymentServiceFactory() {
    }

    /**
     * Creates an instance of the {@link PaymentService} that can process
     * the payment using the credit card.
     * @param creditCard {@link CreditCard}
     * @return the new instance
     */
    public static PaymentService createPaymentService(final CreditCard creditCard) {
        switch (creditCard.getType()) {
            case VISA:
                return new DefaultPaymentService(new VisaDiscountProcessor());
            case MASTER_CARD:
                return new DefaultPaymentService(new MasterCardDiscountProcessor());
            default:
                return new DefaultPaymentService(new NoDiscountProcessor());
        }
    }

}

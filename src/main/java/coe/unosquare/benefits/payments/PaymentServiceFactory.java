/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coe.unosquare.benefits.payments;

import coe.unosquare.benefits.creditcards.CreditCard;
import coe.unosquare.benefits.discounts.MasterCardDiscountProcessor;
import coe.unosquare.benefits.discounts.NoDiscountProcessor;
import coe.unosquare.benefits.discounts.VisaDiscountProcessor;

/**
 *
 * @author adrian.grajeda
 */
public final class PaymentServiceFactory {

    private PaymentServiceFactory() {
    }

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

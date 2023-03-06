/*
 *  DefaultPaymentService
 *  1.0
 *  3/6/2023 16:00
 *  Copyright (c) 2023 Unosquare
 *  Any illegal reproduction of this content will result in immediate legal action.
 */
package coe.unosquare.benefits.payments;

import coe.unosquare.benefits.creditcards.CreditCard;
import coe.unosquare.benefits.discounts.DiscountProcessor;
import coe.unosquare.benefits.order.Order;
import java.util.Objects;

/**
 * Default implementation for {@link PaymentService}.
 * @author adrian.grajeda
 */
public class DefaultPaymentService implements PaymentService {

    /** {@link DiscountProcessor} type. */
    private final DiscountProcessor discountProcessor;

    /**
     * Creates a new instance of the class.
     * @param discountProcessor an implementation of {@link DiscountProcessor}.
     */
    public DefaultPaymentService(DiscountProcessor discountProcessor) {
        this.discountProcessor = discountProcessor;
    }

    /**
     * {@inheritDoc }.
     * @param order the order
     * @param creditCard the credit card
     * @return the payment details
     */
    @Override
    public PaymentDetails processPayment(final Order order, final CreditCard creditCard) {
        validateOrder(order);
        final PaymentDetails details = createPaymentDetails(creditCard);
        updateTotalAmount(order, details);
        updateDiscount(details, order);
        updateFinalAmount(details);
        return details;
    }

    /**
     * Validates if the {@link Order} is correct.
     * @param order the order type
     */
    private void validateOrder(final Order order) {
        if (Objects.isNull(order) || order.getProducts().isEmpty()) {
            throw new IllegalArgumentException("Order can't be null and must have at least one product");
        }
    }

    /**
     * Process the {@link Order} to calculate the total amount and update the value
     * in the {@link PaymentDetails}.
     * @param order the order
     * @param details the payment details
     */
    private void updateTotalAmount(final Order order, final PaymentDetails details) {
        var totalAmount = order.getProducts().entrySet()
                .stream()
                .mapToDouble(product -> product.getKey().getPrice() * product.getValue())
                .sum();
        details.setTotalAmount(totalAmount);
    }

    /**
     * Process the {@link Order} to calculate the discount percentage and update the value
     * in the {@link PaymentDetails}.
     * @param order the order
     * @param details the payment details
     */
    private void updateDiscount(final PaymentDetails details, final Order order) {
        var discount = discountProcessor.calculateDiscount(order);
        details.setDiscount(discount);
    }

    /**
     * Calculate the final amount of the order by subtracting the discount from 
     * the totalAmount.
     * @param details the payment details
     */
    private void updateFinalAmount(final PaymentDetails details) {
        var discountAmount = details.getTotalAmount() * details.getDiscount();
        var finalAmount = details.getTotalAmount() - discountAmount;
        details.setFinalAmount(finalAmount);
    }

    /**
     * Initialize a new {@link PaymentDetails} based on the {@link CreditCard}.
     * 
     */
    private PaymentDetails createPaymentDetails(final CreditCard creditCard) {
        validateCreditCard(creditCard);
        final PaymentDetails details = new PaymentDetails(PaymentType.CREDIT_CARD, creditCard);
        return details;
    }

    /**
     * Check if the {@link CreditCard} is correct.
     * @param creditCard the credit card
     */
    private void validateCreditCard(final CreditCard creditCard) {
        if (Objects.isNull(creditCard)) {
            throw new IllegalArgumentException("Credit Card can't be null");
        }

        if (Objects.isNull(creditCard.getType())) {
            throw new IllegalArgumentException("Credit Card's Type can't be null");
        }
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coe.unosquare.benefits.payments;

import coe.unosquare.benefits.creditcards.CreditCard;
import coe.unosquare.benefits.discounts.DiscountProcessor;
import coe.unosquare.benefits.order.Order;
import java.util.Objects;

/**
 *
 * @author adrian.grajeda
 */
public class DefaultPaymentService implements PaymentService {

    private final DiscountProcessor discountProcessor;

    public DefaultPaymentService(DiscountProcessor discountProcessor) {
        this.discountProcessor = discountProcessor;
    }

    @Override
    public PaymentDetails processPayment(final Order order, final CreditCard creditCard) {
        validateOrder(order);
        final PaymentDetails details = createPaymentDetails(creditCard);
        updateTotalAmount(order, details);
        updateDiscount(details, order);
        updateFinalAmount(details);
        return details;
    }

    private void validateOrder(final Order order) {
        if (Objects.isNull(order) || order.getProducts().isEmpty()) {
            throw new IllegalArgumentException("Order can't be null and must have at least one product");
        }
    }

    private void updateTotalAmount(final Order order, final PaymentDetails details) {
        var totalAmount = order.getProducts().entrySet()
                .stream()
                .mapToDouble(product -> product.getKey().getPrice() * product.getValue())
                .sum();
        details.setTotalAmount(totalAmount);
    }

    private void updateDiscount(final PaymentDetails details, final Order order) {
        var discount = discountProcessor.calculateDiscount(order);
        details.setDiscount(discount);
    }

    private void updateFinalAmount(final PaymentDetails details) {
        var discountAmount = details.getTotalAmount() * details.getDiscount();
        var finalAmount = details.getTotalAmount() - discountAmount;
        details.setFinalAmount(finalAmount);
    }

    private PaymentDetails createPaymentDetails(final CreditCard creditCard) {
        validateCreditCard(creditCard);
        final PaymentDetails details = new PaymentDetails(PaymentType.CREDIT_CARD, creditCard);
        return details;
    }

    private void validateCreditCard(final CreditCard creditCard) {
        if (Objects.isNull(creditCard)) {
            throw new IllegalArgumentException("Credit Card can't be null");
        }

        if (Objects.isNull(creditCard.getType())) {
            throw new IllegalArgumentException("Credit Card's Type can't be null");
        }
    }

}

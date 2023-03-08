/*
 *  MasterCardDiscountProcessor
 *  1.0
 *  3/6/2023 16:00
 *  Copyright (c) 2023 Unosquare
 *  Any illegal reproduction of this content will result in immediate legal action.
 */
package coe.unosquare.benefits.discounts;

import coe.unosquare.benefits.order.Order;

/**
 * Calculate the specific discount percentage for {@link CreditCardType#MASTER_CARD}.
 * @author adrian.grajeda
 */
public class MasterCardDiscountProcessor implements DiscountProcessor {

    private static final double EIGHT_DISCOUNT = 0.08;
    private static final double TWELVE_DISCOUNT = 0.12;
    private static final double SEVENTEEN_DISCOUNT = 0.17;
    
    /**
     * {@inheritDoc }.
     * @param order the order
     * @return the discount percentage
     */
    @Override
    public Double calculateDiscount(Order order) {
        final var products = order.getProducts();
        Double discount;
        final double totalAmount = products.entrySet()
                .stream()
                .mapToDouble(product -> product.getKey().getPrice() * product.getValue())
                .sum();
        if (totalAmount >= 100) {
            discount = SEVENTEEN_DISCOUNT;
        } else if (totalAmount >= 75 && totalAmount <= 99) {
            discount = TWELVE_DISCOUNT;
        } else {
            discount = EIGHT_DISCOUNT;
        }
        return discount;

    }

}

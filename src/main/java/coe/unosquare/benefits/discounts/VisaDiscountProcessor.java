/*
 *  VisaDiscountProcessor
 *  1.0
 *  3/6/2023 16:00
 *  Copyright (c) 2023 Unosquare
 *  Any illegal reproduction of this content will result in immediate legal action.
 */
package coe.unosquare.benefits.discounts;

import coe.unosquare.benefits.order.Order;

/**
 * /**
 * Calculate the specific discount percentage for
 * {@link CreditCardType#VISA_CARD}.
 *
 * @author adrian.grajeda
 */
public class VisaDiscountProcessor implements DiscountProcessor {

    private static final double FIVE_DISCOUNT = 0.05;
    private static final double TEN_DISCOUNT = 0.10;
    private static final double FIFTEEN_DISCOUNT = 0.15;
    private static final int SEVEN_PRODUCTS = 7;
    private static final int TEN_PRODUCTS = 10;

    /**
     * {@inheritDoc }.
     *
     * @param order the order
     * @return the discount percentage
     */
    @Override
    public Double calculateDiscount(Order order) {
        final var products = order.getProducts();
        Double discount;
        final Integer totalProductsCount = products.values()
                .stream()
                .reduce(0, (totalProductCount, quantity) -> totalProductCount += quantity);

        if (totalProductsCount >= TEN_PRODUCTS) {
            discount = FIFTEEN_DISCOUNT;
        } else if (totalProductsCount >= SEVEN_PRODUCTS && totalProductsCount <= 9) {
            discount = TEN_DISCOUNT;
        } else {
            discount = FIVE_DISCOUNT;
        }

        return discount;
    }

}

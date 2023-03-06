/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coe.unosquare.benefits.discounts;

import coe.unosquare.benefits.order.Order;

/**
 *
 * @author adrian.grajeda
 */
public class VisaDiscountProcessor implements DiscountProcessor {

    private static final double FIVE_DISCOUNT = 0.05;
    private static final double TEN_DISCOUNT = 0.10;
    private static final double FIFTEEN_DISCOUNT = 0.15;
    private static final int SEVEN_PRODUCTS = 7;
    private static final int TEN_PRODUCTS = 10;

    @Override
    public Double calculateDiscount(Order order) {
        final var products = order.getProducts();
        Double discount;

        if (products.values()
                .stream()
                .reduce(0, (totalProductCount, quantity) -> totalProductCount += quantity) >= TEN_PRODUCTS) {
            discount = FIFTEEN_DISCOUNT;
        } else if (products.values()
                .stream()
                .reduce(0, (totalProductCount, quantity) -> totalProductCount += quantity) >= SEVEN_PRODUCTS) {
            discount = TEN_DISCOUNT;
        } else {
            discount = FIVE_DISCOUNT;
        }

        return discount;
    }

}

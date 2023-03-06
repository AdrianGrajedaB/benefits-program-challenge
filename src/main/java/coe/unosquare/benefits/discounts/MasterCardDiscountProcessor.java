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
public class MasterCardDiscountProcessor implements DiscountProcessor {

    private static final double EIGHT_DISCOUNT = 0.08;
    private static final double TWELVE_DISCOUNT = 0.12;
    private static final double SEVENTEEN_DISCOUNT = 0.17;
    @Override
    public Double calculateDiscount(Order order) {
        final var products = order.getProducts();
        Double discount;
        if (products.entrySet()
                .stream()
                .mapToDouble(product -> product.getKey().getPrice() * product.getValue())
                .sum() >= 100) {
            discount = SEVENTEEN_DISCOUNT;
        } else if (products.entrySet().stream()
                .mapToDouble(product -> product.getKey().getPrice() * product.getValue())
                .sum() >= 75) {
            discount = TWELVE_DISCOUNT;
        } else {
            discount = EIGHT_DISCOUNT;
        }
        return discount;

    }

}

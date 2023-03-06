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
public class NoDiscountProcessor implements DiscountProcessor {

    @Override
    public Double calculateDiscount(Order order) {
        return ZERO;
    }
    private static final double ZERO = 0.0;
    
}

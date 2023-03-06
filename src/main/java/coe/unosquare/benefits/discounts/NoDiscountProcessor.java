/*
 *  NoDiscountProcessor
 *  1.0
 *  3/6/2023 16:00
 *  Copyright (c) 2023 Unosquare
 *  Any illegal reproduction of this content will result in immediate legal action.
 */
package coe.unosquare.benefits.discounts;

import coe.unosquare.benefits.order.Order;

/**
 *
 * @author adrian.grajeda
 */
public class NoDiscountProcessor implements DiscountProcessor {

    /** ZERO value. */
    private static final double ZERO = 0.0;
    
    /**
     * {@inheritDoc }.
     * @param order the order
     * @return the discount percentage
     */
    @Override
    public Double calculateDiscount(Order order) {
        return ZERO;
    }
    
}

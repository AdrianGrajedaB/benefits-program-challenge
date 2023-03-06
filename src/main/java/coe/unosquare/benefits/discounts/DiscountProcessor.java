/*
 *  DiscountProcessor
 *  1.0
 *  3/6/2023 16:00
 *  Copyright (c) 2023 Unosquare
 *  Any illegal reproduction of this content will result in immediate legal action.
 */
package coe.unosquare.benefits.discounts;

import coe.unosquare.benefits.order.Order;

/**
 * Represents the different types of discounts that can be applied. Implementing
 * classes should implement the specific discount logic.
 *
 * @author adrian.grajeda
 */
public interface DiscountProcessor {

    /**
     * Returns the discount percentage based on the {@link Order}.
     *
     * @param order the {@link Order} to calculate the discount
     * @return the discount percentage value
     */
    Double calculateDiscount(Order order);

}

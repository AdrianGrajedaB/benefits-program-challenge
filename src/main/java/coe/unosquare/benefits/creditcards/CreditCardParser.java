/*
 *  CreditCardParser
 *  1.0
 *  3/6/2023 16:00
 *  Copyright (c) 2023 Unosquare
 *  Any illegal reproduction of this content will result in immediate legal action.
 */
package coe.unosquare.benefits.creditcards;

/**
 * Help to parse a credit card, ie:
 * <ul>
 * <li> VISA </li>
 * <li> Master_Card </li>
 * </ul>
 *
 * @author adrian.grajeda
 */
public final class CreditCardParser {

    /**
     * Private constructor.
     */
    private CreditCardParser() {
    }

    /**
     * Help to parse a credit card, ie:
     * <ul>
     * <li> VISA </li>
     * <li> Master_Card </li>
     * </ul>
     *
     * @param creditCardType the credit card's type as text
     * @return a new {@link CreditCard} instance based on the type.
     */
    public static CreditCard parseFromString(final String creditCardType) {
        CreditCardType type = CreditCardType.valueOf(creditCardType.trim().toUpperCase());
        if (type != null) {
            return new CreditCard(type);
        }
        return new CreditCard(CreditCardType.OTHER);
    }

}

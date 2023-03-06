/*
 *  CreditCard
 *  1.0
 *  3/6/2023 16:00
 *  Copyright (c) 2023 Unosquare
 *  Any illegal reproduction of this content will result in immediate legal action.
 */
package coe.unosquare.benefits.creditcards;

/**
 * The credit card type.
 * @author adrian.grajeda
 */
public class CreditCard {

    private CreditCardType type;
    // We should add other important attributes like
    // owner's name
    // valid date
    // etc

    /**
     * Initialize a new Credit card.
     * @param type type of the credit card
     */
    public CreditCard(CreditCardType type) {
        this.type = type;
    }

    /**
     * returns the {@link CreditCardType}.
     * @return the type
     */
    public CreditCardType getType() {
        return type;
    }

}

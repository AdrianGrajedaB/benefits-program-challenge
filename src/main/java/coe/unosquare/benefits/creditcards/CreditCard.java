/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coe.unosquare.benefits.creditcards;

/**
 *
 * @author adrian.grajeda
 */
public class CreditCard {

    private CreditCardType type;
    // We should add other important attributes like
    // owner's name
    // valid date
    // etc

    public CreditCard(CreditCardType type) {
        this.type = type;
    }

    public CreditCardType getType() {
        return type;
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coe.unosquare.benefits.creditcards;

/**
 *
 * @author adrian.grajeda
 */
public final class CreditCardParser {

    private CreditCardParser() { }
    
    public static CreditCard parseFromString( final String creditCardType) {
        CreditCardType type = CreditCardType.valueOf(creditCardType.trim().toUpperCase());
        if (type != null) {
            return new CreditCard(type);
        }
        return new CreditCard(CreditCardType.OTHER);
    }
    
    
    
}

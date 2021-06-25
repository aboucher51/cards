package com.companyname.cards.model;

import org.apache.commons.lang3.StringUtils;

public class Card {
    /**
     * Value of the card. Aces = 1, Kings = 13
     */
    private int number;
    private Suit suit;

    public Card(int number, Suit suit){
        this.number = number;
        this.suit = suit;
    }

    public int getNumber() {
        return number;
    }
    public Suit getSuit() {
        return suit;
    }

    @Override
    public boolean equals(Object object) { 
        if (object == null || !(object instanceof Card)){
            return false;
        }
        if (object == this) {
            return true;
        }

        Card other = (Card) object;
        if(other.number == this.number && this.suit.equals(other.getSuit())){
            return true;
        }

        return false;
    }

    @Override
    public int hashCode()
    {
        String suitString = String.valueOf(this.suit.ordinal());
        String paddedNumberString = StringUtils.leftPad(String.valueOf(this.number),2, "0");
        return Integer.parseInt(suitString+paddedNumberString);
    }


}

package com.companyname.cards.model;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

public class Card {

    private static Map<Integer, String> cardNameMappings;
    
    /**
     * Value of the card
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
    protected void setNumber(int number){
        this.number = number;
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

    {
        cardNameMappings = new HashMap<>();
        cardNameMappings.put(11, "Jack");
        cardNameMappings.put(12, "Queen");
        cardNameMappings.put(13, "King");
    }

    @Override
    public String toString(){
        return cardNameMappings.getOrDefault(number, String.valueOf(number));
    }

    public boolean isFaceCard(){
        return (number == 11 || number == 12 || number == 13);
    }
}

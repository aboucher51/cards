package com.companyname.cards.model;
public class Card {
    /**
     * Value of the card. Aces = 1, Kings = 13
     */
    public int number;
    public Suit suit;

    public Card(int number, Suit suit){
        this.number = number;
        this.suit = suit;
    }
}

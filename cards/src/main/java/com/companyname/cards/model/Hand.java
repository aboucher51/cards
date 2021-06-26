package com.companyname.cards.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Hand {
    List<Card> cards = new ArrayList<>();

    public void addCard(Card card){
        cards.add(card);
    }

    public void addCards(Collection<Card> newCards){
        cards.addAll(newCards);
    }

    public int sum(){
        int sum = 0;
        for (Card card : cards) {
            sum += card.getNumber();
        }
        return sum;
    }

    @Override
    public String toString(){
        String handString = "";
        for (Card card : cards) {
            handString +=" "+card.toString();
        }
        return handString;
    }

    public boolean contains(int cardValue){
        return cards.stream().filter(card -> card.getNumber() == cardValue).count() > 0;
    }
}

package com.companyname.cards.model;

import java.util.Collections;
import java.util.Stack;

public class CardCollection{
    private Stack<Card> cards = new Stack<>();

    public void shuffle(){
        Collections.shuffle(cards);
    }

    public int size(){
        return cards.size();
    }

    public Card pop(){
        return cards.pop();
    }
    
}

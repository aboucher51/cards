package com.companyname.cards.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;

public class CardCollection{
    private Stack<Card> cards = new Stack<>();

    public CardCollection(Stack<Card> cards) {
        this.cards = cards;
    }

    public void shuffle(){
        Collections.shuffle(cards);
    }

    public int size(){
        return cards.size();
    }

    /**
     * returns {@code count} cards and removes them from the collection. If the collection contains fewer than {@code count} cards,
     *  it will attempt to return as many as are left.
     * 
     * @param count of cards to return
     * @return a collection of {@link com.companyname.cards.model.Card Cards}
     * @throws java.util.EmptyStackException on empty collection
     */
    public Collection<Card> dealCards(int count){
        if(isEmpty()){
            throw new EmptyStackException();
        }

        List<Card> dealtCards = new ArrayList<>();
        for(int i=0;i<count;i++){
            dealtCards.add(cards.pop());
            if(size() == 0){
                return dealtCards;
            }
        }
        return dealtCards;
    }

    /**
     * @return true if the collection has no remaining cards left
     */
    public boolean isEmpty(){
        return size() == 0;
    }
    
}

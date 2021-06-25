package com.companyname.cards.utilities;
import java.util.Collections;
import java.util.Stack;

import com.companyname.cards.model.Card;
import com.companyname.cards.model.Suit;



public class DeckFactory {
public static final int NUMBER_OF_CARDS_IN_SUIT = 13;

public static Stack<Card> createNewStandardDeck(){
    Stack<Card> cards = new Stack<>();
    for(int i=0;i < Suit.values().length;i++){
        for(int j=1;j <= NUMBER_OF_CARDS_IN_SUIT;j++){ //start at 1, since we have no 0-valued cards
            cards.add(new Card(j, Suit.values()[i]));
        }
    }
    Collections.shuffle(cards);
    return cards;
}

}

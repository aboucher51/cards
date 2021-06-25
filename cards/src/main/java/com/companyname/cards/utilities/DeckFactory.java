package com.companyname.cards.utilities;
import java.util.ArrayList;
import java.util.List;

import com.companyname.cards.model.Card;
import com.companyname.cards.model.Suit;



public class DeckFactory {
private static final int NUMBER_OF_CARDS_IN_SUIT = 13;

public static List<Card> createNewDeck(){
    List<Card> cards = new ArrayList<>();
    for(int i=0;i < Suit.values().length;i++){
        for(int j=1;j <= NUMBER_OF_CARDS_IN_SUIT;j++){ //start at 1, since we have no 0-valued cards
            cards.add(new Card(j, Suit.values()[i]));
        }
    }
    return cards;
}

}

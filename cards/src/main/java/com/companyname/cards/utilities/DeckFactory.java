package com.companyname.cards.utilities;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

import com.companyname.cards.model.AceCard;
import com.companyname.cards.model.Card;
import com.companyname.cards.model.Suit;



public class DeckFactory {
public static final int NUMBER_OF_CARDS_IN_SUIT = 13;

public static Stack<Card> createNewStandardDeck(){
    return createNewStandardDeck(false);
}

public static Stack<Card> createNewStandardDeck(boolean defaultIsAceHigh){
    Stack<Card> cards = new Stack<>();
    cards.addAll(generateAces(defaultIsAceHigh));
    for(int i=0;i < Suit.values().length;i++){
        for(int j=2;j <= NUMBER_OF_CARDS_IN_SUIT;j++){ //start at 1, since we've added aces already
            cards.add(new Card(j, Suit.values()[i]));
        }
    }
    Collections.shuffle(cards);
    return cards;
}

private static Collection<? extends Card> generateAces(boolean defaultIsAceHigh) {
    List<AceCard> aces = new ArrayList<>();
    for(int i=0;i < Suit.values().length;i++){
        aces.add(new AceCard(Suit.values()[i], defaultIsAceHigh));
    }
    return aces;
}

}

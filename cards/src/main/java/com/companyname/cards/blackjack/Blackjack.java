package com.companyname.cards.blackjack;

import java.util.Collection;

import com.companyname.cards.model.Card;
import com.companyname.cards.model.CardCollection;
import com.companyname.cards.model.Hand;
import com.companyname.cards.utilities.DeckFactory;

public class Blackjack {
    
    public static final int ACE_VALUE = 1;
    public static final int DEALER_LIMIT = 17;

    BlackjackHand playerHand = new BlackjackHand();
    BlackjackHand dealerHand = new BlackjackHand();

    CardCollection deck;

    public void play(){
        deck = new CardCollection(DeckFactory.createNewStandardDeck());
        System.out.println("Welcome to Blackjack, first to 21 (without going over) wins. Dealer hits on soft 17");
        dealerHand.addCards(deck.dealCards(2));
        playerHand.addCards(deck.dealCards(2));
        
        System.out.println("Dealer: \n"+dealerHand.toString());

        

        System.out.println("Player: \n"+playerHand.toString());

        while(dealerHand.sum() < DEALER_LIMIT){
            dealerHand.addCards(deck.dealCards(1));
            if(dealerHand.sum() == DEALER_LIMIT && dealerHand.contains(ACE_VALUE));
        }
        //TODO deal with aces
    }



    

}

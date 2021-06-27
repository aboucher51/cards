package com.companyname.cards.blackjack;

import com.companyname.cards.model.CardCollection;
import com.companyname.cards.utilities.DeckFactory;

public class Blackjack {
    
    public static final int ACE_VALUE = 1;
    public static final int DEALER_LIMIT = 17;

    BlackjackHand dealerHand = new BlackjackHand("Dealer");
    BlackjackHand playerHand = new BlackjackHand("Player");

    CardCollection deck;

    public void play(){
        deck = new CardCollection(DeckFactory.createNewStandardDeck(true));
        System.out.println("Welcome to Blackjack, first to 21 (without going over) wins. Dealer hits on soft 17");
        dealerHand.addCards(deck.dealCards(2));
        playerHand.addCards(deck.dealCards(2));
        
        printHandToConsole(playerHand);

        drawDealerToHardSeventeen();
        printHandToConsole(dealerHand);

    }

    private void printHandToConsole(BlackjackHand hand){
        System.out.println(hand.toString());
    }
    
    private void hit(BlackjackHand hand){
        hand.addCards(deck.dealCards(1));
    }

    private void drawDealerToHardSeventeen(){
        while(dealerHand.sum() < DEALER_LIMIT){
            hit(dealerHand);
            if(dealerHand.sum() == DEALER_LIMIT && dealerHand.isHandContainsHighAce()){
                hit(dealerHand);
            }
        }
    }

}

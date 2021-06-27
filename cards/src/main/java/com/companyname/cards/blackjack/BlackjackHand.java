package com.companyname.cards.blackjack;

import com.companyname.cards.model.AceCard;
import com.companyname.cards.model.Hand;

public class BlackjackHand extends Hand {
    
    public static final int BLACKJACK_VALUE = 21;
    public static final String BUST_MESSAGE = "||BUST||";
    public static final String BLACKJACK_MESSAGE = "||BLACKJACK||";

    public BlackjackHand(){}
    public BlackjackHand(String handOwnerName){
        super(handOwnerName);
    }

    /**
     * sums the cards value, manipulating aces to stay below 22 if possible
     */
    @Override
    public int sum(){
        int sum = super.sum();

        while (sum > BLACKJACK_VALUE && numberOfHighAcesInHand() > 0){ //while over blackjack and can still optimize aces
            setNextAceToLow();
            sum = super.sum();
        }

        return sum;
    }


    public boolean checkForBlackjack(){
        return this.sum() == BLACKJACK_VALUE;
    }

    public boolean checkForBust(){
        return this.sum() > BLACKJACK_VALUE;
    }

    public boolean isHandContainsHighAce(){
        return numberOfHighAcesInHand() > 0;
    }

    private int numberOfHighAcesInHand(){
        return (int) getCards().stream()
            .filter(card -> card instanceof AceCard)
            .map(card -> (AceCard) card)
            .filter(AceCard::isAceHigh)
            .count();
    }

    private void setNextAceToLow(){
        getCards().stream()
            .filter(card -> card instanceof AceCard)
            .map(card -> (AceCard) card)
            .filter(AceCard::isAceHigh)
            .findFirst()
            .get()
            .setAceHigh(false);
    }

    @Override
    public String toString(){
        String stringToReturn = getHandOwnerName()+"\n";
        if(checkForBlackjack()){
            stringToReturn += BLACKJACK_MESSAGE;
        }else if(checkForBust()){
            stringToReturn += BUST_MESSAGE;
        }
        stringToReturn += sum();
        stringToReturn += " | "+super.toString();

        return stringToReturn;
    }
}

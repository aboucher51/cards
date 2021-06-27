package com.companyname.cards.blackjack;

import com.companyname.cards.model.Card;
import com.companyname.cards.model.Hand;

public class BlackjackHand extends Hand {
    
    /**
     * sums the cards value
     */
    @Override
    public int sum(){
        int sum = 0;
        for (Card card : getCards()) {
            sum += card.getNumber();
        }
        return sum;
    }


    public boolean checkForBlackjack(){
        return this.sum() == 21;
    }

    public boolean checkForBust(){
        return this.sum() > 21;
    }

}

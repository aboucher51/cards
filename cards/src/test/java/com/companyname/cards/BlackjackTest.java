package com.companyname.cards;

import com.companyname.cards.blackjack.Blackjack;

import org.junit.jupiter.api.Test;

public class BlackjackTest {

Blackjack classUnderTest = new Blackjack();

    @Test
    public void testBlackJackGame(){
        classUnderTest.play();
    }

}

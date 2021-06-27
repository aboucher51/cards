package com.companyname.cards.blackjack;

import org.junit.jupiter.api.Test;

public class BlackjackTest {

Blackjack classUnderTest = new Blackjack();

    //this is less of a test and more of a convenient way to play the game
    @Test
    public void testBlackJackGame(){
        classUnderTest.play();
    }

}

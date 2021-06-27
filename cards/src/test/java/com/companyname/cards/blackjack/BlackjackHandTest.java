package com.companyname.cards.blackjack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.companyname.cards.model.AceCard;
import com.companyname.cards.model.Card;
import com.companyname.cards.model.Suit;

import org.junit.jupiter.api.Test;

public class BlackjackHandTest {

    @Test
    public void testAceSummation(){
        BlackjackHand classUnderTest = new BlackjackHand();
        classUnderTest.addCard(new Card(5, Suit.CLUB));
        classUnderTest.addCard(new AceCard(Suit.CLUB, true));
        assertEquals(15, classUnderTest.sum());
        assertTrue(classUnderTest.isHandContainsHighAce());

        classUnderTest.addCard(new Card(6, Suit.CLUB));
        assertEquals(21, classUnderTest.sum());
        assertTrue(classUnderTest.isHandContainsHighAce());

        classUnderTest.addCard(new Card(1, Suit.CLUB));
        assertFalse(classUnderTest.isHandContainsHighAce());
        assertEquals(13, classUnderTest.sum());
    }

    @Test
    public void testOneHighAceOneLowAce(){
        BlackjackHand classUnderTest = new BlackjackHand();
        classUnderTest.addCard(new Card(7, Suit.CLUB));
        classUnderTest.addCard(new AceCard(Suit.CLUB, true));
        classUnderTest.addCard(new AceCard(Suit.HEART, true));
        assertEquals(18, classUnderTest.sum());
        assertTrue(classUnderTest.isHandContainsHighAce());
    }

}

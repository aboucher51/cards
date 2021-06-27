package com.companyname.cards;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.companyname.cards.model.AceCard;
import com.companyname.cards.model.Suit;

import org.junit.jupiter.api.Test;

public class AceCardTest {
    
    public AceCard classUnderTest;

    @Test
    public void testLowHighFeature(){
        classUnderTest = new AceCard(Suit.CLUB);

        classUnderTest.setAceHigh(true);
        assertTrue(classUnderTest.isAceHigh());
        assertEquals(10, classUnderTest.getNumber());
        assertEquals("Ace(high)", classUnderTest.toString());

        classUnderTest.setAceHigh(false);
        assertFalse(classUnderTest.isAceHigh());
        assertEquals(1, classUnderTest.getNumber());
        assertEquals("Ace(low)", classUnderTest.toString());
    }

}

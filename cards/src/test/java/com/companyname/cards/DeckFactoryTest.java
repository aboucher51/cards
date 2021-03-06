package com.companyname.cards;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Stack;

import com.companyname.cards.model.AceCard;
import com.companyname.cards.model.Card;
import com.companyname.cards.model.Suit;
import com.companyname.cards.utilities.DeckFactory;

import org.junit.jupiter.api.Test;

public class DeckFactoryTest {
    
    @Test
    public void testSpecificCardsInStandardDeck()
    {
        Stack<Card> cardsUnderTest = DeckFactory.createNewStandardDeck();
        assertEquals(52, cardsUnderTest.size());
        for(int i=0;i < Suit.values().length;i++){
            for(int j=1;j <= DeckFactory.NUMBER_OF_CARDS_IN_SUIT;j++){
                Card testCard = new Card(j, Suit.values()[i]);
                assertTrue(cardsUnderTest.contains(testCard));
            }
        }
    }

    @Test
    public void testCorrectNumbersPerSuit(){
        Stack<Card> cardsUnderTest = DeckFactory.createNewStandardDeck();
        for (Suit suit : Suit.values()) {
            assertEquals(DeckFactory.NUMBER_OF_CARDS_IN_SUIT, cardsUnderTest.stream().filter(card -> card.getSuit().equals(suit)).count());
        }
    }

    @Test
    public void testCorrectSuitsPerNumbers(){
        Stack<Card> cardsUnderTest = DeckFactory.createNewStandardDeck();
        for(int i=1;i <= DeckFactory.NUMBER_OF_CARDS_IN_SUIT;i++){
            int number = i;
            assertEquals(Suit.values().length, cardsUnderTest.stream().filter(card -> card.getNumber() == number).count());
        }
    }

    @Test
    public void test1AceInEachSuit(){
        Stack<Card> cardsUnderTest = DeckFactory.createNewStandardDeck();
        for (Suit suit : Suit.values()) {
            assertEquals(1, cardsUnderTest.stream().filter(card -> card.getSuit().equals(suit)).filter(card -> card instanceof AceCard).count());
        }
    }

    @Test
    public void testDefaultHighAces(){
        Stack<Card> cardsUnderTest = DeckFactory.createNewStandardDeck(true);
        for (Suit suit : Suit.values()) {
            assertEquals(1, cardsUnderTest.stream().filter(card -> card.getSuit().equals(suit)).filter(card -> card instanceof AceCard).filter(card -> card.getNumber() == 10).count());
        }
    }
}

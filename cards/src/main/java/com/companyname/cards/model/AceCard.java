package com.companyname.cards.model;

public class AceCard extends Card{

    private boolean isAceHigh = false;
    
    public AceCard(Suit suit) {
        super(1, suit);
    }

    public AceCard(Suit suit, boolean defaultIsAceHigh) {
        super(defaultIsAceHigh ? 10:1, suit);
        this.isAceHigh = defaultIsAceHigh;
    }
    
    @Override
    public int getNumber() {
        return isAceHigh ? 10 : 1;
    }
    
    public boolean isAceHigh() {
        return isAceHigh;
    }

    public void setAceHigh(boolean isAceHigh) {
        this.isAceHigh = isAceHigh;
    }
    
    @Override
    public String toString(){
        return "Ace("+(getNumber()==1?"low":"high")+")";
    }
    
}

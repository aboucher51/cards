package cards.src.main.java.com.companyname.cards.model;
public enum Suit {
    HEART(SuitColor.RED),DIAMOND(SuitColor.RED),SPADE(SuitColor.BLACK),CLUB(SuitColor.BLACK);
    private SuitColor color;
    Suit(SuitColor color) {
        this.color = color;
    }
    SuitColor getPrice() {
       return color;
    } 
}

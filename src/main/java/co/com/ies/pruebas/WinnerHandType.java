package co.com.ies.pruebas;

public enum WinnerHandType {
	
	ROYAL_FLUSH("Royal flush"), STRAIGHT_FLUSH("Straight flush"), POKER("Poker"), FULL_HOUSE("Full house"), TERNA("terna"), PAIR("pair");

    private String desc;

    WinnerHandType(String desc) {
        this.desc = desc;
    }

}

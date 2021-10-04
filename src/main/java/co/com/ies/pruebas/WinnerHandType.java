package co.com.ies.pruebas;

public enum WinnerHandType {
	
	ROYAL_FLUSH("royal flush"), STRAIGHT_FLUSH("straight flush"), POKER("poker"), FULL_HOUSE("full house"), FLUSH("flush"), STRAIGHT("straight"), TERNA("terna"), TWO_PAIR("two pair"), PAIR("pair"), HIGH_CARD("high card");

    private String desc;

    WinnerHandType(String desc) {
        this.desc = desc;
    }

}

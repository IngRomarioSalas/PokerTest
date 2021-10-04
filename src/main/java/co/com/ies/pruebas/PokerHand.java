package co.com.ies.pruebas;

import java.util.ArrayList;
import java.util.List;

public class PokerHand {
	
	
	public Card card1;
	public Card  card2;
	public Card  card3;
	public Card  card4;
	public Card  card5;
	 
    public PokerHand(Card card1, Card card2, Card card3, Card card4, Card card5) {
		super();
		this.card1 = card1;
		this.card2 = card2;
		this.card3 = card3;
		this.card4 = card4;
		this.card5 = card5;
	}

	public static PokerHand of(String hand){
    	return loadHand(hand);
    }

	private static PokerHand loadHand(String hand) {
		String[] handString = hand.split(" ");
		
		return new PokerHand(verify(handString[0]),verify(handString[1]), verify(handString[2]), verify(handString[3]), verify(handString[4]));
	}

	private static Card verify(String card) {
		int value = getValue(card);
	    String stick = getStick(card);
		return new Card(value,stick);
	}

	private static String getStick(String card) {
		if(card.length()==3) {
			return ""+card.charAt(2);
		}
		return ""+card.charAt(1);
	}

	private static int getValue(String card) {
		if(card.charAt(0)=='J') {
			return 11;
		}
		if(card.charAt(0)=='Q') {
			return 12;
		}
		if(card.charAt(0)=='K') {
			return 13;
		}
		if(card.charAt(0)=='A') {
			return 14;
		}
		if(card.length()==3) {
			return Integer.parseInt(""+card.charAt(0)+card.charAt(1));
		}	
		return Integer.parseInt(""+card.charAt(0));
	}

	
	



	

     
    
    
    
}

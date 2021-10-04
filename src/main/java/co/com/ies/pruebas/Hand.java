package co.com.ies.pruebas;

import java.util.ArrayList;
import java.util.List;

public class Hand {
	
	public static WinnerRound searchHandWinner(PokerHand hand,int handType) {
		WinnerRound winner = typeHand(hand,handType);
		if(winner == null) {
			handType+=1;
			winner=searchHandWinner(hand,handType);
		}
		return winner;
	}

	private static WinnerRound typeHand(PokerHand hand, int i) {
		switch (i) {
		case 1:
			return royalFlush(hand);
		case 2:
			return straightFlush(hand);
		case 3:
			return searchPoker(hand);
		case 4:
			return fullHouse(hand);
		case 5:
			return flush(hand);
		case 6:
			return straight(hand);
		case 7:
			return searchTerna(hand);
		case 8:
			return twoPairs(hand);
		case 9:
			return searchPairs(hand, 0);
		case 10:
			return highCard(hand);	
		}
		return null;
	}

	private static WinnerRound highCard(PokerHand hand) {
		WinnerRound winner = new WinnerRound();
 		List<Card> cardList = listCard(hand);
 		int cardHigh;
 		cardHigh = cardList.get(0).value;
 		for(int i=1; i<cardList.size();i++) {
 			if(cardHigh<cardList.get(i).value) {
 				cardHigh=cardList.get(i).value;
 			}
 		}
 			winner.setWinnerHandType(WinnerHandType.HIGH_CARD);
 			winner.setCompositionWinnerHand("gana. - con "+WinnerHandType.HIGH_CARD+": "+"con trio "+cardHigh);
 			winner.setValueCardWinner(cardHigh);
 			return winner;
	}

	private static WinnerRound twoPairs(PokerHand hand) {
		WinnerRound pairs = searchPairs(hand,0);
		if(pairs!=null) {
			if(searchPairs(hand,pairs.getValueCardWinner())!=null) {
				WinnerRound winner = new WinnerRound();
				winner.setWinnerHandType(WinnerHandType.TWO_PAIR);
				winner.setCompositionWinnerHand("gana. - con "+WinnerHandType.TWO_PAIR+": "+"con par "+pairs.getValueCardWinner());
				return winner;
			}
		}
		return null;
	}

	private static WinnerRound straight(PokerHand hand) {
		if(isStraight(hand)) {
			WinnerRound winner = new WinnerRound();
			winner.setWinnerHandType(WinnerHandType.STRAIGHT);
			winner.setCompositionWinnerHand("gana. - con "+WinnerHandType.FLUSH+": "+hand.card1.stick);
			return winner;
		}
		return null;
	}

	private static WinnerRound flush(PokerHand hand) {
		WinnerRound winner = new WinnerRound();
		if(isSameColor(hand)) {
			winner.setWinnerHandType(WinnerHandType.FLUSH);
			winner.setCompositionWinnerHand("gana. - con "+WinnerHandType.FLUSH+": "+hand.card1.stick);
			return winner;
		}
		return null;
	}

	private static WinnerRound fullHouse(PokerHand hand) {
		WinnerRound terna = searchTerna(hand);
		if(terna!=null) {
			if(searchPairs(hand,terna.getValueCardWinner())!=null) {
				WinnerRound winner = new WinnerRound();
				winner.setWinnerHandType(WinnerHandType.FULL_HOUSE);
				winner.setCompositionWinnerHand("gana. - con "+WinnerHandType.FULL_HOUSE+": "+"con trio "+terna.getValueCardWinner());
				return winner;
			}
			return null;
		}
		return null;
	}

	private static WinnerRound straightFlush(PokerHand hand) {
		if(isSameColor(hand) && isStraight(hand)) {
			WinnerRound winner = new WinnerRound();
			winner.setWinnerHandType(WinnerHandType.STRAIGHT_FLUSH);
			winner.setCompositionWinnerHand("gana. - con "+WinnerHandType.STRAIGHT_FLUSH+": "+hand.card1.stick);
			return winner;
		}
		return null;
	}

	private static WinnerRound royalFlush(PokerHand hand) {
		if(isSameColor(hand) && isStraight(hand) && hand.card1.value==10 || hand.card5.value==10) {
			WinnerRound winner = new WinnerRound();
			winner.setWinnerHandType(WinnerHandType.ROYAL_FLUSH);
			winner.setCompositionWinnerHand("gana. - con "+WinnerHandType.ROYAL_FLUSH+": "+hand.card1.stick);
			return winner;
		}
		return null;
	}

	
	
	private static boolean isSameColor(PokerHand hand) {
		if(hand.card1.stick.equals(hand.card2.stick) && hand.card2.stick.equals(hand.card3.stick) && hand.card3.stick.equals(hand.card4.stick) && hand.card4.stick.equals(hand.card5.stick)) {
			return true;
		}
		return false; 
	}
	private static boolean isStraight(PokerHand hand) {
		if(hand.card1.value>hand.card5.value && hand.card1.value==hand.card5.value+4 && hand.card2.value==hand.card4.value+2 && hand.card1.value==hand.card3.value+2) {
			return true;
		}
		if(hand.card1.value<hand.card5.value && hand.card5.value==hand.card1.value+4 && hand.card4.value==hand.card2.value+2 && hand.card3.value==hand.card1.value+2) {
			return true;
		}
		return false;
	}
	
     private static WinnerRound searchPoker(PokerHand hand) {
    	 WinnerRound winner = new WinnerRound();
 		List<Card> cardList = listCard(hand);
 		int firstCard;
 		for(int j=0; j<cardList.size();j++) {
 			int value=0;
 			int count =1;
 		firstCard = cardList.get(j).value;
 		for(int i=j+1; i<cardList.size();i++) {
 			if(firstCard==cardList.get(i).value) {
 				count +=1;
 				value = firstCard;
 			}
 		}
 		if(count==4) {
 			winner.setWinnerHandType(WinnerHandType.POKER);
 			winner.setCompositionWinnerHand("gana. - con "+WinnerHandType.POKER+": "+value);
 			winner.setValueCardWinner(value);
 			return winner;
 		}
 	    }
 		return null;
	}
     
     private static List<Card> listCard(PokerHand hand) {
 		List<Card> cardList = new ArrayList<Card>();
 		  cardList.add(hand.card1);
 		  cardList.add(hand.card2);
 		  cardList.add(hand.card3);
 		  cardList.add(hand.card4);
 		  cardList.add(hand.card5);
 		return cardList;
 	}
     
     private static WinnerRound searchPairs(PokerHand hand, int comparator) {
    	 WinnerRound winner = new WinnerRound();
  		List<Card> cardList = listCard(hand);
  		int firstCard;
  		for(int j=0; j<cardList.size();j++) {
  			int value=0;
  			int count =1;
  		firstCard = cardList.get(j).value;
  		for(int i=j+1; i<cardList.size();i++) {
  			if(firstCard==cardList.get(i).value) {
  				count +=1;
  				value = firstCard;
  			}
  		}
  		if(count==2&&value!=comparator) {
  			winner.setWinnerHandType(WinnerHandType.PAIR);
  			winner.setCompositionWinnerHand("gana. - con "+WinnerHandType.PAIR+": "+value);
  			winner.setValueCardWinner(value);
  			return winner;
  		}
  	    }
  		return winner;
 	}

 	private static WinnerRound searchTerna(PokerHand hand) {
 		 WinnerRound winner = new WinnerRound();
  		List<Card> cardList = listCard(hand);
  		int firstCard;
  		for(int j=0; j<cardList.size();j++) {
  			int value=0;
  			int count =1;
  		firstCard = cardList.get(j).value;
  		for(int i=j+1; i<cardList.size();i++) {
  			if(firstCard==cardList.get(i).value) {
  				count +=1;
  				value = firstCard;
  			}
  		}
  		System.out.println(count);
  		if(count==3) {
  			winner.setWinnerHandType(WinnerHandType.TERNA);
  			winner.setCompositionWinnerHand("gana. - con "+WinnerHandType.TERNA+": "+value);
  			winner.setValueCardWinner(value);
  			return winner;
  		}
  		return null;
  	    }
  		return null;
 	}
	
}

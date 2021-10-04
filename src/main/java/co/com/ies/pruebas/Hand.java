package co.com.ies.pruebas;

import java.util.ArrayList;
import java.util.List;

public class Hand {
	
	public static WinnerRound searchHandWinner(PokerHand hand,int handType) {
		if(typeHand(hand,handType) == null) {
			handType+=1;
			typeHand(hand,handType);
		}
		return typeHand(hand,handType);
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
		}
		return null;
	}

	private static WinnerRound fullHouse(PokerHand hand) {
		if(searchTerna(hand)!=null&&searchPairs(hand)!=null) {
			WinnerRound winner = new WinnerRound();
			winner.setWinnerHandType(WinnerHandType.FULL_HOUSE);
			winner.setCompositionWinnerHand(hand);
			return winner;
		}
		return null;
	}

	private static WinnerRound straightFlush(PokerHand hand) {
		if(isSameColor(hand) && isFlush(hand)) {
			WinnerRound winner = new WinnerRound();
			winner.setWinnerHandType(WinnerHandType.STRAIGHT_FLUSH);
			//winner.setCompositionWinnerHand(hand);
			return winner;
		}
		return null;
	}

	private static WinnerRound royalFlush(PokerHand hand) {
		if(isSameColor(hand) && isFlush(hand) && hand.card1.value==10 || hand.card5.value==10) {
			WinnerRound winner = new WinnerRound();
			winner.setWinnerHandType(WinnerHandType.ROYAL_FLUSH);
			//winner.setCompositionWinnerHand(hand);
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
	private static boolean isFlush(PokerHand hand) {
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
 			System.out.println("entro");
 			winner.setWinnerHandType(WinnerHandType.POKER);
 			winner.setCompositionWinnerHand(hand);
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
     
     private static Object searchPairs(PokerHand hand) {
 		WinnerRound winner = new WinnerRound();
 		List<Card> cardList = listCard(hand);
 		int count =0;
 		int value=0;
 		for(int j=0; j<cardList.size();j++) {
 		int firstCard = cardList.get(j).value;
 		for(int i=j+1; i<cardList.size();i++) {
 			if(firstCard==cardList.get(i).value) {
 				count +=1;
 				value = firstCard;
 			}
 		}
 		if(count==2) {
 			winner.setWinnerHandType(WinnerHandType.TERNA);
 			winner.setCompositionWinnerHand(hand);
 			winner.setValueCardWinner(value);
 			return winner;
 		}
 	    }
 		return null;
 	}

 	private static WinnerRound searchTerna(PokerHand hand) {
 		WinnerRound winner = new WinnerRound();
 		List<Card> cardList = listCard(hand);
 		int count =0;
 		int value=0;
 		for(int j=0; j<cardList.size();j++) {
 		int firstCard = cardList.get(j).value;
 		for(int i=j+1; i<cardList.size();i++) {
 			if(firstCard==cardList.get(i).value) {
 				count +=1;
 				value = firstCard;
 			}
 		}
 		if(count==3) {
 			winner.setWinnerHandType(WinnerHandType.TERNA);
 			winner.setCompositionWinnerHand(hand);
 			winner.setValueCardWinner(value);
 			return winner;
 		}
 	    }
 		return null;
 	}
	
}

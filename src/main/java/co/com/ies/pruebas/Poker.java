package co.com.ies.pruebas;

public class Poker {
	
	WinnerRound white = new WinnerRound();
	WinnerRound black = new WinnerRound();
	
    public WinnerRound playRound(PokerHand blanco, PokerHand negro) {
    	
    	white = Hand.searchHandWinner(blanco,1);
    	black = Hand.searchHandWinner(negro,1);
    	
        System.out.println(white.getWinnerHandType());
        System.out.println(black.getWinnerHandType());
        return black;
    }
    
}

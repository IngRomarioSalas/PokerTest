package co.com.ies.pruebas;

public class Poker {
	
	WinnerRound white = new WinnerRound();
	WinnerRound black = new WinnerRound();
	
    public WinnerRound playRound(PokerHand blanco, PokerHand negro) {
    	
    	white = Hand.searchHandWinner(blanco,1);
    	black = Hand.searchHandWinner(negro,1);
    	
    	if(white.getWinnerHandType().ordinal()>black.getWinnerHandType().ordinal()) {
    		white.setCompositionWinnerHand(" blanco "+white.getCompositionWinnerHand());
    		return white;
    	}
    	
    	if(white.getWinnerHandType().ordinal()<black.getWinnerHandType().ordinal()) {
    		black.setCompositionWinnerHand(" negro "+black.getCompositionWinnerHand());
    		return black;
    	}
    	
    	if(white.getWinnerHandType().ordinal()==black.getWinnerHandType().ordinal()) {
    		if(white.getValueCardWinner()<black.getValueCardWinner()) {
    			black.setCompositionWinnerHand(" negro "+black.getCompositionWinnerHand());
    			return black;
    		}
    		if(white.getValueCardWinner()>black.getValueCardWinner()) {
    			white.setCompositionWinnerHand(" blanco "+white.getCompositionWinnerHand());
    			return white;
    		}
    		white.setCompositionWinnerHand(" blanco "+white.getCompositionWinnerHand());
    		return white;
    	}
    	
        return white;
    }
    
}

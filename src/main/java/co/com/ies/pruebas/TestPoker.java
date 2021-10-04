package co.com.ies.pruebas;

class TestPoker {
	public static void main(String[] args) {
		PokerHand blanco = PokerHand.of("2C 2H 2S 2D KH");
        PokerHand negro = PokerHand.of("2C 2H 2S 2D KH");
        Poker poker = new Poker();
        WinnerRound winnerRound = poker.playRound(blanco, negro);
        //System.out.println(winnerRound.getWinnerHandType());
        
    }
}

package co.com.ies.pruebas;

class TestPoker {
	public static void main(String[] args) {
		String white="2C 3C 4C 5C 6C";
		String black="2C 3C 4C 5C 6C";
		PokerHand blanco = PokerHand.of(white);
        PokerHand negro = PokerHand.of(black);
        Poker poker = new Poker();
        WinnerRound winnerRound = poker.playRound(blanco, negro);
        //("Blanco: 2H 3D 5S 8C KD  Negro: 10C JC QC KC AC Negro gana. - con Escalera Real: Trebol")
        
        System.out.println("Blanco: "+white+"  Negro: "+black+winnerRound.getCompositionWinnerHand());
        
    }
}

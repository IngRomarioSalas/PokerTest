package co.com.ies.pruebas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;

import java.util.List;

class PokerTest {
    @DisplayName("Blanco: 2H 3D 5S 9C KD  Negro: 2C 3H 4S 8C AH Negro gana. - con la carta alta: As ")
    @Test
    void testCartaAlta() {
    	Poker poker = new Poker();
        WinnerRound winnerRound = new WinnerRound();
    	String white="2H 3D 5S 9C KD";
		String black="2C 3H 4S 8C AH";
		PokerHand blanco = PokerHand.of(white);
        PokerHand negro = PokerHand.of(black);
        winnerRound = poker.playRound(blanco, negro);
        System.out.println("Blanco: "+white+"  Negro: "+black+winnerRound.getCompositionWinnerHand());

    }

    @DisplayName("Blanco: 2H 3D 5S 9C KD  Negro: 2C 3H 4S 8C 5C Blanco gana. - con la carta alta: Rey ")
    @Test
    void testCartaAlta2() {
    	Poker poker = new Poker();
        WinnerRound winnerRound = new WinnerRound();
    	String white="2H 3D 5S 9C KD";
		String black="2C 3H 4S 8C 5C";
		PokerHand blanco = PokerHand.of(white);
        PokerHand negro = PokerHand.of(black);
        winnerRound = poker.playRound(blanco, negro);
        System.out.println("Blanco: "+white+"  Negro: "+black+winnerRound.getCompositionWinnerHand());
    }

    //par

    @DisplayName("Blanco: 2H 3D 5S KC KD  Negro: 2C 3H 4S 8C AH Blanco gana. - con par: Rey ")
    @Test
    void testPar() {
    	String white="2H 3D 5S KC KD";
		String black="2C 3H 4S 8C AH";
		PokerHand blanco = PokerHand.of(white);
        PokerHand negro = PokerHand.of(black);
        Poker poker = new Poker();
        WinnerRound winnerRound = poker.playRound(blanco, negro);
        System.out.println("Blanco: "+white+"  Negro: "+black+winnerRound.getCompositionWinnerHand());
    }

    @DisplayName("Blanco: 2H 3D 5S 8C KD  Negro: 2C 3H 4S AC AH Negro gana. - con par: As ")
    @Test
    void testPar2() {
    	String white="2H 3D 5S 8C KD";
		String black="2C 3H 4S AC AH";
		PokerHand blanco = PokerHand.of(white);
        PokerHand negro = PokerHand.of(black);
        Poker poker = new Poker();
        WinnerRound winnerRound = poker.playRound(blanco, negro);
        System.out.println("Blanco: "+white+"  Negro: "+black+winnerRound.getCompositionWinnerHand());
    }

    //dos pares


    @DisplayName("Blanco: 2H 3D 3S KC KD  Negro: 2C 3H 4S 8C AH Blanco gana. - con dos pares: Rey y Tres")
    @Test
    void testDosPares() {
    	String white="2H 3D 3S KC KD";
		String black="2C 3H 4S 8C AH";
		PokerHand blanco = PokerHand.of(white);
        PokerHand negro = PokerHand.of(black);
        Poker poker = new Poker();
        WinnerRound winnerRound = poker.playRound(blanco, negro);
        System.out.println("Blanco: "+white+"  Negro: "+black+winnerRound.getCompositionWinnerHand());
    }

    @DisplayName("Blanco: 2H 3D 5S 8C KD  Negro: 2C 3H 3S AC AH Negro gana. - con dos pares: As y Tres ")
    @Test
    void testDosPares2() {
    	String white="2H 3D 5S 8C KD";
		String black="2C 3H 3S AC AH";
		PokerHand blanco = PokerHand.of(white);
        PokerHand negro = PokerHand.of(black);
        Poker poker = new Poker();
        WinnerRound winnerRound = poker.playRound(blanco, negro);
        System.out.println("Blanco: "+white+"  Negro: "+black+winnerRound.getCompositionWinnerHand());
    }

    // terna

    @DisplayName("Blanco: 2H 3D KS KC KD  Negro: 2C 3H 4S 8C AH Blanco gana. - con Terna: Rey ")
    @Test
    void testTerna() {
    	String white="2H 3D KS KC KD";
		String black="2C 3H 4S 8C AH";
		PokerHand blanco = PokerHand.of(white);
        PokerHand negro = PokerHand.of(black);
        Poker poker = new Poker();
        WinnerRound winnerRound = poker.playRound(blanco, negro);
        System.out.println("Blanco: "+white+"  Negro: "+black+winnerRound.getCompositionWinnerHand());
    }

    @DisplayName("Blanco: 2H 3D 5S 8C KD  Negro: 2C 3H AS AC AH Negro gana. - con Terna: As ")
    @Test
    void testTerna2() {
    	String white="2H 3D 5S 8C KD";
		String black="2C 3H AS AC AH";
		PokerHand blanco = PokerHand.of(white);
        PokerHand negro = PokerHand.of(black);
        Poker poker = new Poker();
        WinnerRound winnerRound = poker.playRound(blanco, negro);
        System.out.println("Blanco: "+white+"  Negro: "+black+winnerRound.getCompositionWinnerHand());
    }


    // escalera
    @DisplayName("Blanco: 2H 3D 4S 5C 6D  Negro: 2C 3H 4S 8C AH Blanco gana. - con Escalera ")
    @Test
    void testEscalera() {
    	String white="2H 3D 4S 5C 6D";
		String black="2C 3H 4S 8C AH";
		PokerHand blanco = PokerHand.of(white);
        PokerHand negro = PokerHand.of(black);
        Poker poker = new Poker();
        WinnerRound winnerRound = poker.playRound(blanco, negro);
        System.out.println("Blanco: "+white+"  Negro: "+black+winnerRound.getCompositionWinnerHand());
    }

    @DisplayName("Blanco: 2H 3D 5S 8C KD  Negro: 2C 3H 4S 5C 6H Negro gana. - con Escalera ")
    @Test
    void testEscalera2() {
    	String white="2H 3D 5S 8C KD";
		String black="2C 3H 4S 5C 6H";
		PokerHand blanco = PokerHand.of(white);
        PokerHand negro = PokerHand.of(black);
        Poker poker = new Poker();
        WinnerRound winnerRound = poker.playRound(blanco, negro);
        System.out.println("Blanco: "+white+"  Negro: "+black+winnerRound.getCompositionWinnerHand());
    }


    // color
    @DisplayName("Blanco: 2H 3H 5H KH 8H  Negro: 2C 3H 4S 8C AH Blanco gana. - con color ")
    @Test
    void testColor() {
    	String white="2H 3H 5H KH 8H";
		String black="2C 3H 4S 8C AH";
		PokerHand blanco = PokerHand.of(white);
        PokerHand negro = PokerHand.of(black);
        Poker poker = new Poker();
        WinnerRound winnerRound = poker.playRound(blanco, negro);
        System.out.println("Blanco: "+white+"  Negro: "+black+winnerRound.getCompositionWinnerHand());
    }

    @DisplayName("Blanco: 2H 3D 5S 8C KD  Negro: 2C 3C 4C AC QC Negro gana. - con color ")
    @Test
    void testColor2() {
    	String white="2H 3D 5S 8C KD";
		String black="2C 3C 4C AC QC";
		PokerHand blanco = PokerHand.of(white);
        PokerHand negro = PokerHand.of(black);
        Poker poker = new Poker();
        WinnerRound winnerRound = poker.playRound(blanco, negro);
        System.out.println("Blanco: "+white+"  Negro: "+black+winnerRound.getCompositionWinnerHand());
    }

    //full house
    @DisplayName("Blanco: 2H 2D KS KC KD  Negro: 2C 3H 4S 8C AH Blanco gana. - con full house ")
    @Test
    void testFullHouse() {
    	String white="2H 2D KS KC KD";
		String black="2C 3H 4S 8C AH";
		PokerHand blanco = PokerHand.of(white);
        PokerHand negro = PokerHand.of(black);
        Poker poker = new Poker();
        WinnerRound winnerRound = poker.playRound(blanco, negro);
        System.out.println("Blanco: "+white+"  Negro: "+black+winnerRound.getCompositionWinnerHand());
    }

    @DisplayName("Blanco: 2H 3D 5S 8C KD  Negro: 2C 2H 2S AC AH Negro gana. - con full house ")
    @Test
    void testFullHouse2() {
    	String white="2H 3D 5S 8C KD";
		String black="2C 2H 2S AC AH";
		PokerHand blanco = PokerHand.of(white);
        PokerHand negro = PokerHand.of(black);
        Poker poker = new Poker();
        WinnerRound winnerRound = poker.playRound(blanco, negro);
        System.out.println("Blanco: "+white+"  Negro: "+black+winnerRound.getCompositionWinnerHand());
    }

    // poker
    @DisplayName("Blanco: 2H 2D 2S 2C KD  Negro: 2C 3H 4S 8C AH Blanco gana. - con poker: 2 ")
    @Test
    void testPoker() {
    	String white="2H 2D 2S 2C KD";
		String black="2C 3H 4S 8C AH";
		PokerHand blanco = PokerHand.of(white);
        PokerHand negro = PokerHand.of(black);
        Poker poker = new Poker();
        WinnerRound winnerRound = poker.playRound(blanco, negro);
        System.out.println("Blanco: "+white+"  Negro: "+black+winnerRound.getCompositionWinnerHand());
    }

    @DisplayName("Blanco: 2H 3D 5S 8C KD  Negro: 2C 2H 2S 2D KH Negro gana. - con poker: 2 ")
    @Test
    void testPoker2() {
    	String white="2H 3D 5S 8C KD";
		String black="2C 2H 2S 2D KH";
		PokerHand blanco = PokerHand.of(white);
        PokerHand negro = PokerHand.of(black);
        Poker poker = new Poker();
        WinnerRound winnerRound = poker.playRound(blanco, negro);
        System.out.println("Blanco: "+white+"  Negro: "+black+winnerRound.getCompositionWinnerHand());
    }


    // escalera color
    @DisplayName("Blanco: 2H 3H 4H 5H 6H  Negro: 2C 3H 4S 8C AH Blanco gana. - con Escalera Color: Corazon")
    @Test
    void testEscaleraColor() {
    	String white="2H 3H 4H 5H 6H";
		String black="2C 3H 4S 8C AH";
		PokerHand blanco = PokerHand.of(white);
        PokerHand negro = PokerHand.of(black);
        Poker poker = new Poker();
        WinnerRound winnerRound = poker.playRound(blanco, negro);
        System.out.println("Blanco: "+white+"  Negro: "+black+winnerRound.getCompositionWinnerHand());
    }

    @DisplayName("Blanco: 2H 3D 5S 8C KD  Negro: 2C 3C 4C 5C 6C Negro gana. - con Escalera Color: Trebol")
    @Test
    void testEscaleraColor2() {
    	String white="2H 3D 5S 8C KD";
		String black="2C 3C 4C 5C 6C";
		PokerHand blanco = PokerHand.of(white);
        PokerHand negro = PokerHand.of(black);
        Poker poker = new Poker();
        WinnerRound winnerRound = poker.playRound(blanco, negro);
        System.out.println("Blanco: "+white+"  Negro: "+black+winnerRound.getCompositionWinnerHand());
    }


    // escalera real
    @DisplayName("Blanco: 10H JH QH KH AH  Negro: 2C 3H 4S 8C AH Blanco gana. - con Escalera Real: Corazon ")
    @Test
    void testEscaleraReal() {
    	String white="10H JH QH KH AH";
		String black="2C 3H 4S 8C AH";
		PokerHand blanco = PokerHand.of(white);
        PokerHand negro = PokerHand.of(black);
        Poker poker = new Poker();
        WinnerRound winnerRound = poker.playRound(blanco, negro);
        System.out.println("Blanco: "+white+"  Negro: "+black+winnerRound.getCompositionWinnerHand());
    }

    @DisplayName("Blanco: 2H 3D 5S 8C KD  Negro: 10C JC QC KC AC Negro gana. - con Escalera Real: Trebol")
    @Test
    void testEscaleraReal2() {
    	String white="2H 3D 5S 8C KD";
		String black="10C JC QC KC AC";
		PokerHand blanco = PokerHand.of(white);
        PokerHand negro = PokerHand.of(black);
        Poker poker = new Poker();
        WinnerRound winnerRound = poker.playRound(blanco, negro);
        System.out.println("Blanco: "+white+"  Negro: "+black+winnerRound.getCompositionWinnerHand());
    }
}
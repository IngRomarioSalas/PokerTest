package co.com.ies.pruebas;

import java.util.List;
import java.util.Objects;

public class WinnerRound {

    private WinnerHandType winnerHandType;
    private PokerHand compositionWinnerHand;
    private boolean firstWin;
    private int valueCardWinner;

    public WinnerHandType getWinnerHandType() {
        return winnerHandType;
    }

    public void setWinnerHandType(WinnerHandType winnerHandType) {
        this.winnerHandType = winnerHandType;
    }
    
    public int getValueCardWinner() {
		return valueCardWinner;
	}

    
    public void setValueCardWinner(int valueCardWinner) {
		this.valueCardWinner = valueCardWinner;
	}

    public PokerHand getCompositionWinnerHand() {
        return compositionWinnerHand;
    }

    public void setCompositionWinnerHand(PokerHand compositionWinnerHand) {
        this.compositionWinnerHand = compositionWinnerHand;
    }

    public boolean isFirstWin() {
        return firstWin;
    }

    public void setFirstWin(boolean firstWin) {
        this.firstWin = firstWin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinnerRound that = (WinnerRound) o;
        return firstWin == that.firstWin && winnerHandType == that.winnerHandType && Objects.equals(compositionWinnerHand, that.compositionWinnerHand);
    }

    @Override
    public String toString() {
        return "WinnerRound{" +
                "winnerHandType=" + winnerHandType +
                ", compositionWinnerHand=" + compositionWinnerHand +
                ", firstWin=" + firstWin +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(winnerHandType, compositionWinnerHand, firstWin);
    }

	


}

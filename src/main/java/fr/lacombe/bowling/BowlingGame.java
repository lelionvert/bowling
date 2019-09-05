package fr.lacombe.bowling;

public class BowlingGame {
    private int score = 0;
    private Frame frame;
    private int countRolls = 0;

    public BowlingGame(Frame frame) {
        this.frame = frame;
    }

    public int getIntermediateScore() {
        return 0;
    }

    public void roll(int pinsKnockedOnRoll) {
        if (countRolls == 0 || countRolls == 8) {
            frame.firstRolls(pinsKnockedOnRoll);
        }
        if(countRolls == 1 || countRolls == 9) {
            frame.secondRolls(pinsKnockedOnRoll);
        }
        if((countRolls == 2 || countRolls == 10) && frame.isSpare()) {
            score += pinsKnockedOnRoll;
            frame = new Frame();
        }
        countRolls++;
        score += pinsKnockedOnRoll;
    }

    public int Score() {
        return score;
    }

    public boolean containSpare() {
        return false;
    }
}

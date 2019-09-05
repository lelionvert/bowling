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
        if(countRolls == 2 && frame.isSpare()) {
            score += pinsKnockedOnRoll;
            frame = new Frame();
        }
        if (countRolls == 0) {
            frame.firstRolls(pinsKnockedOnRoll);
        }
        if(countRolls == 1) {
            frame.secondRolls(pinsKnockedOnRoll);
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

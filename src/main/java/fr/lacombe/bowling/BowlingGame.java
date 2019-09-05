package fr.lacombe.bowling;

public class BowlingGame {
    private int score = 0;
    private Frame frame;

    public BowlingGame(Frame frame) {
        this.frame = frame;
    }

    public int getIntermediateScore() {
        return 0;
    }

    public void roll(int pinsKnockedOnRoll) {
        if (frame.isSpare())
            score += frame.spareValue();
        else {
            score += pinsKnockedOnRoll;
        }
    }

    public int Score() {
        return score;
    }

    public boolean containSpare() {
        return false;
    }
}

package fr.lacombe.bowling;

public class BowlingGame {
    private int score = 0;

    public int getIntermediateScore() {
        return 0;
    }

    public void roll(int pinsKnockedOnRoll) {
        score += pinsKnockedOnRoll;
    }

    public int Score() {
        return score;
    }
}

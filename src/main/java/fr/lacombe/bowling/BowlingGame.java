package fr.lacombe.bowling;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame {
    private int score = 0;
    private Frame frame = new Frame();
    private int countRolls = 0;
    private final Frames frames = new Frames(new ArrayList<Frame>());

    public BowlingGame() {
    }

    public int getIntermediateScore() {
        return 0;
    }

    public void roll(int pinsKnockedOnRoll) {
        boolean startFrame = countRolls % 2 == 0;
        if (startFrame) {
            frame = new Frame();
            frame.firstRolls(pinsKnockedOnRoll);
            if (frames.last().isSpare()) {
                score += pinsKnockedOnRoll;
            }
        }
        boolean endOfFrame = countRolls % 2 == 1;
        if (endOfFrame) {
            frame.secondRolls(pinsKnockedOnRoll);
            frames.add(frame);
        }
        countRolls++;
        score += pinsKnockedOnRoll;
    }

    public int Score() {
        return score;
    }
}

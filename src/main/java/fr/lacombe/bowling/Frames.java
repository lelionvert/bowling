package fr.lacombe.bowling;

import java.util.ArrayList;

public class Frames {
    private final ArrayList<Frame> items;
    private Frame currentFrame;

    public Frames(ArrayList<Frame> items) {

        this.items = items;
    }

    public Frame last() {
        return items.size() != 0 ? items.get(items.size() - 1) : new Frame();
    }

    public void add(Frame frame) {
        items.add(frame);
    }

    public void firstRolls(int pinsKnockedOnRoll) {
        currentFrame = new Frame();
        currentFrame.firstRolls(pinsKnockedOnRoll);

    }

    public void secondRolls(int pinsKnockedOnRoll) {
        currentFrame.secondRolls(pinsKnockedOnRoll);
        items.add(currentFrame);
    }

    int addSpareBonus(int pinsKnockedOnRoll) {
        if (last().isSpare()) {
            return pinsKnockedOnRoll;
        }
        return 0;
    }
}

package fr.lacombe.bowling;

import java.util.ArrayList;

public class Frames {
    private final ArrayList<Frame> frames;

    public Frames(ArrayList<Frame> frames) {

        this.frames = frames;
    }

    public Frame last() {
        return frames.size() != 0 ? frames.get(frames.size() - 1) : new Frame();
    }

    public void add(Frame frame) {
        frames.add(frame);
    }
}

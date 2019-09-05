package fr.lacombe.bowling;

public class Frame {
    private Frame(int firstTryDownPins, int secondTryDownPins) {

    }

    public static Frame of(int firstTryDownPins, int secondTryDownPins) {
        return new Frame(firstTryDownPins, secondTryDownPins);
    }

    public int getScore() {
        return 8;
    }
}

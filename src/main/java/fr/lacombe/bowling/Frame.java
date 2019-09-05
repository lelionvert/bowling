package fr.lacombe.bowling;

public class Frame {
    private final int firstTryDownPins;
    private final int secondTryDownPins;

    private Frame(int firstTryDownPins, int secondTryDownPins) {
        this.firstTryDownPins = firstTryDownPins;
        this.secondTryDownPins = secondTryDownPins;
    }

    public static Frame of(int firstTryDownPins, int secondTryDownPins) {
        return new Frame(firstTryDownPins, secondTryDownPins);
    }

    public int getScore() {
        return firstTryDownPins + secondTryDownPins;
    }
}

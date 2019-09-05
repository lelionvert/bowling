package fr.lacombe.bowling;

public class Frame {
    private final int firstRollKnockedDownPins;
    private final int secondRollKnockedDownPins;

    private Frame(int firstRollKnockedDownPins, int secondRollKnockedDownPins) {
        this.firstRollKnockedDownPins = firstRollKnockedDownPins;
        this.secondRollKnockedDownPins = secondRollKnockedDownPins;
    }

    public static Frame of(int firstTryDownPins, int secondTryDownPins) {
        return new Frame(firstTryDownPins, secondTryDownPins);
    }

    public int getScore() {
        return firstRollKnockedDownPins + secondRollKnockedDownPins;
    }

    public boolean isSpare() {
        return true;
    }

    public int spareValue() {
        return 0;
    }
}

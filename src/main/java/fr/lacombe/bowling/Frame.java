package fr.lacombe.bowling;

public class Frame {
    private int firstRollKnockedDownPins;
    private int secondRollKnockedDownPins;

    public Frame(int firstRollKnockedDownPins, int secondRollKnockedDownPins) {
        this.firstRollKnockedDownPins = firstRollKnockedDownPins;
        this.secondRollKnockedDownPins = secondRollKnockedDownPins;
    }

    public Frame() {

    }

    public static Frame of(int firstTryDownPins, int secondTryDownPins) {
        return new Frame(firstTryDownPins, secondTryDownPins);
    }

    public int score() {
        return firstRollKnockedDownPins + secondRollKnockedDownPins;
    }

    public boolean isSpare() {
        return score() == 10;
    }

    public int spareValue(int pinsKnockedOnRoll) {
        return score() + pinsKnockedOnRoll;
    }

    public void firstRolls(int pinsKnockedOnRoll) {
        firstRollKnockedDownPins = pinsKnockedOnRoll;
    }

    public void secondRolls(int pinsKnockedOnRoll) {
        secondRollKnockedDownPins = pinsKnockedOnRoll;
    }
}

package fr.lacombe.bowling;

public class Frame {
    private int firstRollKnockedDownPins = 0;
    private int secondRollKnockedDownPins = 0;

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

    public void firstRolls(int pinsKnockedOnRoll) {
        firstRollKnockedDownPins = pinsKnockedOnRoll;
    }

    public void secondRolls(int pinsKnockedOnRoll) {
        secondRollKnockedDownPins = pinsKnockedOnRoll;
    }
}

package fr.lacombe.bowling;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

public class BowlingGameTest {

    private BowlingGame bowlingGame;

    @BeforeEach
    void setUp() {
        Frame frame = new Frame();
        bowlingGame = new BowlingGame(frame);
    }

    @Test
    void two_gutter_rolls_should_give_intermediate_score_of_0() {
        int gutterRoll = 0;

        bowlingGame.roll(gutterRoll);
        bowlingGame.roll(gutterRoll);
        int intermediateScore = bowlingGame.getIntermediateScore();

        assertThat(intermediateScore).isEqualTo(0);
    }

    @Test
    void entire_bowling_game_of_gutter_rolls() {
        playEntireGame(0);

        int finalScore = bowlingGame.Score();

        assertThat(finalScore).isEqualTo(0);
    }

    @Test
    void entire_game_of_normal_score() {
        playEntireGame(1);

        int finalScore = bowlingGame.Score();

        assertThat(finalScore).isEqualTo(20);
    }

    @Test
    void add_third_roll_score_to_first_spare_frame_in_entire_game_score() {
        int firstRoll = 7;
        int secondRoll = 3;
        bowlingGame.roll(firstRoll);
        bowlingGame.roll(secondRoll);

        int numberOfRolls = 18;
        int pinsKnockedOnRoll = 2;
        for (int i = 0; i < numberOfRolls; i++) {
            bowlingGame.roll(pinsKnockedOnRoll);
        }

        int containSpare = bowlingGame.Score();

        int spareValue = firstRoll + secondRoll + pinsKnockedOnRoll;
        int scoreOthersFrame = numberOfRolls * pinsKnockedOnRoll;

        assertThat(containSpare).isEqualTo(spareValue + scoreOthersFrame);
    }

    private void playEntireGame(int pinKnockedForEachRoll) {
        for (int i = 0; i < 20; i++) {
            bowlingGame.roll(pinKnockedForEachRoll);
        }
    }
}

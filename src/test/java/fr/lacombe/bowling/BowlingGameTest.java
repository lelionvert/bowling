package fr.lacombe.bowling;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

public class BowlingGameTest {

    private BowlingGame bowlingGame;

    @BeforeEach
    void setUp() {
        bowlingGame = new BowlingGame();
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
        playGame(0, 20);

        int finalScore = bowlingGame.Score();

        assertThat(finalScore).isEqualTo(0);
    }

    @Test
    void entire_game_of_normal_score() {
        playGame(1, 20);

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
        playGame(pinsKnockedOnRoll, numberOfRolls);

        int containSpare = bowlingGame.Score();

        int spareValue = firstRoll + secondRoll + pinsKnockedOnRoll;
        int scoreOthersFrame = numberOfRolls * pinsKnockedOnRoll;

        assertThat(containSpare).isEqualTo(spareValue + scoreOthersFrame);
    }

    @Test
    void Rename_me() {
        int firstRoll = 7;
        int secondRoll = 3;
        int numberOfRolls = 8;
        int pinsKnockedOnRoll = 1;
        playGame(pinsKnockedOnRoll, numberOfRolls);
        bowlingGame.roll(firstRoll);
        bowlingGame.roll(secondRoll);
        playGame(pinsKnockedOnRoll, 10);

        int containSpare = bowlingGame.Score();

        int spareValue = firstRoll + secondRoll + pinsKnockedOnRoll;
        int scoreOthersFrame = (numberOfRolls + 10) * pinsKnockedOnRoll;

        assertThat(containSpare).isEqualTo(spareValue + scoreOthersFrame);
    }

    private void playGame(int pinKnockedForEachRoll, int numberOfRolls) {
        for (int i = 0; i < numberOfRolls; i++) {
            bowlingGame.roll(pinKnockedForEachRoll);
        }
    }
}

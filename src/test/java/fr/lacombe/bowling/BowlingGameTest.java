package fr.lacombe.bowling;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BowlingGameTest {
    @Test
    void two_gutter_rolls_should_give_intermediate_score_of_0() {
        int gutterRoll = 0;
        BowlingGame bowlingGame = new BowlingGame();

        bowlingGame.roll(gutterRoll);
        bowlingGame.roll(gutterRoll);
        int intermediateScore = bowlingGame.getIntermediateScore();

        assertThat(intermediateScore).isEqualTo(0);
    }

    @Test
    void entire_bowling_game_of_gutter_rolls() {
        BowlingGame bowlingGame = new BowlingGame();
        for (int i = 0; i < 20; i++) {
            bowlingGame.roll(0);
        }
        int finalScore = bowlingGame.Score();

        assertThat(finalScore).isEqualTo(0);
    }


}

package fr.lacombe.bowling;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

public class BowlingGameTest {

    private BowlingGame bowlingGame;

    @BeforeEach
    void setUp() {
        Frame frame = mock(Frame.class);
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
    void there_is_spare_in_game_when_a_pair_of_rolls_equal_10() {
        bowlingGame.roll(7);
        bowlingGame.roll(3);

        for (int i = 0; i < 18; i++) {
            bowlingGame.roll(1);
        }

        int containSpare = bowlingGame.Score();

        assertThat(containSpare).isEqualTo(11 + 18);
    }

    private void playEntireGame(int pinKnockedForEachRoll) {
        for (int i = 0; i < 20; i++) {
            bowlingGame.roll(pinKnockedForEachRoll);
        }
    }
}

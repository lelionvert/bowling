package fr.lacombe.bowling;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FrameTest {
    @Test
    void frame_score_is_equal_to_sum_of_knocked_down_pins_when_at_least_one_remain_standing() {
        int pinsKnockedDownOnFirstTry = 3;
        int pinsKnockedDownOnSecondTry = 5;
        int sumOfKnockedDownPins = pinsKnockedDownOnFirstTry + pinsKnockedDownOnSecondTry;

        int score = Frame.of(
                pinsKnockedDownOnFirstTry,
                pinsKnockedDownOnSecondTry)
                .getScore();

        assertThat(score).isEqualTo(sumOfKnockedDownPins);
    }

}

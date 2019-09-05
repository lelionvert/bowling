package fr.lacombe.bowling;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class FrameTest {

    @MethodSource(value = "twoRollsAndTheResultingScore")
    @ParameterizedTest
    void frame_score_is_equal_to_sum_of_knocked_down_pins_when_at_least_one_remain_standing(
            int pinsKnockedDownOnFirstTry, int pinsKnockedDownOnSecondTry, int sumOfKnockedDownPins) {

        int score = Frame.of(
                pinsKnockedDownOnFirstTry,
                pinsKnockedDownOnSecondTry)
                .score();

        assertThat(score).isEqualTo(sumOfKnockedDownPins);
    }

    @Test
    void frame_is_spare_when_the_sum_of_rolls_is_equal_10() {
        Frame frame = Frame.of(7,3);

        boolean isSpare = frame.isSpare();

        assertThat(isSpare).isEqualTo(true);
    }


    @Test
    void frame_is_not_spare_when_the_sum_of_rolls_is_not_10() {
        Frame frame = Frame.of(3, 4);

        boolean isNotSpare = frame.isSpare();

        assertThat(isNotSpare).isEqualTo(false);
    }


    private static Stream<Arguments> twoRollsAndTheResultingScore() {
        return Stream.of(
                Arguments.of(3, 5, 8),
                Arguments.of(2, 3, 5)
        );
    }
}

package fr.lacombe.bowling;

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
                .getScore();

        assertThat(score).isEqualTo(sumOfKnockedDownPins);
    }

    private static Stream<Arguments> twoRollsAndTheResultingScore() {
        return Stream.of(
                Arguments.of(3, 5, 8),
                Arguments.of(2, 3, 5)
        );
    }
}

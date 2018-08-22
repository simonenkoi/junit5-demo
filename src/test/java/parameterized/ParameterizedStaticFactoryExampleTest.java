package parameterized;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

@DisplayName("Pass the method parameters provided by the @MethodSource annotation")
class ParameterizedStaticFactoryExampleTest {

    private static Stream<Arguments> sumProvider() {
        return Stream.of(Arguments.of(1, 1, 2), Arguments.of(1, 2, 3), Arguments.of(1, 3, 4));
    }

    @DisplayName("Should return correct sum")
    @ParameterizedTest(name = "{index} => {0} + {1} = {2}")
    @MethodSource("sumProvider")
    void shouldReturnCorrectSum(int a, int b, int sum) {
        assertEquals(sum, a + b);
    }
}

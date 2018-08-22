package parameterized;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.Assert.assertEquals;

@DisplayName("Pass the method parameters provided by the @CsvSource annotation")
class ParameterizedCsvExampleTest {

    @DisplayName("Should return correct sum")
    @ParameterizedTest(name = "{index} => {0} + {1} = {2}")
    @CsvSource({"1, 1, 2", "1, 2, 3", "1, 3, 4"})
    void shouldReturnCorrectSum(int a, int b, int sum) {
        assertEquals(sum, a + b);
    }
}

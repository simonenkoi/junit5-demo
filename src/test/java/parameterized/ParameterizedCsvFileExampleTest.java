package parameterized;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.Assert.assertEquals;

@DisplayName("Pass the method parameters provided by the @CsvFileSource annotation")
class ParameterizedCsvFileExampleTest {

    @DisplayName("Should return correct sum")
    @ParameterizedTest(name = "{index} => {0} + {1} = {2}")
    @CsvFileSource(resources = "/csv-data.csv")
    void shouldReturnCorrectSum(int a, int b, int sum) {
        assertEquals(sum, a + b);
    }
}

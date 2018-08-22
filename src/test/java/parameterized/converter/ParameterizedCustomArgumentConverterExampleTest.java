package parameterized.converter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.Assert.assertEquals;

@DisplayName("Pass the method parameters provided by the @CsvSource annotation with custom converter")
class ParameterizedCustomArgumentConverterExampleTest {

    @DisplayName("Should pass a non-null message to our test method")
    @ParameterizedTest(name = "{index} => actual=''{0}'', expected=''{1}''")
    @CsvSource({"Hello, Hello", "World, World"})
    void shouldReturnCorrectSum(@ConvertWith(MessageConverter.class) Message actual,
                                @ConvertWith(MessageConverter.class) Message expected) {
        assertEquals(expected.getMessage(), actual.getMessage());
    }
}

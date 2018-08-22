package parameterized;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

@DisplayName("Pass the method parameters provided by the @ArgumentsSource annotation")
class ParameterizedCustomProviderExampleTest {

    @DisplayName("Should return correct sum")
    @ParameterizedTest(name = "{index} => {0} + {1} = {2}")
    @ArgumentsSource(CustomArgumentProvider.class)
    void shouldReturnCorrectSum(int a, int b, int sum) {
        assertEquals(sum, a + b);
    }

    static class CustomArgumentProvider implements ArgumentsProvider {

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            return Stream.of(Arguments.of(1, 1, 2), Arguments.of(1, 2, 3), Arguments.of(1, 3, 4));
        }
    }
}

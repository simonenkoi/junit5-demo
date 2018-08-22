package parameterized;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.Assert.assertNotNull;

@DisplayName("Pass the method parameters provided by the @EnumSource annotation")
class ParameterizedEnumExampleTest {

    @DisplayName("Should pass a non-null message to our test method")
    @ParameterizedTest(name = "{index} => message=''{0}''")
    @EnumSource(Test.class)
    void shouldPassNonNullMessageAsMethodParameter(Test message) {
        assertNotNull(message);
    }

    @DisplayName("Should pass a non-null message to our test method")
    @ParameterizedTest(name = "{index} => message=''{0}''")
    @EnumSource(value = Test.class, names = "HELLO")
    void shouldPassNonNullMessageAsMethodParameterForHello(Test message) {
        assertNotNull(message);
    }

    enum Test {
        HELLO, WORLD
    }
}

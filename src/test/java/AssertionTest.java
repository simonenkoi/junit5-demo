import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test all the assertions")
class AssertionTest {

    @Test
    @DisplayName("Should be true")
    void shouldBeTrue() {
        assertTrue(true);
    }

    @Test
    @DisplayName("Should be false")
    void shouldBeFalse() {
        assertFalse(false);
    }

    @Test
    @DisplayName("Should be null")
    void shouldBeNull() {
        assertNull(null);
    }

    @Test
    @DisplayName("Should not be null")
    void shouldNotBeNull() {
        assertNotNull(new Object());
    }

    @Test
    @DisplayName("Should be equal")
    void shouldBeEqual() {
        Integer expected = 9;
        Integer actual = 9;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Should not be equal")
    void shouldNotBeEqual() {
        Integer expected = 9;
        Integer actual = 4;
        assertNotEquals(expected, actual);
    }

    @Test
    @DisplayName("Should refer to the same object")
    void shouldReferToSameObject() {
        Object expected = new Object();
        Object actual = expected;
        assertSame(expected, actual);
    }

    @Test
    @DisplayName("Should not refer to the same object")
    void shouldNotReferToSameObject() {
        Object expected = new Object();
        Object actual = new Object();
        assertNotSame(expected, actual);
    }

    @Test
    @DisplayName("Should contain the same integers")
    void shouldContainSameIntegers() {
        int[] expected = new int[]{2, 5, 7};
        int[] actual = new int[]{2, 5, 7};
        assertArrayEquals(expected, actual);
    }

    @Test
    @DisplayName("Should contain the same elements")
    void shouldContainSameElements() {
        List<Integer> expected = Arrays.asList(1, 2, 3);
        List<Integer> actual = Arrays.asList(1, 2, 3);
        assertIterableEquals(expected, actual);
    }

    @Test
    @DisplayName("Should throw the correct exception")
    void shouldThrowCorrectException() {
        assertThrows(NullPointerException.class, () -> {
            throw new NullPointerException();
        });
    }

    @Test
    @DisplayName("Should throw an exception that has the correct message")
    void shouldThrowAnExceptionWithCorrectMessage() {
        NullPointerException thrown = assertThrows(NullPointerException.class, () -> {
            throw new NullPointerException("Hello World!");
        });
        assertEquals("Hello World!", thrown.getMessage());
    }

    @Test
    @DisplayName("Should return the correct message before timeout is exceeded")
    void shouldReturnCorrectMessageBeforeTimeoutIsExceeded() {
        String message = assertTimeout(Duration.ofMillis(50), () -> {
            Thread.sleep(20);
            return "Hello World!";
        });
        assertEquals("Hello World!", message);
    }

    @Test
    @DisplayName("Should return the correct message before timeout is exceeded preemptively")
    void shouldReturnCorrectMessageBeforeTimeoutIsExceededPreemptively() {
        final String message = assertTimeoutPreemptively(Duration.ofMillis(50), () -> {
            Thread.sleep(20);
            return "Hello World!";
        });
        assertEquals("Hello World!", message);
    }

    @Test
    @DisplayName("Should be false with custom error message")
    void shouldBeFalseWithCustomErrorMessage() {
        assertFalse(false, "The boolean is not false");
    }

    @Test
    @DisplayName("Should contain the correct key")
    void shouldContainCorrectKey() {
        Map<String, String> map = new HashMap<>();
        String key = "KEY";
        String value = "VALUE";
        map.put(key, value);
        assertTrue(map.containsKey(key), () -> String.format("The map doesn't contain the key: %s", key));
    }

    @Test
    @DisplayName("Should have the correct name")
    void shouldHaveCorrectName() {
        String firstName = "FIRST_NAME";
        String lastName = "LAST_NAME";
        Person person = new Person(firstName, lastName);
        assertAll("name",
                () -> assertEquals(firstName, person.getFirstName(), "The first name is incorrect"),
                () -> assertEquals(lastName, person.getLastName(), "The last name is incorrect"));
    }

    private final class Person {

        private final String firstName;
        private final String lastName;

        Person(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        String getFirstName() {
            return firstName;
        }

        String getLastName() {
            return lastName;
        }
    }
}

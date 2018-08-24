import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("Test all the assertions")
class AssertionAssertJTest {

    @Test
    @DisplayName("Should be true")
    void shouldBeTrue() {
        assertThat(true).isTrue();
    }

    @Test
    @DisplayName("Should be false")
    void shouldBeFalse() {
        assertThat(false).isFalse();
    }

    @Test
    @DisplayName("Should be null")
    void shouldBeNull() {
        Object object = null;
        assertThat(object).isNull();
    }

    @Test
    @DisplayName("Should not be null")
    void shouldNotBeNull() {
        assertThat(new Object()).isNotNull();
    }

    @Test
    @DisplayName("Should be equal")
    void shouldBeEqual() {
        Integer expected = 9;
        Integer actual = 9;
        assertThat(actual).isEqualByComparingTo(expected);
    }

    @Test
    @DisplayName("Should not be equal")
    void shouldNotBeEqual() {
        Integer expected = 9;
        Integer actual = 4;
        assertThat(actual).isNotEqualByComparingTo(expected);
    }

    @Test
    @DisplayName("Should refer to the same object")
    void shouldReferToSameObject() {
        Object expected = new Object();
        Object actual = expected;
        assertThat(actual).isSameAs(expected);
    }

    @Test
    @DisplayName("Should not refer to the same object")
    void shouldNotReferToSameObject() {
        Object expected = new Object();
        Object actual = new Object();
        assertThat(actual).isNotSameAs(expected);
    }

    @Test
    @DisplayName("Should contain the same integers")
    void shouldContainSameIntegers() {
        int[] expected = new int[]{2, 5, 7};
        int[] actual = new int[]{2, 5, 7};
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("Should not contain the same integers")
    void shouldNotContainSameIntegers() {
        int[] expected = new int[]{2, 5, 7};
        int[] actual = new int[]{2, 5, 8};
        assertThat(actual).isNotEqualTo(expected);
    }

    @Test
    @DisplayName("Should contain two elements")
    void shouldContainTwoElements() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        assertThat(list).hasSize(3);
    }

    @Test
    @DisplayName("Should contain the correct elements in the given order")
    void shouldContainCorrectElementsInGivenOrder() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        assertThat(list).containsExactly(1, 2, 3);
    }

    @Test
    @DisplayName("Should contain the correct elements in any order")
    void shouldContainCorrectElementsInAnyOrder() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        assertThat(list).containsExactlyInAnyOrder(3, 2, 1);
    }

    @Test
    @DisplayName("Should contain the correct element once")
    void shouldContainCorrectElementOnce() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        assertThat(list).containsOnlyOnce(1);
    }

    @Test
    @DisplayName("Should not contain an incorrect element")
    void shouldNotContainIncorrectElement() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        assertThat(list).doesNotContain(4);
    }

    @Test
    @DisplayName("Should contain the same elements")
    void shouldContainSameElements() {
        List<Integer> expected = Arrays.asList(1, 2, 3);
        List<Integer> actual = Arrays.asList(1, 2, 3);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("Should throw the correct exception")
    void shouldThrowCorrectException() {
        assertThatThrownBy(() -> {
            throw new NullPointerException();
        }).isExactlyInstanceOf(NullPointerException.class);
    }

    @Test
    @DisplayName("Should throw an exception that has the correct message")
    void shouldThrowAnExceptionWithCorrectMessage() {
        assertThatThrownBy(() -> {
            throw new NullPointerException("Hello World!");
        }).hasMessage("Hello World!");
    }

    @Test
    @DisplayName("Should be empty")
    void shouldBeEmpty() {
        assertThat(Optional.empty()).isEmpty();
    }

    @Test
    @DisplayName("Should not be empty")
    void shouldNotBeEmpty() {
        assertThat(Optional.of(new Object())).isNotEmpty();
    }

    @Test
    @DisplayName("Should contain the correct object")
    void shouldContainCorrectObject() {
        Object object = new Object();
        assertThat(Optional.of(object)).contains(object);
    }

    @Test
    @DisplayName("Should be false with custom description")
    void shouldBeFalseWithCustomDescription() {
        assertThat(false)
                .describedAs("The boolean is not false")
                .isFalse();
    }

    @Test
    @DisplayName("Should override entire error message")
    void shouldBeFalseWithCustomErrorMessage() {
        assertThat(false)
                .overridingErrorMessage("The boolean is not false")
                .isFalse();
    }

    @Test
    @DisplayName("Should contain the correct key")
    void shouldContainCorrectKey() {
        Map<String, String> map = new HashMap<>();
        String key = "KEY";
        String value = "VALUE";
        map.put(key, value);
        assertThat(map).containsKey(key);
    }

    @Test
    @DisplayName("Should not contain the incorrect key")
    void shouldNotContainInCorrectKey() {
        Map<String, String> map = new HashMap<>();
        String key = "KEY";
        String value = "VALUE";
        map.put(key, value);
        assertThat(map).doesNotContainKey("INCORRECT_KEY");
    }

    @Test
    @DisplayName("Should contain the given entry")
    void shouldContainGivenEntry() {
        Map<String, String> map = new HashMap<>();
        String key = "KEY";
        String value = "VALUE";
        map.put(key, value);
        assertThat(map).containsEntry(key, value);
    }

    @Test
    @DisplayName("Should not contain the given entry")
    void shouldNotContainGivenEntry() {
        Map<String, String> map = new HashMap<>();
        String key = "KEY";
        String value = "VALUE";
        map.put(key, value);
        assertThat(map).doesNotContainEntry("INCORRECT_KEY", value);
    }

    @Test
    @DisplayName("Should have the correct name")
    void shouldHaveCorrectName() {
        String firstName = "FIRST_NAME";
        String lastName = "LAST_NAME";
        Person person = new Person(firstName, lastName);
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(person.getFirstName()).isEqualTo(firstName);
        softAssertions.assertThat(person.getLastName()).isEqualTo(lastName);
        softAssertions.assertAll();
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

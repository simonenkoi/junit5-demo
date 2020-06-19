package extensions;

import com.github.simonenkoi.junit5.Person;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(ParameterResolverTest.PersonParameterResolver.class)
public class ParameterResolverTest {

    @Test
    public void personShouldBeJimi(Person person) {
        assertEquals("Jimi", person.getFirstName());
    }

    public static class PersonParameterResolver implements ParameterResolver {

        @Override
        public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext)
                throws ParameterResolutionException {
            return parameterContext.getParameter().getType()
                                   .equals(Person.class);
        }

        @Override
        public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext)
                throws ParameterResolutionException {
            return new Person("Jimi", "Hendrix");
        }
    }
}

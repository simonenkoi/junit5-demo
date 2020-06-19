package extensions;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestInstancePostProcessor;

import java.lang.reflect.Field;

import static org.junit.Assert.assertNotNull;

@ExtendWith(PostProcessorTest.InitializationExtension.class)
public class PostProcessorTest {

    private int fieldToInitialize;

    @Test
    void fieldShouldBeInitialized() {
        assertNotNull(fieldToInitialize);
    }

    static class InitializationExtension implements TestInstancePostProcessor {

        @Override
        public void postProcessTestInstance(Object testInstance, ExtensionContext context) throws Exception {
            Field field = testInstance.getClass().getDeclaredField("fieldToInitialize");
            field.setAccessible(true);
            field.setInt(testInstance, 45);
        }
    }
}

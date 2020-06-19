package extensions;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ExecutionCondition;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ExtensionContext;

import static org.junit.Assert.assertNotEquals;

@ExtendWith(ConditionalTest.EnvironmentExtension.class)
public class ConditionalTest {

    @Test
    void shouldBeExecutedOnLocalEnvironmentOnly() {
        assertNotEquals("production", System.getProperty("env"));
    }

    static class EnvironmentExtension implements ExecutionCondition {

        @Override
        public ConditionEvaluationResult evaluateExecutionCondition(ExtensionContext context) {
            String environment = System.getProperty("env");
            if (environment != null && environment.equalsIgnoreCase("production")) {
                return ConditionEvaluationResult.disabled("Test disabled on production environment");
            }
            return ConditionEvaluationResult.enabled("Test enabled on QA environment");
        }
    }
}
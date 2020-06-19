package extensions;

import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class LoggingExtension implements
        BeforeAllCallback, AfterAllCallback, BeforeEachCallback, AfterEachCallback {

    @Override
    public void beforeAll(ExtensionContext extensionContext) {
        System.out.println("Before all");
    }

    @Override
    public void beforeEach(ExtensionContext extensionContext) {
        System.out.println("Before each");
    }

    @Override
    public void afterEach(ExtensionContext extensionContext) {
        System.out.println("After each");

    }

    @Override
    public void afterAll(ExtensionContext extensionContext) {
        System.out.println("After all");
    }
}

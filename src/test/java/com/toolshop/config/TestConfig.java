package com.toolshop.config;

/**
 * Configuration class for test constants and settings.
 * Following the Single Responsibility Principle by centralizing test configuration.
 */
public class TestConfig {
    public static final String PROVIDER_NAME = "ToolshopProvider";
    public static final String CONSUMER_NAME = "ToolshopConsumer";
    public static final String PROVIDER_HOST = "api.practicesoftwaretesting.com";
    public static final int PROVIDER_PORT = 443;
    public static final String PACT_FILES_LOCATION = "target/pacts";
    
    private TestConfig() {
        // Private constructor to prevent instantiation
        // Following the Utility Class pattern
    }
}

package com.toolshop.base;

import au.com.dius.pact.core.model.Interaction;
import au.com.dius.pact.core.model.Pact;
import org.junit.jupiter.api.BeforeEach;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Base class for contract tests implementing Template Method pattern.
 * Provides common functionality and logging for all contract tests.
 */
public abstract class BaseContractTest {
    protected final Logger logger = LoggerFactory.getLogger(getClass());
    
    @BeforeEach
    void baseSetUp() {
        logger.info("Starting contract test execution");
        customSetUp();
    }
    
    /**
     * Template method to be implemented by subclasses for specific setup.
     * Following Template Method pattern.
     */
    protected abstract void customSetUp();
    
    /**
     * Utility method to log interaction details.
     * Following the Single Responsibility Principle.
     */
    protected void logInteractionDetails(Pact pact, Interaction interaction) {
        logger.info("Executing pact: {} - {}", pact.getProvider().getName(), interaction.getDescription());
    }
}

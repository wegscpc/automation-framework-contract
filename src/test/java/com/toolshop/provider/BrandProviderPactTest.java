package com.toolshop.provider;

import au.com.dius.pact.provider.junit5.HttpsTestTarget;
import au.com.dius.pact.provider.junit5.PactVerificationContext;
import au.com.dius.pact.provider.junit5.PactVerificationInvocationContextProvider;
import au.com.dius.pact.provider.junitsupport.Provider;
import au.com.dius.pact.provider.junitsupport.State;
import au.com.dius.pact.provider.junitsupport.loader.PactFolder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.ExtendWith;
import com.toolshop.base.BaseContractTest;
import com.toolshop.config.TestConfig;

/**
 * Provider contract test implementing the Strategy pattern through Pact's test infrastructure.
 * Extends BaseContractTest to inherit common test functionality.
 */
@Provider(TestConfig.PROVIDER_NAME)
@PactFolder(TestConfig.PACT_FILES_LOCATION)
public class BrandProviderPactTest extends BaseContractTest {

    @Override
    protected void customSetUp() {
        // No custom setup needed for now
    }

    @BeforeEach
    void setUp(PactVerificationContext context) {
        logger.info("Setting up provider test with target: {}:{}", 
            TestConfig.PROVIDER_HOST, TestConfig.PROVIDER_PORT);
        context.setTarget(new HttpsTestTarget(TestConfig.PROVIDER_HOST, TestConfig.PROVIDER_PORT));
    }

    @TestTemplate
    @ExtendWith(PactVerificationInvocationContextProvider.class)
    void pactVerificationTestTemplate(PactVerificationContext context) {
        logger.info("Verifying provider interaction");
        context.verifyInteraction();
    }

    @State("brands exist")
    public void brandsExist() {
        logger.info("Setting up 'brands exist' state");
        // The state is already set up in the external API
    }
}

package com.toolshop.consumer;

import au.com.dius.pact.consumer.MockServer;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit5.PactConsumerTestExt;
import au.com.dius.pact.consumer.junit5.PactTestFor;
import au.com.dius.pact.core.model.V4Pact;
import au.com.dius.pact.core.model.annotations.Pact;
import com.toolshop.client.BrandApiClient;
import com.toolshop.dto.BrandDto;
import com.toolshop.base.BaseContractTest;
import com.toolshop.config.TestConfig;
import com.toolshop.builder.BrandTestDataBuilder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Consumer contract test implementing the Strategy pattern through Pact's test infrastructure.
 * Extends BaseContractTest to inherit common test functionality.
 */
@ExtendWith(PactConsumerTestExt.class)
@PactTestFor(providerName = TestConfig.PROVIDER_NAME)
public class BrandConsumerPactTest extends BaseContractTest {

    @Override
    protected void customSetUp() {
        // No custom setup needed for now
    }

    @Pact(consumer = TestConfig.CONSUMER_NAME, provider = TestConfig.PROVIDER_NAME)
    public V4Pact getAllBrandsPact(PactDslWithProvider builder) {
        // Using Builder pattern for test data creation
        String firstBrand = BrandTestDataBuilder.aDefaultBrand().toJsonString();
        String secondBrand = BrandTestDataBuilder.aDefaultBrand()
                .withId("01JHTKACQV2ENDEGXJ4XQGWNVN")
                .withName("MightyCraft Hardware")
                .withSlug("mightycraft-hardware")
                .toJsonString();

        logger.info("Creating pact for getAllBrands");
        return builder
                .given("brands exist")
                .uponReceiving("a request for all brands")
                .path("/brands")
                .method("GET")
                .willRespondWith()
                .status(200)
                .headers(Map.of("Content-Type", "application/json"))
                .body("[" + firstBrand + "," + secondBrand + "]")
                .toPact(V4Pact.class);
    }

    @Test
    @PactTestFor(pactMethod = "getAllBrandsPact")
    void testGetAllBrands(MockServer mockServer) {
        logger.info("Testing getAllBrands with mock server at: {}", mockServer.getUrl());
        
        // Given
        BrandApiClient brandApiClient = new BrandApiClient(mockServer.getUrl());

        // When
        List<BrandDto> brands = brandApiClient.getAllBrands();

        // Then
        assertNotNull(brands, "Brands list should not be null");
        assertTrue(brands.size() >= 1, "Should have at least one brand");
        
        // Using Builder pattern for expected test data
        BrandDto expectedFirstBrand = BrandTestDataBuilder.aDefaultBrand().build();
        BrandDto expectedSecondBrand = BrandTestDataBuilder.aDefaultBrand()
                .withId("01JHTKACQV2ENDEGXJ4XQGWNVN")
                .withName("MightyCraft Hardware")
                .withSlug("mightycraft-hardware")
                .build();
        
        // Verify first brand
        assertBrandEquals(expectedFirstBrand, brands.get(0));
        
        // Verify second brand
        assertBrandEquals(expectedSecondBrand, brands.get(1));
        
        logger.info("Successfully verified {} brands", brands.size());
    }
    
    /**
     * Helper method to assert brand equality.
     * Following Single Responsibility Principle.
     */
    private void assertBrandEquals(BrandDto expected, BrandDto actual) {
        assertEquals(expected.getId(), actual.getId(), "Brand ID should match");
        assertEquals(expected.getName(), actual.getName(), "Brand name should match");
        assertEquals(expected.getSlug(), actual.getSlug(), "Brand slug should match");
    }
}

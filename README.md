# automation-framework-contract
 This is an Automation Framework for contract testing using Java and Pact.io for an API documentation 
 https://api.practicesoftwaretesting.com/docs/api-docs.json

Here is summary of the automation framework structure and its improvements:

1. Architecture Overview:
- The framework follows a contract-testing approach using Pact framework
- Implements a clear separation between consumer and provider tests
- Uses a layered architecture with distinct packages for different responsibilities

2. Key Components: 

  a. Main Components (src/main):
  - BrandApiClient: REST client for making API calls
  - BrandDto: Data transfer objects for brand-related data
  
  b. Test Components (src/test):
  - base: Contains base test classes with common functionality
  - builder: Test data builders
  - config: Test configuration
  - consumer: Consumer contract tests
  - provider: Provider contract tests

3. Design Patterns & Improvements: 

  a. Design Patterns:
  - Template Method Pattern: Used in BaseContractTest for common test setup
  - Builder Pattern: Implemented in BrandTestDataBuilder for test data creation
  - Strategy Pattern: Applied in contract tests through Pact's infrastructure
  
  b. SOLID Principles:
  - Single Responsibility: Each class has a focused purpose
  - Open/Closed: Framework is extensible for new test types
  - Interface Segregation: Clean API client interfaces

4. Key Improvements: 

  a. Code Organization:
  - Clear package structure
  - Separation of concerns between test and main code
  - Centralized configuration in TestConfig
  
  b. Maintainability:
  - Reusable test data builders
  - Common base test class reducing code duplication
  - Consistent logging implementation
  
  c. Testing Approach:
  - Contract testing implementation ensuring API compatibility
  - Separate consumer and provider tests
  - Well-structured test data generation

5. Technical Features:
- Uses RestAssured for API testing
- Implements Pact for contract testing
- Lombok for reducing boilerplate code
- Logback for logging configuration

This framework demonstrates several best practices in test automation:
- Clear separation of concerns
- Use of design patterns
- Maintainable and reusable code structure
- Strong focus on contract testing
- Proper test data management

# API Testing with TestNG and RestAssured

## Project Setup
1. Clone the repository.
2. Ensure Java and Maven are installed.
3. Run `mvn test` to execute all tests.

## Highlights
### Temporary Solutions:
- The test for the POST request lacks detailed error handling.
- The GET request tests verify basic response attributes but require enhancements.

### Technical Debt:
- The `testPostRequest` test needs better error handling for non-201 status codes.
- Future improvements include data-driven testing and more detailed response validations.

## Known Issues
- The POST endpoint occasionally fails under high load.

## Future Improvements
- Implement data-driven testing for multiple endpoints.
- Add comprehensive response validation.




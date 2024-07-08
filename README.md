# LCL0724
This is sample Tool Rental Service application
Steps to compile and run
 JavaLanguageVersion.of(21)
1. git clone LCL0724

2. ./gradlew clean build under folder LCL0724
3. ./gradlew run to run application under folder LCL0724

When do a ./gradlew clean build all the test case should ran/passed

All 6 test cases in the document is in test.java.com.example.toolrental.integrationTest.ToolRentalControllerIntegrationTest
All other test is unit test for each layer.

sample run request:
POST http://localhost:8080/tool_rental_service/v1/checkout
with body json:
{
"code": "",
"rentalDayCount": 4,
"discountPercent": 50,
"checkoutDate": "07/02/20"
}



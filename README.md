# LCL0724
This is sample Tool Rental Service application
Steps to compile and run
git clone LCL0724

do ./gradlew clean build
then do ./gradlew run to run application

When do a ./gradlew clean build all the test case should ran/passed

All 6 test cases on the document is 
in test.java.com.example.toolrental.integrationTest.ToolRentalControllerIntegrationTest
All other test is unit test for each layer.

sample run request:
POST http://localhost:8080/tool_rental_service/checkout
with body json:
{
"code": "",
"rentalDayCount": 4,
"discountPercent": 50,
"checkoutDate": "07/02/20"
}



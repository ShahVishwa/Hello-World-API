# Hello-World-API

*Setup Instructions:
1. Clone Hello-World-API repository using an IDE like Eclipse
2. After importing the project into Eclipse, run the application as "Spring Boot Application" (All dependecies of the project are in pom.xml as this is a spring project and hence does not require importing any dependencies)
3. The Debug Log Level is OFF by default. To enable debug logging level go to src/main/resources/application.properties and change the value of two parameters as shown below and re-run the application to see the debug logger in console:
  1. logging.level.org.springframework=DEBUG
  2. logging.level.root=WARN
4. After starting/running the application, open POSTMAN tool and create GET http request http://localhost:8080/. The result received in the body area of response section will be: "<p>Hello, World</p>"
5. Create GET request with accept headers to http://localhost:8080/. To add Accept header in Postman go to headers tab in the request area and Add Key as "Content-Type" and value as "text/html". Press "Send". The result received in the body area of response section will be "{'message' : 'Hello, World'}"
6. Create POST request by providing a JSON body of either your choice or using "{"message":"Hello! World"}" and result received in the body area of response section will be "{"message":"Hello! World"}"

*cURL commands to start the application from command prompt:
1. Run the application from IDE as Spring Boot Application
2. Open the Command Prompt. Type these 3 commands below for 3 scenarios
  1. GET request without accept headers: curl -v http://localhost:8080
  2. GET request with accept headers: curl -i -H “Accept: application/json” -H “Content-Type: text/html” http://localhost:8080
  3. POST request: curl - -data “message=Hello! World” http://localhost:8080
  
*Running the unit tests
1. Within the project in IDE go to: src/test/java/HelloWorldApiApplicationTest.java
2. Right click within the class and select "Run As" --> JUnit Test
3. In order to check the coverage of the application, right-click on the application and select "Coverage As" --> JUnit Test


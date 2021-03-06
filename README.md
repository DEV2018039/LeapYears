# LeapYears
This is an Full Stack Spring Boot Application which determine whether the given year is Leap Year or not

User Story:
  As a user, I want to know if a year is a leap year, So that I can plan for an extra day on February 29th during those years.

Acceptance Criteria:
- All years divisible by 400 ARE leap years (so, for example, 2000 was indeed a leap year),
- All years divisible by 100 but not by 400 are NOT leap years (so, for example, 1700, 1800, and 1900 were NOT leap years, NOR will 2100 be a leap year),
- All years divisible by 4 but not by 100 ARE leap years (e.g., 2008, 2012, 2016),
- All years not divisible by 4 are NOT leap years (e.g. 2017, 2018, 2019).

Additional Rule:
- NOTE: Entered year have to be between 1582 to 8000.


# Goal:
 Need to determine whether the given year is leap year or not.

# Maven Commands to clean the project:
```bash
mvn clean
```
# Maven Commands to install the project:
```bash
mvn install
```

# Maven Commands to run the test:
```bash
mvn test
```

The Jacoco reports can be found in target folder as below.

```bash
target\site\jacoco\index.html
```

The Mutation reports can be found in target folder as below.

```bash
target\pit-reports
```

# Maven Commands to start the SpringBoot:
```bash
mvn spring-boot:run
```

# Swagger Url to view the Rest API Documentation
  This url will be available only after we start the Spring boot application using above command.
```bash
http://localhost:9080/bnppfortis/swagger-ui.html
```

Use the below creds to view the Swagger documentation

```bash
UserName: user
Password: password
```


# Maven Command to run the sonar

```bash
mvn sonar:sonar -Dsonar.projectKey=DEV2018039_sonarTest -Dsonar.organization=dev2018039-github -Dsonar.host.url=https://sonarcloud.io -Dsonar.login=ed578856983589a00a3a448a97c36138436c1c3c
```

The Sonar results can then be viewed in the below url

```bash
https://sonarcloud.io/dashboard?id=DEV2018039_sonarTest
```

# Accessing the Front end Url
  Use the below url to access the View
```bash
http://localhost:9080/bnppfortis/leapyear
```


# My solution
- Create a Spring boot Microservice Application with two API one with Plain text response and other with Json Response but both performs the same operation.
- Add the Swagger documentation for the API created.
- Perform the Test Driven Develpoment to create a API.
- Test the API using the Swagger docs.
- Create a simple html5 with jquery which invokes the api and shows the result in ui.

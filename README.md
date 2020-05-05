# eBay-Project
 Using [Spring Boot](https://spring.io/projects/spring-boot) and [Jersey](https://eclipse-ee4j.github.io/jersey/), this project creates a local, RESTful web service that determines whether clients' items are eligible for the program.

## Getting Started

Follow these instructions to get the project up and running on your local machine for development and testing purposes.

### Prerequisites

You will need [JDK 14](https://www.oracle.com/java/technologies/javase-jdk14-downloads.html) installed, and your PATH environment variable should have the 'bin' folder from JDK added:

```
C:\>setx PATH "C:\Program Files\Java\jdk-14.0.1\bin;%PATH%"
```

Also, make sure you have added JAVA_HOME as an environment variable:

```
C:\>setx -m JAVA_HOME "C:\Program Files\Java\jdk-14.0.1"
```

NOTE: This project uses Maven as its build tool, but since the Spring Boot framework included Maven Wrapper, an executable shell script, there is no need to install Maven. The command ```mvnw``` is used to run the build tool.

### Installing

We can run any of [Maven's phases](http://maven.apache.org/guides/introduction/introduction-to-the-lifecycle.html) by going to the project's directory:

```
C:\...\eBay_project\CodingChallenge>
```

and executing a goal: 

```
mvnw clean package
```

This will compile, run tests, and package the project up into an executable JAR file. The file can be found in the *target* directory. If you want to install the JAR file to your local machine, run the *install* goal:

```
mvnw clean install
```

which will run all previous Maven goals, and save a copy of the JAR executable to the *./m2/repository* directory in your home directory.

To get the service up and running, either execute the JAR file:

```
java -jar target/CodingChallenge-0.0.1-SNAPSHOT.jar
```

or run it using ```spring-boot```

```
mvnw spring-boot:run
```

which will establish a connection to the server at port 8080. Since the application path is "/rest" and the REST endpoint's path is "/item", we can reach the endpoint using this URI: http://localhost:8080/rest/item.

## Description

Items are characterized by 4 fields:
* The *title* of the item
* The username of the *seller*
* The item's *category*
* The *price* of the item in USD

An item is eligible for the shipping program if:
* The seller of the item is enrolled in the shipping program
* The item is from a pre-approved category
* The item at least a certain price

By default, the minimum price has been set to 100 USD, and a list of pre-approved categories (*ItemCategories.JSON*) and enrolled sellers (*EnrolledSellers.JSON*) have been created to search through. You can find these files in the *service/conditions/* directory.

## API Documentation

 NOTE: If you are not interested in how the service works, and merely want to use the service, you can skip this section.
 
 Here is a flow chart that shows how the client and server communicate:
 
 

## Usage & Testing

Once the service API is up and running, you can use it to see how it works.

### Manual Tests

We can send an item in Postman using the POST HTTP request to the correct URI. Make sure the request is sent as a JSON application:

![postman1](Postman_screenshot_1.png)

and look at the response:

![postman2](Postman_screenshot_2.png)

Make sure to provide all of the correct fields. You can input the fields in any order, and provide more inputs than necessary.

![postman3](Postman_screenshot_3.png)

![postman4](Postman_screenshot_4.png)

Example of a test Item that is missing a field:

![postman5](Postman_screenshot_5.png)

![postman6](Postman_screenshot_6.png)

### Test Programs

Unit tests and integrated tests are provided in the *test* directory. You can run all tests together:

```
mvnw clean test
```

or a set of them by class name:

```
mvnw clean test -Dtest=ClassName
```

## Built With

* [Dropwizard](http://www.dropwizard.io/1.0.2/docs/) - The web framework used
* [Maven](https://maven.apache.org/) - Dependency Management
* [ROME](https://rometools.github.io/rome/) - Used to generate RSS Feeds

### Maven Dependencies


## Authors

* **Billie Thompson** - *Initial work* - [PurpleBooth](https://github.com/PurpleBooth)

See also the list of [contributors](https://github.com/your/project/contributors) who participated in this project.


## Acknowledgments

* Hat tip to anyone whose code was used
* Inspiration
* etc


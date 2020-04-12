# kotlin-gradle-spring-boot-starter
The purpose of this project is to serve as template Spring project with certain initial design choices already decided.

The project is setup to be written in Kotlin targeting Java 11. Gradle is the build tool of choice, being simpler and easier to read than Maven. The gradle build scripts are also written as Kotlin scripts rather than Gradle's previous default Groovy since writing the build scripts in the language of the project is more straightforward.

### Dependencies
Some utility libraries included are Kotlin logging and Jackson's Kotlin module. Spring's actuator, JPA, and web starter libraries are also included by default.

### Features
Features are feature packaged into their own directories. An example of this is provided in this template for 'Jobs'. Each feature contains the following:
- A controller
    - Within the controller file, there are two classes. One class is for "read-only" endpoints and the other is for "mutable" endpoints. This makes it easier to distinguish which endpoints are executed under a read-only versus an ordinary JPA transaction. It is also just easier to read which endpoints are performing an action and which are not.
- A Service
    - The service is injected into the controller and handles business logic related to the feature. It handles writing and reading entities to and from the data store.
    - The service is also responsible for converting data store entities into a model compatible to be sent to the outside world.
    - The data store in this template is a simple list but in a real project could easily be replaced by some sort of database.
    - The service also extends from BaseService which extends from ServiceCoordinatorConsumer
        - BaseService allows the service to access its respective model converter
        - The service extends ServiceCoordinatorConsumer in order to facilitate easy communication between services
            - This feature is intended to be used with care and forethought since communication between all ordinary services could be abused. But doing this also removes the complexity involved with deciding which services should be injected into other services
- A `model` directory
    - This directory is exactly what it sounds: it is intended to hold models specific to a specific feature
- A `converter` directory
    - This directory contains the feature's model converter which is injected into the service and whose purpose is to convert from the feature's backend entity to the model visible to the outside world

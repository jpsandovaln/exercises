# exercises

# Problem 1
----------------------------

    Technologies and tools used:

    *   Hibernate
    *   JPA
    *   Spring boot
    *   Java 8
    *   Intellij IDEA
    *   Gradle
    *   H2
    *   swagger


    Endpoints:

    *   Class:
        *   http://localhost:9090/api/v1/class   -    GET ALL and POST methods
        *   http://localhost:9090/api/v1/class/{id} - GET BY ID, DELETE, UPDATE methods
        *   http://localhost:9090/api/v1/class/filter?code=<some code>&title=<some title> - GET method to search using query params
        *   http://localhost:9090/api/v1/class/students/{user_id} - list all classes by student
    *   Class:
        *   http://localhost:9090/api/v1/student   -    GET ALL and POST methods
        *   http://localhost:9090/api/v1/student/{id} - GET BY ID, DELETE, UPDATE methods
        *   http://localhost:9090/api/v1/student/filter?fisrtName=<some firstName>&lastName=<some lastName> - GET method to search using query params
        *   http://localhost:9090/api/v1/student/classes/{class_id} - list all students by class

    Swagger URL:
    *   http://localhost:9090/api/v1/swagger-ui.html

# Problem 2
----------------------------

    *   I used the Haversine algorithm.

    Note: To test run unit test.

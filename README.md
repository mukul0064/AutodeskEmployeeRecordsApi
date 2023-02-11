
# AUTODESK Employee Records API

This is a simple API working as Autodesk Employee service used to perform CRUD service for Employee records for inventory.

# Pre-requisites
Before Running the application you need a database setup, the application supports mySql.
Once you have setup the MySql database. Go to "DB Query.text" to get certain queries for setting up the employee records table for testing.

-- For any other database the pom need to be updated with respective dependency jdbc driver. Also application properties need to be updated accordingly.

--Use provided postman collection "Autodesk.Employee.postman_collection.json" for testing the application in postman after running.

to Download postman go to the below mentioned link

https://www.postman.com/downloads/

-- "Autodesk Employee Records - Swagger.yaml" is the swagger open api specification of the application, to read it go to the below mentioned url and put swagger there.

https://editor.swagger.io/

# API Endpoints
The API provides the following endpoints:

# Get all Employee Records
Method: GET Endpoint: /autodesk/records

Description: This endpoint retrieves all the employee records from the inventory.
# Update Employee Record
Method: PUT Endpoint: /autodesk/record/update

Description: This endpoint updates the details of an employee record for a given employee ID.
# Add Employee Record
Method: POST Endpoint: /autodesk/record/add

Description: This endpoint adds a new employee record to the inventory.
# Delete Employee Record
Method: PUT Endpoint: /autodesk/record/delete

Description: This endpoint deletes an employee record from the inventory based on the given employee ID.
# Health Check
Method: GET Endpoint: /autodesk/health

Description: This endpoint performs a basic health check to verify if the API is up and running.
# Request and Response
The API request and response bodies have the following schema:
# Request Body
For the /autodesk/record/update and /autodesk/record/add endpoints, the request body must be a JSON object consisting of the following properties:

•	employeeId: Employee ID. Must be a 4-digit positive number greater than 999.

•	employeeFirstName: First name of the employee

•	employeeLastName: Last name of the employee

•	designation: Designation of the employee

•	department: Department for which the employee works

•	salary: Monthly in-hand salary of the employee
# Response Body
•	The GET /autodesk/records endpoint returns a JSON array of objects, each representing an employee record.

•	The PUT /autodesk/record/update endpoint returns a JSON object representing the result of the update operation.

•	The POST /autodesk/record/add and PUT /autodesk/record/delete endpoints return a JSON object representing the status of the operation.

•	The GET /autodesk/health endpoint returns a JSON object representing the health status of the API.
# Contact
For any questions or issues, please contact the API owner at mukul0064@gmail.com.

# Application Definition

This project uses Quarkus, the Supersonic Subatomic Java Framework.
If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running application in local
You can run application application in local as well by simply running the MainApplication java class as Java Application.

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Packaging and running the application

The application can be packaged using:
```shell script
./mvnw package
```
It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:
```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

## Creating a native executable

You can create a native executable using: 
```shell script
./mvnw package -Pnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
./mvnw package -Pnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/employee-records-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.

## Related Guides

- RESTEasy Classic ([guide](https://quarkus.io/guides/resteasy)): REST endpoint framework implementing JAX-RS and more
- Agroal - Database connection pool ([guide](https://quarkus.io/guides/datasource)): Pool JDBC database connections (included in Hibernate ORM)

## Provided Code

### RESTEasy JAX-RS

Easily start your RESTful Web Services

[Related guide section...](https://quarkus.io/guides/getting-started#the-jax-rs-resources)

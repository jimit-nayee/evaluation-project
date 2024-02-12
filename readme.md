# Spring Boot Microservice Project (Retail POS system)

This is a Spring Boot microservice project(Retail POS system) that [briefly describe what your project does].

## Table of Contents
- [Prerequisites](#prerequisites)
- [Usage](#usage)
- [API Endpoints](#api-endpoints)
- [Database](#database)
- [Testing](#testing)

## Prerequisites

List the software and tools that need to be installed before setting up the project.

- [Java JDK](https://adoptium.net/?variant=openjdk11&jvmVariant=hotspot)
- [Apache Maven](https://maven.apache.org/)

## usage

- This web-app is used for store the data of retail store which is store selling and purchaseing item data.
- There are three micro-service 

1. Stock management
2. Sell management
3. purchase management

- There is also a gateway and eureka server in this micro-service.
- you can call any service api using the gateway point


- ApiGateway[8080]
- EurekaService[8761]
- StockManagaement[8081]
- OrderManagement[8082]
- SellManagement[8083]

## used concept 
- Validation
- Pagination
- Model Mapper
- Rest Controller Adviser
- Exception Handling
- DTO
- Gateway
- Eureka server
- Testing

## Datebase

- I have used mongoDb-atlas to store the data.

- > here is a link of my database :- mongodb+srv://root:root@cluster0.vjvzhpe.mongodb.net/?retryWrites=true&w=majority






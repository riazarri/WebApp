# WebApp - IoT Platform 
Welcome to WebApp, an IoT platform reporting service that enables you to store and retrieve sensor readings through REST APIs. This simple web application is designed to handle information from various sensors, including Temperature, Humidity, and Acoustic sensors. With WebApp, you can easily manage and access sensor data for your IoT projects.

# Project Description
WebApp is a web application built on Spring Boot that serves as a reporting service for an IoT platform. The application's main focus is to provide endpoints for storing and retrieving sensor readings from different types of sensors. Whether you're dealing with temperature, humidity, or acoustic data, WebApp has you covered. Through its intuitive REST APIs, you can seamlessly integrate this service into your IoT projects and effectively manage sensor data.

# Prerequisites
Before you start using WebApp, please ensure you have the following prerequisites installed on your system:

- Spring Boot: WebApp is developed using the Spring Boot framework. If you haven't already, you can download and install Spring Boot by following the instructions on the official Spring Boot website.

- Docker (Version 24.0.5 or higher): Docker is used to containerize and manage application dependencies. Make sure you have Docker installed on your system. You can download Docker from the official Docker website and follow their installation guides.

- Jenkins: Jenkins is utilized for continuous integration and automated deployment. If you don't have Jenkins installed, you can set it up by visiting the Jenkins official website and following their installation instructions.

- Java 20: This project requires Java 20 to run. Ensure that you have Java Development Kit (JDK) 20 or a compatible version installed. You can download the JDK from the official Oracle or OpenJDK website.

- PostgreSQL (Version 15.4-1): PostgreSQL is the database system used for this project. You should have PostgreSQL 15.4-1 or a compatible version installed. You can download PostgreSQL from the official PostgreSQL website and follow their installation guides.

# Getting Started
To get started with WebApp, follow these steps:

Clone this repository: git clone https://github.com/SotiriaZarri/WebApp.git

Change into the project directory: cd WebApp

Build and package the project: mvn clean package

Run the application: java -jar target/WebApp.jar

# Usage
WebApp provides a set of REST APIs for managing sensor data. 
1. After building the project you can run the application using the following command:

      java -jar target/WebApp.jar

2. Once the application is running, you can access it by navigating to http://localhost:8090 in your web browser.
3. Now you can interact with Rest APIs and store Sensor readings or retrieve by POST and GETS requests.
   
# Dockerization

You can easily containerize and deploy the WebApp using Docker.
Docker allows you to package your application and its dependencies into a single unit,
making it portable and consistent across different environments.

 - Building the Docker Image
To build a Docker image for the WebApp, follow these steps:

Open a terminal window and navigate to the project directory.

Use the following command to build the Docker image:
docker build -t webapp:latest .
This command will build a Docker image named webapp with the tag latest using the current directory (.) as the build context.
# UML diagram
![uml1 drawio](https://github.com/SotiriaZarri/WebApp/assets/138468560/72f3d5a3-834c-458a-b174-2eaff99a7e98)

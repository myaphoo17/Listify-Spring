# Listify-Spring

# Listify App - Spring Backend

## Table of Contents

- [Features](#features)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
- [Configuration](#configuration)
- [H2 Database Configuration](#h2-database-configuration)
- [Usage](#usage)
- [API Documentation](#api-documentation)
- [Contributing](#contributing)
- [License](#license)

## Features

- Create, update, and delete tasks.
- Mark tasks as completed.
- User authentication and authorization.
- Secure API endpoints.
- Data persistence with an H2 in-memory database.

## Getting Started

Follow these instructions to get a copy of the Listify backend up and running on your local machine for development and testing purposes.

### Prerequisites

- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-downloads.html)
- [Apache Maven](https://maven.apache.org/download.cgi)
- [Spring Boot](https://spring.io/projects/spring-boot)

### Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/yourusername/listify-backend.git

   
Configuration
You can configure the application by modifying the application.properties or application.yml file. Set your database connection details, security settings, and other properties as needed.

H2 Database Configuration
Listify uses the H2 in-memory database for local development and testing. The H2 database is automatically configured in the Spring Boot application. You can access the H2 console to view and manage the database.

Accessing the H2 Console
Ensure that the Listify backend is running locally.

Open a web browser and go to http://localhost:8080/h2-console.

Configure the following settings:

JDBC URL: jdbc:h2:mem:testdb
Driver Class: org.h2.Driver
Username: sa
Password: (leave it empty)
Click the "Connect" button.

You can now interact with the H2 database using the H2 Console. This is useful for inspecting tables, running SQL queries, and debugging during development.

Note: In a production environment, you would typically configure a persistent database like MySQL or PostgreSQL.

Usage
The Listify backend provides a RESTful API for managing tasks. You can interact with the API using tools like Postman or by integrating it with the Listify frontend.

For more details on how to use the API, refer to the API documentation.

API Documentation
For detailed API documentation and endpoints, refer to the API documentation.

Contributing
Contributions to Listify are welcome! To contribute to this project, follow these steps:

Fork the repository.
Create a new branch for your feature or bug fix.
Make your changes and commit them.
Push your changes to your fork.
Submit a pull request to the main branch of the original repository.
Please read our Contributing Guidelines for more information on how to contribute.

License
This project is licensed under the MIT License - see the LICENSE file for details.


<img src="https://github.com/KRPoojari/AIChatBot/assets/26119044/72f1d79c-4976-46f1-8e6d-925943afe1a8" width="50">


# AI-Driven Chatbot for Employee Onboarding

The AI-Driven Chatbot for Employee Onboarding GitHub repository! This project is a chatbot built using React.js, Java Spring Boot, and a MySQL database. It uses Natural Language Processing (NLP) for keyword detection and maps these keywords to JPA database queries. The chatbot is designed to assist new employees with their onboarding activities and answer their queries related to their team, chapter, manager, or company policies.

## Introduction

The AI-driven chatbot is a powerful tool for helping new employees during their onboarding process. It leverages NLP to understand user queries and then fetches relevant information from a MySQL database using Spring Boot and JPA.

## Features

- **NLP Integration:** The chatbot uses Natural Language Processing to understand user queries.
- **Database Connectivity:** It connects to a MySQL database to retrieve relevant information.
- **Employee Onboarding Assistance:** Provides information and answers questions related to team, chapter, manager, and company policies.
- **Interactive User Interface:** Built using React.js for an intuitive and user-friendly experience.

## Installation

Follow these steps to set up and run the chatbot locally:

**Prerequisites:**

- Node.js: Make sure you have Node.js installed. You can download it from [nodejs.org](https://nodejs.org/).

**Frontend (React.js):**

1. Clone the repository:

   ```bash
   git clone https://github.com/yourusername/chatbot.git
   ```

2. Navigate to the React.js frontend directory:

   ```bash
   cd chatbot/frontend
   ```

3. Install frontend dependencies:

   ```bash
   npm install
   ```

4. Start the React.js development server:

   ```bash
   npm start
   ```

5. The chatbot frontend should now be running at `http://localhost:3000`.

**Backend (Java Spring Boot):**

1. Navigate to the Spring Boot backend directory:

   ```bash
   cd chatbot/backend
   ```

2. Configure the MySQL database connection in the `application.properties` file.

3. Build the Spring Boot application:

   ```bash
   ./mvnw clean install
   ```

4. Run the Spring Boot application:

   ```bash
   ./mvnw spring-boot:run
   ```

5. The Spring Boot backend should now be running at `http://localhost:8080`.

**MySQL Database:**

1. Set up a MySQL database and configure the connection details in the Spring Boot `application.properties` file.

2. Create the necessary tables in the database based on the entity classes defined in the Spring Boot application.

3. Populate the database with sample data as needed for employee onboarding information.

## Usage

1. Access the chatbot frontend by opening a web browser and navigating to `http://localhost:3000`.

2. Start interacting with the chatbot by typing in your queries related to onboarding, team, chapter, manager, or company policies.

3. The chatbot will use NLP to understand your query and fetch relevant information from the MySQL database.

4. Enjoy a seamless onboarding experience with the AI-driven chatbot!


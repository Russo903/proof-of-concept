Ecommerce Proof of Concept (Spring Boot + React)
This project is a semi-functional ecommerce site built as a proof of concept using Spring Boot for the backend and React for the frontend. While not fully polished, it demonstrates core functionality such as CRUD operations, file uploads, and API integration.

Getting Started
1. Clone the Repository
sh
Copy
Edit
git clone <repo-url>
cd <project-folder>
2. Set Up the Backend (Spring Boot)
Ensure you have JDK 21 installed.
Navigate to the backend directory:
sh
Copy
Edit
cd backend
Set up the H2 database connection:
Open src/main/resources/application.properties and ensure the spring.datasource.url is correctly set.
The database URL should match the one used in application.properties to avoid connection issues.
Run the backend application:
sh
Copy
Edit
mvn spring-boot:run
This will start the Spring Boot server.
3. Set Up the Frontend (React)
Navigate to the frontend directory:
sh
Copy
Edit
cd frontend
Install dependencies:
sh
Copy
Edit
npm install
Start the frontend:
sh
Copy
Edit
npm start
This will launch the React development server.
📌 Notes
Database Configuration: If the application fails to connect, double-check the H2 database URL in application.properties.
Known Issues: Some features are not fully implemented due to time constraints, but the core functionality demonstrates the integration between Spring Boot and React.
API Integration: Attempts were made to integrate external APIs for product metadata, but this is still a work in progress.

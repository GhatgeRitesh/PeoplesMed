# PeoplesMed - Doctor-Patient Consultation Platform

PeoplesMed is a modern web-based application designed to connect doctors and patients seamlessly. The platform enables efficient communication, appointment scheduling, and online consultations to improve healthcare accessibility and convenience.

---

## 🚀 Features

### For Patients:
- **Easy Registration**: Quickly sign up to book appointments and consult with doctors.
- **Search Doctors**: Find healthcare providers by specialization, location, or availability.
- **Book Appointments**: Schedule consultations with just a few clicks.
- **Medical History**: Securely access your medical records for reference during consultations.

### For Doctors:
- **Profile Management**: Manage your professional profile and expertise.
- **Appointment Management**: View and manage your schedule effortlessly.
- **Patient Records**: Access patient details and medical history for better consultations.

### Additional Highlights:
- **Secure Login and Authentication**: Protect user data with secure authentication mechanisms.
- **Real-time Notifications**: Get notified about appointment confirmations, cancellations, and reminders.
- **Zoom Integration**: Conduct virtual consultations with integrated Zoom meeting links.
- **Payment Gateway**: Effortless payments through Razorpay integration for consultation fees.

---

## 🛠️ Tech Stack

- **Frontend**:
    - HTML, CSS, JavaScript, Bootstrap
- **Backend**:
    - Java, Spring Boot
- **Database**:
    - MySQL
- **Third-party APIs**:
    - Zoom API for online meetings
    - Razorpay API for payments
- **Others**:
    - Feign Client for microservice communication
    - Microservices Architecture
    - Dockerized deployment

---

## 📂 Project Structure

### Microservices:
1. **Web-Interface Service**: Handles user interactions and UI logic.
2. **Database Service**: Manages database operations and handles persistence.
3. **Features Service**:
    - Email notifications
    - Zoom API Integration
    - Razorpay Payment Integration

### Key Directories:

PeoplesMed/ <br> ├── web-interface/ <br> ├──database-service/ <br> ├── features-service/ <br>├── config/ <br> ├── docs/ <br>└── tests/



---

## 💻 Setup and Installation

### Prerequisites:
- Java (JDK 17+)
- Spring Boot (3.0+)
- MySQL (8.0+)
- Maven
- Docker (optional for containerized deployment)

### Steps:
1. **Clone the Repository**:
   ```bash
   git clone https://github.com/YourUsername/PeoplesMed.git
   cd PeoplesMed
Configure Database:

Update application.properties in the database-service with your MySQL credentials.
spring.datasource.url=jdbc:mysql://localhost:3306/peoplesmed
spring.datasource.username=<your-username>
spring.datasource.password=<your-password>

🔗 API Documentation
The project includes API endpoints for various functionalities. Here are some examples:

Patients
Register Patient: POST /api/patients/register
Get Patient Info: GET /api/patients/{id}
Doctors
Register Doctor: POST /api/doctors/register
Get Doctor Info: GET /api/doctors/{id}
Appointments
Book Appointment: POST /api/appointments
Cancel Appointment: DELETE /api/appointments/{id}
For the full list of endpoints, refer to the API Documentation.

🧪 Testing
Unit and Integration Tests:
Tests are implemented for each microservice.
To run tests:
mvn test
🤝 Contributing
We welcome contributions! Here's how you can help:

Fork the repository.
Create a new branch: git checkout -b feature-name.
Commit your changes: git commit -m 'Add some feature'.
Push the branch: git push origin feature-name.
Open a pull request.
🛡️ License
This project is licensed under the MIT License. See the LICENSE file for details.

📞 Contact
For any questions or feedback, feel free to reach out:

Email: support@peoplesmed.com
LinkedIn: PeoplesMed
Website: www.peoplesmed.com

### Key Sections Included:
1. **Project Overview**:
    - Summarizes the purpose and features of the project.
2. **Features**:
    - Lists the functionalities for both doctors and patients.
3. **Tech Stack**:
    - Specifies the technologies used in the project.
4. **Setup Instructions**:
    - Provides clear steps to set up and run the application.
5. **API Documentation**:
    - Briefly introduces the available endpoints.
6. **Testing**:
    - Explains how to run unit and integration tests.
7. **Contribution Guidelines**:
    - Encourages collaboration with clear steps for contributing.
8. **Contact Information**:
    - Details how to reach the team for support or queries.

Feel free to adapt this as per your team’s needs!












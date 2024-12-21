# Library Management System

## Overview

This project is a Library Management System built using Java, JavaFX, MySQL, and Hibernate. It is designed to manage the operations of a library, including book borrowing, member management, and transaction tracking. The system provides a user-friendly interface for both administrators and members to interact with the library's resources.

## Features

- **Admin Management**: Admins can manage library branches, books, and member accounts.
- **Member Management**: Members can sign up, sign in, and manage their profiles.
- **Book Management**: Admins can add, update, and delete books. Members can view available books and borrow them.
- **Transaction Management**: Track book borrowings, returns, and due dates.
- **Email Notifications**: Send email notifications for account creation, password changes, and account deletions.

## Technologies Used

- **Java**: The core programming language used for the application.
- **JavaFX**: Used for building the graphical user interface.
- **MySQL**: The database system used to store library data.
- **Hibernate**: An ORM (Object-Relational Mapping) framework used to interact with the MySQL database.

## Project Structure

- `controller`: Contains the controllers for handling UI interactions.
- `dto`: Contains Data Transfer Objects (DTOs) for transferring data between layers.
- `entity`: Contains entity classes representing the database tables.
- `repository`: Contains repository interfaces and implementations for database operations.
- `service`: Contains service interfaces and implementations for business logic.
- `util`: Contains utility classes for email sending and session management.

## Setup and Installation

1. **Clone the repository**:
    ```sh
    git clone https://github.com/jlokitha/Library-Management-System.git
    ```

2. **Open the project in IntelliJ IDEA**:
    - Open IntelliJ IDEA.
    - Select `File > Open` and choose the cloned project directory.

3. **Set up the database**:
    - Create a MySQL database named `BookWorm`.
    - Import the provided SQL script to create the necessary tables and initial data.

4. **Configure Hibernate**:
    - Update the `hibernate.cfg.xml` file with your MySQL database credentials.

5. **Build and run the project**:
    - Open the project in IntelliJ IDEA.
    - Build the project and run the main application class.

## Usage

- **Admin**:
    - Sign in with admin credentials.
    - Manage books, branches, and member accounts.
    - View and manage transactions.

- **Member**:
    - Sign up for a new account.
    - Sign in with member credentials.
    - View available books and borrow them.
    - Manage personal profile and view transaction history.

## License

This project is licensed under the MIT License. See the [MIT License](LICENSE) file for more details.

##
<div align="center">
<a href="https://github.com/jlokitha" target="_blank"><img src = "https://img.shields.io/badge/GitHub-000000?style=for-the-badge&logo=github&logoColor=white"></a>
<a href="https://git-scm.com/" target="_blank"><img src = "https://img.shields.io/badge/Git-000000?style=for-the-badge&logo=git&logoColor=white"></a>
<a href="https://www.jetbrains.com/idea/download/?section=windows" target="_blank"><img src = "https://img.shields.io/badge/java-000000?style=for-the-badge&logo=openjdk&logoColor=white"></a>
<a href="https://www.mysql.com/downloads/" target="_blank"><img src = "https://img.shields.io/badge/MySQL-000000?style=for-the-badge&logo=mysql&logoColor=white"></a>
<a href="https://hibernate.org/orm/" target="_blank"><img src = "https://img.shields.io/badge/Hibernate-100000?style=for-the-badge&logo=Hibernate&logoColor=white"></a>
<a href="https://www.jetbrains.com/idea/download/?section=windows" target="_blank"><img src = "https://img.shields.io/badge/intellij-000000?style=for-the-badge&logo=intellijidea&logoColor=white"></a>
</div> <br>

<p align="center">
  &copy; 2024 Janindu Lokitha
</p>

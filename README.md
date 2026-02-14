NSBM Green University Clubs Management System
1. Introduction

The NSBM Green University Clubs Management System is a full-stack web application developed using Spring Boot, Spring Security, Thymeleaf, and MySQL. The system is designed to centralize and digitalize the management of university clubs, members, events, meetings, and announcements in a secure and structured environment.
This project was developed as an academic assignment for NSBM Green University, Homagama, Sri Lanka, Development Enterprise Application module.

2. Project Objective
The main objectives of this system are
 - Centralized management of university clubs
 - Secure role-based access control
 - Organized event and meeting scheduling
 - Structured announcement management
 - Digital transformation of manual club operations
 - Implementation of a production-style Spring Boot application


3. Technologies Used
Backend
 - Java 25
 - Spring Boot
 - Spring Security
 - Spring Data JPA
   
Frontend
 - Thymeleaf
 - HTML5
 - CSS3
 - JavaScript

Database
 - MySQL
  
Build Tool
 - Maven
 - IntelliJ

4. System Architecture

The system follows a layered architecture pattern
 - Controller → Service → Repository → Entity

This structure ensures:
 - Clean code organization
 - Separation of concerns
 - Maintainability
 - Scalability

5. User Roles and Permissions

The system contains two main roles:

ROLE_ADMIN
The Admin has full system control.

Admin Capabilities
Full CRUD operations on
Users
Clubs
Events
Meetings
Announcements
Members
Assign roles
Manage presidents and staff
View all system data
Export data in CSV format
Manage system security

ROLE_USER

ROLE_USER is categorized into three types:

President
Manage own club
Create events
Create meetings
Create announcements
View club members
Can lead multiple clubs

Staff
Create events
Create meetings
Create announcements
Manage club activities

Member
View events
View meetings
View announcements
View club information
Cannot create or edit content

6. System Modules
   
 6.1 User Module

User Registration (Sign Up)
Login (Sign In)
Logout (Sign Out)
Session & Cookie-based authentication
BCrypt password encryption
Role-based authorization
Protected routes

 6.2 Club Module

Create club
Update club
Delete club
Assign president
Assign staff
View club members
Manage club information

6.3 Event Module

Create events
Update events
Delete events
View events
Pagination implemented

 6.4 Meeting Module

Schedule meetings
Edit meetings
Delete meetings
View meetings
Pagination implemented

 6.5 Announcement Module

Post announcements
Edit announcements
Delete announcements
View announcements

 6.6 Member Module

View members
Assign members to clubs
Manage member roles

7. Security Implementation

Security is implemented using Spring Security.
Authentication
Session-based authentication
Cookie-based login
HttpOnly cookies
BCrypt password encryption
Authorization
Role-based access control
Protected routes

Access Control Examples
/admin/** → Admin only
/club/** → President & Staff
/events/** → President & Staff
/view/** → All authenticated users

Additional Security Features
CSRF protection enabled
Secure session handling


8. Database Design
Core Entities

users
clubs
events
meetings
announcements
members


Relationships

One Club → Many Events
One Club → Many Meetings
One Club → Many Announcements
One Club → Many Members
One User → Can be President of Multiple Clubs

Spring Data JPA is used for ORM and relationship management.

9. Pagination

Pagination is implemented using Spring Data’s Pageable and PageRequest.

Applied to

Users list
Clubs list
Events list
Meetings list

This improves performance and user experience when handling large datasets.

10. Reporting / Export Feature

The system includes CSV export functionality.
Admin can export:
User data
Club data
Event data

This feature satisfies reporting requirements beyond basic CRUD operations.

11. How to Run the Project

Configure application.properties with MySQL credentials.

Run the application using -
ClubManagementApplication.java
or
mvn spring-boot:run

Access via:
http://localhost:8080

12. License

This project is developed for academic and educational purposes only.

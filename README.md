 HMS - Hospital Management System 🏥

A robust and modular **Hospital Management System** developed using **Java (JDK 21), JDBC, and MySQL**. 
This project follows the **MVC (Model-View-Controller)** architecture to manage hospital workflows like doctor scheduling, patient registrations, appointments, and billing via a clean console-based interface.

---

 Features

* **Department Management:** Add, update, and track hospital departments and locations.
* **Doctor Profiles:** Manage doctor specializations, contact details, and department allocation.
* **Patient Registration:** Maintain comprehensive patient records, blood groups, and history.
* **Appointment Scheduling:** Book, complete, or cancel appointments linking patients with doctors.
* **Billing System:** Generate invoices, track total amounts, and manage payment statuses (`Pending/Paid`).

---

  Tech Used

* **Core Java** (JavaSE-21)
* **JDBC** (Java Database Connectivity)
* **MySQL** Database
* **Eclipse / Spring Tool Suite (STS)**

---

  Concepts Covered

* **MVC Design Pattern** (Separation of Controller, Entity, DAO, and View)
* **DAO (Data Access Object) Pattern** for database operations
* **Object-Oriented Programming (OOPs)**
* **Database Relationships & Integrity** (Foreign keys with Cascade/Set Null options)

---

 Project Structure

* **Controller:** Handles application logic and user requests.
* **Entity:** POJO classes representing the database tables.
* **ModelDao:** Database operations and connection utilities (`DBUtil.java`).
* **View:** Presentation layer for user interaction.

---

# Run Project

1. **Configure Database:** Run the `database.sql` script in your MySQL server to set up tables and dummy data.
2. **Add Driver:** Add the MySQL JDBC Connector jar file to your project's **Referenced Libraries**.
3. **Run Application:** Execute `MainController.java` to start the system.

---

 # MySQL Schema and Connectivity (one table to another table)

<img width="1030" height="882" alt="hospital_management_system" src="https://github.com/user-attachments/assets/5a1c05a5-f998-4130-8e22-ad92a356e449" />

---

 👨‍💻 Author

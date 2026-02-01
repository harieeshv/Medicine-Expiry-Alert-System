💊 Medicine Expiry Alert System  
Java • MySQL • JDBC (Console Application)

A simple Java-based application to manage medicine inventory and automatically identify **expiring** and **expired** medicines using MySQL and JDBC.

This project is built as a clean academic mini/major project and follows a layered design (DAO, Service, DTO).

---

📌 Features

- Add new medicine records
- View all medicines
- View medicines expiring in the next 7 days
- View already expired medicines
- Delete medicine by ID
- Uses JDBC with MySQL database

---

🛠️ Technologies Used

- Java (JDK 8+)
- MySQL
- JDBC
- Eclipse IDE (recommended)

---

📁 Project Structure

All classes are placed under one base package:

```

com.medicinealert
├── MedicineDAO.java
├── MedicineDAOImpl.java
├── MedicineDTO.java
├── MedicineService.java
├── DBConnection.java
└── MainApp.java

````

---

🗄️ Database Setup

Open MySQL Workbench and run the following:

```sql
CREATE DATABASE medicine_alert;
USE medicine_alert;

CREATE TABLE medicines (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    batch_no VARCHAR(50),
    quantity INT,
    expiry_date DATE,
    supplier VARCHAR(100),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
````

---

🔗 Database Connection Configuration

Edit the following file if needed:

```
DBConnection.java
```

```java
String url = "jdbc:mysql://localhost:3306/medicine_alert";
String user = "root";
String pass = "root";
```

Change username and password according to your MySQL configuration.

---

▶ How to Run the Project

1. Open the project in Eclipse.
2. Add **MySQL Connector JAR** to the project build path.
3. Make sure MySQL server is running.
4. Run:

```
MainApp.java
```

---

📋 Application Menu

```
1. Add
2. View All
3. Expiring (7 days)
4. Expired
5. Delete
6. Exit
```

---

🧪 Sample Execution

```
1.Add
2.View All
3.Expiring (7 days)
4.Expired
5.Delete
6.Exit
```

Add medicine:

```
Name: Paracetamol
Batch: B101
Qty: 100
Expiry (yyyy-mm-dd): 2026-02-10
Supplier: Cipla
```

View all:

```
1 Paracetamol 2026-02-10
```

Expiring medicines:

```
Azithromycin 2026-02-04
```

Expired medicines:

```
Cetirizine 2025-12-15
```

---

🧱 Layer Description

**DTO (MedicineDTO)**
  Used to transfer medicine data between layers.

**DAO (MedicineDAO)**
  Declares database operations.

**DAO Implementation (MedicineDAOImpl)**
  Contains actual JDBC and SQL logic.

**Service (MedicineService)**
  Acts as a bridge between main program and DAO layer.

**Main (MainApp)**
  Handles user input and displays results.

---

🎯 Project Objective

The objective of this project is to help pharmacies or hospitals track medicine expiry dates and automatically identify medicines that are about to expire or already expired, thereby reducing loss and improving inventory management.

---

👨‍💻 Developed By
Harieesh V
CSE – 6th Semester

```
```

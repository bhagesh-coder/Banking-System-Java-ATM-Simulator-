# Banking Management System

A Java-based Banking Management System that simulates ATM operations using **Java Swing** for the graphical user interface and **MySQL** for database management. The project allows users to create accounts, perform transactions, manage ATM services, and securely access banking features.

## Features

-  Secure Login Authentication
-  Multi-Step Account Registration
-  Deposit Money
-  Withdraw Money
-  Fast Cash Transactions
-  Balance Enquiry
-  PIN Change
-  Mini Statement Generation
-  MySQL Database Integration
-  User-Friendly ATM Interface

## Technologies Used

- Java
- Java Swing
- MySQL
- JDBC
- JCalendar
- IntelliJ IDEA

## Project Structure

```text
src/
└── bank/
    ├── Login.java
    ├── signup.java
    ├── signupTwo.java
    ├── signup3.java
    ├── Transactions.java
    ├── Deposit.java
    ├── Withdraw.java
    ├── Fastcash.java
    ├── Balance.java
    ├── MiniStatement.java
    ├── Pin_change.java
    └── conn.java
```

## Functional Modules

### Account Management
- New account registration through a multi-page application form.
- Customer information storage in the database.

### Authentication
- Login using Card Number and PIN.
- User verification through MySQL database.

### Banking Transactions
- Deposit funds.
- Withdraw cash.
- Fast Cash withdrawal options.
- Balance enquiry.
- Mini statement generation.
- PIN change facility.

### Database Management
Stores:
- Customer Details
- Account Information
- Login Credentials
- Transaction History

## Database Setup

Update the database connection details in `conn.java`:

```java
Connection con = DriverManager.getConnection(
    "jdbc:mysql:///bankingsystem",
    "root",
    "root"
);
```

### Requirements
- MySQL Server installed and running
- Database named `bankingsystem`
- Required tables created

## How to Run

1. Clone the repository:

```bash
git clone https://github.com/your-username/banking-management-system.git
```

2. Open the project in IntelliJ IDEA or any Java IDE.

3. Add the required libraries:
   - MySQL Connector/J
   - JCalendar

4. Configure the database connection.

5. Run:

```bash
Login.java
```

## Screenshots

Add screenshots of:
- Login Page
- Registration Forms
- Transaction Dashboard
- Deposit & Withdrawal Screens
- Mini Statement

## Future Enhancements

- Password Encryption & Hashing
- Fund Transfer Between Accounts
- PDF Transaction Receipts
- Admin Dashboard
- Online Banking Support
- Enhanced Security Features

## Author

Developed as a Banking Management System project using Java Swing and MySQL to demonstrate GUI development, database connectivity, and banking transaction management.

---


# University_Database-System
This project demonstrates practical OOP design, data structures, and file I/O in Java while simulating a real-world record management system.

A menu-driven Java application for storing and managing core university records from the terminal.
This project models a small university database with three primary entities:
- **Students**
- **Professors**
- **Courses**
Users can import records from CSV files, manage data in memory through interactive menus, and export updated data back to CSV.

---

## Overview

The University Database System is designed for learning and practicing object-oriented programming concepts in Java, including:

- Class modeling, inheritance, and abstraction (`Person`, `Student`, `Professor`)
- Interfaces (`Payable`)
- Collection management with `ArrayList` & `HashMap`
- File I/O and CSV serialization/deserialization (`DataManager`)
- Interactive command-line workflows using `Scanner`

The app is intentionally lightweight and does not require external dependencies or a database engine.

---

## Major Revisions

- Enforced separation of concerns between UI, data model, and file handling
- Centralized all records inside `University` using HashMaps
- Replaced ArrayLists with HashMaps to achieve O(1) average lookups
- Reduced duplicated state and simplified class responsibilities
- Used Git branching for safe refactoring

---

## Core Features

### 1) Data Import
Load saved records from CSV files for:
- Students
- Professors
- Courses

### 2) Data Export
Save current in-memory data to CSV files for backup or later reuse.

### 3) Student Management
- List all students
- Search by ID
- Add a student
- Remove a student

### 4) Professor Management
- List all professors
- Search by ID
- Add/remove professor
- View professor course assignments
- Assign/unassign courses to professors

### 5) Course Management
- List all courses
- Search by course title
- Add/remove courses

### 6) University-Level Summary
View aggregate university data from a dedicated menu option.

---

### File Responsibilities

- **`Main.java`**  
  Entry point, top-level application loop, and all interactive menus.

- **`University.java`**  
  Central in-memory model holding collections and operations for students, professors, and courses.

- **`DataManager.java`**  
  Handles CSV reading and writing for all entity types.

- **`Person.java`**  
  Shared base behavior/state for person-like entities.

- **`Student.java` / `Professor.java` / `Course.java`**  
  Domain models and entity-specific behavior.

- **`Payable.java`**  
  Interface for tuition behavior in applicable classes.

- **`data/`**  
  Sample data files used for import testing and quick start.

---

## Project Structure

.
├── Main.java
├── University.java
├── DataManager.java
├── Person.java
├── Student.java
├── Professor.java
├── Course.java
├── Payable.java
├── data/
│   ├── students.csv
│   ├── professors.csv
│   └── courses.csv
└── README.md

---

## How the Program Works

On startup, the program creates a `University` instance and opens a looped main menu:

<img width="285" height="220" alt="image" src="https://github.com/user-attachments/assets/a42f9599-afd6-4f2f-9bd5-c0556093877a" />

From these menus, you can navigate into submenus and perform operations.

---

## Setup and Installation

### Prerequisites

- JDK 17 or later
- A terminal (bash, zsh, PowerShell, cmd, etc.)
  OR
- Any IDE (IntelliJ, VS Code, Eclipse)

### Verify Java Installation

```bash
java -version
javac -version
```

## Build and Run in terminal
![University_Project](https://github.com/user-attachments/assets/70daf2d3-8b50-4e54-80f9-f7c7f011c5ad)

From the project root directory:

### 1) Compile

```bash
javac *.java
```

### 2) Run

```bash
java Main
```

## Usage Walkthrough

### Import Existing Data

1. Start program with `java Main`
2. Enter `1` for **Import Menu**
3. Choose object type (`student/professor/course`)
4. Enter file (`students/professors/courses`)
(Recommended you import all files provided in data)

### Manage Data

- Use **Course Menu** to create/find/remove courses
- Use **Professor Menu** to manage professor data and assign their courses
- Use **Student Menu** to manage student data and register courses

### Save Data

1. Enter `2` for **Save Menu**
2. Select which records to save
3. Provide output file name

### Exit

Enter `7` at the main menu.

---

## Troubleshooting

### `javac: command not found`
Install a JDK and ensure `javac` is on your PATH.

### `Could not find or load main class Main`
Make sure you are in the project root and compilation succeeded before running.

### Import returns no data
Confirm:

- File path is correct
- File exists and is readable
- CSV structure matches parser expectations

---


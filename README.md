
# 🎓 Student Course Registration System (Java Console Application)

This is a **Java-based console application** that simulates a simple **student course registration system**. It allows users to add students and courses, manage student registrations, drop courses, and view course or student details — all through a text-based menu interface.

---

## 📌 Table of Contents

- [Features](#features)
- [How to Run](#how-to-run)
- [Application Menu](#application-menu)
- [Program Structure](#program-structure)
- [Example Usage](#example-usage)
- [Validations](#validations)
- [License](#license)
- [Author](#author)

---

## 🚀 Features

- Add new students with unique student IDs
- Create new courses with schedules, descriptions, and capacity limits
- Register students for available courses
- Drop courses previously registered by a student
- View individual student details and their registered courses
- View all available courses with real-time slot availability
- Prevents duplicate registrations and overbooking

---

## 🛠️ How to Run

### Requirements

- Java JDK 8 or higher
- Terminal or Java-supported IDE (like IntelliJ IDEA, Eclipse, NetBeans)

### Steps

1. Save the file as:
   ```
   StudentCourseRegistrationConsole.java
   ```

2. Compile the program:
   ```bash
   javac StudentCourseRegistrationConsole.java
   ```

3. Run the compiled class:
   ```bash
   java StudentCourseRegistrationConsole
   ```

---

## 🖥️ Application Menu

```text
===== Student Course Registration Menu =====
1. Add Student
2. Add Course
3. Register Course
4. Drop Course
5. View Student Info
6. View All Courses
7. Exit
```

---

## 🧩 Program Structure

### 🔸 `Course` Class

**Attributes**:
- `courseCode`
- `title`
- `description`
- `schedule`
- `capacity`
- `availableSlots`

**Methods**:
- `registerStudent()` → Enrolls the student if slots are available
- `dropStudent()` → Increases slot count when a student drops
- `toString()` → Returns a formatted string of course details

---

### 🔸 `Student` Class

**Attributes**:
- `studentID`
- `name`
- `registeredCourses` (a list of courses)

**Methods**:
- `registerCourse(Course)` → Adds a course to the student's list if not already registered
- `dropCourse(Course)` → Removes a course from the student's list
- `viewCourses()` → Displays all registered courses for that student

---

### 🔸 `StudentCourseRegistrationConsole` (Main Class)

**Responsibilities**:
- Maintains lists of all students and courses
- Provides a console-based menu system for:
  - Adding students/courses
  - Registering/dropping courses
  - Viewing student/course info

---

## 🧪 Example Usage

```text
===== Student Course Registration Menu =====

Enter student ID: 1001
Enter name: Aditi
✅ Student added.

Enter course code: CS101
Enter title: Data Structures
Enter description: Learn stacks, queues, trees
Enter schedule: Mon-Wed 10:00 AM
Enter capacity: 40
✅ Course added.

Enter student ID: 1001
Enter course code: CS101
✅ Course registered successfully.
```

---

## 🛡️ Validations

- ❌ Prevents registration if course is full
- ❌ Prevents duplicate course registrations
- ❌ Cannot drop a course if the student is not enrolled in it

---

## 📜 License

This project is open-source and free to use for **educational** and **academic** purposes. You are welcome to extend or modify the code as needed.

---

## 👨‍💻 Author

**Gaurav Raj**

> Feel free to expand this application by adding features such as:
> - GUI version (using Java Swing or JavaFX)
> - File/database persistence
> - Multiple user roles (Admin, Student)
> - User authentication system


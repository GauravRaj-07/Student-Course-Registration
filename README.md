# 🎓 Student Course Registration System (Console-Based in Java)

This is a **console-based Java application** that simulates a basic **student course registration system**. It allows students to register for courses, drop courses, and view enrolled courses. Administrators can add new students and courses, view student information, and track course enrollment.

---

## 🚀 Features

- ✅ Add new students and courses
- 📚 Register students for available courses
- ❌ Drop registered courses
- 👁️ View individual student details and enrolled courses
- 🧾 View all available courses with remaining slots
- 🔐 Prevents duplicate registrations and over-enrollment

---

## 🛠️ How to Run

### ✅ Prerequisites

- Java JDK 8 or above
- Any Java IDE (like IntelliJ, Eclipse) or terminal

### ▶️ Steps

1. Copy the code into a file named:  
StudentCourseRegistrationConsole.java

css
Copy
Edit

2. Open a terminal in the project folder and compile:
```bash
javac StudentCourseRegistrationConsole.java
Run the application:
java StudentCourseRegistrationConsole


📋 Menu Options
pgsql
Copy
Edit
===== Student Course Registration Menu =====
1. Add Student
2. Add Course
3. Register Course
4. Drop Course
5. View Student Info
6. View All Courses
7. Exit

🧩 Program Structure
🔸 Course class
Attributes: courseCode, title, description, schedule, capacity, availableSlots

Methods:

registerStudent() → Enrolls if slots available

dropStudent() → Increases slot count

toString() → Displays course details

🔸 Student class
Attributes: studentID, name, registeredCourses list

Methods:

registerCourse(Course) → Adds course to student list

dropCourse(Course) → Removes course

viewCourses() → Lists enrolled courses

🔸 StudentCourseRegistrationConsole (Main Class)
Contains:

Lists of all students and courses

Console menu loop

Functionalities for add/register/drop/view

🧪 Example
text
Copy
Edit
Enter student ID: 1001
Enter name: Aditi
✅ Student added.

Enter course code: CS101
Enter title: Data Structures
Enter capacity: 40
✅ Course added.

Enter student ID: 1001
Enter course code: CS101
✅ Course registered successfully.
🛡️ Validations
❌ Prevents registration if course is full

❌ Prevents duplicate course registrations

❌ Cannot drop if not enrolled

📜 License
This project is open-source and free to use for educational and academic purposes.

👨‍💻 Author
Gaurav Raj

Feel free to modify and extend the application (e.g., GUI version, file persistence, multiple logins).

yaml
Copy
Edit

---

Let me know if you want this packaged into a `.zip` with the source code and README!

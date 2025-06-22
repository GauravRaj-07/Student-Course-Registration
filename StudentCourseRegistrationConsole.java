import java.util.*;

class Course {
    private String courseCode;
    private String title;
    private String description;
    private int capacity;
    private String schedule;
    private int availableSlots;

    public Course(String courseCode, String title, String description, int capacity, String schedule) {
        this.courseCode = courseCode;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
        this.availableSlots = capacity;
    }

    public String getCourseCode() { return courseCode; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getSchedule() { return schedule; }
    public int getAvailableSlots() { return availableSlots; }

    public boolean registerStudent() {
        if (availableSlots > 0) {
            availableSlots--;
            return true;
        }
        return false;
    }

    public void dropStudent() {
        if (availableSlots < capacity) {
            availableSlots++;
        }
    }

    @Override
    public String toString() {
        return courseCode + " - " + title + "\n" +
                "Description: " + description + "\n" +
                "Schedule: " + schedule + "\n" +
                "Available Slots: " + availableSlots + "/" + capacity + "\n";
    }
}

class Student {
    private int studentID;
    private String name;
    private List<Course> registeredCourses = new ArrayList<>();

    public Student(int studentID, String name) {
        this.studentID = studentID;
        this.name = name;
    }

    public int getStudentID() { return studentID; }
    public String getName() { return name; }

    public void registerCourse(Course course) {
        if (!registeredCourses.contains(course) && course.registerStudent()) {
            registeredCourses.add(course);
            System.out.println("✅ Course registered successfully.");
        } else {
            System.out.println("⚠️ Already registered or course is full.");
        }
    }

    public void dropCourse(Course course) {
        if (registeredCourses.contains(course)) {
            course.dropStudent();
            registeredCourses.remove(course);
            System.out.println("✅ Course dropped successfully.");
        } else {
            System.out.println("⚠️ Not registered in this course.");
        }
    }

    public void viewCourses() {
        if (registeredCourses.isEmpty()) {
            System.out.println("No courses registered.");
        } else {
            System.out.println("Registered Courses:");
            for (Course c : registeredCourses) {
                System.out.println(" - " + c.getTitle());
            }
        }
    }

    @Override
    public String toString() {
        return "Student ID: " + studentID + "\nName: " + name;
    }
}

public class StudentCourseRegistrationConsole {
    static Scanner sc = new Scanner(System.in);
    static List<Student> students = new ArrayList<>();
    static List<Course> courses = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===== Student Course Registration Menu =====");
            System.out.println("1. Add Student");
            System.out.println("2. Add Course");
            System.out.println("3. Register Course");
            System.out.println("4. Drop Course");
            System.out.println("5. View Student Info");
            System.out.println("6. View All Courses");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> addCourse();
                case 3 -> registerCourse();
                case 4 -> dropCourse();
                case 5 -> viewStudentInfo();
                case 6 -> viewAllCourses();
                case 7 -> {
                    System.out.println("👋 Exiting. Goodbye!");
                    return;
                }
                default -> System.out.println("❗ Invalid choice.");
            }
        }
    }

    static void addStudent() {
        System.out.print("Enter student ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        students.add(new Student(id, name));
        System.out.println("✅ Student added.");
    }

    static void addCourse() {
        System.out.print("Enter course code: ");
        String code = sc.nextLine();
        System.out.print("Enter course title: ");
        String title = sc.nextLine();
        System.out.print("Enter description: ");
        String desc = sc.nextLine();
        System.out.print("Enter schedule: ");
        String schedule = sc.nextLine();
        System.out.print("Enter capacity: ");
        int cap = sc.nextInt();
        sc.nextLine();
        courses.add(new Course(code, title, desc, cap, schedule));
        System.out.println("✅ Course added.");
    }

    static Student findStudentByID(int id) {
        for (Student s : students) {
            if (s.getStudentID() == id) return s;
        }
        return null;
    }

    static Course findCourseByCode(String code) {
        for (Course c : courses) {
            if (c.getCourseCode().equalsIgnoreCase(code)) return c;
        }
        return null;
    }

    static void registerCourse() {
        System.out.print("Enter student ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter course code: ");
        String code = sc.nextLine();
        Student s = findStudentByID(id);
        Course c = findCourseByCode(code);
        if (s != null && c != null) {
            s.registerCourse(c);
        } else {
            System.out.println("❌ Student or course not found.");
        }
    }

    static void dropCourse() {
        System.out.print("Enter student ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter course code: ");
        String code = sc.nextLine();
        Student s = findStudentByID(id);
        Course c = findCourseByCode(code);
        if (s != null && c != null) {
            s.dropCourse(c);
        } else {
            System.out.println("❌ Student or course not found.");
        }
    }

    static void viewStudentInfo() {
        System.out.print("Enter student ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        Student s = findStudentByID(id);
        if (s != null) {
            System.out.println(s);
            s.viewCourses();
        } else {
            System.out.println("❌ Student not found.");
        }
    }

    static void viewAllCourses() {
        if (courses.isEmpty()) {
            System.out.println("No courses available.");
        } else {
            for (Course c : courses) {
                System.out.println(c);
            }
        }
    }
}

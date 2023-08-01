import java.util.ArrayList;
import java.util.Scanner;

public class App {
    static Scanner scanner = new Scanner(System.in);
    static School SMU = new School(new ArrayList<>(), new ArrayList<>());

    public static void main(String[] args) throws Exception {
        System.out.println("Enter 1 if you would like to prepopulate the school system:");
        if (scanner.nextLine().equals("1")) {
            System.out.println("Prepopulating now...");
            prepopulate();
        }
        displayMainMenu();
    }

    public static void displayMainMenu() {
        System.out.println("\n\nMain Menu:(Enter the corresponding number for menu selection)\n" +
                "1. Courses\n" +
                "2. Accounts\n" +
                "3. Exit Program");
        String input = scanner.nextLine();

        switch (input) {
            case "1":
                System.out.println("Courses Menu:");
                displayCoursesMenu();
                break;
            case "2":
                System.out.println("Accounts Menu:");
                displayAccountsMenu();
                break;
            case "3":
                System.out.println("Exiting program...");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid Input");
                displayMainMenu();
        }
    }

    public static void displayCoursesMenu() {
        System.out.println("1. View all courses");
        System.out.println("2. Add Courses");
        System.out.println("3. Add student to course");
        System.out.println("4. Get grade report for a course");
        System.out.println("5. Set a Student Grade");
        System.out.println("6. Exit to Main Menu");
        String input = scanner.nextLine();

        switch (input) {
            case "1":
                System.out.println("View all courses:");
                ArrayList<Course> availableCourses = SMU.getCourses();
                System.out.println("Courses currently offered: ");
                for (int i = 0; i < availableCourses.size(); i++) {
                    System.out.println(availableCourses.get(i).getId());
                }
                System.out.println("End of course list.\n");
                break;
            case "2":
                System.out.println("Add Courses:");
                createCourse();
                break;
            case "3":
                System.out.println("Add student to course:");
                addStudentToCourse();
                break;
            case "4":
                System.out.println("Getting grades for a course");
                System.out.println("Please Enter the course id: ");
                String courseIDInput = scanner.nextLine();
                getGradesForCourse(courseIDInput);
                break;
            case "5":
                System.out.println("Setting a student's grade");
                setStudentGradeForCourse();
                break;
            case "6":
                System.out.println("Exiting to Main Menu...");
                displayMainMenu();
                break;
            default:
                System.out.println("Invalid Input");
                displayCoursesMenu();
        }
        displayCoursesMenu();
    }

    public static void displayAccountsMenu() {
        System.out.println("1. Teachers");
        System.out.println("2. Students");
        System.out.println("3. Display all accounts");
        System.out.println("4. Exit to Main Menu");
        String input = scanner.nextLine();

        switch (input) {
            case "1":
                System.out.println("Teachers Menu:");
                displayTeachersMenu();
                break;
            case "2":
                System.out.println("Students Menu:");
                displayStudentsMenu();
                break;
            case "3":
                System.out.println("Displaying all accounts: ");
                printAllAccounts();
                break;
            case "4":
                System.out.println("Exiting to Main Menu...");
                displayMainMenu();
                break;
            default:
                System.out.println("Invalid Input");
                displayAccountsMenu();
        }
        displayAccountsMenu();
    }

    public static void displayTeachersMenu() {
        System.out.println("1. View Teachers");
        System.out.println("2. Add Teacher");
        System.out.println("3. Add course to teacher's schedule");
        System.out.println("4. View a teacher's schedule");
        System.out.println("5. Exit to Accounts Menu");
        String input = scanner.nextLine();

        switch (input) {
            case "1":
                System.out.println("View all teachers:");
                ArrayList<Teacher> teachers = SMU.getTeachers();
                for (Teacher teacher : teachers) {
                    System.out.println(
                            teacher.getFirstName() + " " + teacher.getLastName() + " | Email: " + teacher.getEmail()
                                    + "| ID: " + teacher.getId());
                }
                System.out.println("End of list.\n");
                break;
            case "2":
                System.out.println("Add Teacher:");
                createTeacher();
                break;
            case "3":
                System.out.println("Adding course to teacher's schedule");
                addCoursetoSchedule();
                break;
            case "4":
                System.out.println("View a teacher's schedule");
                getTeacherSchedule();
                System.out.println("End of schedule");

                break;
            case "5":
                System.out.println("Exiting to Accounts Menu...");
                displayAccountsMenu();
                break;
            default:
                System.out.println("Invalid Input");
                displayTeachersMenu();
        }
        displayTeachersMenu();
    }

    public static void displayStudentsMenu() {
        System.out.println("1. View all students");
        System.out.println("2. Add Student");
        System.out.println("3. Register student to class");
        System.out.println("4. View a student's grade report");
        System.out.println("5. Exit to Accounts Menu");
        String input = scanner.nextLine();

        switch (input) {
            case "1":
                System.out.println("View all students:");
                ArrayList<Student> students = SMU.getStudents();
                for (Student student : students) {
                    System.out.println(
                            student.getFirstName() + " " + student.getLastName() + " | Email: " + student.getEmail()
                                    + "| ID: " + student.getId());
                }
                System.out.println("End of list.\n");
                break;
            case "2":
                System.out.println("Add Student:");
                createStudent();
                break;

            case "3":
                addStudentToCourse();
                break;
            case "4":
                System.out.println("Getting grade report");
                getGradeReport();
                System.out.println("End of grade report\n");
                break;
            case "5":
                System.out.println("Exiting to Accounts Menu...");
                displayAccountsMenu();
                break;
            default:
                System.out.println("Invalid Input");
                displayStudentsMenu();
        }
        displayStudentsMenu();
    }

    private static void getGradeReport() {
        System.out.println("Enter the student id:");
        int id = Integer.parseInt(scanner.nextLine());
        Student student = SMU.getStudent(id);
        if (student == null) {
            System.out.println("Student id is not in system");
            return;
        }

        ArrayList<String> classes = student.getCoursesTaking();
        for (int i = 0; i < classes.size(); i++) {
            String courseID = classes.get(i);
            Course course = SMU.getCourse(courseID);
            System.out.println("" + courseID + " -> " + course.getStudentGrade(student));
        }

    }

    public static void getGradesForCourse(String id) {
        Course course = SMU.getCourse(id);
        if (course == null) {
            System.err.println("This course is not in the system.");
            return;
        }
        System.out.println(course.getAllGrades());

    }

    private static void getTeacherSchedule() {
        System.out.println("Enter the teacher id:");
        int id = Integer.parseInt(scanner.nextLine());
        Teacher teacher = SMU.getTeacher(id);
        if (teacher == null) {
            System.out.println("Teacher id is not in system");
            return;
        }

        ArrayList<Course> classes = teacher.getCoursesTeaching();
        for (int i = 0; i < classes.size(); i++) {
            System.out.println(classes.get(i).getId());
        }

    }

    public static void setStudentGradeForCourse() {
        System.out.println("Please enter the course id:");
        String courseID = scanner.nextLine();
        if (SMU.getCourse(courseID) == null) {
            System.err.println("This course does not exist.");
            return;
        }
        System.out.println("Please enter the student id:");
        int userID = Integer.parseInt(scanner.nextLine());
        if (SMU.getStudent(userID) == null) {
            System.err.println("This student does not exist");
        }
        System.out.println("Please enter the grade (0-100):");
        int grade = Integer.parseInt(scanner.nextLine());

        Course course = SMU.getCourse(courseID);
        course.setStudentGrade(userID, grade);
    }

    public static Course createCourse() {

        System.out.println("What is the course id: ");
        String courseIDInput = scanner.nextLine();
        if (SMU.getCourse(courseIDInput) != null) {
            System.err.println("Course already exists.");
            return SMU.getCourse(courseIDInput);
        }
        Course c = SMU.addCourse(courseIDInput);
        System.out.println(courseIDInput + " has been added to the database");
        return c;
    }

    private static Student createStudent() {
        System.out.println("Enter student's first name: ");
        String first = scanner.nextLine();
        System.out.println("Enter student's last name: ");
        String last = scanner.nextLine();
        System.out.println("Enter student's email: ");
        String email = scanner.nextLine();
        Student s = SMU.addStudent(first, last, email);
        System.out.println(first + " " + last + " has been added as a student.");
        return s;
    }

    private static Teacher createTeacher() {
        System.out.println("Enter teacher's first name: ");
        String tFirst = scanner.nextLine();
        System.out.println("Enter teacher's last name: ");
        String tLast = scanner.nextLine();
        System.out.println("Enter teacher's email: ");
        String tEmail = scanner.nextLine();
        Teacher teacher = SMU.addTeacher(tFirst, tLast, tEmail);
        System.out.println(tFirst + " " + tLast + " has been added as a teacher.");
        return teacher;
    }

    private static void addCoursetoSchedule() {
        System.out.println("Please input the teacher's id: ");
        int teacherID = Integer.parseInt(scanner.nextLine());
        Teacher teacher = SMU.getTeacher(teacherID);

        if (teacher == null) {
            System.err.println("This teacher does not exist, creating teacher now.");
            teacher = createTeacher();
        }

        System.out.println("Please input the course id: ");
        String courseID = scanner.nextLine();
        Course course = SMU.getCourse(courseID);

        if (course == null) {
            System.err.println("This course does not exist, creating course now.");
            course = createCourse();
        }

        teacher.addCourseTeaching(course);
        System.out
                .println("Successfully added " + course.getId() + " to Dr. " + teacher.getLastName() + "\'s schedule");
        System.out.println("Returning to Teacher menu...\n\n");
    }

    private static void addStudentToCourse() {
        System.out.println("Please input the student's id: ");
        int studentID = Integer.parseInt(scanner.nextLine());
        Student adderStudent = SMU.getStudent(studentID);

        if (adderStudent == null) {
            System.err.println("This student does not exist, creating student now.");
            adderStudent = createStudent();
        }

        System.out.println("Please input the course id: ");
        String courseID = scanner.nextLine();
        Course course = SMU.getCourse(courseID);

        if (course == null) {
            System.err.println("This course does not exist, creating course now.");
            course = createCourse();
        }

        SMU.getCourses().get(SMU.getCourses().indexOf(course)).addStudentToClass(adderStudent);
        System.out.println("Successfully added " + adderStudent.getFirstName() + " to " + course.getId());
        System.out.println("Returning to student menu...\n\n");

    }

    public static void printAllAccounts() {
        ArrayList<Account> accounts = SMU.geAccounts();
        for (int i = 0; i < accounts.size(); i++) {
            Account account = accounts.get(i);
            System.out.println("ID: " + account.getId() + " | Name: " + account.getFirstName() + " "
                    + account.getLastName() + "| Email: " + account.getEmail() + " | Account Type: "
                    + account.getClass().getName());
        }
    }

    public static void prepopulate() {
        SMU.addStudent("Ethan", "Worden", "ethan.worden@stmartin.edu");
        SMU.addStudent("Darryl", "Giron", "darryl.giron@stmartin.edu");
        SMU.addStudent("Rich", "Montgomery", "RMontgomery@stmartin.edu");
        SMU.addTeacher("Xuguang", "Chen", "XChen@stmartin.edu");
        SMU.addTeacher("John", "Doe", "jdoe@stmartin.edu");
        SMU.addCourse("CSC101");
        SMU.addCourse("MTH101");
        SMU.addCourse("ENG400");
        SMU.addCourse("CSC598");
    }
}

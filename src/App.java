import java.util.ArrayList;
import java.util.Scanner;

public class App {
    static Scanner scanner = new Scanner(System.in);
    static School SMU = new School(new ArrayList<>(), new ArrayList<>());

    public static void main(String[] args) throws Exception {
        displayMainMenu();
    }

    public static void displayMainMenu() {
        System.out.println("\n\nMain Menu:\n" +
                "1. Courses\n" +
                "2. Accounts\n" +
                "3. Exit Program");
        String input = scanner.nextLine();

        switch (input) {
            case "1":
                System.out.println("1 was pressed");
                displayCoursesMenu();
                break;
            case "2":
                System.out.println("2 was pressed");
                break;
            case "3":
                System.out.println("3 was pressed");
                break;
            default:
                System.out.println("Invalid Input");
                displayMainMenu();

        }
    }

    public static void displayCoursesMenu() {
        System.out.println("\n\nCourses Menu:\n" +
                "1. View all courses\n" +
                "2. Add Courses\n" +
                "3. Add Student to Course\n" +
                "4. Exit to Main Menu");
        String input = scanner.nextLine();

        switch (input) {
            case "1":
                System.out.println("1 was pressed");
                ArrayList<Course> availableCourses = SMU.getCourses();
                System.out.println("Courses currently offered: ");
                for (int i = 0; i < availableCourses.size(); i++) {
                    System.out.println(availableCourses.get(i).getId());
                }

                break;
            case "2":
                System.out.println("2 was pressed");
                System.out.println("What is the course id: ");
                String courseIDInput = scanner.nextLine();
                SMU.addCourse(courseIDInput);
                System.out.println(courseIDInput + " has been added to the database");

                break;
            case "3":
                addStudentToCourse();

                break;
            case "4":
                System.out.println("3 was pressed");
                displayMainMenu();
                break;
            default:
                System.out.println("Invalid Input");
                displayCoursesMenu();

        }
        displayCoursesMenu();

    }

    private static void addStudentToCourse() {
        System.out.println("3 was pressed");// Add Student to Course
        System.out.println("Please input the student's id: ");
        int studentID = Integer.valueOf(scanner.nextLine());
        ArrayList<Student> currentStudents = SMU.getStudents();
        Student adderStudent = null;
        for (int i = 0; i < currentStudents.size(); i++) {
            if (currentStudents.get(i).getId() == studentID) {
                adderStudent = currentStudents.get(i);
                break;
            }
        }

        if (adderStudent == null) { // student not in system
            createStudent();
        }
    }

    private static void createStudent() {
        System.out.println("Enter student's first name: ");
        String first = scanner.nextLine();
        System.out.println("Enter student's last name: ");
        String last = scanner.nextLine();
        System.out.println("Enter student's last name: ");
        String email = scanner.nextLine();
        SMU.addStudent(first, last, email);
    }

}

/*
 * 
 * 1. Add a course
 * 2. add a teacher
 * 3. add a student
 * 
 * 
 * 1. courses
 * 1. add course
 * 2. Teachers
 * 1. add teacher
 * 2. get all teachers
 * 3.
 */

/*
 * 
 * (Extra Points)
 * Person{
 * id
 * firstName
 * lastName
 * .
 * .
 * .
 * 
 * 
 * }
 * Admin: Person{
 * adds courses
 * adds students
 * adds teachers
 * READ/WRITE all
 * }
 * 
 * Teacher : Person{
 * coursesTeaching
 * department
 * canGrade = true;
 * READ/WRITE access to courses teachingf
 * }
 * 
 * Student :Person {
 * coursesTaking
 * major
 * canGrade = false;
 * 
 * READ access to courses
 * }
 * 
 * Courses{
 * courseId
 * name
 * description
 * .
 * .
 * .
 * .
 * }
 * 
 * 
 * 
 * List<Admin> people
 * 
 * people[0] = admin(....);
 * 
 * List<Courses> courses;
 * 
 * 
 * 
 * Some work....
 * 
 * JSON:
 * Person{
 * Admin{
 * 
 * }
 * 
 * Teacher{
 * 
 * }
 * Student{
 * 
 * }
 * }
 * 
 * 
 */
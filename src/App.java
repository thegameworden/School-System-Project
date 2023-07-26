import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        School SMU = new School(new ArrayList<>(), new ArrayList<>());
        SMU.addStudent("john", "smith", "jsmith@stmartin.edu");
        SMU.addCourse("CSC101");

        System.out.println("Starting program");
        ArrayList<Account> test = SMU.geAccounts();
        System.out.println(test.get(0).getClass());
    }
}

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
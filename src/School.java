import java.util.ArrayList;

public class School {

    private ArrayList<Account> accounts;
    private ArrayList<Course> courses;

    public School(ArrayList<Account> accounts, ArrayList<Course> courses) {
        this.accounts = accounts;
        this.courses = courses;
    }

    public void addStudent(String firstName, String lastName, String email) {
        Student student = new Student(accounts.size() + 1, firstName, lastName, email);
        accounts.add(student);
    }

    public void addTeacher(String firstName, String lastName, String email) {
        Teacher teacher = new Teacher(accounts.size() + 1, firstName, lastName, email);
        accounts.add(teacher);

    }

    public void addCourse(String id) {
        Course course = new Course(id);
        courses.add(course);
    }

    public ArrayList<Course> getCoursese() {
        return courses;
    }

    public ArrayList<Account> geAccounts() {
        return accounts;
    }

    public ArrayList<Student> getStudents() {
        ArrayList<Student> ret = new ArrayList<Student>();
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i) instanceof Student) {
                ret.add((Student) accounts.get(i));
            }
        }
        return ret;
    }

    public ArrayList<Teacher> getTeachers() {
        ArrayList<Teacher> ret = new ArrayList<Teacher>();
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i) instanceof Teacher) {
                ret.add((Teacher) accounts.get(i));
            }
        }
        return ret;
    }

}

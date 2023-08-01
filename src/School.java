import java.util.ArrayList;

public class School {

    private ArrayList<Account> accounts;
    private ArrayList<Course> courses;

    public School(ArrayList<Account> accounts, ArrayList<Course> courses) {
        this.accounts = accounts;
        this.courses = courses;
    }

    public Student addStudent(String firstName, String lastName, String email) {
        Student student = new Student(accounts.size(), firstName, lastName, email);
        accounts.add(student);
        return student;
    }

    public Teacher addTeacher(String firstName, String lastName, String email) {
        Teacher teacher = new Teacher(accounts.size(), firstName, lastName, email);
        accounts.add(teacher);
        return teacher;

    }

    public Course addCourse(String id) {
        Course course = new Course(id);
        courses.add(course);
        return course;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public Course getCourse(String id) {
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getId().equals(id)) {
                return courses.get(i);
            }
        }
        return null;
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

    public Student getStudent(int id) {
        if (id < 0 || id >= accounts.size() || !(accounts.get(id) instanceof Student))
            return null;
        return (Student) accounts.get(id);
    }

    public Teacher getTeacher(int id) {
        if (id < 0 || id >= accounts.size() || !(accounts.get(id) instanceof Teacher))
            return null;
        return (Teacher) accounts.get(id);
    }

}

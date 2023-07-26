import java.util.ArrayList;

public class Teacher extends Account {
    private ArrayList<Course> coursesTeaching;

    public Teacher(int id, String firstName, String lastName, String email) {
        super(id, firstName, lastName, email);
        this.coursesTeaching = new ArrayList<Course>();
    }

    public ArrayList<Course> getCoursesTeaching() {
        return coursesTeaching;
    }

    public void addCourseTeaching(Course course) {
        coursesTeaching.add(course);
    }

}

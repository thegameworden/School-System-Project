import java.util.ArrayList;

public class Student extends Account {
    private ArrayList<String> coursesTaking;

    public Student(int id, String firstName, String lastName, String email) {
        super(id, firstName, lastName, email);
        coursesTaking = new ArrayList<String>();
    }

    public ArrayList<String> getCoursesTaking() {
        System.out.println(this.getFirstName() + " is taking:");
        for (String course : coursesTaking) {
            System.out.println(course);
        }
        return coursesTaking;
    }

    public void setCoursesTaking(ArrayList<String> coursesTaking) {
        this.coursesTaking = coursesTaking;
    }

    public void addCourse(String course) {
        coursesTaking.add(course);
    }

}
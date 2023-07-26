import java.util.HashMap;
import java.util.Map;

public class Course {
    private String id;
    private HashMap<Student, Integer> studentGrade;

    public Course(String id) {
        studentGrade = new HashMap<Student, Integer>();
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getAllGrades() {
        StringBuilder sb = new StringBuilder();
        sb.append("Grade breakdown for " + this.id + ": \n");
        for (Map.Entry<Student, Integer> entry : studentGrade.entrySet()) {
            Student student = entry.getKey();
            Integer grade = entry.getValue();
            sb.append(student.getId() + " : " + grade + "\n");
        }
        return sb.toString();
    }

    public void addStudentToClass(Student student) {
        studentGrade.put(student, null);
        student.addCourse(this.id);
    }

    public String getStudentGrade(Student student) {
        if (!studentGrade.containsKey(student)) {
            return "Student not found in this class";
        }
        String ret = student.getFirstName() + " " + student.getLastName() + "\'s grade is: "
                + studentGrade.get(student);
        return ret;
    }

}

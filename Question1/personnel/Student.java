package personnel;
import java.util.Date;
public abstract class Student extends Person{
    private String department;

    public Student(int id, String name, Date birthdate, String department) {
        super(id, name, birthdate);
        this.department = department;
        }
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return super.toString() + ", Student[department=" + department + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        Student student = (Student) obj;
        return department.equals(student.department);
    }

}

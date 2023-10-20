package personnel;
import java.util.Date;
public class GraduateStudent extends Student{
    private boolean phDStudent;

    public GraduateStudent(int id, String name, Date birthdate, String department, boolean phDStudent) {
        super(id, name, birthdate, department);
        this.phDStudent = phDStudent;
    }
    public boolean isPhDStudent() {
        return phDStudent;
    }

    public void setPhDStudent(boolean phDStudent) {
        this.phDStudent = phDStudent;
    }

    @Override
    public String toString() {
        return super.toString() + ", GraduateStudent[phDStudent=" + phDStudent + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        GraduateStudent graduateStudent = (GraduateStudent) obj;
        return phDStudent == graduateStudent.phDStudent;
    }
}

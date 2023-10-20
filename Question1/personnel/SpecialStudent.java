package personnel;
import java.util.Date;
public class SpecialStudent extends Student{
    private boolean enrolled;

    public SpecialStudent(int id, String name, Date birthdate, String department, boolean enrolled) {
        super(id, name, birthdate, department);
        this.enrolled = enrolled;
    }
    public boolean isEnrolled() {
        return enrolled;
    }

    public void setEnrolled(boolean enrolled) {
        this.enrolled = enrolled;
    }

    @Override
    public String toString() {
        return super.toString() + ", SpecialStudent[enrolled=" + enrolled + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        SpecialStudent specialStudent = (SpecialStudent) obj;
        return enrolled == specialStudent.enrolled;
    }
}

package personnel;
import java.util.Date;
public class UndergraduateStudent extends Student{
    private int year;

    public UndergraduateStudent(int id, String name, Date birthdate, String department, int year) {
        super(id, name, birthdate, department);
        this.year = year;
    }
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return super.toString() + ", UndergraduateStudent[year=" + year + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        UndergraduateStudent undergraduateStudent = (UndergraduateStudent) obj;
        return year == undergraduateStudent.year;
    }
}

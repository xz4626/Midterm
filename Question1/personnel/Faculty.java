package personnel;
import java.util.Date;
public class Faculty extends Employee{
    private String title;
    private String department;
    private boolean tenured;

    public Faculty(int id, String name, Date birthdate, double salary, String title, String department, boolean tenured) {
        super(id, name, birthdate, salary);
        this.title = title;
        this.department = department;
        this.tenured = tenured;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
    public boolean isTenured() {
        return tenured;
    }

    public void setTenured(boolean tenured) {
        this.tenured = tenured;
    }

    @Override
    public String toString() {
        return super.toString() + ", Faculty[title=" + title + ", department=" + department + ", tenured=" + tenured + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        Faculty faculty = (Faculty) obj;
        return title.equals(faculty.title) && department.equals(faculty.department) && tenured == faculty.tenured;
    }
}

package personnel;
import java.util.Date;
public abstract class Employee extends Person{
    private double salary;

    public Employee(int id, String name, Date birthdate, double salary) {
        super(id, name, birthdate);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    @Override
    public String toString() {
        return super.toString() + ", Employee[salary=" + salary + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        Employee employee = (Employee) obj;
        return Double.compare(employee.salary, salary) == 0;
    }
}

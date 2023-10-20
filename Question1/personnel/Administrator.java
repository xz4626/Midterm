package personnel;
import java.util.Date;
public class Administrator extends Employee{
    private String title;
    private double budget;

    public Administrator(int id, String name, Date birthdate, double salary, String title, double budget) {
        super(id, name, birthdate, salary);
        this.title = title;
        this.budget = budget;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    @Override
    public String toString() {
        return super.toString() + ", Administrator[title=" + title + ", budget=" + budget + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        Administrator administrator = (Administrator) obj;
        return title.equals(administrator.title) && Double.compare(administrator.budget, budget) == 0;
    }
}

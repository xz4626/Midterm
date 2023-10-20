package personnel;
import java.util.Date;
public class Staff extends Employee{
    private boolean contractor;
    private boolean fulltime;

    public Staff(int id, String name, Date birthdate, double salary, boolean contractor, boolean fulltime) {
        super(id, name, birthdate, salary);
        this.contractor = contractor;
        this.fulltime = fulltime;
    }

    public boolean isContractor() {
        return contractor;
    }

    public void setContractor(boolean contractor) {
        this.contractor = contractor;
    }

    public boolean isFulltime() {
        return fulltime;
    }

    public void setFulltime(boolean fulltime) {
        this.fulltime = fulltime;
    }

    public String toString() {
        return super.toString() + ", Staff[contractor=" + contractor + ", fulltime=" + fulltime + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        Staff staff = (Staff) obj;
        return contractor == staff.contractor && fulltime == staff.fulltime;
    }
}

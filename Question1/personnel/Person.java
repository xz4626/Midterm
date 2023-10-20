package personnel;
import java.util.Date;
public abstract class Person {
    private int id;
    private String name;
    private Date birthdate;

    public Person(int id, String name, Date birthdate) {
        this.id = id;
        this.name = name;
        this.birthdate = birthdate;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String toString() {
        return "Person[id=" + id + ", name=" + name + ", birthdate=" + birthdate + "]";
    }


    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Person person = (Person) obj;
        return id == person.id && name.equals(person.name) && birthdate.equals(person.birthdate);
    }
}

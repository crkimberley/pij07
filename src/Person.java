/**
 * @author crkimberley on 09/09/2016.
 */
public class Person {
    private String name;
    private int age;
    private String illness;

    public Person(String name, int age, String illness) {
        this.name = name;
        this.age = age;
        this.illness = illness;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return String.format("Name: %-10sAge: %-6dIllness: %-10s", name, age, illness);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (age != person.age) return false;
        if (name != null ? !name.equals(person.name) : person.name != null) return false;
        return illness != null ? illness.equals(person.illness) : person.illness == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        result = 31 * result + (illness != null ? illness.hashCode() : 0);
        return result;
    }
}

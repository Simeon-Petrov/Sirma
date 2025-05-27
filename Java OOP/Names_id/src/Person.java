
public class Person {
    private int id;
    private String firstName;
    private String lastName;

    // Конструктор по подразбиране (нужен за Jackson)
    public Person() {
    }

    // Конструктор с параметри
    public Person(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Getter и Setter методи (нужни за Jackson)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // toString метод за показване на данните
    @Override
    public String toString() {
        return "Person = {" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}


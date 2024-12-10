package SortPersonsbyNameandAge_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StartUp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] cmgArg = scanner.nextLine().split(" ");
            Person person = new Person(cmgArg[0], cmgArg[1], Integer.parseInt(cmgArg[2]));
            persons.add(person);
        }

        persons.sort((p1, p2) -> {
            int firstNameComparison = p1.getFirstName().compareTo(p2.getFirstName());
            if (firstNameComparison != 0) {
                return firstNameComparison;
            }
            return Integer.compare(p1.getAge(), p2.getAge());
        });

        for (Person person : persons) {
            System.out.println(person);
        }
    }
}

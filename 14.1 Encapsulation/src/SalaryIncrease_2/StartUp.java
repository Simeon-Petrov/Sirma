package SalaryIncrease_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StartUp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] cmdArgs = scanner.nextLine().split(" ");
            String firstName = cmdArgs[0];
            String lastName = cmdArgs[1];
            int age = Integer.parseInt(cmdArgs[2]);
            double salary = Double.parseDouble(cmdArgs[3]);
            Person person = new Person(firstName, lastName, age, salary);
            persons.add(person);
        }

        double percentage =  Double.parseDouble(scanner.nextLine());

        persons.forEach(person -> person.increaseSalary(percentage));

        persons.forEach(System.out::println);
    }
}

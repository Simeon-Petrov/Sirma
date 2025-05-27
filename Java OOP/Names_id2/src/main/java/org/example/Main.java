package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final String JSON_FILE = "persons.json";
    private static ObjectMapper objectMapper = new ObjectMapper();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=== Програма за записване на лица ===");

        List<Person> persons = loadPersonsFromFile();

        while (true) {
            System.out.println("\n1. Добави ново лице");
            System.out.println("2. Покажи всички лица");
            System.out.println("3. Изход");
            System.out.print("Избери опция: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Консумира новия ред

            switch (choice) {
                case 1:
                    addNewPerson(persons);
                    break;
                case 2:
                    showAllPersons(persons);
                    break;
                case 3:
                    System.out.println("Довиждане!");
                    return;
                default:
                    System.out.println("Невалидна опция!");
            }
        }
    }

    private static void addNewPerson(List<Person> persons) {
        System.out.print("Въведи ID номер: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Консумира новия ред

        System.out.print("Въведи първо име: ");
        String firstName = scanner.nextLine();

        System.out.print("Въведи фамилия: ");
        String lastName = scanner.nextLine();

        Person person = new Person(id, firstName, lastName);
        persons.add(person);

        savePersonsToFile(persons);
        System.out.println("Лицето е добавено успешно!");
    }

    private static void showAllPersons(List<Person> persons) {
        if (persons.isEmpty()) {
            System.out.println("Няма записани лица.");
            return;
        }

        System.out.println("\n=== Всички лица ===");
        for (Person person : persons) {
            System.out.println(person);
        }
    }

    private static List<Person> loadPersonsFromFile() {
        try {
            File file = new File(JSON_FILE);
            if (file.exists()) {
                Person[] personsArray = objectMapper.readValue(file, Person[].class);
                List<Person> persons = new ArrayList<>();
                for (Person person : personsArray) {
                    persons.add(person);
                }
                System.out.println("Заредени " + persons.size() + " лица от файла.");
                return persons;
            }
        } catch (IOException e) {
            System.out.println("Грешка при четене на файла: " + e.getMessage());
        }
        return new ArrayList<>();
    }

    private static void savePersonsToFile(List<Person> persons) {
        try {
            objectMapper.writerWithDefaultPrettyPrinter()
                    .writeValue(new File(JSON_FILE), persons);
            System.out.println("Данните са запазени в " + JSON_FILE);
        } catch (IOException e) {
            System.out.println("Грешка при запис на файла: " + e.getMessage());
        }
    }
}
package date_2024_01_07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class OrderByAge {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        List<Person> persons = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String[] inputs = br.readLine().split(" ");
            persons.add(new Person(inputs, i));
        }

        Collections.sort(persons);
        for (Person person : persons) {
            System.out.println(person.age + " " + person.name);
        }
    }

    private static class Person implements Comparable<Person> {

        private int age;
        private String name;
        private int index;

        public Person(String[] inputs, int index) {
            this.age = Integer.parseInt(inputs[0]);
            this.name = inputs[1];
            this.index = index;
        }

        @Override
        public int compareTo(Person person) {
            if (age > person.age) {
                return 1;
            } else if (age < person.age) {
                return -1;
            } else {
                return index - person.index;
            }
        }
    }
}

package date_2024_01_06;

// https://www.acmicpc.net/problem/7568
// 덩치 랭킹을 계산하는 문제이다. 정렬의 시간복잡도를 조금만 공부하고 가자.

import java.io.*;
import java.util.*;

public class BigRank {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        List<Person> persons = new ArrayList<>(50);
        HashMap<Person, Integer> rank = new HashMap<>(50);

        for (int i = 0; i < n; i++) {
            int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            persons.add(new Person(inputs));
        }
        List<Person> sortedPersons = new ArrayList<>(persons);
        sortedPersons.sort(Collections.reverseOrder());

        int rankNum = 1;
        rank.put(sortedPersons.get(0), 1);
        for (int i = 1; i < sortedPersons.size(); i++) {
            Person person = sortedPersons.get(i);
            if (person.isSameRank(sortedPersons.get(i - 1))) {
                rank.put(person, rankNum);
            } else {
                rank.put(person, i + 1);
                rankNum = i + 1;
            }
        }

        persons.forEach(p -> sb.append(rank.get(p) + " "));
        sb.deleteCharAt(sb.length() - 1);

        System.out.println(sb);

        Person p1 = new Person(15, 10);
        Person p2 = new Person(5, 15);
        Person p3 = new Person(10, 5);
        System.out.println(p1.compareTo(p2));
        System.out.println(p2.compareTo(p1));
        System.out.println(p2.compareTo(p2));
        System.out.println(p1.compareTo(p3));
        System.out.println(p2.compareTo(p3));


    }

    static class Person implements Comparable<Person> {
        int height;
        int weight;

        public Person(int height, int weight) {
            this.height = height;
            this.weight = weight;
        }

        public Person(int[] inputs) {
            this.height = inputs[0];
            this.weight = inputs[1];
        }

        public boolean isSameRank(Person person) {
            if (person.compareTo(this) == 0) {
                return true;
            }

            return false;
        }

        @Override
        public int compareTo(Person person) {
            if (height == person.height || weight == person.weight) {
                return 0;
            } else if (height > person.height && weight > person.weight) {
                return 1;
            } else if (height < person.height && weight < person.weight) {
                return -1;
            }else{
                return 0;
            }
//            if (height >= person.height && weight > person.weight) {
//                return 1;
//            } else if (height > person.height && weight >= person.weight) {
//                return 1;
//            } else if (height <= person.height && weight < person.weight) {
//                return -1;
//            } else if (height < person.height && weight <= person.weight) {
//                return -1;
//            }else{
//                return 0;
//            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return height == person.height && weight == person.weight;
        }

        @Override
        public int hashCode() {
            return Objects.hash(height, weight);
        }

        @Override
        public String toString() {
            return "Person{" +
                    "height=" + height +
                    ", weight=" + weight +
                    '}';
        }
    }
}

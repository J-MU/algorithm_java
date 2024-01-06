package date_2024_01_06;

// https://www.acmicpc.net/problem/7568
// 덩치 랭킹을 계산하는 문제이다. 정렬의 시간복잡도를 조금만 공부하고 가자.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BigRank2 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        List<Person> persons = new ArrayList<>(50);

        for (int i = 0; i < n; i++) {
            int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            persons.add(new Person(inputs));
        }

        for (int i = 0; i < persons.size(); i++) {
            Person person = persons.get(i);
            int rank = 1;

            for (int j = 0; j < persons.size(); j++) {
                Person target = persons.get(j);
                if (target.compareTo(person) > 0) {
                    rank+=1;
                }
            }

            sb.append(rank+" ");
        }

        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
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
            } else {
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

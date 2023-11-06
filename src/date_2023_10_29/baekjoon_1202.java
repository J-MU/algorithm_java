package date_2023_10_29;

import java.io.*;
import java.util.*;

public class baekjoon_1202 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static int N;
    private static int K;
    private static long valueSum = 0;

    private static List<Item> items = new ArrayList<>();
    private static LinkedList<Integer> bags = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = inputs[0];
        K = inputs[1];

        for (int i = 0; i < N; i++) {
            int[] item = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            items.add(new Item(item[0], item[1]));
        }

        for (int i = 0; i < K; i++) {
            int capacity = Integer.parseInt(br.readLine());
            bags.add(capacity);
        }

        items.sort((o1, o2) -> {
            if (o1.weight == o2.weight) {
                return o2.value - o1.value;
            } else {
                return o1.weight - o2.weight;
            }
        });

        bags.sort(Comparator.comparingInt(e -> (int) e).reversed());

        printSortedArrays();
        int itemIndex = 0;
        int bagIndex = 0;
//        while (true) {
//            Integer capacity = bags.remove(bagIndex);
//            Item itemWeight = items.get(itemIndex++);
////
////            if (capacity >= itemWeight) {
////
////            }
//        }
        for (int i = 0; i < K; i++) {
            Integer capacity = bags.get(i);

            while (true) {
                if (itemIndex == items.size()) {
                    break;
                }
                Item item = items.get(itemIndex);
                if (item.weight < capacity) {
                    itemIndex++;
                } else if (item.weight == capacity) {
                    Item realItem = items.remove(itemIndex);
                    valueSum += realItem.value;
                    break;
                } else {
                    if (itemIndex == 0) {
                        break;
                    }
                    Item realItem = items.remove(--itemIndex);
                    valueSum += realItem.value;
                    break;
                }
            }
        }

        bw.write(valueSum + "\n");
        bw.flush();
    }

    public static void printSortedArrays() {
        System.out.println("items[weight, value]: ");
        for (Item item : items) {
            System.out.println(item.weight + ", " + item.value);
        }
        System.out.println();

        System.out.println("bags: ");
        System.out.println("bags = " + bags);
    }

    static class Item {
        int weight;
        int value;

        Item(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }
}

package date_2023_10_29;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;

public class baekjoon_11399 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int sum = 0;

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        int[] timeArray = new int[N];

        int[] sequence = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int num : sequence) {
            priorityQueue.add(num);
        }

        while (!priorityQueue.isEmpty()) {
            Integer num = priorityQueue.poll();
            sum += num * (N--);
        }

        bw.write(sum + "\n");
        bw.flush();
    }
}

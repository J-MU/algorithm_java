package date_2023_10_26;

import java.io.*;
import java.util.Arrays;


public class PartialNumberArraySum {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static int count = 0;
    private static int N;
    private static int Sum;

    public static void main(String[] args) throws IOException {
        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        N = inputs[0];
        Sum = inputs[1];

        solution();

        bw.write(count + "\n");
        bw.flush();
    }

    private static void solution() throws IOException {
        int[] sequence = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        boolean[] visited = new boolean[sequence.length];

        for (int r = 1; r <= sequence.length; r++) {
            combination(sequence, visited, 0, visited.length, r);
        }
    }

    private static void combination(int[] array, boolean[] visited, int start, int n, int r) {
        if (r == 0) {
            int sum = 0;
            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) {
                    sum += array[i];
                }
            }

            if (sum == Sum) {
                count++;

//                print(visited);
            }

            return;
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            combination(array, visited, i + 1, n, r - 1);
            visited[i] = false;
        }
    }

//    private static void print(boolean[] visited) {
//        System.out.print("visited: ");
//        for (int i = 0; i < visited.length; i++) {
//            System.out.print(visited[i] + ", ");
//        }
//        System.out.println();
//    }
}

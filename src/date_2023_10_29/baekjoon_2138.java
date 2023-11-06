package date_2023_10_29;

import java.io.*;
import java.util.Arrays;

public class baekjoon_2138 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static int first_count = 1;
    private static int second_count = 0;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] A = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        int[] copy_A = Arrays.copyOf(A, N);
        int[] B = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();

        turnLight(0, A);
        for (int i = 1; i < N; i++) {
            if (A[i - 1] != B[i - 1]) {
                turnLight(i, A);
                first_count++;
            }
        }
        boolean firstEqual = A[N - 1] == B[N - 1];
        first_count = firstEqual ? first_count : -1;

        A = copy_A;
        for (int i = 1; i < N; i++) {
            if (A[i - 1] != B[i - 1]) {
                turnLight(i, A);
                second_count++;
            }
        }

        boolean secondEqual = A[N - 1] == B[N - 1];
        second_count = secondEqual ? second_count : -1;

        int count = 0;
        if (first_count == -1 || second_count == -1) {
            count = Math.max(first_count, second_count);
        }else{
            count = Math.min(first_count, second_count);
        }

        bw.write(count + "\n");
        bw.flush();
    }

    private static void turnLight(int i, int[] A) {
        for (int j = i - 1; j <= i + 1; j++) {
            if (j < 0 || j >= A.length) {
                continue;
            }
            A[j] = (A[j] == 0) ? 1 : 0;
        }
    }
}

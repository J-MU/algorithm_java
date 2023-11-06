package date_2023_10_29;

import java.io.*;
import java.util.Arrays;

public class baekjoon_1080 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static int[][] A;
    private static int[][] B;
    private static int count = 0;

    public static void main(String[] args) throws IOException {
        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = inputs[0];
        int M = inputs[1];
        A = new int[N][M];
        B = new int[N][M];

        for (int i = 0; i < N; i++) {
            A[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        for (int i = 0; i < N; i++) {
            B[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        for (int i = 0; i < N - 2; i++) {
            for (int j = 0; j < M - 2; j++) {
                if (A[i][j] != B[i][j]) {
                    switchProcession(i, j);
                    count++;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (A[i][j] != B[i][j]) {
                    count = -1;
                    break;
                }
            }
        }

        bw.write(count + "\n");
        bw.flush();
    }

    private static void switchProcession(int row, int col) {
        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
//                A[i][j] = (A[i][j] + 1) % 2;
                A[i][j] = (A[i][j] == 0) ? 1 : 0;
            }
        }
    }
}

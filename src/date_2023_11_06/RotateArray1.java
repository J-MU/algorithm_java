package date_2023_11_06;

import java.io.*;
import java.util.Arrays;

public class RotateArray1 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int[][] map;
    private static int N;
    private static int M;

    public static void main(String[] args) throws IOException {
        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = inputs[0];
        M = inputs[1];
        int R = inputs[2];

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        for (int i = 0; i < R; i++) {
            rotate();
        }

        for (int[] ints : map) {
            StringBuilder row = new StringBuilder();
            for (int anInt : ints) {
                row.append(anInt + " ");
            }
            row.delete(row.length() - 1, row.length());
            bw.write(row.toString() + "\n");
        }
        bw.flush();
    }

    private static void rotate() {
        int[][] newMap = new int[N][M];

        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                int depthX = Math.min(x, M - 1 - x);
                int depthY = Math.min(y, N - 1 - y);
                int arrayLayer = Math.min(depthX, depthY);

                if (x == arrayLayer && y >= arrayLayer && y < N - 1 - arrayLayer) {
                    newMap[y + 1][x] = map[y][x];
                } else if (y == N - 1 - arrayLayer && x >= arrayLayer && x < M - 1 - arrayLayer) {
                    newMap[y][x + 1] = map[y][x];
                } else if (x == M - 1 - arrayLayer && y >= arrayLayer + 1 && y <= N - 1 - arrayLayer) {
                    newMap[y - 1][x] = map[y][x];
                } else {
                    newMap[y][x - 1] = map[y][x];
                }
            }
        }

        map = newMap;
    }
}

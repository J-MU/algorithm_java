package date_2023_11_06;

import java.io.*;
import java.util.Arrays;

public class RoateArray3 {
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

        int[] operation = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int operationLength = operation.length;
        for (int i = 0; i < operationLength; i++) {
            switch (operation[i]) {
                case 1: {
                    firstOperation();
                    break;
                }
                case 2: {
                    secondOperation();
                    break;
                }
                case 3: {
                    thirdOperation();
                    break;
                }
                case 4: {
                    fourthOperation();
                    break;
                }
                case 5: {
                    fifthOperation();
                    break;
                }
                case 6: {
                    sixthOperation();
                    break;
                }
            }
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

    private static void firstOperation() {
        int[][] newMap = new int[N][M];

        // 0 1 2 N=3 (N-i-1)
        for (int i = 0; i < N; i++) {
            newMap[N - i - 1] = map[i];
        }

        map = newMap;
    }

    private static void secondOperation() {
        int[][] newMap = new int[N][M];

        // 0 1 2 N=3 (N-i-1)
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                newMap[i][j] = map[i][M - j - 1];
            }
        }

        map = newMap;
    }

    private static void thirdOperation() {
        int[][] newMap = new int[M][N];

        // 0 1 2 N=3 (N-i-1)
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                newMap[j][N - i - 1] = map[i][j];
            }
        }
        int temp = M;
        M = N;
        N = temp;
        map = newMap;
    }

    private static void fourthOperation() {
        int[][] newMap = new int[M][N];

        // 0 1 2 N=3 (N-i-1)
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                newMap[M - j - 1][i] = map[i][j];
            }
        }

        int temp = M;
        M = N;
        N = temp;
        map = newMap;
    }

    private static void fifthOperation() {
        int[][] newMap = new int[N][M];

        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                if (y < N / 2 && x < M / 2) { /// 1
                    newMap[y][x + M / 2] = map[y][x];
                } else if (y < N / 2 && M / 2 <= x) { //2
                    newMap[y + N / 2][x] = map[y][x];
                } else if (y >= N / 2 && M / 2 <= x) {//3
                    newMap[y][x - M / 2] = map[y][x];
                } else {//4
                    newMap[y - N / 2][x] = map[y][x];
                }
            }
        }

        map = newMap;
    }

    private static void sixthOperation() {
        int[][] newMap = new int[N][M];

        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                if (y < N / 2 && x < M / 2) { /// 1
                    newMap[y + N / 2][x] = map[y][x];
                } else if (y < N / 2 && M / 2 <= x) { //2
                    newMap[y][x - M / 2] = map[y][x];
                } else if (y >= N / 2 && M / 2 <= x) {//3
                    newMap[y - N / 2][x] = map[y][x];
                } else {//4
                    newMap[y][x + M / 2] = map[y][x];
                }
            }
        }

        map = newMap;
    }
}

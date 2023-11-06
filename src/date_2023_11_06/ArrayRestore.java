package date_2023_11_06;

import java.io.*;
import java.util.Arrays;

public class ArrayRestore {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static int[][] A;
    private static int[][] B;
    private static int H;
    private static int W;
    private static int X;
    private static int Y;

    public static void main(String[] args) throws IOException {
        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        H = inputs[0];
        W = inputs[1];
        X = inputs[2];
        Y = inputs[3];

        A = new int[H][W];
        B = new int[H + X][H + Y];
        for (int i = 0; i < H + X; i++) {
            B[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        for (int row = 0; row < H + X; row++) {
            for (int col = 0; col < W + Y; col++) {
                if (isOriginal(row, col)) {
                    A[row][col] = B[row][col];
                } else if (isMove(row, col)) {
                    A[row - X][col - Y] = B[row][col];
                }
            }
        }

        for (int i = 0; i < H; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < W; j++) {
                sb.append(A[i][j] + " ");
            }
            sb.delete(sb.length() - 1, sb.length());
            sb.append("\n");
            bw.write(sb.toString());
        }
        bw.flush();
    }

    private static boolean isOriginal(int row, int col) {
        return (row < H && col < W) && (row <= X - 1 || col <= Y - 1);
    }

    private static boolean isMove(int row, int col) {
        return ((X <= row && row <= H + X - 1) && (Y <= col && col <= W + Y - 1)) && (H <= row || W <= col);
    }
}

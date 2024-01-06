package date_2024_01_06;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;


public class ChessBoard {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final HashMap<Integer, String> firstOrder = createOrder("B","W");
    private static final HashMap<Integer, String> secondOrder = createOrder("W","B");

    private static String[][] board;
    private static int N;
    private static int M;
    private static int min=Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = inputs[0];
        M = inputs[1];

        board = createBoard();


        for (int i = 0; i < N-8 +1; i++) {
            for (int j = 0; j < M-8 +1 ; j++) {
                calculateDifferentCell(i,j);
            }
        }

        System.out.println(min);
    }

    private static void calculateDifferentCell(int row, int col) {
        int firstCount = 0;
        int secondCount = 0;
        for (int i = row; i < row + 8; i++) {
            for (int j = col; j < col + 8; j++) {
                int pivot = (i + j) % 2;
                if (!firstOrder.get(pivot).equals(board[i][j])) {
                    firstCount++;
                }
                if (!secondOrder.get(pivot).equals(board[i][j])) {
                    secondCount++;
                }
            }
        }

        int innerMin = Math.min(firstCount, secondCount);
        if (innerMin < min) {
            min = innerMin;
        }
    }

    private static String[][] createBoard() throws IOException {
        String[][] board = new String[N][M];
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().split("");
        }

        return board;
    }

    private static HashMap<Integer, String> createOrder(String first, String second) {
        HashMap<Integer, String> order = new HashMap<>();
        order.put(0, first);
        order.put(1, second);

        return order;
    }
}

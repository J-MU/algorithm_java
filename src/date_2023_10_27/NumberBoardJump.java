package date_2023_10_27;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;

public class NumberBoardJump {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static final HashSet<String> answerSet = new HashSet();
    private static int[][] board;
    private static int length;

    public static void main(String[] args) throws IOException {
        initializeBoard();

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                findString(i, j, 6, new StringBuilder());
            }
        }

        bw.write(answerSet.size() + "\n");
        bw.flush();
    }

    private static void findString(int i, int j, int count, StringBuilder sb) {
        if (count == 0) {
            answerSet.add(sb.toString());
            return;
        }
        if (i < 0 || j < 0 || i >= length || j >= length) {
            return;
        }

        sb.append(board[i][j]);
        findString(i + 1, j, count - 1, sb);
        findString(i - 1, j, count - 1, sb);
        findString(i, j + 1, count - 1, sb);
        findString(i, j - 1, count - 1, sb);
        sb.deleteCharAt(sb.length() - 1);
    }

    private static void initializeBoard() throws IOException {
        int i = 0;
        String line = br.readLine();

        int[] row = Arrays.stream(line.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        length = row.length;
        board = new int[length][length];

        board[i++] = row;

        for (int j = 0; j < length - 1; j++) {
            line = br.readLine();

            row = Arrays.stream(line.split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            board[i++] = row;
        }
    }
}

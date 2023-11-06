package date_2023_11_04;


import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// https://www.acmicpc.net/problem/7576
public class Tomato {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static int RowNum;
    private static int ColNum;
    private static int[][] map;
    private static boolean[][] visited;

    private static final int[] dx = {-1, 0, 0, 1};
    private static final int[] dy = {0, 1, -1, 0};

    private static final ArrayList<Queue<Position>> queue = new ArrayList<>();

    static class Position {
        int row;
        int col;

        Position(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) throws IOException {
        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        ColNum = inputs[0];
        RowNum = inputs[1];

        map = new int[RowNum][ColNum];
        visited = new boolean[RowNum][ColNum];

        for (int i = 0; i < RowNum; i++) {
            int[] row = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            map[i] = row;
        }

        boolean isAllRipen = true;

        queue.add(new LinkedList<>());
        for (int i = 0; i < RowNum; i++) {
            for (int j = 0; j < ColNum; j++) {
                if (map[i][j] == 1) {
                    queue.get(0).add(new Position(i, j));
                    visited[i][j] = true;
                } else if (map[i][j] == -1) {
                    visited[i][j] = true;
                } else if (map[i][j] == 0) {
                    isAllRipen = false;
                }
            }
        }

        if (isAllRipen) {
            bw.write(0 + "\n");
            bw.flush();
            return;
        }
        int step = 0;
        queue.add(new LinkedList<>());

        while (!queue.get(step).isEmpty()) {
            while (!queue.get(step).isEmpty()) {
                Position pos = queue.get(step).poll();

                for (int i = 0; i < dx.length; i++) {
                    int nextRow = pos.row + dy[i];
                    int nextCol = pos.col + dx[i];

                    if (nextRow < 0 || nextCol < 0 || nextRow >= RowNum || nextCol >= ColNum || visited[nextRow][nextCol]) {
                        continue;
                    }

                    queue.get(step + 1).add(new Position(nextRow, nextCol));
                    visited[nextRow][nextCol] = true;
                }
            }
            queue.add(new LinkedList<>());
            step += 1;
        }

        isAllRipen = true;
        for (int i = 0; i < RowNum; i++) {
            for (int j = 0; j < ColNum; j++) {
                if (!visited[i][j]) {
                    isAllRipen = false;
                    break;
                }
            }
            if (!isAllRipen) {
                break;
            }
        }

        if (!isAllRipen) {
            bw.write(-1 + "\n");
        } else {
            bw.write(step - 1 + "\n");
        }
        bw.flush();
    }
}

package date_2023_10_29;

import java.io.*;
import java.util.*;

public class baekjoon_1285 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    //    private static final SortedSet<Position> needSwap = new TreeSet<>();
    private static final LinkedList<Position> needSwap = new LinkedList<>();

    private static final int ROW = 0;
    private static final int COL = 1;

    private static int N;
    private static int[][] boards;
    private static int[] sumRow;
    private static int[] sumCol;

    static class Position {
        int type;
        int order;

        Position(int type, int order) {
            this.type = type;
            this.order = order;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Position position = (Position) o;
            return type == position.type && order == position.order;
        }

        @Override
        public int hashCode() {
            return Objects.hash(type, order);
        }
    }

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        boards = new int[N][N];
        sumRow = new int[N];
        sumCol = new int[N];

        for (int i = 0; i < N; i++) {
            int[] row = Arrays.stream(br.readLine().split(""))
                    .mapToInt(e -> e.equals("H") ? 0 : 1)
                    .toArray();

            boards[i] = row;
        }

        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                sumRow[row] += boards[row][col];
            }

            if (sumRow[row] > N / 2) {
                needSwap.add(new Position(ROW, row));
            }
        }

        for (int col = 0; col < N; col++) {
            for (int row = 0; row < N; row++) {
                sumCol[col] += boards[row][col];
            }

            if (sumCol[col] > N / 2) {
                needSwap.add(new Position(COL, col));
            }
        }
        while (!needSwap.isEmpty()) {
            Position position = needSwap.remove(0);
            swapLine(position);
        }

        int count = 0;
        for (int i = 0; i < N; i++) {
            count += sumRow[i];
        }

        bw.write(count + "\n");
        bw.flush();
    }

    private static void swapLine(Position position) {
        if (position.type == ROW) {
            for (int i = 0; i < N; i++) {
                boards[position.order][i] = (boards[position.order][i] == 0) ? 1 : 0;

                Position pos = new Position(COL, i);
                boolean isContain = needSwap.contains(pos);

                if (boards[position.order][i] == 1) {
                    sumCol[i] += 1;
                    if (sumCol[i] > N / 2) {
                        if(!isContain) {
                            needSwap.add(pos);
                        }
                    }
                } else {
                    sumCol[i] -= 1;

                    if (isContain) {
                        if (sumCol[i] <= N / 2) {
                            needSwap.remove(pos);
                        }
                    }
                }
            }

            sumRow[position.order] = N - sumRow[position.order];
        }

        if (position.type == COL) {
            for (int i = 0; i < N; i++) {
                boards[i][position.order] = (boards[i][position.order] == 0) ? 1 : 0;

                Position pos = new Position(ROW, i);
                boolean isContain = needSwap.contains(pos);

                if (boards[i][position.order] == 1) {
                    sumRow[i] += 1;
                    if (sumRow[i] > N / 2 && (!isContain)) {
                            needSwap.add(pos);
                    }
                } else {
                    sumRow[i] -= 1;
                    if (sumRow[i] <= N / 2 && (isContain)) {
                            needSwap.remove(pos);
                    }
                }
            }

            sumCol[position.order] = N - sumCol[position.order];
        }
    }
}

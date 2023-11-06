package date_2023_10_27;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Sudokuu {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static int[][] boards = new int[9][9];
    private static List<Position> emptyPositions = new LinkedList<>();
    private static Position[][] emptyRows = new Position[9][9];
    private static Position[][] emptyColumns = new Position[9][9];
    private static Position[][] emptySquare = new Position[9][9];
    private static int[] rowIndex = new int[9];
    private static int[] colIndex = new int[9];
    private static int[] squareIndex = new int[9];

    private static int[] rowSum = new int[9];
    private static int[] colSum = new int[9];
    private static int[] squareSum = new int[9];

    public static void main(String[] args) throws IOException {
        read();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int squareNumber = 3 * (i/3) + (j/3);

                if (boards[i][j] == 0) {
                    Position position = new Position(i, j);
                    emptyPositions.add(position);
                    emptyRows[i][rowIndex[i]++] = position;
                    emptyColumns[j][colIndex[j]++] = position;
                    emptySquare[squareNumber][squareIndex[squareNumber]++] = position;
                }

                rowSum[i] += boards[i][j];
                colSum[j] += boards[i][j];
                squareSum[squareNumber] += boards[i][j];
            }
        }

        while (true) {
            if (emptyPositions.isEmpty()) {
                break;
            }

            Position position = emptyPositions.remove(0);
            int x = position.x;
            int y = position.y;
            int squareNumber = 3 * (x / 3) + (y / 3);

            if (rowIndex[x] == 1) {
                boards[x][y] = 45 - rowSum[x];
            }
            else if (colIndex[y] == 1) {
                boards[x][y] = 45 - colSum[y];
            }
            else if (squareIndex[squareNumber] == 1) {
                boards[x][y] = 45 - squareSum[squareNumber];
            }else{
                emptyPositions.add(position);
                continue;
            }

            removeInEmptyRow(position,x);
            colIndex[y]--;
            emptyColumns[y][colIndex[y]]=null;
            squareIndex[squareNumber]--;
            emptySquare[squareNumber][squareIndex[squareNumber]] = null;
        }

        print();
    }

    private static void removeInEmptyRow(Position position, int x) {
        rowIndex[x]--;
        for (Position[] emptyRow : emptyRows) {
            if (emptyRow.equals(position)) {

            }
        }
        emptyRows[x][rowIndex[x]]=null;
    }

    private static void print() throws IOException {
        for (int[] rows : boards) {
            for (int cell : rows) {
                bw.write(cell + " ");
            }
            bw.write("\n");
        }
        bw.flush();
    }

    private static void read() throws IOException {
        for (int i = 0; i < 9; i++) {
            int[] rows = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            boards[i] = rows;
        }
    }

    private static class Position {

        public int x;
        public int y;

        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public boolean equals(Position position) {
            return x == position.x && y == position.y;
        }
    }
}
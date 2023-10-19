package date_2023_10_19;

import java.io.*;

import static java.lang.Integer.parseInt;

public class RotateArray {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String[] conditions = br.readLine().split(" ");
        int rowSize = parseInt(conditions[0]);
        int colSize = parseInt(conditions[1]);
        int rotateCount = parseInt(conditions[2]);

        int[][] originalArray = createOriginal(rowSize, colSize);
        int[][] rotatedArray = roateArray(rowSize, colSize, originalArray);
        printArray(rotatedArray);
    }


    private static int[][] createOriginal(int rowSize, int colSize) throws IOException {
        int[][] array = new int[rowSize][colSize];

        for (int row = 0; row < rowSize; row++) {
            String[] rowNumbers = br.readLine().split(" ");

            for (int col = 0; col < colSize; col++) {
                array[row][col] = parseInt(rowNumbers[col]);
            }
        }

        return array;
    }

    private static int[][] roateArray(int rowSize, int colSize, int[][] originalArray) {
        int[][] copiedArray = new int[rowSize][colSize];

        for (int row = 0; row < rowSize; row++) {
            for (int col = 0; col < colSize; col++) {

            }
        }

        return copiedArray;
    }

    private static void printArray(int[][] array) throws IOException {
        for (int[] row : array) {
            StringBuilder answerRow = new StringBuilder();
            for (int cell : row) {
                answerRow.append(cell+" ");
            }
            answerRow.deleteCharAt(answerRow.length() - 1);
            answerRow.append("\n");
            bw.write(answerRow.toString());
        }

        bw.flush();
    }
}

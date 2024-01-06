package date_2023_11_16;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Runway {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int count = 0;
    private static int[][] map;
    private static List list = new ArrayList();

    public static void main(String[] args) throws IOException {
        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int squareSize = inputs[0];
        int runwaySize = inputs[1];
        map = new int[squareSize][squareSize];
        list.remove(0);
        for (int i = 0; i < squareSize; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        for (int i = 0; i < squareSize; i++) {
            int prev = map[i][0];
            int sameHeightLength = 1;
            for (int j = 1; j < squareSize; j++) {
                int value = map[i][j];
                if (value == prev) {
                    sameHeightLength++;
                } else if (Math.abs(value - prev) > 1) {
                    break;
                } else if (value - prev == 1) {
                    if (sameHeightLength >= runwaySize) {
                        sameHeightLength = 0;
                        prev = value;
                    } else {
                        break;
                    }
                } else if (value - prev == -1) {
                    prev = value;
                    int nextBlockLength = 1;
                    boolean isSuccess = false;
                    while (true) {
                        if (nextBlockLength >= runwaySize) {
                            isSuccess = true;
                            sameHeightLength = 0;
                            prev = map[i][j];
                            break;
                        }
                        j++;
                        nextBlockLength++;

                        if (j >= squareSize || value != map[i][j]) {
                            break;
                        }
                    }
                    if (!isSuccess) {
                        break;
                    }
                }
                if (j == squareSize - 1) {
                    count++;
                }
            }
        }


        for (int i = 0; i < squareSize; i++) {
            int prev = map[0][i];
            int sameHeightLength = 1;
            for (int j = 1; j < squareSize; j++) {
                int value = map[j][i];
                if (value == prev) {
                    sameHeightLength++;
                } else if (Math.abs(value - prev) > 1) {
                    break;
                } else if (value - prev == 1) { // 오르막길
                    if (sameHeightLength >= runwaySize) {
                        sameHeightLength = 0;
                        prev = value;
                    } else {
                        break;
                    }
                } else if (prev - value == 1) { // 내리막길
                    prev = value;
                    int nextBlockLength = 1;
                    boolean isSuccess = false;
                    while (true) {
                        if (nextBlockLength >= runwaySize) {
                            isSuccess = true;
                            sameHeightLength = 0;
                            prev = map[j][i];
                            break;
                        }
                        j++;
                        nextBlockLength++;

                        if (j >= squareSize || value != map[j][i]) {
                            break;
                        }
                    }
                    if (!isSuccess) {
                        break;
                    }
                }
                if (j == squareSize - 1) {
                    count++;
                }
            }
        }


        System.out.println(count);

    }
}

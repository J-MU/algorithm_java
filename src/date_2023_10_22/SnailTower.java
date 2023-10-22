package date_2023_10_22;

import java.io.*;
import java.util.Arrays;

public class SnailTower {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int[] input = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int upDistance = input[0];
        int downDistance = input[1];
        int goal = input[2];

        int targetDistance = goal - upDistance;
        int targetDay = (int) Math.ceil(((double) targetDistance / (upDistance - downDistance)));
        printGoalDay(targetDay + 1);
    }

    private static void printGoalDay(int day) throws IOException {
        bw.write(day + "");
        bw.flush();
    }
}

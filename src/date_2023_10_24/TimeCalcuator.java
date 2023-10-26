package date_2023_10_24;

import java.io.*;
import java.util.Arrays;

public class TimeCalcuator {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static int earth = 1;
    private static int sun = 1;
    private static int moon = 1;
    private static int year = 1;

    public static void main(String[] args) throws IOException {
        int[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int targetEarth = inputs[0];
        int targetSun = inputs[1];
        int targetMoon = inputs[2];

        while (!isTargetDate(targetEarth, targetSun, targetMoon)) {
            increaseYear();
        }

        bw.write(year + "\n");
        bw.flush();
    }

    private static void increaseYear() {
        increaseEarth();
        increaseSun();
        increaseMoon();

        year++;
    }

    private static void increaseMoon() {
        if (moon == 19) {
            moon = 0;
        }
        moon++;
    }

    private static void increaseSun() {
        if (sun == 28) {
            sun = 0;
        }
        sun++;
    }

    private static void increaseEarth() {
        if (earth == 15) {
            earth = 0;
        }
        earth++;
    }

    private static boolean isTargetDate(int targetEarth, int targetSun, int targetMoon) {
        return targetEarth == earth && targetSun == sun && moon == targetMoon;
    }
}

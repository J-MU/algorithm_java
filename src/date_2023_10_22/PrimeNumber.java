package date_2023_10_22;

import java.io.*;
import java.util.Arrays;

public class PrimeNumber {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int count = 0;

        int testCaseSize = readTestCaseSize();
        int[] testCases = readTestCases();

        for (int testCase : testCases) {
            if (isPrime(testCase)) {
                count++;
            }
        }

        bw.write(count + "");
        bw.flush();
    }

    private static boolean isPrime(int testCase) {
        if (testCase == 1) {
            return false;
        }

        for (int i = 2; i < testCase; i++) {
            if (testCase % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static int[] readTestCases() throws IOException {
        return Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private static int readTestCaseSize() throws IOException {
        return Integer.parseInt(br.readLine());
    }
}

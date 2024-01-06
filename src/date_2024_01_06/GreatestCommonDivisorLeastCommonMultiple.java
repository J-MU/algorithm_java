package date_2024_01_06;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Map;

public class GreatestCommonDivisorLeastCommonMultiple {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int N;
    private static int M;

    public static void main(String[] args) throws IOException {
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = input[0];
        M = input[1];

        int gcd = calculateGreatestCommonDivisor();
        int lcm = calculateLeastCommonMultiple();

        System.out.println(gcd);
        System.out.println(lcm);
    }

    private static int calculateLeastCommonMultiple() {
        int nPivot = 1;
        int mPivot = 1;

        while (true) {
            if (N * nPivot == M * mPivot) {
                return N * nPivot;
            } else if (N * nPivot > M * mPivot) {
                mPivot++;
            } else {
                nPivot++;
            }
        }
    }

    private static int calculateGreatestCommonDivisor() {
        int min = Math.min(N, M);
        int gcd = 1;
        for (int i = 2; i <= min; i++) {
            if (N % i == 0 && M % i == 0) {
                gcd = i;
            }
        }

        return gcd;
    }
}

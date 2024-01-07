package date_2024_01_07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CombinationCalculator {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = inputs[0];
        int K = inputs[1];

        System.out.println(factorial(N) / (factorial(K) * factorial(N - K)));
    }

    private static int factorial(int number) {
        int answer = 1;
        for (int i = 2; i <= number; i++) {
            answer *= i;
        }
        return answer;
    }
}

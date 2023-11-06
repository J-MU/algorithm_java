package date_2023_10_26;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class PartialNumberArraySum2 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static int count=0;

    public static void main(String[] args) throws IOException {
        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                .toArray();

        int N = inputs[0];
        int targetSum = inputs[1];

        int[] sequence = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int left = 0;
        int right = 0;
        int sum = sequence[0];

        while (left < N && right < N) {
            if (sum > targetSum) {
                sum -= sequence[left];
                left++;
            } else if (sum < targetSum) {
                right++;
                if (right >= N) {
                    break;
                }
                sum += sequence[right];
            } else if (sum == targetSum) {
                count++;
                sum -= sequence[left];
                left++;
            }
        }

        bw.write(count + "\n");
        bw.flush();
    }

}

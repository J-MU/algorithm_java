package date_2023_10_26;

import java.io.*;
import java.util.Arrays;

public class PartialSum {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static int[] sequence;
    private static int targetSum = 0;

    public static void main(String[] args) throws IOException {
        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
//        int N = inputs[0];
        targetSum = inputs[1];
//        sumArray = new int[N];

        sequence = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

//        initializeSumArray(N, sequence);
//
//        for (int i = 1; i < N; i++) {
//            for (int j = i; j < N; j++) {
//                sumArray[j] -= sequence[i - 1];
//                if (sumArray[j] == targetSum) {
//                    count++;
//                }
//            }
//        }

        int left = 0;
        int right = 0;
        int sum = sequence[0];
        int size = sequence.length;
        int minLnegth = Integer.MAX_VALUE;

        while (left < size && right < size) {
            if (sum >= targetSum) {
                if (minLnegth > right - left + 1) {
                    minLnegth = right - left + 1;
                }
                sum -= sequence[left];
                left++;
            } else if (sum < targetSum) {
                right++;
                if (right >= size) {
                    break;
                }
                sum += sequence[right];
            }
        }

        if (minLnegth == Integer.MAX_VALUE) {
            minLnegth = 0;
        }
        bw.write(minLnegth + "\n");
        bw.flush();
    }

//    private static void initializeSumArray(int N, int[] sequence) {
//        int sum = 0;
//        for (int i = 0; i < N; i++) {
//            sum += sequence[i];
//            sumArray[i] = sum;
//            if (sum == targetSum) {
//                count++;
//            }
//        }
//    }
}

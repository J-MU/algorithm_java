package date_2023_10_26;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;

public class TwoArrayPartialSum {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static long count = 0;
    private static int targetNum;

    public static void main(String[] args) throws IOException {
        targetNum = readLineToInteger();

        int Asize = readLineToInteger();
        int[] A = readNumbers();

        int Bsize = readLineToInteger();
        int[] B = readNumbers();

        HashMap<Integer, Long> partialSumMapOfA = getPartialSum(A);
        HashMap<Integer, Long> partialSumMapOfB = getPartialSum(B);

        for (Integer partialSumOfA : partialSumMapOfA.keySet()) {
            boolean isContain = partialSumMapOfB.containsKey(targetNum - partialSumOfA);
            if (isContain) {
                Long countA = partialSumMapOfA.get(partialSumOfA);
                Long countB = partialSumMapOfB.get(targetNum - partialSumOfA);

                count += (countA * countB);
            }
        }

        bw.write(count + "\n");
        bw.flush();
    }

    private static HashMap<Integer, Long> getPartialSum(int[] sequence) {
        HashMap<Integer, Long> partialSumMap = new HashMap<>();

        int[] arrayOfSum = new int[sequence.length];

        int sum = 0;
        for (int i = 0; i < sequence.length; i++) {
            sum += sequence[i];
            arrayOfSum[i] = sum;

            partialSumMap.merge(sum, 1L, Long::sum);
        }

        for (int i = 1; i < sequence.length; i++) {
            for (int j = i; j < sequence.length; j++) {
                arrayOfSum[j] -= sequence[i - 1];

                partialSumMap.merge(arrayOfSum[j], 1L, Long::sum);
            }
        }

        return partialSumMap;
    }

    private static int[] readNumbers() throws IOException {
        return Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private static int readLineToInteger() throws IOException {
        return Integer.parseInt(br.readLine());
    }
}

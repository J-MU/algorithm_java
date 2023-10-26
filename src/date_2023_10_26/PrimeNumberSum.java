package date_2023_10_26;

import java.io.*;

public class PrimeNumberSum {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static int count = 0;
    private static int targetNum;
    private static boolean[] isNotPrimes;
    private static int[] primeNumbers;
    private static int primeNumbersIndex = 0;

    public static void main(String[] args) throws IOException {
        targetNum = Integer.parseInt(br.readLine());
        isNotPrimes = new boolean[targetNum + 1];
        primeNumbers = new int[targetNum];

        findPrimes();
//        System.out.print("primeNumbers = ");
//        for (int i = 0; i < primeNumbersIndex; i++) {
//            System.out.print(primeNumbers[i] + ", ");
//        }
        solution();

//        System.out.println();
        bw.write(count + "\n");
        bw.flush();
    }

    private static void solution() {
        // Two Pointer Algorithm을 사용함.
        int left = 0;
        int right = 0;
        int size = primeNumbersIndex;
        int sum = primeNumbers[left];

        while (left < size && right < size) {
            if (sum < targetNum) {
                right++;
                if (right >= size) break; // OOM 방지
                sum += primeNumbers[right];
            } else if (sum > targetNum) {
                sum -= primeNumbers[left];
                left++;
            } else if (sum == targetNum) {
                count++;

                right++;
                if(right >=size) break;
                sum += primeNumbers[right];
            }
        }
    }

    private static void findPrimes() {
        initializePrimeBooleanArray();
        for (int i = 0; i <= targetNum; i++) {
            if (!isNotPrimes[i]) {
                primeNumbers[primeNumbersIndex++] = i;
            }
        }
    }

    private static void initializePrimeBooleanArray() {
        isNotPrimes[0] = true;
        isNotPrimes[1] = true;

        for (int i = 2; i <= targetNum; i++) {
            for (int j = 2; i * j <= targetNum; j++) {
                isNotPrimes[i * j] = true;
            }
        }
    }
}

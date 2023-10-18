package date_2023_10_18;

// https://www.acmicpc.net/problem/2839

import java.io.*;

public class SugarDelivery {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine());

        int fiveNumber = -1;
        int threeNumber = -1;

        int maxFiveCount = findMaxFiveCount(n);
        for (int fiveCount = maxFiveCount; fiveCount >= 0; fiveCount--) {
            int remainNumber = n - (5 * fiveCount);
            if (remainNumber % 3 == 0) {
                fiveNumber = fiveCount;
                threeNumber = remainNumber / 3;
                break;
            }
        }

        if (fiveNumber != -1 && threeNumber != -1) {
            bufferedWriter.write(fiveNumber + threeNumber+"");
//            System.out.println(fiveNumber + threeNumber);
        } else {
//            System.out.println(-1);
            bufferedWriter.write("-1");
        }
        bufferedWriter.newLine();
        bufferedWriter.flush();
    }

    private static int findMaxFiveCount(int n) {
        return n / 5;
    }
}

package date_2023_11_06;

import java.io.*;

public class DivisorSum2 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int testCaseCount = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCaseCount; i++) {
            int x = Integer.parseInt(br.readLine());
            long sum = 0;

            for (int j = 1; j <= x; j++) {
                sum += (long) (x / j) * j;
            }

            bw.write(sum + "\n");
        }

        bw.flush();
    }
}
//101-84 = 17

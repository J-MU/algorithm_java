package date_2023_11_06;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicInteger;

public class Divisor2 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int x = Integer.parseInt(br.readLine());
        long sum = 0;

        for (int i = 1; i <= x; i++) {
            sum += (long) (x / i) * i;
        }

        bw.write(sum + "\n");
        bw.flush();
    }
}
//101-84 = 17

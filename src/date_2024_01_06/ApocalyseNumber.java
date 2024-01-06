package date_2024_01_06;

import java.io.*;

public class ApocalyseNumber {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int number = Integer.parseInt(br.readLine());

        int[] cache = {666, 1666, 2666, 3666, 4666, 5666,
                6661, 6662, 6663, 6664, 6665,
                6666, 6667, 6668, 6669};

        for (int i = 16; i < number; i++) {
            int target = (i - 16) + 10;
            int right = target % 10;
            int left = target / 10;
            String answer = "" + left + 666 + right;

            System.out.println(Integer.parseInt(answer));
        }
    }
}

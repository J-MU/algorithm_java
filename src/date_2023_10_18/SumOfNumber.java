package date_2023_10_18;

import java.io.*;
import java.util.ArrayList;

public class SumOfNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int K = Integer.parseInt(bufferedReader.readLine());

        ArrayList<Integer> nums = readNums(K, bufferedReader);

        int sum = nums.stream().mapToInt(i -> i).sum();
        bufferedWriter.write(sum + "\n");
        bufferedWriter.flush();
    }

    private static ArrayList<Integer> readNums(int K, BufferedReader bufferedReader) throws IOException {
        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            int num = Integer.parseInt(bufferedReader.readLine());

            if (num == 0) {
                nums.remove(nums.size() - 1);
            } else {
                nums.add(num);
            }
        }

        return nums;
    }
}

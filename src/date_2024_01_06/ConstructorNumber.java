package date_2024_01_06;
// https://www.acmicpc.net/problem/2231
// 진짜 1부터 브루트포스로 뽑아 내면 시간 초과가 날지 가늠이 안갔다.
// 시간 초과 가늠 하는 방법을 공부 하면 좋을 듯 하다.
// intellij 디버깅 기능을 하나 더 알게 되었다.

import java.io.*;
import java.util.stream.Stream;

public class ConstructorNumber {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int target = Integer.parseInt(br.readLine());

        for (int i = 0; i < target; i++) {
            int constructorNumber = disassembleNumber(i);

            if (constructorNumber == target) {
                bw.write(i + "\n");
                bw.flush();
                return;
            }
        }

        bw.write(0 + "\n");
        bw.flush();
    }

    private static int disassembleNumber(int i) {
        int[] number = Stream.of(String.valueOf(i).split("")).mapToInt(Integer::parseInt).toArray();
        int sum = i;

        for (int j = 0; j < number.length; j++) {
            sum += number[number.length - j -1];
        }

        return sum;
    }
}

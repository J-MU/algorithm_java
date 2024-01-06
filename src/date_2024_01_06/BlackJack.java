package date_2024_01_06;
// https://www.acmicpc.net/problem/2798

// 추가로 공부할 만한 점.
// 1. 조합을 뽑아내는 효율적인 방법을 공부해보면 좋을 듯 하다.
// 2. 투포인터를 이용해서 풀어낸 사람이 있다. 투포인터 어떻게 하는건지 까먹었으니 공부해보면 좋을듯.

import java.io.*;
import java.util.Arrays;

public class BlackJack {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final int[] pickedCards = new int[3];
    private static int N;
    private static int M;

    public static void main(String[] args) throws IOException {
        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = inputs[0];
        M = inputs[1];

        int[] cards = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int maxSum = pickCards(cards);
        bw.write(maxSum + "\n");
        bw.flush();
    }

    private static int pickCards(int[] cards) {
        int maxSum = 0;

        for (int i = 0; i < cards.length - 2; i++) {
            for (int j = i + 1; j < cards.length - 1; j++) {
                for (int k = j + 1; k < cards.length; k++) {
                    int curSum = cards[i] + cards[j] + cards[k];

                    if (curSum > M || curSum < maxSum) {
                        continue;
                    }
                    if (curSum == M) {
                        return M;
                    }

                    maxSum = curSum;
                }
            }
        }

        return maxSum;
    }
}

package date_2024_01_06;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Card2 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> deck = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            deck.add(i);
        }

        for (int i = 0; ; i++) {
            if (deck.size() == 1) {
                break;
            }
            if (i % 2 == 0) {
                deck.pollFirst();
            } else {
                Integer num = deck.pollFirst();
                deck.addLast(num);
            }
        }

        System.out.println(deck.poll());
    }
}

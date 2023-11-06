package date_2023_11_01;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class baekjoon_10866 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final Deque<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String[] inputs = br.readLine().split(" ");

            try {
                switch (inputs[0]) {
                    case "push_front": {
                        queue.addFirst(Integer.parseInt(inputs[1]));
                        break;
                    }
                    case "push_back": {
                        queue.addLast(Integer.parseInt(inputs[1]));
                        break;
                    }
                    case "pop_front": {
                        bw.write(queue.removeFirst() + "\n");
                        break;
                    }
                    case "pop_back": {
                        bw.write(queue.removeLast() + "\n");
                        break;
                    }
                    case "size": {
                        bw.write(queue.size() + "\n");
                        break;
                    }
                    case "empty": {
                        bw.write((queue.isEmpty() ? 1 : 0) + "\n");
                        break;
                    }
                    case "front": {
                        bw.write(queue.getFirst() + "\n");
                        break;
                    }
                    case "back": {
                        bw.write(queue.getLast() + "\n");
                        break;
                    }
                }
            } catch (NoSuchElementException e) {
                bw.write(-1 + "\n");
            }
        }

        bw.flush();
    }
}

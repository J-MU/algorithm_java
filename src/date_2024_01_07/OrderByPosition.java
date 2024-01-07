package date_2024_01_07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class OrderByPosition {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        List<Position> positions = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            positions.add(new Position(inputs));
        }

        Collections.sort(positions);
        positions.forEach(System.out::println);
    }

    private static class Position implements Comparable<Position> {

        private int x;
        private int y;

        public Position(int[] inputs) {
            x = inputs[0];
            y = inputs[1];
        }

        @Override
        public int compareTo(Position position) {
            if (x > position.x) {
                return 1;
            } else if (x == position.x) {
                return y - position.y;
            } else {
                return -1;
            }
        }

        @Override
        public String toString() {
            return x + " " + y;
        }
    }
}

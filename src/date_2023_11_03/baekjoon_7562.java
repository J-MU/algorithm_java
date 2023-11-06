package date_2023_11_03;

import java.io.*;
import java.util.*;

public class baekjoon_7562 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    private static final int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
    private static final int[] dy = {+1, -1, +2, -2, +2, -2, +1, -1};


    static class Count {
        Position pos;
        Integer count;

        Count(Position pos, Integer count) {
            this.pos = pos;
            this.count = count;
        }
    }

    static class Position {
        int x;
        int y;

        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Position position = (Position) o;
            return x == position.x && y == position.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public static void main(String[] args) throws IOException {
        final int testCaseCount = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCaseCount; i++) {
            bw.write(test() + "\n");
        }

        bw.flush();
    }

    private static int test() throws IOException {
        final Queue<Count> queue = new LinkedList<>();
        final HashMap<Position, Integer> visited = new HashMap<>();

        final int boardSize = Integer.parseInt(br.readLine());

        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        final Position start = new Position(inputs[0], inputs[1]);

        inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        final Position target = new Position(inputs[0], inputs[1]);

        if (start.equals(target)) {
            return 0;
        }

        queue.add(new Count(start, 0));
        visited.put(start, 0);

        while (!queue.isEmpty()) {
            Count current = queue.poll();

            for (int i = 0; i < dx.length; i++) {
                Position next = new Position(current.pos.x + dx[i], current.pos.y + dy[i]);
                if ((next.x < 0 || next.x >= boardSize) || (next.y < 0 || next.y >= boardSize)) {
                    continue;
                }

                if (!visited.containsKey(next)) {
                    visited.put(next, current.count + 1);
                    queue.add(new Count(next, current.count + 1));
                }

                if (next.equals(target)) {
                    return current.count + 1;
                }
            }
        }

        return -1;
    }
}

package date_2023_11_01;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class baekjoon_1697 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static final HashMap<Integer, Integer> visited = new HashMap();
    private static int count = 0;

    public static void main(String[] args) throws IOException {
        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int N = inputs[0];
        int K = inputs[1];

        if (N == K) {
            bw.write(0 + "\n");
            bw.write(N + "\n");
            bw.flush();
            return;
        }
        bfs(N, K);

//        for (Map.Entry<Integer, Integer> entry : visited.entrySet()) {
//            System.out.println("[current, prev] " + entry.getKey() + ", " + entry.getValue());
//        }

        int current = K;
        int[] path = new int[count + 1];
        path[count] = current;
        int i = count - 1;
        while (true) {
            current = visited.get(current);
            if (current == -1) {
                break;
            }
            path[i--] = current;
        }

        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < count+1; j++) {
            sb.append(path[j]).append(" ");
        }
        sb.delete(sb.length() - 1, sb.length() - 1);
        bw.write(sb.toString());
        bw.flush();
    }

    private static void bfs(int n, int k) throws IOException {
        ArrayList<Queue<Integer>> queue = new ArrayList<>(22);

        queue.add(new LinkedList<>());
        queue.get(0).offer(n);
        visited.put(n, -1);

        for (int step = 0; ; step++) {
            queue.add(new LinkedList<>());
            Queue<Integer> stageQueue = queue.get(step);
            while (!stageQueue.isEmpty()) {
                Integer node = stageQueue.poll();

                if (visit(k, step, queue, node - 1, node) ||
                        visit(k, step, queue, node + 1, node) ||
                        visit(k, step, queue, node * 2, node)
                ) {
                    return;
                }
            }
        }
    }

    private static boolean visit(int k, int step, ArrayList<Queue<Integer>> queue, int node, int prev) throws IOException {
        if (node < 0 || node > 100_000) {
            return false;
        }

        if (!visited.containsKey(node)) {
            if (node == k) {
                count = step + 1;
                bw.write(step + 1 + "\n");
                bw.flush();
                visited.put(node, prev);
                return true;
            }

            queue.get(step + 1).offer(node);
            visited.put(node, prev);
        }

        return false;
    }
}

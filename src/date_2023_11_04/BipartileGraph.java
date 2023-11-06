package date_2023_11_04;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class BipartileGraph {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static final int RED = 1;
    private static final int BLUE = -1;

    public static void main(String[] args) throws IOException {
        int testCaseCount = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCaseCount; i++) {
            test();
        }
    }

    private static void test() throws IOException {
        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int V = inputs[0];
        int E = inputs[1];

        boolean[] visited = new boolean[V + 1];
        boolean[] valid = new boolean[V + 1];
        int[] colors = new int[V + 1];
        ArrayList<LinkedList<Integer>> queue = new ArrayList<>();
        ArrayList<LinkedList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < V + 1; i++) {
            graph.add(new LinkedList<>());
        }

        for (int i = 0; i < E; i++) {
            inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            graph.get(inputs[0]).add(inputs[1]);
            graph.get(inputs[1]).add(inputs[0]);
        }

//        visited[1] = true;
//        colors[1] = BLUE;


        int stage = 0;

        boolean isValid = true;
        for (int start = 1; start < V + 1; start++) {
            queue.add(new LinkedList<>());
            queue.get(0).add(start);
            isValid = bfs(graph, queue, stage, visited, valid, colors);
            if (!isValid) {
                break;
            }
            for (int i = 0; i < visited.length; i++) {
                if (!valid[i]) {
                    valid[i] = visited[i];
                }
            }
        }
        String answer = isValid ? "YES\n" : "NO\n";

        bw.write(answer);
        bw.flush();
    }

    private static boolean bfs(ArrayList<LinkedList<Integer>> graph, ArrayList<LinkedList<Integer>> queue, int stage, boolean[] visited, boolean[] valid, int[] colors) {
        for (int color = RED; ; color *= -1) {
            LinkedList<Integer> stageQueue = queue.get(stage);
            if (stageQueue.isEmpty()) {
                return true;
            }

            queue.add(new LinkedList<>());
            while (!stageQueue.isEmpty()) {
                Integer node = stageQueue.poll();
                if (valid[node]) {
                    continue;
                }
                if (!visited[node]) {
                    visited[node] = true;
                    colors[node] = color;

                    LinkedList<Integer> nextStageQueue = queue.get(stage + 1);
                    LinkedList<Integer> adjacentNodes = graph.get(node);

                    nextStageQueue.addAll(adjacentNodes);
                } else {
                    if (colors[node] != color) {
                        return false;
                    }
                }
            }
            stage++;
        }
    }
}

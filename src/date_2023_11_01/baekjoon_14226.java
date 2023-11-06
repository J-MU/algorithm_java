package date_2023_11_01;

import java.io.*;
import java.util.*;

public class baekjoon_14226 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static final ArrayList<Queue<Integer>> queue = new ArrayList<>();
    private static final HashMap<Integer, Integer> visited = new HashMap<>();
    private static int S;

    public static void main(String[] args) throws IOException {

        S = Integer.parseInt(br.readLine());

        int step = bfs(S);

//        for (Map.Entry<Integer, Integer> entry : visited.entrySet()) {
//            System.out.println("[key, value] : " + entry.getKey() + ", " + entry.getValue());
//        }

//        int[] path = new int[step + 1];
//        Integer targetNode = S;
//        path[step--] = S;
//        while (targetNode != 1) {
//            targetNode = visited.get(targetNode);
//            path[step--] = targetNode;
//        }
//
//        for (int num : path) {
//            System.out.print(num + ", ");
//        }


//        bw.write(count + "\n");
        bw.flush();
    }

    private static int bfs(int s) {
        visited.put(0, -1);
        visited.put(1, -1);
        queue.add(new LinkedList<>());
        queue.get(0).add(1);

        for (int step = 0; ; step++) {
            Queue<Integer> stageQueue = queue.get(step);
            queue.add(new LinkedList<>());
            while (!stageQueue.isEmpty()) {
                Integer node = stageQueue.poll();

                if (visit(node - 1, node, step) || visit(node * 2, node, step)) {
                    return step + 1;
                }
            }
        }
    }

    private static boolean visit(Integer node, Integer prev, int step) {
        if (node > 1 && !visited.containsKey(node)) {
            queue.get(step + 1).add(node);
            visited.put(node, prev);
        }

        return node == S;
    }
}

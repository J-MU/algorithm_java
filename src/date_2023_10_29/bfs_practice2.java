package date_2023_10_29;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class bfs_practice2 {

    private static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    private static boolean[] visited;

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            Integer currentNode = queue.poll();

            int connectedNodeCount = graph.get(currentNode).size();

            for (int i = 0; i < connectedNodeCount; i++) {
                Integer connectedNode = graph.get(currentNode).get(i);
                if (!visited[connectedNode]) {
                    queue.offer(connectedNode);
                    visited[connectedNode] = true;
                }
            }
        }
    }
}

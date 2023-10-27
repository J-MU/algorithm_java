package date_2023_10_27;

import com.sun.jdi.PathSearchingVirtualMachine;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

public class IceCreamCombination {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static final List<int[]> blackLists = new ArrayList<>();
    private static int count = 0;
    private static int visitedIndex = 0;

    public static void main(String[] args) throws IOException {
        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                .toArray();
        int N = inputs[0];
        int M = inputs[1];

        int[] sequence = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            sequence[i] = i;
        }

        for (int i = 0; i < M; i++) {
            int[] combination = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                    .toArray();
            blackLists.add(combination);
        }

        int[] visited = new int[3];
        combination(sequence, visited, 1, sequence.length, 3);

        bw.write(count + "\n");
        bw.flush();
    }

    private static void combination(
            int[] sequence,
            int[] visited,
            int start,
            int length,
            int r
    ) {
        if (r == 0) {
            // 로직.
            int[] chosenIceCream = visited;
            boolean isBlacked = false;
            for (int[] blackList : blackLists) {
                int i = 0;
                int j = 0;
                int matchCount = 0;
                while (true) {
                    if (i >= chosenIceCream.length || j >= blackList.length) {
                        break;
                    }
                    if (chosenIceCream[i] == blackList[j]) {
                        i++;
                        j++;
                        matchCount++;
                    } else if (chosenIceCream[i] > blackList[j]) {
                        j++;
                    } else if (chosenIceCream[i] < blackList[j]) {
                        i++;
                    }
                }
                if (matchCount == 2) {
                    isBlacked = true;
                    break;
                }
            }
            if (!isBlacked) {
                count++;
            }
            return;
        }

        for (int i = start; i < length; i++) {
            visited[visitedIndex++] = i;
            combination(sequence, visited, i + 1, length, r - 1);
            visitedIndex--;
        }
    }

    static int[] print(int[] arr, boolean[] visited, int n) {
        int[] blackList = new int[3];
        int cnt = 0;

        for (int i = 1; i < n; i++) {
            if (visited[i]) {
                blackList[cnt++] = i;
//                System.out.print(arr[i] + " ");
            }
        }
//        System.out.println();

        return blackList;
    }
}

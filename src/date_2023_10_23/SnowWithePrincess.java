package date_2023_10_23;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class SnowWithePrincess {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static final List<Integer> children = new ArrayList<>();
    private static final int CHILDREN_COUNT = 9;

    public static void main(String[] args) throws IOException {

        initializeChildrenHeight();

        Integer sumOfHeight = children.stream().reduce(0, Integer::sum);
        int exceededHeight = sumOfHeight - 100;

        for (int i = 0; i < children.size() - 1; i++) {
            for (int j = i + 1; j < children.size(); j++) {
                if (children.get(i) + children.get(j) == exceededHeight) {
                    printChildren(i, j);
                    bw.flush();
                    return;
                }
            }
        }
    }

    private static void printChildren(int index1, int index2) throws IOException {
        for (int i = 0; i < children.size(); i++) {
            if (i == index1 || i == index2) {
                continue;
            }

            bw.write(children.get(i) + "\n");
        }
    }

    private static void initializeChildrenHeight() throws IOException {
        for (int i = 0; i < CHILDREN_COUNT; i++) {
            children.add(Integer.parseInt(br.readLine()));
        }

        children.sort((a1, a2) -> a1 - a2);
    }

}

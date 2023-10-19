package date_2023_10_19;

import java.io.*;
import java.util.*;

public class PrinterQueue {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int testCaseCount = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < testCaseCount; i++) {
            bufferedWriter.write(getAnswer() + "\n");
        }

        bufferedWriter.flush();
    }

    private static Integer getAnswer() throws IOException {
        String[] mn = bufferedReader.readLine().split(" ");
        int documentCount = Integer.parseInt(mn[0]);
        int targetIndex = Integer.parseInt(mn[1]);

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        List<Integer> documentsQueue = new LinkedList<>();
        String[] documents = bufferedReader.readLine().split(" ");
        for (String document : documents) {
            int documentPriority = Integer.parseInt(document);
            priorityQueue.add(documentPriority);
            documentsQueue.add(documentPriority);
        }

        Integer maxPriority = priorityQueue.peek();
        while (true) {
            for (int index = 0; index < documentCount; index++) {
                Integer num = documentsQueue.get(index);
                if (num == null) {
                    continue;
                }

                if (num.equals(maxPriority)) {
                    priorityQueue.poll();
                    maxPriority = priorityQueue.peek();
                    if (index == targetIndex) {
                        return documentCount - priorityQueue.size();
                    }
                }
            }
        }
    }
}

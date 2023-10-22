package date_2023_10_22;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StackImpl {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int testCaseSize = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCaseSize; i++) {
            String[] operation = br.readLine().split(" ");
            Stack.function(operation);
        }
        bw.flush();
    }

    private static class Stack {
        private static List<Integer> stack = new ArrayList<>();

        public static void function(String[] operation) throws IOException {
            switch (operation[0]) {
                case "push" :
                    push(Integer.parseInt(operation[1]));
                    break;
                case "pop" :
                    pop();
                    break;
                case "size" :
                    getSize();
                    break;
                case "empty" :
                    isEmpty();
                    break;
                case "top" :
                    printTop();
                    break;
                default :
                    System.out.println("operation = " + operation);
                    break;
            }
        }

        private static void printTop() throws IOException {
            if (stack.isEmpty()) {
                bw.write("-1\n");
                return ;
            }

            bw.write(stack.get(stack.size() - 1)+"\n");
        }

        private static void isEmpty() throws IOException {
            if (stack.isEmpty()) {
                bw.write("1\n");
            } else {
                bw.write("0\n");
            }
        }

        private static void getSize() throws IOException {
            bw.write(stack.size() + "\n");
        }

        private static void pop() throws IOException {
            if (stack.isEmpty()) {
                bw.write("-1\n");
                return ;
            }

            bw.write(stack.remove(stack.size() - 1) + "\n");
        }

        private static void push(int num) {
            stack.add(num);
        }

    }
}

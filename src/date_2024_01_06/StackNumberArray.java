package date_2024_01_06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StackNumberArray {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        int target = Integer.parseInt(br.readLine());
        List<Integer> numberArray = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < target; i++) {
            numberArray.add(Integer.parseInt(br.readLine()));
        }

        int stackNum = 2;
        stack.push(1);
        sb.append("+\n");
        for (int i = 0; i < numberArray.size(); i++) {
            Integer number = numberArray.get(i);
            while (true) {
                if (number > stackNum - 1) {
                    stack.push(stackNum++);
                    sb.append("+\n");
                } else if (number < stackNum) {
                    Integer pop = stack.pop();
                    if (!pop.equals(number)) {
                        System.out.println("NO");
                        return;
                    }
                    sb.append("-\n");
                    break;
                }
            }
        }

        System.out.println(sb);
    }
}

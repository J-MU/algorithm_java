package date_2024_01_07;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Stack;

public class Parenthesis {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            boolean isValid = true;
            Stack<String> stack = new Stack<>();
            String[] parenthesisString = br.readLine().split("");
            for (int j = 0; j < parenthesisString.length; j++) {
                if (parenthesisString[j].equals("(")) {
                    stack.push(parenthesisString[j]);
                } else if (stack.empty()) {
                    isValid = false;
                    break;
                } else {
                    stack.pop();
                }
            }
            if (stack.empty() && isValid) {
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
}

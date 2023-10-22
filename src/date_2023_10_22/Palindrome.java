package date_2023_10_22;

import java.io.*;

public class Palindrome {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static final String END_INPUT_SIGNAL = "0";

    public static void main(String[] args) throws IOException {
        while (true) {
            String input = br.readLine();
            if (input.equals(END_INPUT_SIGNAL)) {
                break;
            }

            if (isPalindrome(input)) {
                bw.write("yes\n");
            } else {
                bw.write("no\n");
            }
        }

        bw.flush();
    }

    private static boolean isPalindrome(String input) throws IOException {
        int inputLength = input.length();
        for (int index = 0; index < inputLength; index++) {
            if (input.charAt(index) != input.charAt(inputLength - 1 - index)) {
                return false;
            }
        }

        return true;
    }
}

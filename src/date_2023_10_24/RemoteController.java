package date_2023_10_24;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;

public class RemoteController {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static final HashMap<Integer, Integer> activeButtons = new HashMap<>();
    private static final StringBuilder makedNumber = new StringBuilder();

    private static int count = 0;

    public static void main(String[] args) throws IOException {
        String targetNumber = br.readLine();
        int errorButtonCount = Integer.parseInt(br.readLine());

        int[] errorButtons = new int[0];
        if (errorButtonCount > 0) {
            errorButtons = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        createActiveButtons(errorButtons);

        int jumpedNum = !activeButtons.isEmpty() ? findNumber(targetNumber) : 100;

        if (count > Math.abs(Integer.parseInt(targetNumber) - 100)) {
            bw.write((Integer.parseInt(targetNumber) - 100) + "\n");
        } else {
            count += Math.abs(Integer.parseInt(targetNumber) - jumpedNum);
            bw.write(count + "\n");
        }

        bw.flush();
    }

    private static int findNumber(String targetNumber) {
        int length = targetNumber.length();
        for (int i = 0; i < length; i++) {
            int number = Integer.parseInt(targetNumber.charAt(i) + "");
            if (activeButtons.containsKey(number)) {
                makedNumber.append(number);
                count++;
            } else {
                findNumber(number - 1, number + 1);
            }
        }

        return Integer.parseInt(makedNumber.toString());
    }

    private static void findNumber(int smallNum, int bigNum) {
        if (activeButtons.containsKey(bigNum)) {
            makedNumber.append(bigNum);
            count++;
        } else if (activeButtons.containsKey(smallNum)) {
            makedNumber.append(smallNum);
            count++;
        } else {
            findNumber(smallNum - 1, bigNum + 1);
        }
    }

    private static HashMap<Integer, Integer> createActiveButtons(int[] errorButtons) {
        for (int i = 0; i < 10; i++) {
            activeButtons.put(i, i);
        }

        for (int errorButton : errorButtons) {
            activeButtons.remove(errorButton);
        }

        return activeButtons;
    }
}

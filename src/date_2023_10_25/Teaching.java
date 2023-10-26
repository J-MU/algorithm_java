package date_2023_10_25;

import java.io.*;
import java.util.*;

public class Teaching {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static int maxCount = -1;
    private static int wordCount;
    private static int teachableAlphabetCount;
    private static HashSet<Character> alphabetToTeach = new HashSet<>();
    private static String[] needAlphabetList;


    public static void main(String[] args) throws IOException {
        int count = 0;
        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        wordCount = inputs[0];
        teachableAlphabetCount = inputs[1];

        needAlphabetList = new String[wordCount];
        // anta + tica -> a n t i c 알파벳이 필요하므로
        // teachableAlpahbetCount가 5미만일 때는 항상 0임.
        if (teachableAlphabetCount < 5) {
            count = 0;
        }
        if (teachableAlphabetCount == 26) {
            count = 26;
        } else {
            count = solution();
        }

        bw.write(count + "\n");
        bw.flush();
    }

    private static int solution() throws IOException {
        for (int i = 0; i < wordCount; i++) {
            String word = br.readLine();
            // antarctica size = 10 -4 = 6
            String essential = word.substring(4, word.length() - 4);
            needAlphabetList[i] = essential;
        }

        teachableAlphabetCount -= 5;
        if (teachableAlphabetCount >= alphabetToTeach.size()) {
            return wordCount;
        }

        getAnswer();
        return maxCount;
    }

    private static void getAnswer() {
        char[] alphabets = new char[alphabetToTeach.size()];

        int i = 0;
        for (Character toTeach : alphabetToTeach) {
            alphabets[i++] = toTeach;
        }

        boolean[] visited = new boolean[26];
        getMax(alphabets, visited, 0, alphabets.length, teachableAlphabetCount);
    }

    private static void getMax(char[] alphabets, boolean[] visited, int start, int n, int r) {
        if (r == 0) {
            int count = 0;
            for (String word : needAlphabetList) {
                boolean isAllContain = true;
                for (int i = 0; i < word.length(); i++) {
                    if (!visited[word.charAt(i) - 'a']) {
                        isAllContain = false;
                        break;
                    }
                }
                if (isAllContain) {
                    count++;
                }
            }
            maxCount = Math.max(count, maxCount);
        }

        for (int i = start; i < n; i++) {
            visited[alphabets[i] - 'a'] = true;
            getMax(alphabets, visited, start + 1, n, r - 1);
            visited[alphabets[i] - 'a'] = false;
        }
    }
}
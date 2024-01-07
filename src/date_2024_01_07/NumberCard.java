package date_2024_01_07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class NumberCard {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        HashMap<Integer, Integer> countMap = new HashMap<>();

        br.readLine();
        int[] sangeun = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        br.readLine();
        int[] target = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Arrays.stream(sangeun)
            .forEach(key -> countMap.compute(key, (k, v) -> v == null ? 1 : v + 1));

        Arrays.stream(target)
            .forEach(key -> sb.append(countMap.get(key) == null ? 0 : countMap.get(key)).append(" "));
        sb.deleteCharAt(sb.length() - 1);

        System.out.println(sb);
    }
}

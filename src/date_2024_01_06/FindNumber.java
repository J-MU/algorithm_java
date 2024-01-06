package date_2024_01_06;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;

public class FindNumber {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        // value , hasValue
        HashMap<Integer, Boolean> map = new HashMap<>();

        int N = Integer.parseInt(br.readLine());
        int[] nArray = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(nArray);

        int M = Integer.parseInt(br.readLine());
        int[] mArray = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] sortedMArray = mArray.clone();
        Arrays.stream(mArray).forEach(e -> map.put(e, false));
        Arrays.sort(sortedMArray);

        int nPointer = 0;
        int mPointer = 0;

        while (true) {
            if (nPointer >= nArray.length || mPointer >= sortedMArray.length) {
                break;
            }

            if (nArray[nPointer] == sortedMArray[mPointer]) {
                map.put(sortedMArray[mPointer], true);
                nPointer++;
                mPointer++;
            } else if (nArray[nPointer] > sortedMArray[mPointer]) {
                mPointer++;
            } else if (nArray[nPointer] < sortedMArray[mPointer]) {
                nPointer++;
            }
        }

        for (int i = 0; i < mArray.length; i++) {
            System.out.println(map.get(mArray[i]) ? 1 : 0);
        }
    }

}

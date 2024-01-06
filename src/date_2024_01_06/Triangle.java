package date_2024_01_06;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Triangle {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        while (true) {
            int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if (inputs[0] == 0 && inputs[1] == 0 && inputs[2] == 0) {
                return ;
            }

            Arrays.sort(inputs);
            if (inputs[2] * inputs[2] == inputs[0] * inputs[0] + inputs[1] * inputs[1]) {
                bw.write("right\n");
            }else{
                bw.write("wrong\n");
            }

            bw.flush();
        }
    }
}

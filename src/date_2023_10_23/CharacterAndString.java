package date_2023_10_23;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class CharacterAndString {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String input = br.readLine();
        int index = Integer.parseInt(br.readLine());
        bw.write(input.charAt(index - 1));
        bw.flush();
    }

}

package date_2023_10_23;

import java.io.*;
import java.util.Arrays;

public class AcmHotel {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int testCaseSize = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCaseSize; i++) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int height = input[0];
            int wide = input[1];
            int orderOfCustomer = input[2];

            String theNumberOfRoom = getTheNumberOfRoom(orderOfCustomer, height);
            String theFloorOfRoom = getTheFloorOfRoom(orderOfCustomer, height);

            bw.write(theFloorOfRoom + theNumberOfRoom + "\n");
        }
        bw.flush();
    }

    private static String getTheFloorOfRoom(int orderOfCustomer, int height) {
        int theFloorOfRoom = orderOfCustomer % height;
        if (theFloorOfRoom == 0) {
            return "" + height;
        } else {
            return "" + theFloorOfRoom;
        }
    }

    private static String getTheNumberOfRoom(int orderOfCustomer, int height) {
        boolean isTop = orderOfCustomer % height == 0 ? true : false;
        int theOrder = isTop == false ? (orderOfCustomer / height) + 1 : (orderOfCustomer / height);

        if (theOrder < 10) {
            return "0" + (theOrder);
        } else {
            return "" + theOrder;
        }
    }
}

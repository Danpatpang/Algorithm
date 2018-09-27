package part16;

import java.util.Scanner;

public class exam1003 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int countZero = 0, countOne = 0;
        int N = s.nextInt();
        int[][] result = new int[41][2];
        result[0][0] = 1;
        result[0][1] = 0;
        result[1][0] = 0;
        result[1][1] = 1;
        for (int i = 2; i < 41; i++) {
            result[i][0] = result[i-1][0] + result[i-2][0];
            result[i][1] = result[i-1][1] + result[i-2][1];
        }

        for (int i = 0; i < N; i++) {
            int num = s.nextInt();
            System.out.println(result[num][0] + " " + result[num][1]);
        }
    }
}

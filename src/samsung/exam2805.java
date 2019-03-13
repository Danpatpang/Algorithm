package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class exam2805 {
    public static int[][] map;
    public static int size;
    public static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            size = Integer.parseInt(br.readLine());
            count = 0;
            map = new int[size][size];

            for (int j = 0; j < size; j++) {
                String str = br.readLine();
                for (int k = 0; k < size; k++) {
                    map[j][k] = str.charAt(k) - '0';
                }
            }

            for (int j = 0; j < (size / 2); j++) {
                for (int k = (size / 2) - j; k <= (size / 2) + j; k++) {
                    count += map[j][k];
                }
            }
            // j값 수정 필요
            for (int j = (size / 2); j >= 0; j--) {
                for (int k = (size / 2) - j; k <= (size / 2) + j; k++) {
                    count += map[size - 1 - j][k];
                }
            }

            System.out.println("#" + i + " " + count);
        }
    }
}
package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class exam1209 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 1; i <= 10; i++) {
            int[][] map = new int[101][101];
            br.readLine();

            for (int j = 1; j <= 100; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 1; k <= 100; k++) {
                    map[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            int[] sum = new int[203];
            for (int j = 1; j <= 100; j++) {
                for (int k = 1; k <= 100; k++) {
                    sum[j] += map[j][k];
                    sum[100 + j] += map[k][j];
                    if (j == k) {
                        sum[201] = map[j][k];
                    }
                    if (j + k == 101) {
                        sum[202] = map[j][k];
                    }
                }
            }

            int max = 0;
            for (int j = 1; j < sum.length; j++) {
                max = Math.max(max, sum[j]);
            }

            System.out.println("#" + i + " " + max);
        }
    }
}

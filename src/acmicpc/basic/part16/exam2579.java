package acmicpc.basic.part16;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class exam2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] sum = new int[2][N + 1];
        int countOverlapOneStep = 0;

        for (int i = 1; i <= N; i++) {
            int currentScore = Integer.parseInt(br.readLine());
            // 1칸
            if (sum[0][i - 1] >= sum[1][i - 1] && countOverlapOneStep != 2) {
                sum[0][i] = sum[0][i - 1] + currentScore;
                countOverlapOneStep++;
            } else {
                sum[0][i] = sum[1][i - 1] + currentScore;
                countOverlapOneStep = 1;
                countOverlapOneStep++;
            }
            // 2칸
            if (i != 1) {
                sum[1][i] = Math.max(sum[0][i - 2], sum[1][i - 2]) + currentScore;
            }
        }
        System.out.println(Math.max(sum[0][N], sum[1][N]));
    }
}

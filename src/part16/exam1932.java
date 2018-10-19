package part16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class exam1932 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] value = new int[n + 1][n + 1];
        int[][] dp = new int[n + 1][n + 1];
        int result;

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= i; j++) {
                value[i][j] = Integer.parseInt(st.nextToken());
            }

            for (int j = 1; j <= i; j++) {
                // 가장 왼쪽에 위치
                if (j == 1) {
                    dp[i][j] = dp[i - 1][j] + value[i][j];
                }
                // 가장 오른쪽에 위치
                if (j == i) {
                    dp[i][j] = dp[i - 1][j - 1] + value[i][j];
                }
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1]) + value[i][j];
                }
            }
        }
        // 초기화
        result = dp[n][1];
        for (int i = 2; i <= n; i++) {
            result = Math.max(result, dp[n][i]);
        }

        System.out.println(result);
    }
}
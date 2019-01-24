package exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class exam9465 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            int dp[][] = new int[n + 1][3];
            int value[][] = new int[2][n + 1];

            for (int j = 0; j < 2; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 1; k <= n; k++) {
                    value[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            for (int j = 1; j <= n; j++) {
                dp[j][0] = Math.max(dp[j - 1][0], Math.max(dp[j - 1][1], dp[j - 1][2]));
                dp[j][1] = Math.max(dp[j - 1][0], dp[j - 1][2]) + value[0][j];
                dp[j][2] = Math.max(dp[j - 1][0], dp[j - 1][1]) + value[1][j];
            }

            System.out.println(Math.max(dp[n][0], Math.max(dp[n][1], dp[n][2])));
        }
    }
}

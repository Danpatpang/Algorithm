package acmicpc.basic.part16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class exam9461 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        long[] dp = new long[101];

        // acmicpc.dp 초기화
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;
        dp[5] = 2;

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            for (int j = 6; j <= N; j++) {
                dp[j] = dp[j - 1] + dp[j - 5];
            }
            System.out.println(dp[N]);
        }
    }
}

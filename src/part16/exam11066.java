package part16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class exam11066 {
    static int[] cost;
    static int[] sum;
    static int[][] dp;
    static final int max = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int K = Integer.parseInt(br.readLine());
            cost = new int[K + 1];
            sum = new int[K + 1];
            dp = new int[K + 1][K + 1];
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < K; j++) {
                cost[j + 1] = Integer.parseInt(st.nextToken());
                sum[j + 1] = sum[j] + cost[j + 1];

                for (int k = 0; k < K; k++) {
                    dp[j + 1][k + 1] = max;
                }
            }
            System.out.println(solve(1, K));
        }
    }

    static int solve(int start, int end) {
        if (start >= end) {
            return 0;
        }

        if (start + 1 == end) {
            return cost[start] + cost[end];
        }
        // 시간 초과 원인
        // 방문 여부
        if (dp[start][end] != max){
            return dp[start][end];
        }

        for (int i = start; i < end; i++) {
            int temp = solve(start, i) + solve(i + 1, end) + sum[end] - sum[start - 1];
            dp[start][end] = Math.min(dp[start][end], temp);
        }

        return dp[start][end];
    }
}

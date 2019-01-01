package part15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class exam11051 {
    public static long[][] dp = new long[1001][1001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        System.out.println(calculate(N, K));
    }

    public static long calculate(int N, int K) {
        if (N == K || K == 0) {
            return 1;
        }
        if (dp[N][K] != 0) {
            return dp[N][K];
        }

        dp[N][K] = calculate(N - 1, K - 1) + calculate(N - 1, K);
        return dp[N][K] % 10007;
    }
}

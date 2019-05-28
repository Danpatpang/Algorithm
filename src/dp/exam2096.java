package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class exam2096 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[][] max_dp = new int[3][N + 1];
		int[][] min_dp = new int[3][N + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int value1 = Integer.parseInt(st.nextToken());
			int value2 = Integer.parseInt(st.nextToken());
			int value3 = Integer.parseInt(st.nextToken());
			max_dp[0][i] = Math.max(max_dp[0][i - 1], max_dp[1][i - 1]) + value1;
			max_dp[1][i] = Math.max(max_dp[2][i - 1], Math.max(max_dp[0][i - 1], max_dp[1][i - 1])) + value2;
			max_dp[2][i] = Math.max(max_dp[1][i - 1], max_dp[2][i - 1]) + value3;

			min_dp[0][i] = Math.min(min_dp[0][i - 1], min_dp[1][i - 1]) + value1;
			min_dp[1][i] = Math.min(min_dp[2][i - 1], Math.min(min_dp[0][i - 1], min_dp[1][i - 1])) + value2;
			min_dp[2][i] = Math.min(min_dp[1][i - 1], min_dp[2][i - 1]) + value3;
		}

		System.out.println(Math.max(max_dp[2][N], Math.max(max_dp[0][N], max_dp[1][N])));
		System.out.println(Math.min(min_dp[2][N], Math.min(min_dp[0][N], min_dp[1][N])));
	}
}

package acmicpc.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class exam15483 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] A = br.readLine().toCharArray();
		char[] B = br.readLine().toCharArray();

		int[][] dp = new int[1001][1001];

		for (int i = 1; i <= 1000; i++) {
			dp[0][i] = i;
			dp[i][0] = i;
		}

		for (int i = 1; i <= A.length; i++) {
			for (int j = 1; j <= B.length; j++) {
				if (A[i - 1] == B[j - 1]) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					dp[i][j] = dp[i][j - 1] + 1;
					dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + 1);
					dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + 1);
				}
			}
		}

		System.out.println(dp[A.length][B.length]);
	}
}

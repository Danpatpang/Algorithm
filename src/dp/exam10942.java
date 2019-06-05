package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class exam10942 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] dp = new int[N + 1][N + 1];
		int[] value = new int[N + 1];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 1; i <= N; i++) {
			value[i] = Integer.parseInt(st.nextToken());
			dp[i][i] = 1;
		}

		for (int i = 1; i < N; i++) {
			if (value[i] == value[i + 1]) {
				dp[i][i + 1] = 1;
			}
		}

		for (int i = 3; i <= N; i++) {
			for (int j = 1; j <= N - i + 1; j++) {
				int k = i + j - 1;
				if (dp[j + 1][k - 1] == 1) {
					if (value[j] == value[k]) {
						dp[j][k] = 1;
					}
				}
			}
		}

		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			System.out.println(dp[start][end]);
		}
	}
}

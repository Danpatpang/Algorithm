package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class exam11054 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] value = new int[N + 1];
		int[] dp = new int[N + 1];
		int[] dp_b = new int[N + 1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			value[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= N; i++) {
			dp[i] = 1;
			for (int j = 1; j <= i; j++) {
				if (value[i] > value[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}

		int result = 0;
		for (int i = N; i >= 1; i--) {
			for (int j = N; j >= i; j--) {
				if (value[i] > value[j]) {
					dp_b[i] = Math.max(dp_b[i], dp_b[j] + 1);
				}
			}
			result = Math.max(result, dp[i] + dp_b[i]);
		}

		System.out.println(result);
	}
}

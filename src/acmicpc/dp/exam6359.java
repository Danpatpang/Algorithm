package acmicpc.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class exam6359 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			int[] dp = new int[N + 1];

			for (int j = 1; j <= N; j++) {
				for (int k = 1; j * k <= N; k++) {
					if (dp[j * k] != 0) {
						dp[j * k] = 0;
					} else {
						dp[j * k] = 1;
					}
				}
			}

			int result = 0;
			for (int j = 1; j <= N; j++) {
				result += dp[j];
			}
			System.out.println(result);
		}
	}
}

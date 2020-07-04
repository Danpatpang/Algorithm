package acmicpc.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class exam2133 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N + 1];

		if (N % 2 == 1) {
			System.out.println(0);
		} else {
			dp[0] = 1;
			dp[2] = 3;
			for (int i = 4; i <= N; i += 2) {
				for (int j = 2; j <= i; j += 2) {
					int now = (j == 2) ? 3 : 2;
					dp[i] += now * dp[i - j];
				}
			}

			System.out.println(dp[N]);
		}
	}
}

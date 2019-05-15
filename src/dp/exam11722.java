package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class exam11722 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] dp = new int[N + 1];
		int[] value = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			value[i] = Integer.parseInt(st.nextToken());
		}

		int result = 0;
		for (int i = 1; i <= N; i++) {
			dp[i] = 1;
			for (int j = 1; j <= i; j++) {
				if(value[i] < value[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			result = Math.max(dp[i], result);
		}

		System.out.println(result);
	}
}

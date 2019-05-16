package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class exam1965 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] value = new int[n+1];
		int[] dp = new int[n+1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			value[i] = Integer.parseInt(st.nextToken());
		}

		int result = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				if(value[i] > value[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			result = Math.max(result, dp[i]);
		}

		System.out.println(result);
	}
}

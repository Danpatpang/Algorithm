package acmicpc.basic.part31;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class exam11062 {
	static int[][] dp;
	static int[] card;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());

			dp = new int[N][N];
			card = new int[N];
			for (int j = 0; j < N; j++) {
				card[j] = Integer.parseInt(st.nextToken());
			}

			System.out.println(Best(0, N - 1));
		}
	}

	public static int Best(int left, int right) {
		if (dp[left][right] != 0) {
			return dp[left][right];
		}

		int sum = 0;
		if (left == right) {
			return card[left];
		} else {
			for (int i = left; i <= right; i++) {
				sum += card[i];
			}
			int temp = Math.max(sum - Best(left + 1, right), sum - Best(left, right - 1));
			dp[left][right] = temp;
			return temp;
		}
	}
}

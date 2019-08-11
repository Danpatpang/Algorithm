package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class exam3752 {
	static int testNum, sum;
	static int[] value;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 1; i <= T; i++) {
			StringBuffer sb = new StringBuffer("#" + i + " ");
			testNum = Integer.parseInt(br.readLine());
			boolean[] dp = new boolean[10101];
			StringTokenizer st = new StringTokenizer(br.readLine());

			dp[0] = true;
			sum = 0;
			value = new int[testNum];
			for (int j = 0; j < testNum; j++) {
				value[j] = Integer.parseInt(st.nextToken());
				sum += value[j];
			}

			for (int j = 0; j < testNum; j++) {
				for (int k = sum; k >= 0; k--) {
					if (dp[k]) {
						dp[value[j] + k] = true;
					}
				}
			}

			int result = 0;
			for (boolean j : dp) if (j) result++;

			sb.append(result);
			System.out.println(sb.toString());
		}
	}
}

/**
 * N개의 정수가 주어진 배열 A가 있다고 할 때, 이 중 최소한 k개의 연속한 수로 이루어진 부분합의 최대를 구하는 프로그램을 작성하시오.
 *
 * 입력
 * 표준 입력으로 입력이 주어진다.
 * 첫 줄에는 두 정수 N과 k가 주어진다. N은 1,000,000 이하이며, k는 1 이상 1,000 이하이다.
 * 다음 줄에는 N개의 정수가 주어진다.   이 정수의 범위는 -1,000 이상 1,000 이하이다.
 *
 * 출력
 * 표준 출력으로 출력한다.
 * 출력하는 수는 정확히 하나로, 부분합 중 가장 큰 값이다.
 *
 * 예제 입력 1
 * 10 1
 * 1 2 3 4 5 6 7 8 9 10
 * 예제 출력 1
 * 55
 *
 * 예제 입력 2
 * 8 2
 * -2 -3 4 -1 -2 1 7 -3
 * 예제  출력 2
 * 9
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class HomeTest2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] value = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			value[i] = Integer.parseInt(st.nextToken());
		}


		int[] dp = new int[N + 2 - k];
		for (int i = 1; i <= k; i++) {
			dp[1] += value[i];
		}

		for (int i = 2; i <= N + 1 - k; i++) {
			dp[i] = dp[i - 1] - value[i - 1] + value[i + k - 1];
		}

		int result = dp[1];
		for (int i = 2; i <= N + 1 - k; i++) {
			dp[i] = Math.max(dp[i - 1] + value[i + k - 1], dp[i]);
			result = Math.max(result, dp[i]);
		}

		System.out.println(result);
	}
}

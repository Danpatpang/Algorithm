package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class exam2817 {
	static int N, K, result;
	static int[] value;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 1; i <= T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			value = new int[N];
			for (int j = 0; j < N; j++) {
				value[j] = Integer.parseInt(st.nextToken());
			}

			result = 0;
			DFS(0, 0);
			System.out.println("#" + i + " " + result);
		}
	}

	static void DFS(int index, int sum) {
		if (sum == K) {
			result++;
			return;
		}

		if (sum > K || index >= N) {
			return;
		}

		DFS(index + 1, sum + value[index]);
		DFS(index + 1, sum);
	}
}

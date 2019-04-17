package exam.rmq;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class exam2042 {
	static int N, M, K;
	static long A[], Tree[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		A = new long[N + 1];
		Tree = new long[N + 1];

		for (int i = 1; i <= N; i++) {
			A[i] = Long.parseLong(br.readLine());
			update(i, A[i]);
		}

		for (int i = N + 2; i <= N + M + K + 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			if (a == 1) {
				long value = c - A[b];
				A[b] = c;
				update(b, value);
			} else {
				long result = sum(c) - sum(b - 1);
				System.out.println(result);
			}
		}
	}

	public static long sum(int finish) {
		long result = 0;
		while (0 < finish) {
			result += Tree[finish];
			finish -= (finish & -finish);
		}

		return result;
	}

	public static void update(int i, long value) {
		while (i < Tree.length) {
			Tree[i] += value;
			i += (i & -i);
		}
	}
}

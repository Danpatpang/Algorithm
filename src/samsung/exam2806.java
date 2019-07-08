package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class exam2806 {
	static int[] col;
	static int N, result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int i = 1; i <= T; i++) {
			StringBuffer sb = new StringBuffer("#" + i + " ");
			N = Integer.parseInt(br.readLine());
			result = 0;

			for (int j = 1; j <= N; j++) {
				col = new int[N + 1];
				col[1] = j;
				DFS(1);
			}

			sb.append(result);
			System.out.println(sb.toString());
		}
	}

	public static void DFS(int row) {
		if (row == N) {
			result++;
		} else {
			for (int i = 1; i <= N; i++) {
				col[row + 1] = i;
				if (isPossible(row + 1)) {
					DFS(row + 1);
				} else {
					col[row + 1] = 0;
				}
			}
		}

		col[row] = 0;
	}

	public static boolean isPossible(int now) {
		for (int i = 1; i < now; i++) {
			if (col[i] == col[now]) {
				return false;
			}
			if (Math.abs(col[i] - col[now]) == Math.abs(i - now)) {
				return false;
			}
		}
		return true;
	}
}

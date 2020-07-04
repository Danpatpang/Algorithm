package acmicpc.basic.part34;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class exam9663 {
	static int[] col;
	static int N, result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		col = new int[N + 1];
		result = 0;

		for (int i = 1; i <= N; i++) {
			Arrays.fill(col, 0);
			col[1] = i;
			DFS(1);
		}

		System.out.println(result);
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
			if(col[i] == col[now]) {
				return false;
			}

			if(Math.abs(col[i] - col[now]) == Math.abs(i - now)) {
				return false;
			}
		}

		return true;
	}
}
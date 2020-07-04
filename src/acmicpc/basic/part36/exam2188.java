package acmicpc.basic.part36;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class exam2188 {

	public static boolean[] isVisit;
	public static int[] parent;
	public static int edge[][], N, M;

	public static void back(int n) {
		while (n != 0) {
			int child = n;
			n = parent[child];
			edge[n][child]--;
			edge[child][n]++;
		}
	}

	public static boolean DFS(int start) {
		if (start == N + M + 1) {
			return true;
		}

		for (int i = 0; i <= N + M + 1; i++) {
			if (edge[start][i] <= 0 || isVisit[i]) {
				continue;
			}
			parent[i] = start;
			isVisit[i] = true;
			if (DFS(i)) {
				return true;
			}
		}

		return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		edge = new int[N + M + 2][N + M + 2];
		parent = new int[N + M + 2];
		isVisit = new boolean[N + M + 2];

		// Start
		for (int i = 1; i <= N; i++) {
			edge[0][i] = 1;
		}

		// Finish
		for (int i = N + 1; i <= N + M; i++) {
			edge[i][N + M + 1] = 1;
		}

		// Input
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int length = Integer.parseInt(st.nextToken());
			for (int j = 1; j <= length; j++) {
				int node = Integer.parseInt(st.nextToken());
				edge[i][N + node] = 1;
			}
		}

		int result = 0;
		while (DFS(0)) {
			result++;
			back(N + M + 1);
			Arrays.fill(isVisit, false);
		}

		System.out.println(result);
	}
}

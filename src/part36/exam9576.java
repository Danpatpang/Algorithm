package part36;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class exam9576 {
	static int edge[][], parent[];
	static boolean isVisit[];
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			edge = new int[N + M + 2][N + M + 2];
			parent = new int[N + M + 2];
			isVisit = new boolean[N + M + 2];

			for (int j = 1; j <= M; j++) {
				edge[0][j] = 1;
			}

			for (int j = M + 1; j <= M + N; j++) {
				edge[j][N + M + 1] = 1;
			}

			for (int j = 1; j <= M; j++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				for (int k = M + a; k <= M + b; k++) {
					edge[j][k] = 1;
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

	static void back(int node) {
		while (node != 0) {
			int child = node;
			node = parent[child];
			edge[child][node]++;
			edge[node][child]--;
		}
	}

	static boolean DFS(int start) {
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
}

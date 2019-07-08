package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class exam2814 {
	static int[][] map;
	static boolean[] isVisit;
	static int N, M, result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int i = 1; i <= T; i++) {
			StringBuffer sb = new StringBuffer("#" + i + " ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new int[N + 1][N + 1];
			isVisit = new boolean[N + 1];
			result = 0;

			for (int j = 0; j < M; j++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());

				map[x][y] = 1;
				map[y][x] = 1;
			}

			for (int j = 1; j <= N; j++) {
				DFS(j, 1);
			}

			sb.append(result);
			System.out.println(sb.toString());
		}
	}

	public static void DFS(int V, int dept) {
		if(result < dept) {
			result = dept;
		}

		isVisit[V] = true;
		for (int i = 1; i <= N; i++) {
			if (!isVisit[i] && map[V][i] == 1) {
				DFS(i, dept + 1);
			}
		}

		isVisit[V] = false;
	}
}

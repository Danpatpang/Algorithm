package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class exam1915 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}

		int result = 0;
		for (int i = 0; i < N; i++) {
			result = Math.max(map[i][0], map[0][i]);
			if(result == 1) {
				break;
			}
		}

		for (int i = 1; i < N; i++) {
			for (int j = 1; j < M; j++) {
				if (map[i][j] > 0) {
					map[i][j] += Math.min(map[i - 1][j - 1], Math.min(map[i - 1][j], map[i][j - 1]));
				}
				result = Math.max(result, map[i][j]);
			}
		}
		System.out.println(result * result);
	}

}
package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class exam2819 {
	static int[][] map;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static HashSet<String> set;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 1; i <= T; i++) {
			StringBuffer sb = new StringBuffer("#" + i + " ");
			StringTokenizer st;
			set = new HashSet<>();
			map = new int[4][4];

			for (int j = 0; j < 4; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < 4; k++) {
					map[j][k] = Integer.parseInt(st.nextToken());
				}
			}

			for (int j = 0; j < 4; j++) {
				for (int k = 0; k < 4; k++) {
					DFS(j, k, "");
				}
			}

			sb.append(set.size());
			System.out.println(sb.toString());
		}
	}

	private static void DFS(int x, int y, String s) {
		s += map[x][y];
		if (s.length() == 7) {
			set.add(s);
			return;
		}

		for (int i = 0; i < 4; i++) {
			int currentX = x + dx[i];
			int currentY = y + dy[i];

			if (currentX >= 0 && currentX < 4 && currentY >= 0 && currentY < 4) {
				DFS(currentX, currentY, s);
			}
		}
	}
}

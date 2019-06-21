package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class exam4963 {
	static int[][] map;
	static boolean[][] isVisit;
	static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
	static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
	static int w, h;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();

		while (!s.equals("0 0")) {
			StringTokenizer st = new StringTokenizer(s);
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());

			map = new int[h][w];
			isVisit = new boolean[h][w];

			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int count = 0;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (!isVisit[i][j] && map[i][j] == 1) {
						DFS(i, j);
						count++;
					}
				}
			}
			System.out.println(count);

			s = br.readLine();
		}
	}

	public static void DFS(int y, int x) {
		isVisit[y][x] = true;

		for (int i = 0; i < 8; i++) {
			int currentY = y + dy[i];
			int currentX = x + dx[i];

			if (currentX >= 0 && currentX < w && currentY >= 0 && currentY < h) {
				if (!isVisit[currentY][currentX] && map[currentY][currentX] == 1) {
					DFS(currentY, currentX);
				}
			}
		}
	}
}

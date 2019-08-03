package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class exam1226 {
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static int[][] map;
	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 1; i <= 10; i++) {
			br.readLine();
			StringBuffer sb = new StringBuffer("#" + i + " ");
			map = new int[16][16];
			result = 0;

			for (int j = 0; j < 16; j++) {
				char[] row = br.readLine().toCharArray();
				for (int k = 0; k < 16; k++) {
					map[j][k] = row[k] - '0';
				}
			}
			DFS(1, 1);

			sb.append(result);
			System.out.println(sb.toString());
		}
	}

	private static void DFS(int x, int y) {
		if (map[x][y] == 3) {
			result = 1;
		}

		for (int i = 0; i < 4; i++) {
			int currentX = x + dx[i];
			int currentY = y + dy[i];
			if (map[currentX][currentY] != 1) {
				if (map[currentX][currentY] == 0) map[currentX][currentY] = 1;
				DFS(currentX, currentY);
			}
		}
	}
}

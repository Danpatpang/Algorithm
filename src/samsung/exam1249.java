package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class exam1249 {
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static int[][] map;
	static int[][] dist;
	static int N, result;
	final static int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 1; i <= T; i++) {
			StringBuffer sb = new StringBuffer("#" + i + " ");
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			dist = new int[N][N];

			for (int j = 0; j < N; j++) {
				char[] row = br.readLine().toCharArray();
				for (int k = 0; k < N; k++) {
					map[j][k] = row[k] - '0';
					dist[j][k] = INF;
				}
			}

			BFS();
			sb.append(dist[N-1][N-1]);
			System.out.println(sb.toString());
		}
	}

	private static void BFS() {
		PriorityQueue<Point> queue = new PriorityQueue<Point>();
		queue.offer(new Point(0, 0, 0));
		dist[0][0] = 0;

		while (!queue.isEmpty()) {
			Point curPoint = queue.poll();
			int currentX = curPoint.x;
			int currentY = curPoint.y;

			for (int i = 0; i < 4; i++) {
				int nextX = currentX + dx[i];
				int nextY = currentY + dy[i];
				if (nextX < 0 || N <= nextX || nextY < 0 || N <= nextY) continue;

				if (dist[nextX][nextY] > dist[currentX][currentY] + map[nextX][nextY]) {
					queue.offer(new Point(nextX, nextY, map[nextX][nextY]));
					dist[nextX][nextY] = dist[currentX][currentY] + map[nextX][nextY];
				}

			}
		}
	}
}

class Point implements Comparable<Point> {
	int x;
	int y;
	int cost;

	Point(int x, int y, int cost) {
		this.x = x;
		this.y = y;
		this.cost = cost;
	}

	@Override
	public int compareTo(Point p) {
		return this.cost - p.cost;
	}
}
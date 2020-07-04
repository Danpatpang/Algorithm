package acmicpc.exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class exam11650 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		Point[] p = new Point[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			p[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		Arrays.sort(p, new Comparator<Point>() {
			@Override
			public int compare(Point o1, Point o2) {
				if (o1.x != o2.x) {
					return o1.x - o2.x;
				}
				return o1.y - o2.y;
			}
		});

		for (int i = 0; i < N; i++) {
			System.out.println(p[i].x + " " + p[i].y);
		}
	}
}

class Point {
	int x;
	int y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
package acmicpc.basic.part37;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class exam1708 {
	static Point root;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());

		Point[] point = new Point[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			point[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		root = FindRoot(point);

		Arrays.sort(point, (o1, o2) -> {
			int result = CCW(root, o1, o2);
			if (result > 0) return -1;
			if (result < 0) return 1;

			long result1 = distance(root, o1);
			long result2 = distance(root, o2);

			if (result1 > result2) return 1;
			return -1;
		});

		LinkedList<Point> list = new LinkedList<Point>();
		list.add(root);

		for (int i = 1; i < point.length; i++) {
			while (list.size() > 1 && CCW(list.get(list.size() - 2), list.get(list.size() - 1), point[i]) <= 0) {
				list.remove(list.size() - 1);
			}
			list.add(point[i]);
		}

		System.out.println(list.size());
	}

	static Point FindRoot(Point[] p) {
		Arrays.sort(p, (o1, o2) -> {
			if (o1.y > o2.y) {
				return 1;
			} else if (o1.y == o2.y) {
				if (o1.x > o2.x) {
					return 1;
				} else {
					return -1;
				}
			} else {
				return -1;
			}
		});
		return p[0];
	}

	static int CCW(Point p1, Point p2, Point p3) {
		long result = (p2.x - p1.x) * (p3.y - p1.y) - (p3.x - p1.x) * (p2.y - p1.y);
		if (result > 0) return 1;
		if (result < 0) return -1;
		return 0;
	}

	static long distance(Point p1, Point p2) {
		return (long) (Math.pow((p2.x - p1.x), 2) + Math.pow((p2.y - p1.y), 2));
	}
}

class Point {
	long x;
	long y;

	Point(long x, long y) {
		this.x = x;
		this.y = y;
	}
}

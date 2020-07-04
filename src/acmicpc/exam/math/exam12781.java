package acmicpc.exam.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class exam12781 {
	static Point[] point;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		point = new Point[4];

		for (int i = 0; i < 4; i++) {
			point[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		boolean result = Check(CCW(point[0], point[1], point[2]), CCW(point[0], point[1], point[3]));
		result &= Check(CCW(point[2], point[3], point[0]), CCW(point[2], point[3], point[1]));

		if (result) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}

	public static int CCW(Point p1, Point p2, Point p3) {
		long temp = ((p2.x - p1.x) * (p3.y - p1.y)) - ((p3.x - p1.x) * (p2.y - p1.y));
		if(temp > 0) {
			return 1;
		} else if (temp == 0) {
			return 0;
		} else {
			return -1;
		}
	}

	public static boolean Check(int v1, int v2) {
		int temp = v1 * v2;
		if (temp >= 0) {
			return false;
		} else {
			return true;
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
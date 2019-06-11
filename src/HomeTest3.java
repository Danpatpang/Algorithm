/**
 * 값비싼 보석을  전시하는 전시회를 기획하려고 한다. 각각의  보석은 아주 넓은 전시장 중앙 지역에 하나씩 위치를 정하여 배치 되고, 보석이 도난 되거나 파손되는 것을 막고 감시하기 위해서  여러 대의 감시카메라를 전시장 곳곳에 배치하려고 한다.
 * 전시될 보석들의 종류와 전시회의 테마를 고려한 전문가의 구상을 따라 전시장 내의 보석들의 배치도를 완성했다. 그리고, 보안 담당자는 전시장 내 곳곳에 감시카메라를 설치했다. 감시카메라는 제자리에서 빠른 속도로 회전하기 때문에 360도 주위를 모두 볼 수 있고, 성능이 우수하여 멀리 있는 보석도 감시 가능하다.
 * 보석을 모든 방향에서 보다 잘 감시하기 위해서는 보석 마다 세 대의 감시카메라가 필요한데, 세 대의 감시카메라의 위치를 서로 연결하는 직선 선분으로 만들수 있는 삼각형에 그 보석이 들어 있으면 이 보석은 모든 방향에서 감시가 가능하다. 삼각형의 변이나 꼭지점에 보석이 있는 경우에도 이 보석은 모든 방향에서 감시가 가능하다. 다만, 세 대의 감시카메라가 하나의 직선위에 있는 경우, 두 대의 감시카메라가 동일한 위치에 있는 경우, 두 개의 보석이 동일한 위치에 있는 경우는 없다.
 * 전시될 보석들의 위치와 감시카메라의 위치가 모두 주어졌을 때, 각 보석이 모든 방향에서 감시가 가능하지 판별하는 프로그램을 작성하시오.
 *
 * 입력
 * 표준 입력으로 입력을 받는다. 첫 줄에는 보석의 개수를 나타내는 자연수 N과 감시카메라의 개수를 나타내는 자연수 M이 주어진다.
 * N은 1 이상 100,000 이하 정수이고 M은 3이상 100,000이하의 정수이다.
 * 이어지는 N줄 각각엔 보석 좌표를 나타내는 (x,y) 쌍이 주어진다. 이어서 M개의 줄 각각엔 감시카메라의 좌표를 나타내는 (x,y) 쌍이 차례로 주어진다. 좌표를 나타내는 모든 값은 0 이상 1,000,000,000 이하의 정수이다.
 *
 * 출력
 * 입력에서 주어진 보석의 순서대로, 각 보석이 모든 방향에서 감시가 가능하다면 Y, 아니면 N을 한줄에 연속하여 출력한다.
 *
 * 예제 입력
 * 3 4
 * 1 6
 * 3 3
 * 5 6
 * 0 3
 * 8 4
 * 5 0
 * 4 8
 * 예제 출력
 * NYY
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class HomeTest3 {
	static Point root;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Point[] jewelry = new Point[N];
		Point[] cctv = new Point[M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			jewelry[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			cctv[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		root = FindRoot(cctv);

		Arrays.sort(cctv, (o1, o2) -> {
			int result = CCW(root, o1, o2);
			if (result > 0) return -1;
			if (result < 0) return 1;

			long result1 = distance(root, o1);
			long result2 = distance(root, o2);

			if (result1 > result2) return 1;
			else return -1;
		});

		LinkedList<Point> list = new LinkedList<Point>();
		list.add(root);
		for (int i = 1; i < cctv.length; i++) {
			while (list.size() > 1 && CCW(list.get(list.size() - 2), list.get(list.size() - 1), cctv[i]) <= 0) {
				list.remove(list.size() - 1);
			}
			list.add(cctv[i]);
		}

		boolean isValid;
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < N; i++) {
			isValid = true;
			for (int j = 0; j < list.size() - 1; j++) {
				if (CCW(list.get(j), list.get(j + 1), jewelry[i]) < 0) {
					isValid = false;
					break;
				}
			}

			if (CCW(list.get(list.size() - 1), list.get(0), jewelry[i]) < 0) {
				isValid = false;
			}

			if (isValid) {
				sb.append("Y");
			} else {
				sb.append("N");
			}
		}

		System.out.println(sb.toString());
	}

	static Point FindRoot(Point[] p) {
		Arrays.sort(p, (o1, o2) -> {
			if (o1.y > o2.y) return 1;
			else if (o1.y < o2.y) return -1;
			else {
				if (o1.x > o2.x) return 1;
				else return -1;
			}
		});
		return p[0];
	}

	static int CCW(Point p1, Point p2, Point p3) {
		long temp = (p2.x - p1.x) * (p3.y - p1.y) - (p3.x - p1.x) * (p2.y - p1.y);
		if (temp > 0) return 1;
		if (temp < 0) return -1;
		return 0;
	}

	static long distance(Point p1, Point p2) {
		return (long) (Math.pow((p2.x - p1.x), 2) + Math.pow((p2.y - p1.y), 2));
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

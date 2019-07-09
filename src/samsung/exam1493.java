package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class exam1493 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int i = 1; i <= T; i++) {
			StringBuffer sb = new StringBuffer("#" + i + " ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());

			int result = Star(p, q);
			sb.append(result);
			System.out.println(sb.toString());
		}
	}

	public static int Sharp(P p) {
		return ((p.x + p.y) * (p.x + p.y - 1) / 2) + 1 - p.y;
	}

	public static P And(int v) {
		int i, sharp = 0;
		for (i = 2; i <= 20000; i++) {
			sharp = Sharp(new P(i - 1, 1));
			if (v <= sharp) break;
		}

		int y = sharp - v + 1;
		int x = i - y;
		return new P(x, y);
	}

	public static P Add(P p1, P p2) {
		return new P(p1.x + p2.x, p1.y + p2.y);
	}

	public static int Star(int x, int y) {
		return Sharp(Add(And(x), And(y)));
	}
}

class P {
	int x;
	int y;

	P(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
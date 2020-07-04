package acmicpc.exam.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class exam1107 {
	static boolean[] isBroken;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		isBroken = new boolean[10];
		if(M > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				isBroken[Integer.parseInt(st.nextToken())] = true;
			}
		}

		// 버튼 사용 X
		int answer = Math.abs(N - 100);

		// 버튼 체크
		for (int i = 0; i <= 1000000; i++) {
			int channel = i;
			int length = move(channel);

			if (length > 0) {
				int	press = Math.abs(channel - N);
				answer = Math.min(answer, length + press);
			}
		}

		System.out.println(answer);
	}

	public static int move(int channel) {
		int length = 0;

		if (channel == 0) {
			return isBroken[0] ? 0 : 1;
		}

		while (channel > 0) {
			if (isBroken[channel % 10]) {
				return 0;
			}
			length += 1;
			channel /= 10;
		}
		return length;
	}
}

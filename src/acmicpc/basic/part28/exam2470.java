package acmicpc.basic.part28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class exam2470 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Integer[] value = new Integer[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			value[i] = new Integer(st.nextToken());
		}
		Arrays.sort(value, (o1, o2) -> Math.abs(o1) - Math.abs(o2));

		long result = Long.MAX_VALUE;
		int[] index = new int[2];
		for (int i = 0; i < N - 1; i++) {
			long temp = Math.abs(value[i] + value[i + 1]);
			if (result > temp) {
				index[0] = value[i];
				index[1] = value[i + 1];
				result = temp;
			}
		}
		Arrays.sort(index);
		System.out.println(index[0] + " " + index[1]);
	}
}

package part33;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class exam11399 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] value = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			value[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(value);

		int result = 0;
		for (int i = 0; i < N; i++) {
			result += (value[i] * (N - i));
		}
		System.out.println(result);
	}
}

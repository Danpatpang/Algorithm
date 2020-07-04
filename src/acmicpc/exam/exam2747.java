package acmicpc.exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class exam2747 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] fibonacci = new int[46];

		fibonacci[1] = 1;
		fibonacci[2] = 1;
		for (int i = 3; i <= n; i++) {
			fibonacci[i] = fibonacci[i-1] + fibonacci[i-2];
		}

		System.out.println(fibonacci[n]);
	}
}

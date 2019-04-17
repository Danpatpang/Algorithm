package exam.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class exam2609 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int num1 = Integer.parseInt(st.nextToken());
		int num2 = Integer.parseInt(st.nextToken());

		int GCD = GCD(num1, num2);
		int LCM = LCM(num1, num2, GCD);
		System.out.println(GCD + " " + LCM);
	}

	public static int GCD(int num1, int num2) {
		if (num1 < num2) {
			return GCD(num2, num1);
		} else if (num1 % num2 == 0) {
			return num2;
		} else {
			return GCD((num1 % num2), num2);
		}
	}

	public static int LCM(int num1, int num2, int GCD) {
		return num1 * num2 / GCD;
	}
}

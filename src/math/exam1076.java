package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class exam1076 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		long result = 0;
		for (int i = 0; i < 3; i++) {
			String str = br.readLine();
			int value = 0;

			if (str.equals("black")) value = 0;
			else if (str.equals("brown")) value = 1;
			else if (str.equals("red")) value = 2;
			else if (str.equals("orange")) value = 3;
			else if (str.equals("yellow")) value = 4;
			else if (str.equals("green")) value = 5;
			else if (str.equals("blue")) value = 6;
			else if (str.equals("violet")) value = 7;
			else if (str.equals("grey")) value = 8;
			else if (str.equals("white")) value = 9;

			if (i == 0) {
				result += value * 10;
			} else if (i == 1) {
				result += value;
			} else {
				result *= Math.pow(10, value);
			}
		}
		System.out.println(result);
	}
}
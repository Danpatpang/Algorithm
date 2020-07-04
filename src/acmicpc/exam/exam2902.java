package acmicpc.exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class exam2902 {
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		String[] KMP = str.split("-");
		for (int i = 0; i < KMP.length; i++) {
			System.out.print(KMP[i].charAt(0));
		}
	}
}

package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class exam1221 {
	static int[] num;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int i = 1; i <= T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			System.out.println(st.nextToken());

			num = new int[10];
			int N = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				num[ChangeNum(st.nextToken())]++;
			}

			for (int j = 0; j < 10; j++) {
				String s = ChangeString(j);
				for (int k = 0; k < num[j]; k++) {
					System.out.print(s + " ");
				}
			}

			System.out.println();
		}
	}

	private static int ChangeNum(String s) {
		if(s.equals("ZRO")) return 0;
		if(s.equals("ONE")) return 1;
		if(s.equals("TWO")) return 2;
		if(s.equals("THR")) return 3;
		if(s.equals("FOR")) return 4;
		if(s.equals("FIV")) return 5;
		if(s.equals("SIX")) return 6;
		if(s.equals("SVN")) return 7;
		if(s.equals("EGT")) return 8;
		if(s.equals("NIN")) return 9;
		return 0;
	}

	private static String ChangeString(int n) {
		if(n == 0) return "ZRO";
		if(n == 1) return "ONE";
		if(n == 2) return "TWO";
		if(n == 3) return "THR";
		if(n == 4) return "FOR";
		if(n == 5) return "FIV";
		if(n == 6) return "SIX";
		if(n == 7) return "SVN";
		if(n == 8) return "EGT";
		if(n == 9) return "NIN";
		return null;
	}
}

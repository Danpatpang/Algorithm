package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class exam7272 {
	static int[] value;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		value = new int[26];
		value[0] = value[3] = value[14] = value[15] = value[16] = value[17] = 1;
		value[1] = 2;

		int T = Integer.parseInt(br.readLine());
		for (int i = 1; i <= T; i++) {
			StringBuffer sb = new StringBuffer("#" + i + " ");
			StringTokenizer st = new StringTokenizer(br.readLine());

			if (isSame(st.nextToken(), st.nextToken())) {
				sb.append("SAME");
			} else {
				sb.append("DIFF");
			}

			System.out.println(sb.toString());
		}
	}

	private static boolean isSame(String s1, String s2) {
		if (s1.length() != s2.length()) return false;
		for (int i = 0; i < s1.length(); i++) {
			if (value[s1.charAt(i) - 'A'] != value[s2.charAt(i) - 'A']) return false;
		}
		return true;
	}
}

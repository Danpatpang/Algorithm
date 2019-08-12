package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class exam7193 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 1; i <= T; i++) {
			StringBuffer sb = new StringBuffer("#" + i + " ");
			StringTokenizer st = new StringTokenizer(br.readLine());

			int number = Integer.parseInt(st.nextToken()) - 1;
			String X = st.nextToken();
			int result = 0;
			for (int j = 0; j < X.length(); j++) {
				result += (X.charAt(j) - '0') % number;
			}

			sb.append(result % number);
			System.out.println(sb.toString());
		}
	}
}

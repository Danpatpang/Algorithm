package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class exam1289 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int i = 1; i <= T; i++) {
			StringBuffer sb = new StringBuffer("#" + i + " ");
			String s = br.readLine();
			char[] array = s.toCharArray();

			int result = 0;
			char flag = '0';
			for (int j = 0; j < array.length; j++) {
				if(array[j] == flag) {
					continue;
				} else {
					if(flag == '0') flag = '1';
					else flag = '0';
					result++;
				}
			}

			sb.append(result);
			System.out.println(sb.toString());
		}
	}
}

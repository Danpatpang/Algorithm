package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class exam1217 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 1; i <= 10; i++) {
			br.readLine();
			StringTokenizer st = new StringTokenizer(br.readLine());
			int result = (int) Math.pow(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			System.out.println("#" + i + " " + result);
		}
	}
}

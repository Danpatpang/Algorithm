package part29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class exam1300 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());

		int left = 1;
		int right = k;
		int result = 0;
		while (left <= right) {
			long cnt = 0;
			int mid = (left + right) / 2;
			for (int i = 1; i <= N; i++) {
				cnt += Math.min(mid / i , N);
			}

			if(cnt < k) {
				left = mid + 1;
			} else {
				result = mid;
				right = mid - 1;
			}
		}

		System.out.println(result);
	}
}

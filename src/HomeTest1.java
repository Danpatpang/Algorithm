/**
 * n개의 정수를 입력받고, 이 중 k번 이상 나오는 수를 출력하는 프로그램을 작성하시오.
 * 예를 들어, n=6, k=2라면 입력이 1 3 2 5 2 7일 때 답은 2이다.
 *
 * 입력
 * 입력은 표준 입력으로 주어진다. 표준 입력이 무슨 말인지 모르겠다면, scanf나 std::cin, Java 사용자라면 System.in에서 읽는다고 생각하면 된다.  두 줄로 이루어지며, 첫 줄에는 두 수 n과 k가 사이에 하나 이상의 공백을 두고 주어진다. n은 1 이상 1,000,000 이하이며, k는 1 이상 n 이하이다.  다음 줄에는 n개의 숫자가 사이에 하나 이상의 공백을 두고 주어진다. 모든 수는 1 이상 1,000,000 이하이며, 동일한 수가 두 번 이상 나올 수 있다.
 *
 * 출력
 * 출력은 표준 출력으로 주어진다. 입력받은 n개의 수 중 k번 이상 나오는 수를 출력한다. 만약 이런 수가 둘 이상 있다면, 이 중 가장 작은 수를 출력한다.
 * 만약 이런 수가 없다면 -1을 출력한다.
 *
 * 예제 입력 1
 * 6 2
 * 1 3 2 5 2 7
 *
 * 예제 출력 1
 * 2
 *
 * 예제 입력 2
 * 8 2
 * 1 3 2 5 2 7 3 3
 *
 * 예제 출력 2
 * 2 (2가 2번, 3이 3번 나오지만 2번 이상 나오면서 가장 작은 수는 2)
 *
 * 예제 입력 3
 * 6 3
 * 1 3 2 5 2 7
 *
 * 예제 출력 3
 * -1
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class HomeTest1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] count = new int[1000001];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int value = Integer.parseInt(st.nextToken());
			count[value]++;
		}

		int result = -1;
		for (int i = 1; i <= 1000000; i++) {
			if(count[i] >= k) {
				result = i;
				break;
			}
		}

		System.out.println(result);
	}
}

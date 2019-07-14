package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class exam1234 {
	static Stack<Integer> stack;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 1; i <= 10; i++) {
			StringBuffer sb = new StringBuffer("#" + i + " ");
			StringTokenizer st = new StringTokenizer(br.readLine());

			stack = new Stack<Integer>();
			int N = Integer.parseInt(st.nextToken());
			String s = st.nextToken();
			for (int j = 0; j < N; j++) {
				int current = s.charAt(j) - '0';

				if (stack.isEmpty()) {
					stack.add(current);
					continue;
				}

				int top = stack.peek();
				if (top == current) {
					stack.pop();
				} else {
					stack.add(current);
				}
			}

			for (int j : stack) {
				sb.append(j);
			}
			System.out.println(sb.toString());
		}
	}
}

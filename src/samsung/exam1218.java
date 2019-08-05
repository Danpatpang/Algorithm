package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class exam1218 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 1; i <= 10; i++) {
			StringBuffer sb = new StringBuffer("#" + i + " ");
			int N = Integer.parseInt(br.readLine());

			Stack<Character> stack = new Stack<>();
			String input = br.readLine();
			boolean isValid = true;
			for (int j = 0; j < input.length(); j++) {
				char current = input.charAt(j);
				if (current == '{' || current == '(' || current == '<' || current == '[') {
					stack.push(current);
				} else {
					if (stack.isEmpty()) {
						isValid = false;
						break;
					}

					if (current == '}' && stack.peek() == '{') {
						stack.pop();
					} else if (current == ')' && stack.peek() == '(') {
						stack.pop();
					} else if (current == ']' && stack.peek() == '[') {
						stack.pop();
					} else if (current == '>' && stack.peek() == '<') {
						stack.pop();
					} else {
						isValid = false;
						break;
					}
				}
			}

			if (stack.isEmpty() && isValid) sb.append(1);
			else sb.append(0);

			System.out.println(sb.toString());
		}
	}
}

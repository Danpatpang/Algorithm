package acmicpc.exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class exam9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            Boolean result = isVPS(br.readLine());
            if (result) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    public static boolean isVPS(String str) {
        Stack<Character> stack = new Stack<>();
        char[] words = str.toCharArray();

        for (int i = 0; i < words.length; i++) {
            if (words[i] == '(') {
                stack.push(str.charAt(i));
            } else {
                if (stack.isEmpty() || stack.peek() == ')') {
                    return false;
                }
                if (stack.peek() == '(') {
                    stack.pop();
                }
            }
        }

        if (!stack.isEmpty()) {
            return false;
        }

        return true;
    }
}

package acmicpc.exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class exam10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();
        String stick = br.readLine();

        int count = 0;
        char last = '0';

        for (int i = 0; i < stick.length(); i++) {
            char now = stick.charAt(i);
            if (now == '(') {
                stack.push(now);
            } else {
                if (last == ')') {
                    stack.pop();
                    count += 1;
                } else {
                    stack.pop();
                    count += stack.size();
                }
            }
            last = now;
        }

        System.out.println(count);
    }
}

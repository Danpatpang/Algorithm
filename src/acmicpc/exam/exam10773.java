package acmicpc.exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class exam10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<Integer>();
        long result = 0;

        for (int i = 1; i <= K; i++) {
            int n = Integer.parseInt(br.readLine());

            if (n == 0) {
                stack.pop();
            } else {
                stack.push(n);
            }
        }

        while (!stack.empty()) {
            result += stack.pop();
        }

        System.out.println(result);
    }
}

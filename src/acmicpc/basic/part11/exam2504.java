package acmicpc.basic.part11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class exam2504 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();

        Stack<String> stack = new Stack();

        int smallCnt = 0;
        int largeCnt = 0;
        boolean isValid = true;
        // 연산과정 + valid 한가
        try {
            for (int i = 0; i < input.length; i++) {
                if (input[i] == '(') {
                    smallCnt++;
                    stack.push("(");
                }

                if (input[i] == '[') {
                    largeCnt++;
                    stack.push("[");
                }

                if (input[i] == ')') {
                    smallCnt--;
                    String temp = stack.peek();
                    if (temp.equals("(")) {
                        stack.pop();
                        stack.push("2");
                    } else {
                        int result = 0;
                        while (temp != "(") {
                            result += Integer.parseInt(temp);
                            stack.pop();
                            temp = stack.peek();
                        }
                        stack.pop();
                        result *= 2;
                        stack.push(Integer.toString(result));
                    }
                }
                if (input[i] == ']') {
                    smallCnt--;
                    String temp = stack.peek();
                    if (temp.equals("[")) {
                        stack.pop();
                        stack.push("3");
                    } else {
                        int result = 0;
                        while (temp != "[") {
                            result += Integer.parseInt(temp);
                            stack.pop();
                            temp = stack.peek();
                        }
                        stack.pop();
                        result *= 3;
                        stack.push(Integer.toString(result));
                    }
                }
            }

            int result = 0;
            while (!stack.empty()) {
                result += Integer.parseInt(stack.pop());
            }
            System.out.println(result);
        } catch (Exception e) {
            System.out.println(0);
        }
    }
}
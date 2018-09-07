package part11;

import java.util.Scanner;
import java.util.ArrayList;

public class exam1874 {
    public static ArrayList stack = new ArrayList();

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int value;
        int top = 0, bottom = 0;
        ArrayList list = new ArrayList();
        ArrayList result = new ArrayList();
        for (int i = 0; i < N; i++) {
            list.add(s.nextInt());
        }

        for (int i = 0; i < N; i++) {
            value = (int) list.get(i);

            if (top < value) {
                for (int j = top + 1; j <= value; j++) {
                    push(j);
                    result.add("+");
                }
                top = value;
                pop();
                result.add("-");
            } else {
                if (top() == value) {
                    pop();
                    result.add("-");
                } else {
                    break;
                }
            }
        }
        if (result.size() == (2 * N)) {
            for (int i = 0; i < result.size(); i++) {
                System.out.println(result.get(i));
            }
        } else{
            System.out.println("NO");
        }
    }

    public static void push(int n) {
        stack.add(n);
    }

    public static void pop() {
        if (stack.isEmpty()) {
            return;
        }
        stack.remove(stack.size() - 1);
    }

    public static int top() {
        if (stack.isEmpty()) {
            return 0;
        }
        return (int) stack.get(stack.size() - 1);
    }
}
package part11;

import java.util.ArrayList;
import java.util.Scanner;

public class exam10828 {
    public static ArrayList stack = new ArrayList();

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int countOfInstruction = Integer.parseInt(s.nextLine());
        while (countOfInstruction > 0) {
            String instruction = s.nextLine();
            if (instruction.startsWith("push")) {
                push(Integer.parseInt(instruction.substring(5)));
            } else if (instruction.equals("pop")) {
                System.out.println(pop());
            } else if (instruction.equals("top")) {
                System.out.println(top());
            } else if (instruction.equals("size")) {
                System.out.println(size());
            } else if (instruction.equals("empty")) {
                if (empty()) {
                    System.out.println("1");
                } else {
                    System.out.println("0");
                }
            }
            countOfInstruction--;
        }
    }

    static void push(int n) {
        stack.add(n);
    }

    static int top() {
        if (stack.size() == 0) {
            return -1;
        }
        int value = (int) stack.get(stack.size() - 1);
        return value;
    }

    static int pop() {
        if (stack.size() == 0) {
            return -1;
        }
        int value = (int) stack.get(stack.size() - 1);
        ;
        stack.remove(stack.size() - 1);
        return value;
    }

    static boolean empty() {
        if (stack.size() == 0) {
            return true;
        }
        return false;
    }

    static int size() {
        return stack.size();
    }
}
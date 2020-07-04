package acmicpc.basic.part7;

import java.util.Scanner;

public class exam2908 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int x = s.nextInt();
        int y = s.nextInt();
        StringBuffer X = new StringBuffer(Integer.toString(x)).reverse();
        StringBuffer Y = new StringBuffer(Integer.toString(y)).reverse();
        if (Integer.parseInt(X.toString()) > Integer.parseInt(Y.toString())) {
            System.out.println(Integer.parseInt(X.toString()));
        } else {
            System.out.println(Integer.parseInt(Y.toString()));
        }
    }
}

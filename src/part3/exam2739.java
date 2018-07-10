package part3;

import java.util.Scanner;

public class exam2739 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        for (int i = 1; i <= 9 ; i++) {
            System.out.println(N + " * " + i + " = " + N*i);
        }
    }
}

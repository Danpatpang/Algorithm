package part7;

import java.util.Scanner;

public class exam10809 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        String alpha = "abcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i < alpha.length(); i++) {
            System.out.print(str.indexOf(alpha.charAt(i)) + " ");
        }
    }
}

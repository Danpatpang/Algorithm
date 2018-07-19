package part7;

import java.util.Scanner;

public class exam2941 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        int result = 0;
        String[] alpha = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
        for (int i = 0; i < str.length(); i++) {
            check:
            for (int j = 0; j < alpha.length; j++) {
                if (str.startsWith(alpha[j], i)) {
                    result++;
                    break check;
                }
            }
        }
        System.out.println(str.length()-result);
    }
}
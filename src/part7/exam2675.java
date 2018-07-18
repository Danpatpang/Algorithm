package part7;

import java.util.Scanner;

public class exam2675 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        String[] output = new String[N];
        for (int i = 0; i < N; i++) {
            int k = s.nextInt();
            String str = s.next();
            output[i] = "";
            for (int j = 0; j < str.length(); j++) {
                for (int l = 0; l < k; l++) {
                    output[i] += str.charAt(j);
                }
            }
        }
        for (int i = 0; i < output.length; i++) {
            System.out.println(output[i]);
        }
    }
}

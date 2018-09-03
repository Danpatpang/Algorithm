package part10;

import java.util.Scanner;

public class exam2581 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int M = s.nextInt();
        int N = s.nextInt();
        int min = 0;
        int sum = 0;

        test:
        for (int i = M; i <= N; i++) {
            if (i == 1) {
                continue test;
            }
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    continue test;
                }
            }
            min = i;
            sum += i;
        }
        if(min == 0){
            min = -1;
        }
        System.out.println(sum);
        System.out.println(min);
    }
}

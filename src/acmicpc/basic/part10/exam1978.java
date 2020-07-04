package acmicpc.basic.part10;

import java.util.Scanner;

public class exam1978 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int count = 0;
        boolean[] isPrime = new boolean[1000];

        for (int i = 1; i < 1000; i++) {
            isPrime[i] = true;
        }
        for (int i = 2; i <= 1000; i++) {
            if (isPrime[i - 1]) {
                for (int j = i + 1; j <= 1000; j++) {
                    if (j % i == 0) {
                        isPrime[j - 1] = false;
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            int num = s.nextInt();
            if(isPrime[num-1]){
                count++;
            }
        }
        System.out.println(count);
    }
}

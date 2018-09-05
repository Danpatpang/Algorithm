package part10;

import java.util.Scanner;

public class exam9020 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        for (int i = 0; i < N; i++) {
            int value = s.nextInt();
            int minPrime = 0, maxPrime = 0;

            check:
            for (int j = (value / 2); j >= 2; j--) {
                for (int l = 2; l <= Math.sqrt(j); l++) {
                    if (j % l == 0) {
                        continue check;
                    }
                }

                minPrime = j;
                maxPrime = value - minPrime;

                for (int k = 2; k <= Math.sqrt(maxPrime); k++) {
                    if(maxPrime % k == 0){
                        continue  check;
                    }
                }
                break;
            }

            System.out.println(minPrime + " " + maxPrime);
        }
    }
}
